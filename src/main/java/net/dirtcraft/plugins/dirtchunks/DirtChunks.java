package net.dirtcraft.plugins.dirtchunks;

import com.moandjiezana.toml.Toml;
import net.dirtcraft.plugins.dirtchunks.config.Config;
import net.dirtcraft.plugins.dirtchunks.listeners.ChunkListener;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public final class DirtChunks extends JavaPlugin {

	public static Config config;

	@Override
	public void onEnable() {
		loadConfig();
		getServer().getPluginManager().registerEvents(new ChunkListener(), this);
	}

	public void loadConfig() {
		if (!this.getDataFolder().exists()) {
			this.getDataFolder().mkdirs();
		}
		File file = new File(this.getDataFolder(), "config.toml");
		if (!file.exists()) {
			try {
				Files.copy(this.getResource("config.toml"), file.toPath());
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		config = new Toml(new Toml().read(this.getResource("config.toml"))).read(file).to(Config.class);
	}
}
