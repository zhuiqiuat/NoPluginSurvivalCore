package cn.Mchaptim.NPSurvivalCore;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

public class Listeners implements Listener {

	@EventHandler
	void onRespawn(PlayerRespawnEvent e) {
		if (e.isBedSpawn()) {
			return;
		}
		World w = Bukkit.getWorld(Config.World);
		int X = Config.getRandomX();
		int Z = Config.getRandomZ();
		Location Loc = new Location(w, X, w.getHighestBlockYAt(X, Z), Z);
		do {
			X = Config.getRandomX();
			Z = Config.getRandomZ();
			Loc = new Location(w, X, w.getHighestBlockYAt(X, Z), Z);
		} while (Loc.getBlock().getType() == Material.LAVA || Loc.getBlock().getType() == Material.WATER);
		e.setRespawnLocation(Loc);
	}

	@EventHandler
	void onJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		e.joinMessage(null);
		if (!p.hasPlayedBefore()) {
			World w = Bukkit.getWorld(Config.World);
			int X = Config.getRandomX();
			int Z = Config.getRandomZ();
			Location Loc = new Location(w, X, w.getHighestBlockYAt(X, Z), Z);
			do {
				X = Config.getRandomX();
				Z = Config.getRandomZ();
				Loc = new Location(w, X, w.getHighestBlockYAt(X, Z), Z);
			} while (Loc.getBlock().getType() == Material.LAVA || Loc.getBlock().getType() == Material.WATER);
			p.teleport(Loc);
			return;
		}
	}

	@EventHandler
	void onQuit(PlayerQuitEvent e) {
		e.quitMessage(null);
	}

}
