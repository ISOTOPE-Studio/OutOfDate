package cc.isotopestudio.OutOfDate;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.block.Sign;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class SignListener implements Listener {

	@EventHandler
	public void onClickSign(PlayerInteractEvent event) {
		try {
			if (!(event.getClickedBlock().getType() == Material.WALL_SIGN)) {
				return;
			}
		} catch (Exception e) {
			return;
		}
		Sign s = (Sign) event.getClickedBlock().getState();
		String name = s.getLine(1);
		long now = new java.util.Date().getTime();
		for (OfflinePlayer player : Bukkit.getOfflinePlayers()) {
			if (name.equals(player.getName()) && (now - player.getLastPlayed()) / (1000 * 60 * 60 * 24) > 20)
				event.getClickedBlock().setType(Material.AIR);
		}
	}
}
