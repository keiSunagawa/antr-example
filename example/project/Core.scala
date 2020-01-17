import sbt._
import Keys._
import Dependencies._

object Core {
  lazy val core = (project in file("core"))
    .settings(Base.settings)
    .settings(
      name := "example-core",
      scalacOptions ++= Base.commonScalaOptions,
      libraryDependencies ++= Base.commonLibs ++ Seq(
        "org.antlr" % "antlr4-runtime" % "4.7",
        "org.antlr" % "stringtemplate" % "3.2"
      )
    )
}
