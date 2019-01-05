plugins {
    java
//    ear
    id("com.mkring.wildlydeplyplugin.deploy-wildfly-plugin")
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}

dependencies {
    val keycloakVersion = ext.get("keycloakVersion") as String
    compileOnly("org.keycloak", "keycloak-core", keycloakVersion)
    compileOnly("org.keycloak", "keycloak-server-spi", keycloakVersion)
    compileOnly("org.keycloak", "keycloak-server-spi-private", keycloakVersion)
    compileOnly("org.keycloak", "keycloak-services", keycloakVersion)

//    earlib(group = "com.google.guava", name = "guava", version = "21.0", ext = "jar")
}


//ear {
//    appDirName = "src/main/application"
//    libDirName = "lib"
//    deploymentDescriptor {
//        fileName = "application.xml"
//        version = "6"
//        applicationName = project.name
//        initializeInOrder = true
//        displayName = "user-storage"
//        description = "User Storage SPI"
////        securityRole("admin")
////        withXml {
////            // add a custom node to the XML
////            asElement().apply {
////                appendChild(ownerDocument.createElement("data-source").apply { textContent = "my/data/source" })
////            }
////        }
//    }
//}

task("deploy", com.mkring.wildlydeplyplugin.DeployWildflyTask::class) {
    host = "localhost"
    port = 10090
    user = "admin"
    password = "admin"
    deploymentName = project.name
    runtimeName = "${project.name}-$version.jar"
    file = "$buildDir/libs/${project.name}-$version.jar".apply { println("file=$this") }
}