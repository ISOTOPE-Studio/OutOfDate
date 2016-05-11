package cc.isotopestudio.OutOfDate;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandTest implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("players")) {
			if (!sender.isOp())
				return true;
			long now = new java.util.Date().getTime();
			for (OfflinePlayer player : Bukkit.getOfflinePlayers()) {
				int day = (int) (now - player.getLastPlayed()) / (1000 * 60 * 60 * 24);
				sender.sendMessage(player.getName() + "上次登录 " + day + " 天 超时: " + (day > 20));
			}
			return true;
		}
		return false;
	}
}