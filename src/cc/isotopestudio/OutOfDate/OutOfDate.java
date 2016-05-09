package cc.isotopestudio.OutOfDate;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import com.bekvon.bukkit.residence.Residence;

public class OutOfDate extends JavaPlugin {
	@Override
	public void onEnable() {
		for (OfflinePlayer player : Bukkit.getOfflinePlayers()) {
			player.getLastPlayed();
		}
		Plugin resPlug = getServer().getPluginManager().getPlugin("Residence");
		if (resPlug != null) {
			Residence.getResidenceManager().getByName("").getOwner();
		}
	}

}
