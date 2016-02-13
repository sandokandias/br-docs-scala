lazy val root = (project in file(".")).
  settings(
    organization := "github.com.sandokandias",
    name := "br-docs-scala",
    version := "1.0-SNAPSHOT",
    scalaVersion := "2.11.7"
  )

libraryDependencies ++= Seq(
  "org.scalactic" %% "scalactic" % "2.2.6",
  "org.scalatest" %% "scalatest" % "2.2.6" % "test"
)

resolvers ++= Seq(
  Resolver.mavenLocal
)

