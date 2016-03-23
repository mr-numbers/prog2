
public class Stock extends Valuable {
	private int quantity;
	private double course;
	public Stock(int quantity, double course, String name){
		super(name);
		this.quantity = quantity;
		this.course = course;
	}
	@Override
	public String toString(){
		return getName()+" : "+getQuantity()+" : "+getCourse();
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getCourse() {
		return course;
	}
	public void setCourse(double course) {
		this.course = course;
	}
}
