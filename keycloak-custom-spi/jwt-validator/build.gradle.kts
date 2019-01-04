plugins {
    java
    id("com.mkring.wildlydeplyplugin.deploy-wildfly-plugin")
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}

dependencies {
    val keycloakVersion = ext.get("keycloakVersion") as String
    compileOnly( "org.keycloak","keycloak-core", keycloakVersion)
    compileOnly( "org.keycloak","keycloak-server-spi", keycloakVersion)
    compileOnly( "org.keycloak","keycloak-server-spi-private", keycloakVersion)
    compileOnly( "org.keycloak","keycloak-services", keycloakVersion)
    testCompile("junit", "junit", "4.12")
}

task("deploy", com.mkring.wildlydeplyplugin.DeployWildflyTask::class) {
    host = "localhost"
    port = 10090
    user = "admin"
    password = "admin"
    deploymentName = project.name
    runtimeName = "${project.name}-$version.jar"
    file = "$buildDir/libs/${project.name}-$version.jar".apply { println("file=$this") }
}