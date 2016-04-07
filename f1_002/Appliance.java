package f1_002;

//Klass skapad av Carl Herkommer, för inlämning 1 för kursen Prog2, VT2016
public class Appliance extends Valuable {
	private double cost;
	private int wear;

	public Appliance(String name, double cost, int wear) {
		super(name);
		this.cost = cost;
		this.wear = wear;
	}

	@Override
	void calculateValue() {
		double wear = getWear();
		double cost = getCost();
		double value = ((wear / 10) * cost);
		setValue(value);
	}

	@Override
	public String toString() {
		calculateValue();
		return getName() + " | original cost: " + getCost() + " | wear: " + getWear() + " | current value: "
				+ getValue();
	}

	@Override
	public int compareTo(Valuable other) {
		if (getValue() > other.getValue()) {
			return 1;
		} else {
			return 0;
		}
	}

	// Getters
	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public int getWear() {
		return wear;
	}

}
