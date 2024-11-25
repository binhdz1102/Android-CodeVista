// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.kotlin.jvm) apply false
    alias(libs.plugins.kotlinAndroid) apply false
    alias(libs.plugins.android.hilt) apply false
    alias(libs.plugins.android.room) apply false
    alias(libs.plugins.ksp) apply false
    alias(libs.plugins.androidTest) apply false
}

tasks.withType<Test> {

    useJUnitPlatform()

}