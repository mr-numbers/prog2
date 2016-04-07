package f1_002;

//Klass skapad av Carl Herkommer, för inlämning 1 för kursen Prog2, VT2016
abstract class Valuable implements Comparable<Valuable> {
	private String name;
	protected double value;
	private static final double moms = 1.25;

	public Valuable(String name) {
		this.name = name;
	}

	protected void setValue(double value) {
		this.value = (value * moms); 
	}

	abstract void calculateValue();

	public abstract String toString();

	public int compareTo(Valuable other) {
		if (this.getValue() > other.getValue()) {
			return 1;
		} else {
			return 0;
		}
	}

	// Getters

	public String getName() {
		return name;
	}

	public double getValue() {
		return value;
	}

}
