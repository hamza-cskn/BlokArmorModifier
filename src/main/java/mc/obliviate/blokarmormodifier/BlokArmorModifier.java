package mc.obliviate.blokarmormodifier;

import mc.obliviate.blokarmormodifier.commands.BAMCommand;
import mc.obliviate.blokarmormodifier.handlers.ConfigHandler;
import mc.obliviate.blokarmormodifier.listeners.DamageListener;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class BlokArmorModifier extends JavaPlugin {

	private final ConfigHandler configHandler = new ConfigHandler(this);

	@Override
	public void onEnable() {
		registerListeners();
		registerCommands();
		configHandler.load();
		Bukkit.getLogger().info(ChatColor.GREEN + "Blok Armor Modifier has been enabled!");
		Bukkit.getLogger().info(ChatColor.GRAY + "Coded by Mr_Obliviate");
	}


	private void registerListeners() {
		Bukkit.getPluginManager().registerEvents(new DamageListener(), this);
	}

	private void registerCommands() {
		getCommand("bam").setExecutor(new BAMCommand(this));
	}

	public ConfigHandler getConfigHandler() {
		return configHandler;
	}
}
