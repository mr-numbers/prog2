package f1_002;

//Klass skapad av Carl Herkommer, för inlämning 1 för kursen Prog2, VT2016
public class Jewellery extends Valuable {
	private boolean isGold;
	private int stones;

	public Jewellery(String name, boolean isGold, int stones) {
		super(name);
		this.isGold = isGold;
		this.stones = stones;
	}

	@Override
	void calculateValue() {
		int stones = getStones();
		double value = 0;
		if (isGold()) {
			value = 2000;
		} else {
			value = 700;
		}
		value = value + (stones * 500);
		setValue(value);

	}

	@Override
	public String toString() {
		calculateValue();
		String gold;
		if (isGold()) {
			gold = " Gold ";
		} else {
			gold = " Silver ";
		}
		return getName() + " | stones: " + getStones() + " | " + gold + " | current value: " + getValue(); // string
																											// format
	}

	// Getters
	public boolean isGold() {
		return isGold;
	}

	public int getStones() {
		return stones;
	}

}
