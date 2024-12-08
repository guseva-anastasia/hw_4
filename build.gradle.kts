plugins {
    id("java")
}

group = "guru-qa-hw"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("com.codeborne:selenide:6.19.1")
}

tasks.test {
    useJUnitPlatform()
}