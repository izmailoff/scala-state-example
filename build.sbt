
name := "scala-state-example"

version := "0.1"
     
scalaVersion := "2.11.7"

javacOptions ++= Seq("-target", "1.8")

scalacOptions in Test ++= Seq("-Yrangepos")

libraryDependencies ++= {
  val akkaVersion = "2.4.0"
  val scalazVersion = "7.1.6"
  Seq(
    "com.typesafe.akka" %% "akka-actor" % akkaVersion,
    "com.typesafe.akka" %% "akka-slf4j" % akkaVersion,
    "ch.qos.logback" % "logback-classic" % "1.1.3",
    "org.specs2" %% "specs2-core" % "3.7" % "test",
    "com.typesafe.akka" %% "akka-testkit" % akkaVersion % "test",
    "org.scalatest" %% "scalatest" % "2.2.4" % "test",
    "org.scalaz" %% "scalaz-core" % scalazVersion,
    "org.scalaz" %% "scalaz-effect" % scalazVersion,
    "org.scalaz" %% "scalaz-typelevel" % scalazVersion,
    "org.scalaz" %% "scalaz-scalacheck-binding" % scalazVersion % "test"
  )
}

resolvers ++= Seq(
  "Akka Snapshot Repository" at "http://repo.akka.io/snapshots/",
  Classpaths.sbtPluginReleases
)
