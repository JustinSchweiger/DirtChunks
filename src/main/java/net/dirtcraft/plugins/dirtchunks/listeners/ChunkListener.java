package net.dirtcraft.plugins.dirtchunks.listeners;

import net.dirtcraft.plugins.dirtchunks.DirtChunks;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.ChunkLoadEvent;

import java.util.logging.Level;

public class ChunkListener implements Listener {
	@EventHandler
	public void onChunkLoad(ChunkLoadEvent event) {
		if (!DirtChunks.config.enabled) return;

		Bukkit.getServer().getLogger().log(Level.INFO, ChatColor.GREEN + "Loaded chunk " + ChatColor.AQUA + event.getChunk().getX() + ChatColor.GREEN + ", " + ChatColor.AQUA + event.getChunk().getZ() + ChatColor.GREEN + " in world " + ChatColor.YELLOW + event.getWorld().getName());
	}
}
