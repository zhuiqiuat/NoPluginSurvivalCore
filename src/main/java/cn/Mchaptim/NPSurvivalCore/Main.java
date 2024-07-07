package cn.Mchaptim.NPSurvivalCore;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	private static Main plugin;

	@Override
	public void onEnable() {
		plugin = this;
		Config.loadConfig();
		Bukkit.getPluginManager().registerEvents(new Listeners(), this);
	}

	public static Main getPlugin() {
		return plugin;
	}
}
