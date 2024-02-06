import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildSteps.maven
import jetbrains.buildServer.configs.kotlin.buildSteps.script


version = "2023.11"

project {



    val numProjects=12
    val numConfigurationsPerProject=800


    for (i in 0..numProjects) {
        subProject {
            id("subProj_$i")
            name = "subProj $i"

for (j in 0..1)
                buildType {
                    id("Auto_$i" + "_$j")
                    name = "auto $i $j"                    
                    vcs {
                        root(DslContext.settingsRoot)
                        }
                    steps {
                    maven {
                    id = "Maven2"
                    goals = "clean test"
                    runnerArgs = "-Dmaven.test.failure.ignore=true"
                    mavenVersion = auto()
                            }
                    }
                }

                buildType {
                    id("Mvn_$i" + "_$j")
                    name = "bundled 3.2.5 $i $j"                    
                    vcs {
                        root(DslContext.settingsRoot)
                        }
                    steps {
                    maven {
                    id = "Maven2"
                    goals = "clean test"
                    runnerArgs = "-Dmaven.test.failure.ignore=true"
                    mavenVersion = bundled_3_2()
                            }
                    }
                }
}

        }
    }
}

/*


project {

    buildType(NonBundled396)
    buildType(Mvn)
    buildType(BundledDefault363)
    buildType(Auto)
    buildType(Nonbundled322)
    buildType(OutsideOfRunner)

    params {
        param("env.M2_HOME", "/opt/homebrew/Cellar/maven/3.9.5/libexec")
    }
}

object Auto : BuildType({
    name = "auto"

    vcs {
        root(DslContext.settingsRoot)
    }

    steps {
        maven {
            id = "Maven2"
            goals = "clean test"
            runnerArgs = "-Dmaven.test.failure.ignore=true"
            mavenVersion = auto()
        }
    }
})

object BundledDefault363 : BuildType({
    name = "bundledDefault3.6.3"

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

object Mvn : BuildType({
    name = "bundled3.2.5"

    vcs {
        root(DslContext.settingsRoot)
    }

    steps {
        maven {
            id = "Maven2"
            goals = "clean test"
            runnerArgs = "-Dmaven.test.failure.ignore=true"
            mavenVersion = bundled_3_2()
            dockerImage = "openjdk:17-ea-slim"
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
                path = "%teamcity.tool.maven.3.9.6%"
            }
            dockerImage = "openjdk:17-ea-slim"
        }
    }
})

object Nonbundled322 : BuildType({
    name = "nonbundled3.2.2"

    vcs {
        root(DslContext.settingsRoot)
    }

    steps {
        maven {
            id = "Maven2"
            goals = "clean test"
            runnerArgs = "-Dmaven.test.failure.ignore=true"
            mavenVersion = custom {
                path = "%teamcity.tool.maven.3.2.2%"
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
                echo '%mvn2%'
            """.trimIndent()
        }
    }
})

*/
