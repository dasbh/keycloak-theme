plugins {
    base
    id("com.mkring.wildlydeplyplugin.deploy-wildfly-plugin") version "0.2.8"  apply false
}


allprojects {
    group = "org.keycloak.custom"
    version = "1.0.0"

    ext{
        set("keycloakVersion", "4.8.1.Final")
    }

    repositories {
        mavenCentral()
        maven {
            url = uri("http://repository.jboss.org/nexus/content/groups/public/")
        }
    }
}
