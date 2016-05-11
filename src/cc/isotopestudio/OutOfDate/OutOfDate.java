package cc.isotopestudio.OutOfDate;

import java.io.File;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class OutOfDate extends JavaPlugin {
	public static final String prefix = (new StringBuilder()).append(ChatColor.GOLD).append(ChatColor.BOLD).append("[")
			.append("�������").append("]").append(ChatColor.RESET).toString();
	public static final String pluginName = "OutOfDate";
	public static OutOfDate plugin;

	@Override
	public void onEnable() {
		plugin = this;
		File file = new File(getDataFolder(), "config.yml");
		if (!file.exists()) {
			saveDefaultConfig();
		}
		this.getServer().getPluginManager().registerEvents(new SignListener(), this);
		this.getCommand("players").setExecutor(new CommandTest());
		getLogger().info(pluginName + "�ɹ�����!");
		getLogger().info(pluginName + "��ISOTOPE Studio����!");
		getLogger().info("http://isotopestudio.cc");
	}

	@Override
	public void onDisable() {
		getLogger().info(pluginName + "�ɹ�ж��!");
	}

}
