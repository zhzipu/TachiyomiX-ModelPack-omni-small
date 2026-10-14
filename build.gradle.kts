plugins {
    id("com.android.application") version "9.2.1"
}

android {
    namespace = "com.tachiyomix.modelpack.omnismall"
    compileSdk = 37

    defaultConfig {
        applicationId = "com.tachiyomix.modelpack.omnismall"
        minSdk = 26
        targetSdk = 36
        versionCode = 7
        versionName = "1.4"
        manifestPlaceholders["modelpackId"] = "omni-small"
        manifestPlaceholders["modelpackName"] = "Omni Small 模型"
    }

    buildTypes {
        named("release") {
            // 侧载安装，与原 model-packs 模块一致使用 debug 签名
            signingConfig = signingConfigs.getByName("debug")
            isMinifyEnabled = false
            isShrinkResources = false
        }
    }

    // 自带 libmodelpack.so 的模型包必须解压原生库到 nativeLibraryDir，
    // 宿主才能用系统认可的路径 dlopen；否则 .so 留在 APK 内会被拒绝加载
    packaging {
        jniLibs {
            useLegacyPackaging = true
        }
    }

    lint {
        abortOnError = false
        checkReleaseBuilds = false
    }
}

androidComponents {
    onVariants { variant ->
        variant.outputs.forEach { output ->
            output.outputFileName.set("TachiyomiX-modelpack-omni-small-release.apk")
        }
    }
}

// 工程里没有任何 Kotlin 源码：去掉标准库依赖，避免它的 classes 被 dex 进 APK
// （否则 APK 会白白大 0.6~0.7 MB，全是没有用到的 Kotlin 运行时）
configurations.configureEach {
    exclude(group = "org.jetbrains.kotlin", module = "kotlin-stdlib")
}
