import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildSteps.maven
import jetbrains.buildServer.configs.kotlin.buildSteps.script

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
    buildType(OutsideOfRunner)

    params {
        param("env.M2_HOME", "/opt/homebrew/Cellar/maven/3.9.5/libexec")
    }
}

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
                path = "%teamcity.tool.maven.3.9.6%"
            }
            dockerImage = "openjdk:17-ea-slim"
        }
    }
})

object OutsideOfRunner : BuildType({
    name = "outsideOfRunner"

    params {
        param("mvn2", "%teamcity.tool.maven3_8%")
    }

    steps {
        script {
            id = "simpleRunner"
            scriptContent = """
                echo '%teamcity.tool.maven3_3%'
                echo '%teamcity.tool.maven.3.9.5%'
            """.trimIndent()
        }
    }
})
