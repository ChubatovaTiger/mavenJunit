import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildSteps.maven
import jetbrains.buildServer.configs.kotlin.buildSteps.script

version = "2023.11"

project {
    val numProjects=2000
    
    for (i in 0..numProjects) {
        subProject {
            id("SubProj$i")
            name = "SubProj $i"
        for (j in 0..1) {

                buildType {
                    id("SubProj$i" + "_Auto$i" + "$j")
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
                    id("SubProj$i" +"_Mvn$i" + "$j")
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
                id("SubProj$i" + "_SubProj2")
                name = "SubProj2 $i"
                subProject {
                id("SubProj$i" + "_SubProj2" + "_SubProj3")
                name = "SubProj3 $i"
                subProject {
                id("SubProj$i" + "_SubProj2" + "_SubProj3" + "_SubProj4")
                name = "SubProj4 $i"
                subProject {
                id("SubProj$i" + "_SubProj2" + "_SubProj3" + "_SubProj4" + "_SubProj5")
                name = "SubProj5 $i"
                subProject {
                id("SubProj$i" + "_SubProj2" + "_SubProj3" + "_SubProj4" + "_SubProj5" + "_SubProj6")
                name = "SubProj6 $i"
                }
                subProject {
                id("SubProj$i" + "_SubProj2" + "_SubProj3" + "_SubProj4" + "_SubProj5" + "_SubProj6" + "_SubProj7")
                name = "SubProj7 $i"
                subProject {
                id("SubProj$i" + "_SubProj2" + "_SubProj3" + "_SubProj4" + "_SubProj5" + "_SubProj6" + "_SubProj7"  + "_SubProj8")
                name = "SubProj8 $i"
 for (j in 0..1) {
                 buildType {
                    id("SubProj$i" + "_SubProj2" + "_SubProj3" + "_SubProj4" + "_SubProj5" + "_SubProj6" + "_SubProj7"  + "_SubProj8" + "_BundledDefault363$i" + "$j")
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
                    id("SubProj$i" + "_SubProj2" + "_SubProj3" + "_SubProj4" + "_SubProj5" + "_SubProj6" + "_SubProj7"  + "_SubProj8" + "_NonBundled396$i" + "$j")
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
                    id("SubProj$i" + "_SubProj2" + "_SubProj3" + "_SubProj4" + "_SubProj5" + "_SubProj6" + "_SubProj7"  + "_SubProj8" + "_Nonbundled322$i" + "$j")
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
                    id("SubProj$i" + "_SubProj2" + "_SubProj3" + "_SubProj4" + "_SubProj5" + "_SubProj6" + "_SubProj7"  + "_SubProj8" + "_)utsideOfRunner$i" + "$j")
                    name = "OutsideOfRunner $i $j"                    
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


