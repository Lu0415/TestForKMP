import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.plugin.mpp.apple.XCFramework

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
}

kotlin {
    // 定義 XCFramework
    val xcf = XCFramework()

    androidTarget {
        compilations.all {
            compileTaskProvider.configure {
                compilerOptions {
                    jvmTarget.set(JvmTarget.JVM_1_8)
                }
            }
        }
    }

    // 添加 iOS targets
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared" // 設定框架名稱
            isStatic = true     // 設定為靜態框架 (根據需要)
            xcf.add(this)       // 添加到 XCFramework
        }
    }

    sourceSets {
        commonMain.dependencies {
            // 添加跨平台的依賴
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
    }
}

android {
    namespace = "com.example.mytestapplication"
    compileSdk = 34
    defaultConfig {
        minSdk = 29
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

tasks.register("customAssembleXCFramework") {
    group = "build"
    description = "Assemble XCFramework for iOS targets"

    doLast {
        val frameworkName = "shared"
        val outputDir = layout.buildDirectory.get().dir("xcframework").asFile
        val frameworksDir = layout.buildDirectory.get().dir("bin").asFile

        // 確保輸出目錄存在
        outputDir.mkdirs()

        // 使用 xcodebuild 將各個 Framework 合併為 XCFramework
        exec {
            commandLine(
                "xcodebuild",
                "-create-xcframework",
                "-framework", frameworksDir.resolve("iosArm64/debugFramework/$frameworkName.framework").absolutePath,
                "-framework", frameworksDir.resolve("iosSimulatorArm64/debugFramework/$frameworkName.framework").absolutePath,
                "-framework", frameworksDir.resolve("iosX64/debugFramework/$frameworkName.framework").absolutePath, // 如果需要支持 x64 模擬器
                "-output", outputDir.resolve("$frameworkName.xcframework").absolutePath
            )
        }
    }
}