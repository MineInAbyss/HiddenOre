pluginManagement {
	repositories {
		gradlePluginPortal()
		maven("https://repo.mineinabyss.com/releases")
		maven("https://repo.mineinabyss.com/snapshots")
		maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
		maven("https://repo.papermc.io/repository/maven-public/") //Paper
	}
}

dependencyResolutionManagement {
	val idofrontVersion: String by settings

	repositories {
		mavenLocal()
		maven("https://repo.mineinabyss.com/releases")
	}

	versionCatalogs {
		create("libs").from("com.mineinabyss:catalog:$idofrontVersion")
		create("hiddenlibs").from(files("gradle/hiddenlibs.versions.toml"))
	}
}

rootProject.name = "HiddenOre"
