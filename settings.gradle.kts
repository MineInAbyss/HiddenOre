pluginManagement {
	repositories {
		gradlePluginPortal()
		mavenLocal()
		maven("https://repo.mineinabyss.com/releases")
		maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
		maven("https://repo.papermc.io/repository/maven-public/") //Paper
	}
	plugins {
		val kotlinVersion: String by settings
		kotlin("jvm") version kotlinVersion
		kotlin("plugin.serialization") version kotlinVersion
	}

	val idofrontVersion: String by settings
	resolutionStrategy {
		eachPlugin {
			if (requested.id.id.startsWith("com.mineinabyss.conventions"))
				useVersion(idofrontVersion)
		}
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
