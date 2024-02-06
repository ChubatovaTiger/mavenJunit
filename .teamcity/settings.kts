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

version = "2023.05"

project {

    buildType(Kkjkj)
}

object Kkjkj : BuildType({
    name = "kkjkj"

    vcs {
        root(DslContext.settingsRoot)
    }

    steps {
        maven {
            enabled = false
            goals = "clean test"
            runnerArgs = "-Dmaven.test.failure.ignore=true"
            mavenVersion = bundled_3_2()
        }
        script {
            scriptContent = """echo 'time="2024-02-06T14:23:48Z" level=warning msg="failed to list images: Cannot connect to the Docker daemon at unix:///var/run/docker.sock. Is the docker daemon running?" subtask=registry.jetbrains.team/p/em/containers/em-deployment task=Build' 1>&2"""
            dockerImage = "ubuntu"
        }
    }
})
