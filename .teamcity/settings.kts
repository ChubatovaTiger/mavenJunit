import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildSteps.maven
import jetbrains.buildServer.configs.kotlin.buildSteps.script

version = "2023.11"

project {
    val numProjects=3000
    
    for (i in 0..numProjects) {
        subProject {
            id("subProj_$i")
            name = "subProj $i"
        for (j in 0..1) {

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

            subProject {
                id("subProj2_$i")
                name = "subProj2 $i"
                subProject {
                id("subProj3_$i")
                name = "subProj3 $i"
                subProject {
                id("subProj4_$i")
                name = "subProj4 $i"
                subProject {
                id("subProj5_$i")
                name = "subProj5 $i"
                subProject {
                id("subProj6_$i")
                name = "subProj6 $i"
                }
                subProject {
                id("subProj7_$i")
                name = "subProj7 $i"
                subProject {
                id("subProj8_$i")
                name = "subProj8 $i"
 for (j in 0..1) {
                 buildType {
                    id("BundledDefault363_$i" + "_$j")
                    name = "BundledDefault363 $i $j"                    
                    vcs {
                        root(DslContext.settingsRoot)
                        }
                    steps {
                    maven {
                    id = "Maven2"
                    goals = "clean test"
                    runnerArgs = "-Dmaven.test.failure.ignore=true"
                    //mavenVersion = bundled_3_2()
                            }
                    }
                }

                 buildType {
                    id("NonBundled396_$i" + "_$j")
                    name = "NonBundled396 $i $j"                    
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
                            }
                    }
                }

                 buildType {
                    id("Nonbundled322_$i" + "_$j")
                    name = "Nonbundled322 $i $j"                    
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
                            }
                    }
                }

                 buildType {
                    id("outsideOfRunner_$i" + "_$j")
                    name = "outsideOfRunner $i $j"                    
                    vcs {
                        root(DslContext.settingsRoot)
                        }
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
                }



                }
                }    
                }
                }
                }
            }


            }
        }
    }
}


