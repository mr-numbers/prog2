package f1_002;

public class Jewellery extends Valuable {
	private boolean isGold;
	private int stones;
	public Jewellery(String name, boolean isGold, int stones){
	super(name);
	this.isGold=isGold;
	this.stones=stones;
	}
	public boolean isGold() {
		return isGold;
	}
	public int getStones() {
		return stones;
	}

}
