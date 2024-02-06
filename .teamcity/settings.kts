import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildSteps.maven

/*
The settings script is an entry point for defining a TeamCity
project hierarchy. The script should contain a single call to the
project() function with a Project instance or an init function as
an argument.

VcsRoots, BuildTypes, Templates, and subprojects can be
registered inside the project using the vcsRoot(), buildType(),
template(), and subProject() methods respectively.

To debug settings scripts in command-line, run the

    mvnDebug org.jetbrains.teamcity:teamcity-configs-maven-plugin:generate

command and attach your debugger to the port 8000.

To debug in IntelliJ Idea, open the 'Maven Projects' tool window (View
-> Tool Windows -> Maven Projects), find the generate task node
(Plugins -> teamcity-configs -> teamcity-configs:generate), the
'Debug' option is available in the context menu for the task.
*/

version = "2023.11"

project {

    buildType(NonBundled396)
    buildType(id395)

    params {
        param("env.M2_HOME", "/opt/homebrew/Cellar/maven/3.9.5/libexec")
    }
}

object id395 : BuildType({
    id("395")
    name = "3.9.5"

    vcs {
        root(DslContext.settingsRoot)
    }

    steps {
        maven {
            id = "Maven2"
            goals = "clean test"
            runnerArgs = "-Dmaven.test.failure.ignore=true"
        }
    }
})

object NonBundled396 : BuildType({
    name = "non-bundled3.9.6changed"

    vcs {
        root(DslContext.settingsRoot)
    }

    steps {
        maven {
            id = "Maven2"
            goals = "clean test"
            runnerArgs = "-Dmaven.test.failure.ignore=true"
            mavenVersion = custom {
                path = "%teamcity.tool.maven.4.0.0-alpha-10%"
            }
            jdkHome = "%env.JDK_17_0_ARM64%"
        }
    }
})
