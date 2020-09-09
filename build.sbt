import Settings._
import sbt.Keys._

lazy val `relationalEngine` = (project in file("relational-engine"))
  .settings(baseSettings)
  .settings(name := s"relational-engine")


lazy val root = (project in file("."))
  .settings(baseSettings)
  .settings(
    name := s"$baseName-root",
    skip in publish := true
  )
  .aggregate(
    `relationalEngine`
  )
