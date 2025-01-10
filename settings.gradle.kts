pluginManagement {
    repositories {
        maven ( "https://maven.aliyun.com/repository/central")
        maven ( "https://maven.aliyun.com/repository/public")
        maven ( "https://maven.aliyun.com/repository/google")
        maven ( "https://maven.aliyun.com/repository/gradle-plugin")

        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        maven ( "https://maven.aliyun.com/repository/central")
        maven ( "https://maven.aliyun.com/repository/public")
        maven ( "https://maven.aliyun.com/repository/google")
        maven ( "https://maven.aliyun.com/repository/gradle-plugin")

        //Anythink(Core)
        maven ("https://jfrog.anythinktech.com/artifactory/overseas_sdk")
        //Ironsource
        maven ("https://android-sdk.is.com/")
        //Pangle
        maven ("https://artifact.bytedance.com/repository/pangle")
        //Mintegral
        maven ("https://dl-maven-android.mintegral.com/repository/mbridge_android_sdk_oversea")

        google()
        mavenCentral()
        maven ("https://jitpack.io")
    }
}

rootProject.name = "CleanMaster"
include(":app")
//include(":overseas-support")
