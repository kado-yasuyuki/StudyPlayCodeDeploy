name := """study-play-code-deploy"""
organization := "com.dys"

version := "1.0-SNAPSHOT"

lazy val root = (project in file("."))
  .enablePlugins(
    PlayScala,
    SbtWeb,
    RpmPlugin,
    JavaServerAppPackaging,
    SystemVPlugin
  )

scalaVersion := "2.12.7"

pipelineStages := Seq(gzip)

libraryDependencies ++= Seq(evolutions, jdbc, ehcache, ws, specs2 % Test, guice)

// disabling documentation generation to speed up compilation
// https://www.playframework.com/documentation/2.6.x/SBTCookbook
sources in(Compile, doc) := Seq.empty
publishArtifact in(Compile, packageDoc) := false

// https://www.playframework.com/documentation/2.6.x/Deploying
maintainer in Linux := "com.dys"

packageSummary in Linux := "study-play-code-deploy"

packageDescription in Linux := "study-play-code-deploy"

rpmRelease := "1"
rpmVendor := "com.dys"
rpmUrl := Some("url")
rpmLicense := Some("no license")
daemonUser := "root"

javaOptions in Universal ++= Seq(
  s"-Dpidfile.path=/var/run/${packageName.value}/play.pid",
)