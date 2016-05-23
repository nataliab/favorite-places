import NativePackagerHelper._

lazy val favorite_places = project.in(file(".")).enablePlugins(PlayScala)
  .settings(
    name := "favorite-places",
    dockerExposedPorts := Seq(9000),
    dockerRepository := Some("giltouroboros"),
    maintainer := "Ouroboros <ouroboros@gilt.com>",
    dockerBaseImage := "fiadliel/java8-jre:8u60",
    version := "0.0.1"
  ).dependsOn("apidoc")

lazy val apidoc = project.in(file("apidoc"))
  .settings(
    name := "apidoc",
    libraryDependencies += ws
  )