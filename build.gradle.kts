plugins {
	id("com.mineinabyss.conventions.papermc")
	id("com.mineinabyss.conventions.publication")
}

repositories {
	maven("https://repo.mineinabyss.com/releases")
	maven("https://maven.enginehub.org/repo")
}

val worldGuardVersion: String by project

dependencies {
	compileOnly(hiddenlibs.minecraft.plugin.worldguard)
}
