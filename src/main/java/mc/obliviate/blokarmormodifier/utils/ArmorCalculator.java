package mc.obliviate.blokarmormodifier.utils;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

import java.util.Random;

import static mc.obliviate.blokarmormodifier.listeners.DamageListener.ARMOR_POINT_VALUES;

public class ArmorCalculator {

	public static ArmorScore calculateArmorScore(final ItemStack[] armorContents) {
		double totalArmorPoint = 0;
		int totalEPF = 0;

		for (final ItemStack armor : armorContents) {
			if (ARMOR_POINT_VALUES.get(armor.getType()) == null) continue;
			final int pLevel = armor.getEnchantmentLevel(Enchantment.PROTECTION_ENVIRONMENTAL);
			if (pLevel > 0) {
				totalEPF += (int) (((6 + (pLevel * pLevel)) * 0.75) / 3d);
			}
			totalArmorPoint += ARMOR_POINT_VALUES.get(armor.getType());
		}

		return new ArmorScore(totalArmorPoint, totalEPF);
	}

	public static double calculateArmorReduction(final double point, final double baseDamage) {
		return -((point * 0.04) * baseDamage);
	}

	public static double calculateMinimumMagicReduction(final double point, final int epf, final double baseDamage) {
		return -(((1 - point * 0.04) * epf * 4 * 0.005) * baseDamage);
	}

	public static double randomizeMagicReduction(final double minimumMagicReduction) {
		return minimumMagicReduction + ((minimumMagicReduction * 2) - minimumMagicReduction) * new Random().nextDouble();
	}

	public static ArmorReductionResult recalculateDamage(final double baseDamage, final ItemStack[] armorContents) {
		final ArmorScore armorScore = ArmorCalculator.calculateArmorScore(armorContents);
		final double totalArmorPoint = armorScore.getPoint();
		final int totalEPF = armorScore.getEpf();
		final double armorReduction = ArmorCalculator.calculateArmorReduction(totalArmorPoint, baseDamage);

		final double minimumMagicReduction = ArmorCalculator.calculateMinimumMagicReduction(totalArmorPoint, totalEPF, baseDamage);
		final double magicReduction = ArmorCalculator.randomizeMagicReduction(minimumMagicReduction);

		return new ArmorReductionResult(magicReduction, armorReduction);
	}


}
