import Settings._
import sbt.Keys._
import Dependencies._

lazy val `relationalEngine` = (project in file("relational-engine"))
  .settings(baseSettings)
  .settings(name := s"relational-engine")
  .settings(
    libraryDependencies ++= Seq(
        ScalaLangModules.parserCombinator
      )
  )

lazy val root = (project in file("."))
  .settings(baseSettings)
  .settings(
    name := s"$baseName-root",
    skip in publish := true
  )
  .aggregate(
    `relationalEngine`
  )
