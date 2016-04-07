package f1_002;

//Klass skapad av Carl Herkommer, för inlämning 1 för kursen Prog2, VT2016
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Swing extends JFrame {
	public static ArrayList<Valuable> valuablesList = new ArrayList<>();
	private JTextArea display = new JTextArea();
	private JRadioButton byName, byWorth;

	private JLabel newValuable;
	private JLabel sort;
	private JButton showButton;
	private JButton stockMarketCrashButton;
	private JScrollPane scrollP;
	private String[] valuables = { "Jewellery", "Stock", "Appliance" };
	JComboBox<String> boxen = new JComboBox<String>(valuables);

	// The constructor creates everything for the GUI

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

		byName = new JRadioButton("name");
		byName.addActionListener(new sortByNameListener());
		byWorth = new JRadioButton("value");
		byWorth.addActionListener(new sortByWorthListener());
		east.add(sort);
		east.add(byName);
		east.add(byWorth);

		display = new JTextArea();
		scrollP = new JScrollPane(display);
		add(scrollP, BorderLayout.CENTER);
		display.setEditable(false);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(700, 400); // bredd, höjd
		setLocation(400, 300);
		setVisible(true);
	}

	// Listener for the comboBox

	class BoxListener implements ActionListener {
		public void actionPerformed(ActionEvent ave) {
			boolean b = true;// switch
			int svar;
			String name, emptyCheck, emptyCheck2;
			do {
				try {
					String selected = boxen.getSelectedItem().toString();
					switch (selected) {
					case ("Stock"):
						b = false;
						Form f0 = new Form(0);
						svar = JOptionPane.showConfirmDialog(null, f0, "New Stock", JOptionPane.OK_CANCEL_OPTION);
						if (svar != JOptionPane.OK_OPTION) {
							return;
						}
						name = f0.getNameField();
						int stocks = f0.getIntField();
						double course = f0.getDoubleField();
						emptyCheck = String.valueOf(stocks);
						emptyCheck2 = String.valueOf(course);
						if (name == null || name.length() == 0 || emptyCheck == null || emptyCheck == null
								|| emptyCheck2 == null || emptyCheck2.length() == 0) {
							JOptionPane.showMessageDialog(Swing.this, "Empty field", "Wrong entry",
									JOptionPane.ERROR_MESSAGE);
							b = true;
						}
						if (b == false) {
							valuablesList.add(new Stock(name, stocks, course));
						}
						break;
					case ("Appliance"):
						b = false;
						Form f1 = new Form(1);
						svar = JOptionPane.showConfirmDialog(null, f1, "New Appliance", JOptionPane.OK_CANCEL_OPTION);
						if (svar != JOptionPane.OK_OPTION) {
							return;
						}
						name = f1.getNameField();
						int wear = f1.getIntField();
						double cost = f1.getDoubleField();
						if (wear > 10 || wear < 1) {
							JOptionPane.showMessageDialog(Swing.this, "Wear must be a value from 1-10", "Wrong entry",
									JOptionPane.ERROR_MESSAGE);
							b = true;
						}
						emptyCheck = String.valueOf(cost);
						if (name == null || emptyCheck == null || name.length() == 0 || emptyCheck == null) {
							JOptionPane.showMessageDialog(Swing.this, "Empty field", "Wrong entry",
									JOptionPane.ERROR_MESSAGE);
							b = true;
						}
						if (b == false) {
							valuablesList.add(new Appliance(name, cost, wear));
						}
						break;
					case ("Jewellery"):
						b = false;
						Form f2 = new Form(2);
						svar = JOptionPane.showConfirmDialog(null, f2, "New Jewellery", JOptionPane.OK_CANCEL_OPTION);
						if (svar != JOptionPane.OK_OPTION) {
							return;
						}
						name = f2.getNameField();
						int stones = f2.getIntField();
						boolean isGold = f2.getGold();
						emptyCheck = String.valueOf(stones);
						if (name == null || name.length() == 0 || emptyCheck == null || emptyCheck == null) {
							JOptionPane.showMessageDialog(Swing.this, "Empty field", "Wrong entry",
									JOptionPane.ERROR_MESSAGE);
							b = true;
						}
						if (b == false) {
							valuablesList.add(new Jewellery(name, isGold, stones));
						}
						break;
					default:
						b = false;
						break;
					}
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(Swing.this,
							"Either you enterred a character where there should be a number, or you left a field empty.");
					b = true;
				}
			} while (b);
		}
	}

	// Listeners for the buttons

	class showListener implements ActionListener {
		public void actionPerformed(ActionEvent ave) {
			display.setText("");
			if (byName.isSelected()) {
				Collections.sort(valuablesList, new NamnComparator());
			} else if (byWorth.isSelected()) {
				Collections.sort(valuablesList, new WorthComparator());
			}
			for (Valuable v : valuablesList) {
				display.append("\n" + v.toString());
			}

		}
	}

	class crashListener implements ActionListener {
		public void actionPerformed(ActionEvent ave) {
			for (Valuable v : valuablesList) {
				if (v instanceof Stock) {
					((Stock) v).setCourse(0);
				}
			}
		}
	}

	class sortByNameListener implements ActionListener {
		public void actionPerformed(ActionEvent ave) {
			if (byName.isSelected()) {
				byName.setEnabled(false);
				byWorth.setSelected(false);
				byWorth.setEnabled(true);
			}
		}
	}

	class sortByWorthListener implements ActionListener {
		public void actionPerformed(ActionEvent ave) {
			if (byWorth.isSelected()) {
				byWorth.setEnabled(false);
				byName.setSelected(false);
				byName.setEnabled(true);
			}
		}
	}

	// Comparators

	class NamnComparator implements Comparator<Valuable> {
		public int compare(Valuable v1, Valuable v2) {
			return v1.getName().toLowerCase().compareTo(v2.getName().toLowerCase());
		}

	}

	class WorthComparator implements Comparator<Valuable> {
		public int compare(Valuable v1, Valuable v2) {
			return (int) (v2.getValue() - v1.getValue());
		}

	}

}
