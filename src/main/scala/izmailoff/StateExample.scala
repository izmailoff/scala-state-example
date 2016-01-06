package izmailoff

object StateExample extends App {

  def startCall(calls: CallState, caller: User, phone: PhoneNumber): CallState =
    calls + (phone -> caller)

  def finishCall(calls: CallState, phone: PhoneNumber): CallState =
    calls - phone

  def startCallingPeople(calls: CallState) = {
    val intermediateState1 = startCall(calls, User("one"), "123")
    val intermediateState2 = startCall(intermediateState1, User("two"), "456")
    intermediateState2
  }

  def hangupCalls(calls: CallState) = {
    val intermediateState1 = finishCall(calls, "123")
    val intermediateState2 = finishCall(intermediateState1, "456")
    intermediateState2
  }

  // mutable part of your program
  var callState: CallState = Map()

  // side effecting part of your program
  def runSimulation(): Unit = {
    println(s"BEFORE ANY CALLS: $callState")
    callState = startCallingPeople(callState)
    println(s"AFTER CALLING 2 PEOPLE: $callState")
    callState = hangupCalls(callState)
    println(s"AFTER HANGING UP: $callState")
  }

  runSimulation()
}
