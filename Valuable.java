package f1_002;
import java.util.ArrayList;
abstract class Valuable {
	private String name;
	private double value;
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
		this.value = value;
	}
	public void calculateValue(ArrayList<Valuable> v){
		
	}
	

}
