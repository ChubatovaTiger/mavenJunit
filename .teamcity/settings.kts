import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildSteps.maven
import jetbrains.buildServer.configs.kotlin.buildSteps.script

version = "2023.11"

project {
    val numProjects=2000
    
    for (i in 0..numProjects) {
        subProject {
            id("subProj$i")
            name = "subProj $i"
        for (j in 0..1) {

                buildType {
                    id("subProj$i" + "_Auto$i" + "$j")
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
                    id("subProj$i" +"_Mvn$i" + "$j")
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
                id("subProj$i" + "_subProj2")
                name = "subProj2 $i"
                subProject {
                id("subProj$i" + "_subProj2" + "_subProj3")
                name = "subProj3 $i"
                subProject {
                id("subProj$i" + "_subProj2" + "_subProj3" + "_subProj4")
                name = "subProj4 $i"
                subProject {
                id("subProj$i" + "_subProj2" + "_subProj3" + "_subProj4" + "_subProj5")
                name = "subProj5 $i"
                subProject {
                id("subProj$i" + "_subProj2" + "_subProj3" + "_subProj4" + "_subProj5" + "_subProj6")
                name = "subProj6 $i"
                }
                subProject {
                id("subProj$i" + "_subProj2" + "_subProj3" + "_subProj4" + "_subProj5" + "_subProj6" + "_subProj7")
                name = "subProj7 $i"
                subProject {
                id("subProj$i" + "_subProj2" + "_subProj3" + "_subProj4" + "_subProj5" + "_subProj6" + "_subProj7"  + "_subProj8")
                name = "subProj8 $i"
 for (j in 0..1) {
                 buildType {
                    id("subProj$i" + "_subProj2" + "_subProj3" + "_subProj4" + "_subProj5" + "_subProj6" + "_subProj7"  + "_subProj8" + "_BundledDefault363$i" + "$j")
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
                    id("subProj$i" + "_subProj2" + "_subProj3" + "_subProj4" + "_subProj5" + "_subProj6" + "_subProj7"  + "_subProj8" + "_NonBundled396$i" + "$j")
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
                    id("subProj$i" + "_subProj2" + "_subProj3" + "_subProj4" + "_subProj5" + "_subProj6" + "_subProj7"  + "_subProj8" + "_Nonbundled322$i" + "$j")
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
                    id("subProj$i" + "_subProj2" + "_subProj3" + "_subProj4" + "_subProj5" + "_subProj6" + "_subProj7"  + "_subProj8" + "_outsideOfRunner$i" + "$j")
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


