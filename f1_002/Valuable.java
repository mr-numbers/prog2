package f1_002;

abstract class Valuable {
	private String name;
	protected double value;
	public Valuable(String name){
		this.name=name;
	}
	public String getName() {
		return name;
	}
	public double getValue() {
		return value;
	}
	protected void setValue(double value) {
		this.value = (value*1.25); //Moms
	}
	abstract void calculateValue();
	public abstract String toString();
	

}
