package f1_002;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Swing extends JFrame {
	/**
	 * 
	 */

	public static ArrayList<Valuable> valuablesList = new ArrayList<>();

	private JTextArea display = new JTextArea();
	private JRadioButton name, worth;

	private JLabel newValuable;
	private JLabel sort;
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

	class BoxListener implements ActionListener { // This + the form class are
													// all capable of handling
													// each type of new
													// valuable's creation
													// process; and more
													// importantly
		// It's also quite possible to add more types of valuables later! Simply
		// add another if-set!
		public void actionPerformed(ActionEvent ave) {
			try {
				String selected = boxen.getSelectedItem().toString();
				if (selected.equalsIgnoreCase("Stock")) {
					Form f = new Form(0);
					int svar = JOptionPane.showConfirmDialog(null, f, "Indata", JOptionPane.OK_CANCEL_OPTION);
					if (svar != JOptionPane.OK_OPTION) {
						return;
					}
					String name = f.getName();
					int stocks = f.getIntField();
					double course = f.getDoubleField();
					valuablesList.add(new Stock(name, stocks, course));
				} else if (selected.equalsIgnoreCase("Appliance")) {
					boolean b;
					do {
						b = false;
						Form f = new Form(1);
						int svar = JOptionPane.showConfirmDialog(null, f, "Indata", JOptionPane.OK_CANCEL_OPTION);
						if (svar != JOptionPane.OK_OPTION) {
							return;
						}
						String name = f.getName();
						int wear = f.getIntField();
						double cost = f.getDoubleField();
						if (wear > 10 || wear < 1) {
							JOptionPane.showMessageDialog(Swing.this, "Wear must be a value from 1-10", "Wrong entry",
									JOptionPane.ERROR_MESSAGE);
							b = true;
						}
						if (b == false) {
							valuablesList.add(new Appliance(name, cost, wear));
						}
					} while (b);

				} else if (selected.equalsIgnoreCase("Jewellery")) {
					Form f = new Form(2);
					int svar = JOptionPane.showConfirmDialog(null, f, "Indata", JOptionPane.OK_CANCEL_OPTION);
					if (svar != JOptionPane.OK_OPTION) {
						return;
					}
					String name = f.getName();
					int stones = f.getIntField();
					boolean isGold = f.getGold();
					valuablesList.add(new Jewellery(name, isGold, stones));
				}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(Swing.this, "Invalid entry");
			}
		}
	}

	class showListener implements ActionListener {
		public void actionPerformed(ActionEvent ave) {
			display.setText("");
			for(Valuable v : valuablesList){
				display.append("\n"+v.toString());
			}

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

}
