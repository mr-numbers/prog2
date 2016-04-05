package f1_002;
//Carl Herkommer
import java.util.Collections.*;
import java.util.Comparator;
abstract class Valuable implements Comparable<Valuable>{
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
	public int compareTo(Valuable other){
		if(this.getValue()>other.getValue()){
			return 1;
		}
		else{
			return 0;
		}
		}

/*	public boolean equals(Object other){
		if (other instanceof Valuable){
		    Valuable p = (Valuable)other;
		    return getName() == p.getName();
		}
		else
		    return false;
	    }*/
	

}
