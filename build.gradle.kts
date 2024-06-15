@Suppress("DSL_SCOPE_VIOLATION")
plugins {
	alias(idofrontLibs.plugins.mia.kotlin.jvm)
	alias(idofrontLibs.plugins.kotlinx.serialization)
	alias(idofrontLibs.plugins.mia.papermc)
	alias(idofrontLibs.plugins.mia.copyjar)
	alias(idofrontLibs.plugins.mia.publication)
	alias(idofrontLibs.plugins.mia.autoversion)
}


repositories {
	maven("https://repo.mineinabyss.com/releases")
	maven("https://repo.mineinabyss.com/snapshots")
	maven("https://maven.enginehub.org/repo")
	mavenLocal()
}

dependencies {
	compileOnly(idofrontLibs.bundles.idofront.core)
	compileOnly(hiddenlibs.minecraft.plugin.geary.papermc)
	compileOnly(hiddenlibs.minecraft.plugin.blocky)
	compileOnly(hiddenlibs.minecraft.plugin.deeperworld)
	compileOnly(hiddenlibs.minecraft.plugin.mineinabyss)
}
