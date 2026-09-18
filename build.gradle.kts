import net.minecrell.pluginyml.bukkit.BukkitPluginDescription.Permission.Default.OP
import net.minecrell.pluginyml.bukkit.BukkitPluginDescription.Permission.Default.TRUE
import net.minecrell.pluginyml.bukkit.BukkitPluginDescription.PluginLoadOrder.POSTWORLD
import net.minecrell.pluginyml.paper.PaperPluginDescription.RelativeLoadOrder.BEFORE

plugins {
	alias(miaLibs.plugins.mia.kotlin.jvm)
	alias(miaLibs.plugins.kotlinx.serialization)
	alias(miaLibs.plugins.mia.papermc)
	alias(miaLibs.plugins.mia.copyjar)
	alias(miaLibs.plugins.mia.publication)
	alias(miaLibs.plugins.mia.autoversion)
}


repositories {
	maven("https://repo.mineinabyss.com/releases")
	maven("https://repo.mineinabyss.com/snapshots")
	maven("https://repo.mineinabyss.com/mirror")
	maven("https://maven.enginehub.org/repo")
	mavenLocal()
}

dependencies {
	compileOnly(miaLibs.bundles.idofront.core)
	compileOnly(miaLibs.geary.papermc)
	compileOnly(miaLibs.minecraft.plugin.nexo)
	compileOnly(miaLibs.deeperworld)
	compileOnly(hiddenlibs.minecraft.plugin.mineinabyss.features)
	compileOnly(hiddenlibs.minecraft.plugin.mineinabyss.components)
}

paper {
	name = "HiddenOre"
	main = "com.github.devotedmc.hiddenore.HiddenOre"
	author = "Soerxpso"
	authors = listOf("ProgrammerDan")
	website = "https://www.github.com/DevotedMC/HiddenOre"
	description = "HiddenOre allows the complete disguising of ores from players by not generating them in the first place, instead using a probability model to generate configurable ore layouts in response to player mining."
	apiVersion = "1.21"
	load = POSTWORLD

	permissions {
		register("hiddenore.*") {
			description = "Gives access to all HiddenOre commands"
			default = OP
			children = listOf("hiddenore.adv")
		}
		register("hiddenore.toggle") {
			description = "Allows players to toggle Ore Generation."
			default = TRUE
		}
		register("hiddenore.admin") {
			description = "Allows access to reload or debug commands"
			default = OP
		}
	}

	serverDependencies {
		register("Idofront") {
			required = true
			load = BEFORE
			joinClasspath = true
		}
		register("Geary") {
			required = true
			load = BEFORE
			joinClasspath = true
		}
		register("MineInAbyss") {
			required = true
			load = BEFORE
			joinClasspath = true
		}
		register("Nexo") {
			required = true
			load = BEFORE
			joinClasspath = true
		}
	}
}
