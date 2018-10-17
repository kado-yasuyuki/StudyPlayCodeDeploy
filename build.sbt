name := """study-play-code-deploy"""
organization := "com.dys"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.12.7"

libraryDependencies ++= Seq(evolutions, jdbc, ehcache, ws, specs2 % Test, guice)

// disabling documentation generation to speed up compilation
// https://www.playframework.com/documentation/2.6.x/SBTCookbook
sources in(Compile, doc) := Seq.empty
publishArtifact in(Compile, packageDoc) := false
