package com.github.devotedmc.hiddenore;

import com.github.devotedmc.hiddenore.commands.CommandHandler;
import com.github.devotedmc.hiddenore.listeners.BlockBreakListener;
import com.github.devotedmc.hiddenore.listeners.ExploitListener;
import com.github.devotedmc.hiddenore.listeners.PlayerListener;
import com.github.devotedmc.hiddenore.listeners.WorldGenerationListener;
import com.github.devotedmc.hiddenore.tracking.BreakTracking;
import java.util.ArrayList;
import java.util.List;

import com.mineinabyss.blocky.api.BlockyBlocks;
import com.mineinabyss.geary.addons.GearyPhase;
import com.mineinabyss.geary.modules.GearyModuleKt;
import org.bukkit.Bukkit;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;

public class HiddenOre extends JavaPlugin {

	private static HiddenOre plugin;

	private static CommandHandler commandHandler;

	private static BreakTracking tracking;
	private static BukkitTask trackingSave;
	private static BukkitTask trackingMapSave;
	
	private static BlockBreakListener breakHandler;
	private static PlayerListener playerListener;
	private static ExploitListener exploitHandler;
	private static List<WorldGenerationListener> worldGen;

	@Override
	public void onEnable() {
		plugin = this;

		if (Bukkit.getPluginManager().isPluginEnabled("Blocky")) {
			GearyModuleKt.getGeary().getPipeline().intercept(GearyPhase.ENABLE, () -> {
				startupFunctions(plugin);
				return null;
			});
		} else startupFunctions(plugin);
	}

	public static void startupFunctions(HiddenOre plugin) {
		plugin.saveDefaultConfig();
		plugin.reloadConfig();
		Config.loadConfig();

		tracking = new BreakTracking();
		tracking.load();
		trackingSave = Bukkit.getScheduler().runTaskTimerAsynchronously(plugin, () -> tracking.save(), Config.trackSave, Config.trackSave);
		trackingMapSave = Bukkit.getScheduler().runTaskTimerAsynchronously(plugin, () -> tracking.saveMap(), Config.mapSave, Config.mapSave);

		exploitHandler = new ExploitListener(plugin);
		Bukkit.getServer().getPluginManager().registerEvents(exploitHandler, plugin);

		breakHandler = new BlockBreakListener(plugin);
		plugin.getServer().getPluginManager().registerEvents(breakHandler, plugin);

		playerListener = new PlayerListener();
		plugin.getServer().getPluginManager().registerEvents(playerListener, plugin);

		commandHandler = new CommandHandler(plugin);
		plugin.getCommand("hiddenore").setExecutor(commandHandler);

		worldGen = new ArrayList<>();

		ConfigurationSection worldGenConfig = Config.instance.getWorldGenerations();
		if (worldGenConfig != null) {
			for (String key : worldGenConfig.getKeys(false)) {
				// this.getLogger().log(Level.INFO, "Registered Ore Generation Suppression Listener for World {0}", key);
				WorldGenerationListener list = new WorldGenerationListener(worldGenConfig.getConfigurationSection(key));
				plugin.getServer().getPluginManager().registerEvents(list, plugin);
				worldGen.add(list);
			}
		}
	}

	@Override
	public void onDisable() {
		trackingSave.cancel();
		trackingMapSave.cancel();
		tracking.save();
		tracking.saveMap();
	}

	public static HiddenOre getPlugin() {
		return plugin;
	}

	public BreakTracking getTracking() {
		return tracking;
	}
	
	public BlockBreakListener getBreakListener() {
		return breakHandler;
	}
}
