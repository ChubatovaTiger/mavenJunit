package patches.buildTypes

import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildSteps.MavenBuildStep
import jetbrains.buildServer.configs.kotlin.buildSteps.maven
import jetbrains.buildServer.configs.kotlin.ui.*

/*
This patch script was generated by TeamCity on settings change in UI.
To apply the patch, change the buildType with id = 'NonBundled396'
accordingly, and delete the patch script.
*/
changeBuildType(RelativeId("NonBundled396")) {
    expectSteps {
        maven {
            id = "Maven2"
            goals = "clean test"
            runnerArgs = "-Dmaven.test.failure.ignore=true"
            mavenVersion = bundled_3_9_6()
            jdkHome = "%env.JDK_11%"
        }
    }
    steps {
        update<MavenBuildStep>(0) {
            clearConditions()
            jdkHome = "%env.JDK_17_0_ARM64%"
        }
    }
}
