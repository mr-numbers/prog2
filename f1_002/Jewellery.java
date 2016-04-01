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
	@Override
	void calculateValue() {
		int stones = getStones();
		double value = 0;
		if(isGold()){
			value = 2000;
		}
		else{
			value=700;
		}
		value=value+(stones*500);
		this.setValue(value);
		
	}
	@Override
	public String toString() {
		return "Name: "+getName()+ " | stones: "+getStones()+" | isGold: "+isGold()+" | value: "+getValue();
	}

}
