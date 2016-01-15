package izmailoff

import scalaz.State

object StateMonadExample extends App {

  def startCall(caller: User, phone: PhoneNumber): State[CallState, Unit] =
    State { s => s + (phone -> caller) ->() }

  def finishCall(phone: PhoneNumber): State[CallState, Unit] =
    State { s => (s - phone) ->() }

  def startCallingPeople: State[CallState, Unit] =
    startCall(User("one"), "123").flatMap(_ => startCall(User("two"), "456"))

  def hangupCalls: State[CallState, Unit] =
    finishCall("123").flatMap(_ => finishCall("456"))

  // mutable part of your program
  var callState: CallState = Map()

  // side effecting part of your program
  def runSimulation(): Unit = {
    test1() // intermediate state being saved
    test2() // intermediate state being passed through
    test3() // same as test 2 but also outputs intermediate state without updating it as test 1 does
  }

  def test1(): Unit = {
    // reset initial state just in case
    callState = Map()
    println("TEST 1:")
    println(s"BEFORE ANY CALLS: $callState")
    callState = startCallingPeople.run(callState)._1
    println(s"AFTER CALLING 2 PEOPLE: $callState")
    callState = hangupCalls.run(callState)._1
    println(s"AFTER HANGING UP: $callState")
    println("END OF TEST 1.\n")
  }

  def test2(): Unit = {
    // reset initial state just in case
    callState = Map()
    println("TEST 2:")
    println(s"BEFORE ANY CALLS: $callState")
    val computation = for {
      _ <- startCallingPeople
      _ <- hangupCalls
    } yield ()
    callState = computation.run(callState)._1
    println(s"AFTER CALL AND HANGUP: $callState")
    println("END OF TEST 2.\n")
  }

  def test3(): Unit = {
    // reset initial state just in case
    callState = Map()
    println("TEST 3:")
    println(s"BEFORE ANY CALLS: $callState")
    val computation = for {
      s1 <- startCallingPeople.flatMap(_ => State { s: CallState => println(s"AFTER CALLING 2 PEOPLE: $s"); s -> () })
      _ <- hangupCalls
    } yield ()
    callState = computation.run(callState)._1
    println(s"AFTER HANGING UP: $callState")
    println("END OF TEST 3.\n")
  }

  runSimulation()
}
