lazy val root =
  project
    .in(file("."))
    .enablePlugins(ScalaJSPlugin)
    .settings(
      scalaVersion := "2.12.2",
      libraryDependencies ++= Seq(
        "com.github.benhutchison" %%% "prickle" % "1.1.13",
        "demo.akkajs" %%% "twitter-messages" % "0.0.1",
        "org.akka-js" %%% "akkajsactor" % "1.2.5.2",
        "org.akka-js" %%% "akkajstestkit" % "1.2.5.2" % "test"
      ),
      fork in run := true,
      cancelable in Global := true
    )
