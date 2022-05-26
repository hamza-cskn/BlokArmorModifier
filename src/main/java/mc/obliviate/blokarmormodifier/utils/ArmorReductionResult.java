package mc.obliviate.blokarmormodifier.utils;

public class ArmorReductionResult {

	private final double magicReduction;
	private final double armorReduction;

	public ArmorReductionResult(double magicReduction, double armorReduction) {
		this.magicReduction = magicReduction;
		this.armorReduction = armorReduction;
	}

	public double getArmorReduction() {
		return armorReduction;
	}

	public double getMagicReduction() {
		return magicReduction;
	}

}
