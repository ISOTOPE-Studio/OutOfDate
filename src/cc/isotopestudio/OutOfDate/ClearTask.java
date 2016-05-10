package cc.isotopestudio.OutOfDate;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.scheduler.BukkitRunnable;

import com.bekvon.bukkit.residence.Residence;
import com.bekvon.bukkit.residence.protection.ClaimedResidence;
import com.bekvon.bukkit.residence.protection.ResidenceManager;

public class ClearTask extends BukkitRunnable {

	private final OutOfDate plugin;

	public ClearTask(OutOfDate plugin) {
		this.plugin = plugin;
	}

	@Override
	public void run() {
		ResidenceManager man = Residence.getResidenceManager();
		String[] resList = man.getResidenceList();
		long now = new java.util.Date().getTime();
		for (String resName : resList) {
			ClaimedResidence res = man.getByName(resName);
			String playerName = res.getOwner();
			OfflinePlayer player = Bukkit.getOfflinePlayer(playerName);
			if (now - player.getLastPlayed() > 1000 * 60 * 60 * 24 * 20) {
				res.remove();
				plugin.getLogger().info(playerName + "的领地" + resName + "已被清除");
			}
		}
	}

}
