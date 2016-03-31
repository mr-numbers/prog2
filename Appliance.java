package f1_002;

public class Appliance extends Valuable{
	private double cost;
	private int wear;

	public Appliance(String name, double cost, int wear){
		super(name);
		this.cost=cost;
		this.wear=wear;
	}

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
