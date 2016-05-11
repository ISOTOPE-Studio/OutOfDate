package cc.isotopestudio.OutOfDate;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.bekvon.bukkit.residence.Residence;
import com.bekvon.bukkit.residence.protection.ClaimedResidence;
import com.bekvon.bukkit.residence.protection.ResidenceManager;

public class CommandTest implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("players")) {
			if (!sender.isOp())
				return true;
			long now = new java.util.Date().getTime();
			/*
			for (OfflinePlayer player : Bukkit.getOfflinePlayers()) {
				int day = (int) ((now - player.getLastPlayed()) / (1000 * 60 * 60 * 24));
				OutOfDate.plugin.getConfig().set(player.getName() + ".last", player.getLastPlayed());
				OutOfDate.plugin.getConfig().set(player.getName() + ".day", day);
			}
			OutOfDate.plugin.saveConfig();
			*/
			sender.sendMessage("清理!");
			ResidenceManager man = Residence.getResidenceManager();
			String[] resList = man.getResidenceList();
			for (String resName : resList) {
				ClaimedResidence res = man.getByName(resName);
				String playerName = res.getOwner();
				OfflinePlayer player = Bukkit.getOfflinePlayer(playerName);
				int days = (int) ((now - player.getLastPlayed()) / (1000 * 60 * 60 * 24));
				if (days > 20) {
					res.remove();
					sender.sendMessage(playerName + "(" + days + "天前上线)的领地" + resName + "已被清除");
				}
			}
			return true;
		}
		return false;
	}
}