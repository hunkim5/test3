plugins {
    java
    id("org.springframework.boot") version "3.3.3"
    id("io.spring.dependency-management") version "1.1.6"
    id("checkstyle")
    id("org.sonarqube") version "4.4.1.3373"
    id("jacoco")
}

group = "com.airpremia"
version = "0.0.1-SNAPSHOT"
description = "airpremia eosh"

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}

repositories {
    mavenCentral()
    // 임시적용
    maven {
        url = uri("http://49.254.216.206:8081/repository/airpremia-core/")
        isAllowInsecureProtocol = true
    }
}

dependencies {
    implementation("org.springframework.boot:spring-boot")
    implementation("org.springframework.boot:spring-boot-starter-aop")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springframework.data:spring-data-commons")
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springframework.boot:spring-boot-configuration-processor")
    developmentOnly("org.springframework.boot:spring-boot-devtools")
    implementation("org.mybatis.spring.boot:mybatis-spring-boot-starter:3.0.3")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.17.1")
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.5.0")
    implementation("org.mybatis:mybatis:3.5.13")
    implementation("com.mysql:mysql-connector-j")
    implementation("org.apache.commons:commons-lang3")
    implementation("commons-io:commons-io:2.16.1")
    implementation("com.github.f4b6a3:uuid-creator:6.0.0")
    
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.3")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.9.3")

    implementation("com.airpremia.esmsfos:ap-esmsfos-core-data:0.0.18")
    implementation("com.airpremia.esmsfos:ap-esmsfos-core-web:0.0.14")

    implementation("org.springframework.cloud:spring-cloud-starter-vault-config")
    implementation("org.apache.poi:poi:5.3.0")
    implementation("org.apache.poi:poi-ooxml:5.3.0")
    implementation("org.projectlombok:lombok")
    implementation("org.springframework.boot:spring-boot-starter-hateoas")
    annotationProcessor("org.projectlombok:lombok")

    implementation("io.jsonwebtoken:jjwt-impl:0.12.6")
    implementation("io.jsonwebtoken:jjwt-jackson:0.12.6")
}

dependencyManagement {
    imports {
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:2023.0.3")
    }
}

tasks.withType<JavaCompile> {
    options.compilerArgs.add("-parameters")
    options.encoding = "UTF-8"
}

checkstyle {
    maxWarnings = 0
    configFile = file("${rootDir}/ide-editor-config/airpremia-checkstyle-rules.xml")
    toolVersion = "10.17.0"
}

tasks.withType<Checkstyle>().configureEach {
    reports {
        xml.required = false
        html.required = true
    }
}

sonar {
    properties {
        property("sonar.projectKey", "airpremia_ap-eosh_2bb9a822-85de-4b7b-a721-1594d9178914")
        property("sonar.projectName", "ap-eosh")
        property("sonar.gradle.skipCompile", "true")
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.test {
    finalizedBy(tasks.jacocoTestReport)
}

tasks.jacocoTestReport {
    reports {
        xml.required = false
        csv.required = false
        html.required = true
        html.outputLocation = layout.buildDirectory.dir("jacocoHtml")
    }
    dependsOn(tasks.test)
}
