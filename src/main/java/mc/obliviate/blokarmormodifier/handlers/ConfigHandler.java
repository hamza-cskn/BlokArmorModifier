package mc.obliviate.blokarmormodifier.handlers;

import mc.obliviate.blokarmormodifier.BlokArmorModifier;
import mc.obliviate.blokarmormodifier.listeners.DamageListener;
import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ConfigHandler {

    private final BlokArmorModifier plugin;

    public ConfigHandler(final BlokArmorModifier plugin) {
        this.plugin = plugin;
    }

    public void load() {
        final File file = new File(plugin.getDataFolder().getPath() + File.separator + "config.yml");
        final YamlConfiguration config = YamlConfiguration.loadConfiguration(file);

        Map<Material, Integer> armorPoints = new HashMap<>();
        armorPoints.put(Material.GOLD_HELMET, 2);
        armorPoints.put(Material.GOLD_CHESTPLATE, 5);
        armorPoints.put(Material.GOLD_LEGGINGS, 3);
        armorPoints.put(Material.GOLD_BOOTS, 1);

        armorPoints.put(Material.DIAMOND_HELMET, 3);
        armorPoints.put(Material.DIAMOND_CHESTPLATE, 8);
        armorPoints.put(Material.DIAMOND_LEGGINGS, 6);
        armorPoints.put(Material.DIAMOND_BOOTS, 3);

        armorPoints.put(Material.LEATHER_HELMET, 1);
        armorPoints.put(Material.LEATHER_CHESTPLATE, 3);
        armorPoints.put(Material.LEATHER_LEGGINGS, 2);
        armorPoints.put(Material.LEATHER_BOOTS, 1);

        armorPoints.put(Material.IRON_HELMET, 2);
        armorPoints.put(Material.IRON_CHESTPLATE, 6);
        armorPoints.put(Material.IRON_LEGGINGS, 5);
        armorPoints.put(Material.IRON_BOOTS, 2);

        armorPoints.put(Material.CHAINMAIL_HELMET, 2);
        armorPoints.put(Material.CHAINMAIL_CHESTPLATE, 5);
        armorPoints.put(Material.CHAINMAIL_LEGGINGS, 4);
        armorPoints.put(Material.CHAINMAIL_BOOTS, 1);

        if (config.getKeys(false).isEmpty()) {

            config.set("armor-points." + Material.GOLD_HELMET, 2d);
            config.set("armor-points." + Material.GOLD_CHESTPLATE, 5d);
            config.set("armor-points." + Material.GOLD_LEGGINGS, 3d);
            config.set("armor-points." + Material.GOLD_BOOTS, 1d);

            config.set("armor-points." + Material.DIAMOND_HELMET, 3d);
            config.set("armor-points." + Material.DIAMOND_CHESTPLATE, 8d);
            config.set("armor-points." + Material.DIAMOND_LEGGINGS, 6d);
            config.set("armor-points." + Material.DIAMOND_BOOTS, 3d);

            config.set("armor-points." + Material.LEATHER_HELMET, 1d);
            config.set("armor-points." + Material.LEATHER_CHESTPLATE, 3d);
            config.set("armor-points." + Material.LEATHER_LEGGINGS, 2d);
            config.set("armor-points." + Material.LEATHER_BOOTS, 1d);

            config.set("armor-points." + Material.IRON_HELMET, 2d);
            config.set("armor-points." + Material.IRON_CHESTPLATE, 6d);
            config.set("armor-points." + Material.IRON_LEGGINGS, 5d);
            config.set("armor-points." + Material.IRON_BOOTS, 2d);

            config.set("armor-points." + Material.CHAINMAIL_HELMET, 2d);
            config.set("armor-points." + Material.CHAINMAIL_CHESTPLATE, 5d);
            config.set("armor-points." + Material.CHAINMAIL_LEGGINGS, 4d);
            config.set("armor-points." + Material.CHAINMAIL_BOOTS, 1d);

            try {
                config.save(file);
            } catch (final IOException e) {
                e.printStackTrace();
            }
        }

        for (final Material material : armorPoints.keySet()) {
            DamageListener.ARMOR_POINT_VALUES.put(material, config.getDouble("armor-points." + material.toString()));
        }

    }
}
