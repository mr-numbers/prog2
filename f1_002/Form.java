package f1_002;

//Klass skapad av Carl Herkommer, för inlämning 1 för kursen Prog2, VT2016
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Form extends JPanel { // ändrat kommentar

	private JTextField nameField = new JTextField(10);
	private JTextField intField = new JTextField(5);
	private JTextField doubleField = new JTextField(5);
	private JRadioButton isGold = new JRadioButton();

	public Form(int value) {// switch-sats
		JPanel row1 = new JPanel();
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		row1.add(new JLabel("Name: "));
		row1.add(nameField);
		add(row1);
		JPanel row2 = new JPanel();
		JPanel row3 = new JPanel();

		switch (value) {
		case 0:
			row2.add(new JLabel("Number of stocks: "));
			row3.add(new JLabel("Current course: "));
			row2.add(intField);
			row3.add(doubleField);

			break;
		case 1:
			row2.add(new JLabel("Wear, from 1-10: "));
			row3.add(new JLabel("Original cost of item:  "));
			row2.add(intField);
			row3.add(doubleField);

			break;
		case 2:
			row2.add(new JLabel("Number of stones: "));
			row3.add(new JLabel("Is it made of gold?: "));
			row2.add(intField);
			row3.add(isGold);
			break;
		default:
			break;
		}
		add(row2);
		add(row3);

	}

	// Getters

	public String getNameField() {
		return nameField.getText();
	}

	public int getIntField() {
		return Integer.parseInt(intField.getText());
	}

	public double getDoubleField() {
		return Double.parseDouble(doubleField.getText());
	}

	public boolean getGold() {
		return isGold.isSelected();
	}

}
