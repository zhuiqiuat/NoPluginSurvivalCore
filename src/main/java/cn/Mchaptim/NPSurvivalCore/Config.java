package cn.Mchaptim.NPSurvivalCore;

import java.util.Random;

import org.bukkit.configuration.file.FileConfiguration;

public class Config {
	public static int MinX;
	public static int MinZ;
	public static int MaxX;
	public static int MaxZ;
	public static String World;
	public static String Chat_Format;

	public static void loadConfig() {
		Main.getPlugin().saveDefaultConfig();
		Main.getPlugin().reloadConfig();
		FileConfiguration config = Main.getPlugin().getConfig();
		MinX = config.getInt("Spawn.MinX");
		MinZ = config.getInt("Spawn.MinZ");
		MaxX = config.getInt("Spawn.MaxX");
		MaxZ = config.getInt("Spawn.MaxZ");
		World = config.getString("Spawn.World");
		Chat_Format = config.getString("Chat.Format");
	}

	public static int getRandomX() {
		Random r = new Random();
		int tmp = MinX + r.nextInt(MaxX - MinX);
		return tmp;
	}

	public static int getRandomZ() {
		Random r = new Random();
		int tmp = MinZ + r.nextInt(MaxZ - MinZ);
		return tmp;
	}
}
