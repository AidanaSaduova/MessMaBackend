name := """swagger-java-playframework"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava, PlayEbean)

scalaVersion := "2.12.2"

playEbeanModels in Compile := Seq("apimodels.*")

libraryDependencies ++= Seq(
  javaJdbc,
  "mysql"   %  "mysql-connector-java" % "5.1.35"
)

sources in (Compile, doc) ~= (_ filter (_.getName endsWith ".java"))

libraryDependencies += "org.webjars" % "swagger-ui" % "3.1.5"
libraryDependencies += "javax.validation" % "validation-api" % "1.1.0.Final"
libraryDependencies += guice