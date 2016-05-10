package cc.isotopestudio.OutOfDate;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class OutOfDate extends JavaPlugin {
	public static final String prefix = (new StringBuilder()).append(ChatColor.GOLD).append(ChatColor.BOLD).append("[")
			.append("玩家清理").append("]").append(ChatColor.RESET).toString();
	public static final String pluginName = "OutOfDate";

	@Override
	public void onEnable() {
		new ClearTask(this).runTaskTimer(this, 40, 1728000);
		this.getServer().getPluginManager().registerEvents(new SignListener(), this);
		getLogger().info(pluginName + "成功加载!");
		getLogger().info(pluginName + "由ISOTOPE Studio制作!");
		getLogger().info("http://isotopestudio.cc");
	}

	@Override
	public void onDisable() {
		getLogger().info(pluginName + "成功卸载!");
	}

}
