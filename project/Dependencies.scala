import sbt._

object Dependencies {

  object ScalaLangModules {
    val parserCombinator = "org.scala-lang.modules" %% "scala-parser-combinators" % "1.1.2"
  }

  object Scalatest {
    val core = "org.scalatest" %% "scalatest" % "3.2.0"
  }

  object Logback {
    val classic = "ch.qos.logback" % "logback-classic" % "1.2.3" excludeAll (
      ExclusionRule(organization = "org.slf4j")
      )
  }

}
