plugins {
    id("java")
}

group = "com.hihusky"
version = "unspecified"

repositories {
    mavenCentral()
}

dependencies {
    // spring context with latest version
    implementation("org.springframework:spring-context:6.0.7")
    // spring aop with latest version
    implementation("org.springframework:spring-aop:6.0.7")
    // aspectjweaver with latest version
    implementation("org.aspectj:aspectjweaver:1.9.8")

    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}