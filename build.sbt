name := "ingestor-madness"

version := "0.1"

scalaVersion := "2.12.8"

libraryDependencies ++= Seq(
  "org.typelevel" %% "cats-core" % "2.0.0-M1",
  "io.chrisdavenport" %% "cats-par" % "0.2.0",
  "org.typelevel" %% "cats-effect" % "1.3.0"
)

scalacOptions ++= Seq(
  "-deprecation",
  "-encoding", "UTF-8",
  "-language:higherKinds",
  "-language:postfixOps",
  "-feature",
  "-Ypartial-unification",
  "-Xfatal-warnings",
)