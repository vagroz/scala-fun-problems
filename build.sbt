import Dependencies._

ThisBuild / scalaVersion := "2.13.5"

lazy val root = (project in file("."))
  .settings(commonSettings)