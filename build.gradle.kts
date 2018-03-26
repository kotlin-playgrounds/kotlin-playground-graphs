import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.jetbrains.kotlin.gradle.dsl.Coroutines

val kotlinVersion by project
val tinkerpopVersion by extra { "3.3.1" }
val jgraphxVersion by extra { "3.9.3" }
val jgraphtVersion by extra { "1.1.0" }

plugins {
    kotlin("jvm") version "1.2.30"
}

repositories {
    jcenter()
    mavenCentral()
    maven(url = "https://jitpack.io")
}

dependencies {
    compile(kotlin("stdlib", "$kotlinVersion"))
    compile(kotlin("stdlib-jdk7", "$kotlinVersion"))
    compile(kotlin("stdlib-jdk8", "$kotlinVersion"))
    compile(kotlin("reflect", "$kotlinVersion"))

    compile("org.apache.tinkerpop:gremlin-core:$tinkerpopVersion")
    compile("org.apache.tinkerpop:tinkergraph-gremlin:$tinkerpopVersion")

    compile("com.github.jgraph:jgraphx:v$jgraphxVersion")
    compile("org.jgrapht:jgrapht-core:$jgraphtVersion")
    compile("org.jgrapht:jgrapht-ext:$jgraphtVersion")
}

dependencies {
    testCompile(kotlin("test", "$kotlinVersion"))
    testCompile(kotlin("test-junit", "$kotlinVersion"))
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

kotlin {
    experimental.coroutines = Coroutines.ENABLE
}

tasks {
    withType<KotlinCompile> {
        kotlinOptions.jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
}
