package cc.isotopestudio.OutOfDate;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class OutOfDate extends JavaPlugin {
	public static final String prefix = (new StringBuilder()).append(ChatColor.GOLD).append(ChatColor.BOLD).append("[")
			.append("�������").append("]").append(ChatColor.RESET).toString();
	public static final String pluginName = "OutOfDate";

	@Override
	public void onEnable() {
		new ClearTask(this).runTaskTimer(this, 40, 1728000);
		this.getServer().getPluginManager().registerEvents(new SignListener(), this);
		getLogger().info(pluginName + "�ɹ�����!");
		getLogger().info(pluginName + "��ISOTOPE Studio����!");
		getLogger().info("http://isotopestudio.cc");
	}

	@Override
	public void onDisable() {
		getLogger().info(pluginName + "�ɹ�ж��!");
	}

}
