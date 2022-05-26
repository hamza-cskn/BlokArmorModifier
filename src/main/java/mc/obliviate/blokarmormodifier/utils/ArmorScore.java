package mc.obliviate.blokarmormodifier.utils;

public class ArmorScore {

	private final double point;
	private final int epf;

	public ArmorScore(double point, int epf) {
		this.point = point;
		this.epf = epf;
	}

	public double getPoint() {
		return point;
	}

	public int getEpf() {
		return epf;
	}
}
