import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.amazonEC2CloudImage
import jetbrains.buildServer.configs.kotlin.amazonEC2CloudProfile

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

    buildType(Build1)

    features {
        amazonEC2CloudImage {
            id = "PROJECT_EXT_5"
            profileId = "amazon-1"
            agentPoolId = "-2"
            vpcSubnetId = "subnet-043178c302cabfe37"
            keyPairName = "chubatova-amazon-ireland"
            instanceType = "t3.medium"
            securityGroups = listOf("sg-072d8bfa0626ea2a6")
            source = Source("ami-0b80008bcbc184132")
        }
        amazonEC2CloudProfile {
            id = "amazon-1"
            name = "prof1001"
            terminateIdleMinutes = 30
            region = AmazonEC2CloudProfile.Regions.EU_WEST_DUBLIN
            authType = accessKey {
                keyId = "credentialsJSON:985c2505-9be6-469a-aa1b-cc3e6f0e5895"
                secretKey = "credentialsJSON:e6178d43-b1a0-499c-afc0-cd2eaec95120"
            }
            param("agentPushPreset", "1705051069692")
        }
    }
}

object Build1 : BuildType({
    name = "build1"
})
