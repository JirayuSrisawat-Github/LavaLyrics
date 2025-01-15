plugins {
   `java-library`
    id("dev.arbjerg.lavalink.gradle-plugin") version "1.0.15"
}

base {
    archivesName = "lavalyrics"
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
}

lavalinkPlugin {
    name = "lavalyrics"
    apiVersion = "4.0.5"
    serverVersion = "4.0.5"
    configurePublishing = false
}

java {
    withJavadocJar()
    withSourcesJar()
}

dependencies {
    compileOnly("dev.arbjerg:lavaplayer:2.0.4")
    compileOnly("org.jetbrains:annotations:24.0.1")
    compileOnly("org.slf4j:slf4j-api:2.0.16")
    implementation("org.jetbrains.kotlin:kotlin-annotations-jvm:1.9.0")
    implementation("org.slf4j:slf4j-api:2.0.16")
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            from(components["java"])
            artifactId = base.archivesName.get()
        }
    }
}

