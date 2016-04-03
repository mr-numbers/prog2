package f1_002;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Swing extends JFrame {

	private JTextArea display = new JTextArea();
	private JRadioButton name, worth;

	private JTextField fält;
	private JLabel newValuable;
	private JLabel sort;
	private int value = 0;
	private JButton showButton;
	private JButton stockMarketCrashButton;
	private JScrollPane scrollP;
	private String[] valuables = { "Jewellery", "Stock", "Appliance" };
	JComboBox<String> boxen = new JComboBox<String>(valuables);

	public Swing() {

		super("Sakregister");
		JPanel north = new JPanel();
		add(north, BorderLayout.NORTH);
		JLabel valueLabel = new JLabel("Valuables");
		north.add(valueLabel);

		JPanel south = new JPanel();
		add(south, BorderLayout.SOUTH);
		boxen = new JComboBox<String>(valuables);
		boxen.addActionListener(new BoxListener());
		newValuable = new JLabel("Nytt: ");
		stockMarketCrashButton = new JButton("Stock Market Crash");
		stockMarketCrashButton.addActionListener(new crashListener());
		showButton = new JButton("Show");
		showButton.addActionListener(new showListener());
		south.add(newValuable);
		south.add(boxen);
		south.add(showButton);
		south.add(stockMarketCrashButton);

		JPanel east = new JPanel();
		sort = new JLabel("Sort by");
		add(east, BorderLayout.EAST);
		east.setLayout(new BoxLayout(east, BoxLayout.Y_AXIS));

		name = new JRadioButton("name");
		name.addActionListener(new sortByNameListener());
		worth = new JRadioButton("value");
		worth.addActionListener(new sortByWorthListener());
		east.add(sort);
		east.add(name);
		east.add(worth);

		display = new JTextArea();
		scrollP = new JScrollPane(display);
		add(scrollP, BorderLayout.CENTER);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(500, 400); // bredd, höjd
		setLocation(400, 300);
		setVisible(true);
	}

	class BoxListener implements ActionListener {  //This + the form class are all capable of handling each type of new valuable's creation process; and more importantly
		//It's also quite possible to add more types of valuables later! Simply add another if-set!
		public void actionPerformed(ActionEvent ave) {
			try{
			String selected = boxen.getSelectedItem().toString();
			if (selected.equalsIgnoreCase("Stock")) {
				Form f = new Form(0);
				int svar = JOptionPane.showConfirmDialog(null, f, "Indata", JOptionPane.OK_CANCEL_OPTION);
				if (svar != JOptionPane.OK_OPTION){
				    return;
				}
				String name = f.getName();
				int stocks = f.getIntField();
				double course = f.getDoubleField();
			}
			else if (selected.equalsIgnoreCase("Appliance")) {
				Form f = new Form(1);
				int svar = JOptionPane.showConfirmDialog(null, f, "Indata", JOptionPane.OK_CANCEL_OPTION);
				if (svar != JOptionPane.OK_OPTION){
				    return;
				}
				String name = f.getName();
				int wear = f.getIntField();
				double cost = f.getDoubleField();
			}
			else if (selected.equalsIgnoreCase("Jewellery")) {
				Form f = new Form(2);
				int svar = JOptionPane.showConfirmDialog(null, f, "Indata", JOptionPane.OK_CANCEL_OPTION);
				if (svar != JOptionPane.OK_OPTION){
				    return;
				}
				String name = f.getName();
				int stones = f.getIntField();
				boolean isGold = f.getGold();
			}
			}catch(NumberFormatException e){
				JOptionPane.showMessageDialog(Swing.this, "Invalid entry");
			}
		}
	}

	class showListener implements ActionListener {
		public void actionPerformed(ActionEvent ave) {

		}
	}

	class crashListener implements ActionListener {
		public void actionPerformed(ActionEvent ave) {

		}
	}

	class sortByNameListener implements ActionListener {
		public void actionPerformed(ActionEvent ave) {
		}
	}

	class sortByWorthListener implements ActionListener {
		public void actionPerformed(ActionEvent ave) {

		}
	}

	class Form extends JPanel {   //Tried to design it in such a way that it could be built upon with more types of valuables later. Now you simply add another if-set if that's what you want
		
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
			if(value==0){
				row2.add(new JLabel("Number of stocks: "));		
				row3.add(new JLabel("Current course: "));
				row2.add(intField);
				add(row2);
				row3.add(doubleField);
				add(row3);

			}
			else if(value==1){
				row2.add(new JLabel("Wear, from 1-10: "));		
				row3.add(new JLabel("Original cost of item:  "));
				row2.add(intField);
				add(row2);
				row3.add(doubleField);
				add(row3);

			}
			else if(value==2){
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
		public boolean getGold(){
			return isGold.isSelected();
		}
	}

	public String getString() {
		String theString = null;
		return theString;
	}

	public String getNamn() {
		String namn = null;
		return namn;
	}

	public double getDouble() {
		double d = -1;
		return d;
	}

	public int getInt() {
		int i = -1;
		return i;
	}

}
