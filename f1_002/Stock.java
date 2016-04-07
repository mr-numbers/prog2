package f1_002;

//Klass skapad av Carl Herkommer, för inlämning 1 för kursen Prog2, VT2016
public class Stock extends Valuable {
	private double course;
	private int stocks;

	public Stock(String name, int stocks, double course) {
		super(name);
		this.stocks = stocks;
		this.course = course;
	}

	@Override
	void calculateValue() {
		double value = (getCourse() * getStocks());
		setValue(value);
	}

	@Override
	public String toString() {
		calculateValue();
		return getName() + " | stocks: " + getStocks() + " | current course: " + getCourse() + " | current value: "
				+ getValue();
	}

	
	// Getters
	public double getCourse() {
		return course;
	}

	// Setters
	public void setCourse(double course) {
		this.course = course;
	}

	public int getStocks() {
		return stocks;
	}

	public void setStocks(int stocks) {
		this.stocks = stocks;
	}

}
