import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    id("maven-publish")
    signing

}

android {
    namespace = "com.karthik.pro.engr.previewers"
    compileSdk = 36

    defaultConfig {
        minSdk = 25

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    // Ensure sources JAR for publishing later
    publishing {
        singleVariant("release") {
            withSourcesJar()
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlin {
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11)
        }
    }


}
afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("release") {
                from(components["release"])

                groupId = "com.karthik.pro.engr.devtools"
                artifactId = "preview"
                version = "1.0.0"

                pom {
                    name.set("All Variants Preview")
                    description.set("A Compose multi-preview annotation for orientations, UI modes and so.")
                    url.set("https://github.com/YOUR_GH_USERNAME/YOUR_REPO")
                    licenses {
                        license {
                            name.set("Apache License 2.0")
                            url.set("https://www.apache.org/licenses/LICENSE-2.0")
                        }
                    }
                    developers {
                        developer {
                            id.set("karthik.pro.engr")
                            name.set("Karthik.pro.engr")
                        }
                    }
                    scm {
                        url.set("https://github.com/YOUR_GH_USERNAME/YOUR_REPO")
                        connection.set("scm:git:https://github.com/YOUR_GH_USERNAME/YOUR_REPO.git")
                        developerConnection.set("scm:git:ssh://github.com:YOUR_GH_USERNAME/YOUR_REPO.git")
                    }
                }
            }
        }
        repositories {
            maven {
                name = "GitHubPackages"
                url = uri("https://maven.pkg.github.com/YOUR_GH_USERNAME/YOUR_REPO")
                credentials {
                    username = findProperty("gpr.user") as String? ?: System.getenv("GITHUB_ACTOR")
                    password = findProperty("gpr.key") as String? ?: System.getenv("GITHUB_TOKEN")
                }
            }
        }
    }
}

signing {
    // Signing is optional for GitHub Packages, but we wire it for Maven Central later
    val signingKey: String? = findProperty("signing.key") as String?
    val signingPassword: String? = findProperty("signing.password") as String?
    if (!signingKey.isNullOrBlank() && !signingPassword.isNullOrBlank()) {
        useInMemoryPgpKeys(signingKey, signingPassword)
        sign(publishing.publications["release"])
    }
}


dependencies {

    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.junit.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.androidx.test.ext.truth)
    androidTestImplementation(libs.androidx.test.runner)
    androidTestImplementation(libs.androidx.test.espresso.core)



    // Compose BOM controls versions
    implementation(platform(libs.androidx.compose.bom))

    // Core runtime libraries
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.material3)

    // Preview-only (don’t leak to consumers)
    compileOnly(libs.androidx.compose.ui.tooling.preview)
    debugImplementation(libs.androidx.compose.ui.tooling)
}