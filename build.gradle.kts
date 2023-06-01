@Suppress("DSL_SCOPE_VIOLATION")
plugins {
	alias(libs.plugins.mia.kotlin.jvm)
	alias(libs.plugins.kotlinx.serialization)
	alias(libs.plugins.mia.papermc)
	alias(libs.plugins.mia.copyjar)
	alias(libs.plugins.mia.publication)
	alias(libs.plugins.mia.autoversion)
}


repositories {
	maven("https://repo.mineinabyss.com/releases")
	maven("https://repo.mineinabyss.com/snapshots")
	maven("https://maven.enginehub.org/repo")
}

dependencies {
	compileOnly(hiddenlibs.minecraft.plugin.worldguard)
	compileOnly(libs.bundles.idofront.core)
	compileOnly(hiddenlibs.minecraft.plugin.geary.papermc)
	compileOnly(hiddenlibs.minecraft.plugin.blocky)
}
