import sbt.Keys._
import sbt._

object Dependencies {
  val commonSettings = Seq(
    libraryDependencies ++= Seq(
      enumeratum, scalatest
    )
  )

  val enumeratum = "com.beachape" %% "enumeratum" % "1.6.1"
  val scalatest =  "org.scalatest" %% "scalatest" % "3.2.5" % "test"
}
