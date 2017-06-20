lazy val root =
  project
    .in(file("."))
    .enablePlugins(ScalaJSPlugin)
    .settings(
      scalaVersion := "2.12.2",
      scalacOptions := Seq("-feature", "-language:_", "-deprecation"),
      libraryDependencies ++= Seq(
        "com.github.benhutchison" %%% "prickle" % "1.1.13",
        "demo.akkajs" %%% "twitter-messages" % "0.0.1",
        "com.lihaoyi" %%% "scalatags" % "0.6.3",
        "org.akka-js" %%% "akkajsactorstream" % "1.2.5.2",
        "org.scalatest" %%% "scalatest" % "3.0.0" % "test",
        "org.akka-js" %%% "akkajstestkit" % "1.2.5.2" % "test",
        "org.akka-js" %%% "akkajsstreamtestkit" % "1.2.5.2" % "test"
      ),
      jsDependencies +=
        "org.webjars.bower" % "diff-dom" % "2.0.3" / "diffDOM.js",
      scalaJSUseMainModuleInitializer := true,
      skip in packageJSDependencies := false
    )
