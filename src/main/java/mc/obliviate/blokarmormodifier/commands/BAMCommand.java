package mc.obliviate.blokarmormodifier.commands;

import mc.obliviate.blokarmormodifier.BlokArmorModifier;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BAMCommand implements CommandExecutor {

    private final BlokArmorModifier plugin;

    public BAMCommand(BlokArmorModifier plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(final CommandSender sender, final Command command, final String s, final String[] args) {
        if (sender instanceof Player && !(sender.isOp())) return false;
        sender.sendMessage("§aBlokArmorModifier§7 configuration reloading...");
        final long start = System.currentTimeMillis();
        plugin.getConfigHandler().load();
        final long diff = System.currentTimeMillis()-start;
        sender.sendMessage("§aBlokArmorModifier§7 configuration reloaded in §f" + diff + "ms§7.");


        return false;
    }
}
