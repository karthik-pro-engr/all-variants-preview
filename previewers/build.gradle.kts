import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    `maven-publish`
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

    // ✅ Ensure publishing component exists
    publishing {
        singleVariant("release") {
            withSourcesJar()
            withJavadocJar()
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
                from(components["release"]) // ✅ component is ready

                groupId = "io.github.karthik_pro_engr.devtools"
                artifactId = "preview"
                version = "v0.1.0"

                pom {
                    name.set("All Variants Preview")
                    description.set("A Compose multi-preview annotation for orientations, UI modes and so.")
                    url.set("https://github.com/karthik-pro-engr/all-variants-preview")
                    licenses {
                        license {
                            name.set("Apache License 2.0")
                            url.set("https://www.apache.org/licenses/LICENSE-2.0")
                        }
                    }
                    developers {
                        developer {
                            id.set("karthik.pro.engr")
                            name.set("Karthik Pro Engr")
                        }
                    }
                    scm {
                        url.set("https://github.com/karthik-pro-engr/all-variants-preview")
                        connection.set("scm:git:https://github.com/karthik-pro-engr/all-variants-preview.git")
                        developerConnection.set("scm:git:ssh://github.com:karthik-pro-engr/all-variants-preview.git")
                    }
                }
            }
        }

        repositories {
            maven {
                name = "CentralPortal"
                url = uri("https://central.sonatype.com/api/v1/publish")
                credentials {
                    username = System.getenv("SONATYPE_USERNAME") ?: ""
                    password = System.getenv("SONATYPE_PASSWORD") ?: ""
                }
                /*name = "GitHubPackages"
                url = uri("https://maven.pkg.github.com/karthik-pro-engr/all-variants-preview")
                credentials {
                    username = findProperty("gpr.user") as String? ?: System.getenv("GITHUB_ACTOR")
                    password = System.getenv("GPR_KEY")
                }*/
            }
        }
    }
}
afterEvaluate {
    signing {
        val signingKey = System.getenv("SIGNING_KEY")
        val signingPassword = System.getenv("SIGNING_PASSWORD")

        if (!signingKey.isNullOrBlank() && !signingPassword.isNullOrBlank()) {
            useInMemoryPgpKeys(signingKey, signingPassword)
            sign(publishing.publications["release"])
        } else {
            logger.lifecycle("Signing keys not found in env or gradle.properties; skipping signing.")
        }
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
