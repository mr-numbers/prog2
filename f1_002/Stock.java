package f1_002;
//Carl Herkommer
public class Stock extends Valuable{
	private double course;
	private int stocks;
	public Stock(String name, int stocks, double course){
		super(name);
		this.stocks=stocks;
		this.course=course;
	}
	public double getCourse() {
		return course;
	}
	public void setCourse(double course) {
		this.course = course;
	}
	public int getStocks() {
		return stocks;
	}
	public void setStocks(int stocks) {
		this.stocks = stocks;
	}
	@Override
	void calculateValue() {
		double value = (getCourse()*getStocks());
		setValue(value);
	}
	@Override
	public String toString() {
		calculateValue();
		return getName()+ " | stocks: "+getStocks()+" | current course: "+getCourse()+" | current value: "+getValue();
	}

}
