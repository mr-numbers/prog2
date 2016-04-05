package f1_002;

//Carl Herkommer
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Collections.*;
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

	class BoxListener implements ActionListener {
		public void actionPerformed(ActionEvent ave) {
			boolean b=true;
			do {
			try {
				String selected = boxen.getSelectedItem().toString();
				if (selected.equalsIgnoreCase("Stock")) {
						b = false;
						Form f = new Form(0);
						int svar = JOptionPane.showConfirmDialog(null, f, "New Stock", JOptionPane.OK_CANCEL_OPTION);
						if (svar != JOptionPane.OK_OPTION) {
							return;
						}
						String name = f.getNameField();
						int stocks = f.getIntField();
						double course = f.getDoubleField();
						String emptyCheck = String.valueOf(stocks);
						String emptyCheck2 = String.valueOf(course);
						if (name == null || name.length() == 0 || emptyCheck == null || emptyCheck == null
								|| emptyCheck2 == null || emptyCheck2.length() == 0) {
							JOptionPane.showMessageDialog(Swing.this, "Empty field", "Wrong entry",
									JOptionPane.ERROR_MESSAGE);
							b = true;
						}
						if (b == false) {
							valuablesList.add(new Stock(name, stocks, course));
						}

				} else if (selected.equalsIgnoreCase("Appliance")) {
						b = false;
						Form f = new Form(1);
						int svar = JOptionPane.showConfirmDialog(null, f, "New Appliance",
								JOptionPane.OK_CANCEL_OPTION);
						if (svar != JOptionPane.OK_OPTION) {
							return;
						}
						String name = f.getNameField();
						int wear = f.getIntField();
						double cost = f.getDoubleField();
						if (wear > 10 || wear < 1) {
							JOptionPane.showMessageDialog(Swing.this, "Wear must be a value from 1-10", "Wrong entry",
									JOptionPane.ERROR_MESSAGE);
							b = true;
						}
						String emptyCheck = String.valueOf(cost);
						if (name == null || emptyCheck == null || name.length() == 0 || emptyCheck == null) {
							JOptionPane.showMessageDialog(Swing.this, "Empty field", "Wrong entry",
									JOptionPane.ERROR_MESSAGE);
							b = true;
						}
						if (b == false) {
							valuablesList.add(new Appliance(name, cost, wear));
						}

				} else if (selected.equalsIgnoreCase("Jewellery")) {
						b = false;
						Form f = new Form(2);
						int svar = JOptionPane.showConfirmDialog(null, f, "New Jewellery",
								JOptionPane.OK_CANCEL_OPTION);
						if (svar != JOptionPane.OK_OPTION) {
							return;
						}
						String name = f.getNameField();
						int stones = f.getIntField();
						boolean isGold = f.getGold();
						String emptyCheck = String.valueOf(stones);
						if (name == null || name.length() == 0 || emptyCheck == null || emptyCheck == null) {
							JOptionPane.showMessageDialog(Swing.this, "Empty field", "Wrong entry",
									JOptionPane.ERROR_MESSAGE);
							b = true;
						}
						if(b==false){
						valuablesList.add(new Jewellery(name, isGold, stones));
						}
				}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(Swing.this, "Number format exception, broski");
				b=true;
			}
			} while (b);
		}
	}

	class showListener implements ActionListener {
		public void actionPerformed(ActionEvent ave) {
			display.setText("");
			if (byName.isSelected()) {
				Collections.sort(valuablesList, new NamnComparator());
			}
			else if(byWorth.isSelected()) {
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
