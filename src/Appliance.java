
public class Appliance extends Valuable{
	private int wear;
	private double cost;
	public Appliance (int wear, double cost, String name){
		super(name);
		this.wear=wear;
		this.cost=cost;
	}
	@Override
	public String toString(){
		return getName()+" : "+getWear()+" : "+getCost();
	}
	public int getWear() {
		return wear;
	}
	public void setWear(int wear) {
		this.wear = wear;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}

}
