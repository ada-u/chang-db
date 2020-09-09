import org.scalafmt.sbt.ScalafmtPlugin.autoImport.scalafmtOnCompile
import sbt.Keys._
import sbt._
import wartremover.WartRemover.autoImport._
import Dependencies._

object Settings {

  val baseName = "chang-db"

  val baseSettings = Seq(
    scalaVersion := "2.13.3",
    scalacOptions ++= Seq(
        "-feature",
        "-deprecation",
        "-unchecked",
        "-encoding",
        "UTF-8",
        "-Xfatal-warnings",
        "-language:_",
        // Warn if an argument list is modified to match the receiver
        "-Xlint:adapted-args",
        // Warn when dead code is identified.
        "-Ywarn-dead-code",
        // Warn about inaccessible types in method signatures.
        "-Xlint:inaccessible",
        // Warn when a type argument is inferred to be `Any`.
        "-Xlint:infer-any",
        // Warn when nullary methods return Unit.
        "-Xlint:nullary-unit",
        // Warn when numerics are widened.
        "-Ywarn-numeric-widen"
      ),
    scalafmtOnCompile in Compile := true,
    wartremoverErrors in (Compile, compile) ++= Seq(
        Wart.ArrayEquals,
        Wart.AnyVal,
        Wart.Var,
        Wart.Null,
        Wart.OptionPartial
      ),
    resolvers ++= Seq(
        Resolver.sonatypeRepo("snapshots"),
        Resolver.sonatypeRepo("releases")
      ),
    libraryDependencies ++= Seq(
        Scalatest.core  % Test,
        Logback.classic % Test
      ),
    parallelExecution in Test := false,
    fork := true,
    updateOptions := updateOptions.value.withLatestSnapshots(false),
    scalacOptions in (Compile, console) += "-Ywarn-unused:-imports,_",
    scalacOptions in (Test, console) += "-Ywarn-unused:-imports,_"
  )

}
