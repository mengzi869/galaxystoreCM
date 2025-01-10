plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android") version "1.8.0"
}
//repositories {
//    google()
//    mavenCentral()
//}
//apply(from = "topon.gradle")

android {
    namespace = "com.clean888.cleansuper.cleaner"
    compileSdk = 34
    buildFeatures {
        viewBinding = true
    }
    defaultConfig {
        applicationId = "com.jcbw.clean888.cleansuper"//包名不要动；string.xml里面的账号组件名称要对应修改；
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }

        javaCompileOptions {
            annotationProcessorOptions {

//                includeCompileClasspath = true
            }
        }


        ndk {
            abiFilters.add("armeabi-v7a")
            abiFilters.add("arm64-v8a")
        }
    }
    signingConfigs {
        create("release") {
            storeFile = file("cleaner.jks")
            storePassword = "123456"
            keyAlias = "cleaner"
            keyPassword = "123456"
        }
    }
    buildTypes {
        release {
            isMinifyEnabled = true
            isDebuggable = false
            signingConfig = signingConfigs.getByName("release")
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
        buildConfig = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }

    sourceSets {
        getByName("main") {
            jniLibs.srcDirs("libs") // 配置 JNI 库目录
        }
    }
}

dependencies {
//    implementation(fileTree(mapOf("include" to listOf("*.jar"), "dir" to listOf("libs"))))

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.appcompat.appcompat)
    implementation(libs.utilcodex)
    implementation("com.tencent:mmkv:2.0.0")
    implementation(libs.androidx.constraintlayout)
    implementation(libs.google.material)
    implementation(libs.androidx.fragment.fragment3)
    implementation(libs.com.airbnb.android.lottie3)
    implementation("io.github.CymChad:BaseRecyclerViewAdapterHelper:3.0.10")
    implementation(libs.live.event.bus)
    implementation(libs.json)
    implementation(libs.androidx.room.runtime)
    annotationProcessor("androidx.room:room-compiler:2.5.1")

    implementation(libs.rxjava)
    implementation("com.unity3d.ads:unity-ads:4.12.4")
    //implementation ("com.mbridge.msdk:foundation:16.8.61")
    implementation("androidx.exifinterface:exifinterface:1.3.7")
    //noinspection GradleDependency
    implementation("io.reactivex.rxjava3:rxandroid:3.0.2")

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

//    implementation(project(":overseas-support"))

}