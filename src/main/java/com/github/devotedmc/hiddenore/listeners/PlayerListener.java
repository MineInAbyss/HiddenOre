package com.github.devotedmc.hiddenore.listeners;

import com.github.devotedmc.hiddenore.HiddenOre;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.UUID;

public class PlayerListener implements Listener {
	public static HashSet<UUID> disabledPlayers = new HashSet<>();

	@EventHandler
	public static void onPlayerJoin(PlayerJoinEvent event) {
		UUID uuid = event.getPlayer().getUniqueId();
		if (disabledPlayers.contains(uuid)) {
			disabledPlayers.remove(uuid);
			event.getPlayer().sendMessage(ChatColor.GREEN + "Ore-Generation has been enabled.");
		}
	}
}
