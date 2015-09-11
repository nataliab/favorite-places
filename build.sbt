import com.typesafe.sbt.packager.Keys._

enablePlugins(PlayScala)

name := "hello-world"
dockerRepository := Some("giltouroboros")
maintainer := "Ouroboros <ouroboros@gilt.com>"
dockerBaseImage := "fiadliel/java8-jre:8u60"
version := "git describe --tags --dirty --always".!!
  .stripPrefix("v").trim
