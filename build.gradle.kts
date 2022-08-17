import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

apply(from = "gradle/integration-test.gradle.kts")

plugins {
	id("org.springframework.boot") version "2.7.2"
	id("io.spring.dependency-management") version "1.0.12.RELEASE"
	kotlin("jvm") version "1.6.21"
	kotlin("plugin.spring") version "1.6.21"
	id("io.kotest") version "0.3.9"
}

group = "com.github.akhilsunilkumar"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-couchbase-reactive")
	implementation("io.projectreactor.kotlin:reactor-kotlin-extensions")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")
	implementation("org.springframework:spring-webflux")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("io.projectreactor:reactor-test")
	testImplementation("io.kotest:kotest-assertions-core-jvm:5.4.2")
	testImplementation("io.kotest:kotest-runner-junit5-jvm:5.4.2")
	testImplementation("io.kotest:kotest-extensions-spring:5.4.2")
	testImplementation("io.kotest:kotest-property:5.4.2")
	testImplementation("io.kotest:kotest-extensions-testcontainers:5.4.2")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "17"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
