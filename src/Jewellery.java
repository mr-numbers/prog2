
public class Jewellery extends Valuable{
	private int stones;
	private boolean isGold;
	public Jewellery(int stones, boolean isGold, String name){
		super(name);
		this.stones = stones;
		this.isGold=isGold;
	}
	@Override
	public String toString(){
		return getName()+" : "+getStones()+" : "+isGold();
	}
	public int getStones() {
		return stones;
	}
	public void setStones(int stones) {
		this.stones = stones;
	}
	public boolean isGold() {
		return isGold;
	}
	public void setGold(boolean isGold) {
		this.isGold = isGold;
	}
	
}
