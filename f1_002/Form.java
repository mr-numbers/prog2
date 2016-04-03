package f1_002;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Form extends JPanel { // Tried to design it in such a way that it
									// could be built upon with more types of
									// valuables later. Now you simply add
									// another if-set if that's what you want

	private JTextField nameField = new JTextField(10);
	private JTextField intField = new JTextField(5);
	private JTextField doubleField = new JTextField(5);
	private JRadioButton isGold = new JRadioButton();

	public Form(int value) {
		JPanel row1 = new JPanel();
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		row1.add(new JLabel("Name: "));
		row1.add(nameField);
		add(row1);
		JPanel row2 = new JPanel();
		JPanel row3 = new JPanel();
		if (value == 0) {
			row2.add(new JLabel("Number of stocks: "));
			row3.add(new JLabel("Current course: "));
			row2.add(intField);
			add(row2);
			row3.add(doubleField);
			add(row3);

		} else if (value == 1) {
			row2.add(new JLabel("Wear, from 1-10: "));
			row3.add(new JLabel("Original cost of item:  "));
			row2.add(intField);
			add(row2);
			row3.add(doubleField);
			add(row3);

		} else if (value == 2) {
			row2.add(new JLabel("Number of stones: "));
			row3.add(new JLabel("Is it made of gold?: "));
			row2.add(intField);
			add(row2);
			row3.add(isGold);
			add(row3);

		}

	}

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
