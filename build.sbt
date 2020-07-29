
name := "spark-demo"
organization := "ch.epfl.scala"
version := "1.0"

scalaVersion := "2.12.10"
javacOptions ++= Seq("-source", "1.8", "-target", "1.8")


val sparkVersion = "3.0.0"

libraryDependencies ++= Seq(
  "org.apache.spark"   %% "spark-core"      % sparkVersion,
  "org.apache.spark"   %% "spark-streaming" % sparkVersion,
  "org.apache.spark"   %% "spark-mllib"     % sparkVersion,
  "org.apache.commons" % "commons-lang3"    % "3.5",
  "com.typesafe"       % "config"           % "1.3.1"
)


resolvers ++= Seq(
  "JBoss Repository" at "http://repository.jboss.org/nexus/content/repositories/releases/",
  "Akka Repository" at "http://repo.akka.io/releases/",
  "scala-tools" at "https://oss.sonatype.org/content/groups/scala-tools",
  "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/",
  "Second Typesafe repo" at "http://repo.typesafe.com/typesafe/maven-releases/",
  Resolver.sonatypeRepo("public")
)

