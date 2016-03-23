import java.util.ArrayList;
import java.util.Scanner;

public class Mainmethod { // A program to store valuables and calculate their
							// value, then display them.
	ArrayList<Valuable> valuables = new ArrayList<>();
	Scanner keyboard = new Scanner(System.in);

	public void displayText(String theString) { // Handles all output
		if (theString.equals("ExecuteMenuProtocol")) {
			System.out.println("Menu: \n1. Add a valuable\n2.View all data\n3. Quit");
		} else {
			System.out.println(theString);
		}
	}

	public String newString() { // Handles input and serves to root out any
								// errors such as null-values, etc. will add
								// more to this soon enough.
		String theString = keyboard.nextLine();
		return theString;
	}

	public boolean newBoolean(String answer) { // Unfinished, the idea was to
												// make sure that the "isGold"
												// Boolean has the possibility
												// of being null, so that a
												// re-entry can be done.

		boolean theBoolean = false;
		if (answer.equalsIgnoreCase("y")) {
			theBoolean = true;
		}
		return theBoolean;
	}

	public int newInt() { // Every int that's used for input will be a positive
							// value
		int theInt = keyboard.nextInt();
		keyboard.nextLine();
		if (theInt < 0) {
			theInt = 0;
		}
		return theInt;
	}

	public double newDouble() { // Self-explanatory
		double theDouble = keyboard.nextDouble();
		keyboard.nextLine();
		return theDouble;
	}

	public void run() { // Everything the user chooses to do, goes through here.
		boolean i = true;
		while (i) {
			displayText("ExecuteMenuProtocol"); // Calls upon the displayText to
												// display the menu, saves space
												// here.
			String newString = newString();
			switch (newString) {
			case "1":
				newValuable();
				break;
			case "2":
				for (Valuable v : valuables) { // Lists all valuables
					displayText(v.toString());
				}
				break;
			case "3":
				i = false;
				break;
			default:
				displayText(
						"Unrecognized command! Did you put in a number that corresponds with the option you wanted to choose?");
				break;
			}
		}

	}

	public void newValuable() {
		int i = 0;
		while (i == 0) {
			displayText("Choose type of valuable!\n1. Jewellery\n2.Stocks\n3.Appliance"); // There
																							// are
																							// 3
																							// types
																							// of
																							// valuables
			String choice = newString(); // The user makes a choice
			displayText("Name: "); // Every valuable has a name, no matter which
									// one we're talking about.
			String name = newString();
			switch (choice) {
			case "1":
				createJewellery(name); // Each of the three valuables have
										// different "constructors", so, I opted
										// to make use of a switch-case type of
										// solution.
				break;
			case "2":
				createStock(name);
				break;
			case "3":
				createAppliance(name);
				break;
			default:
				displayText("Command not recognized.");
			}
			displayText("Would you like to add another valuable? y/n"); // If
																		// the
																		// answer
																		// is
																		// anything
																		// but
																		// "n",
																		// this
																		// method
																		// will
																		// run
																		// again.
			String answer = newString();
			if (answer.equalsIgnoreCase("n")) {
				i = -1;
			}
		}
	}

	public void createJewellery(String name) {
		displayText("Is it made of gold? y/n");
		String answer = newString();
		boolean isGold = newBoolean(answer); // Not happy with this solution,
												// will revisit to make sure
												// that no "wrong" answers can
												// be given.
		displayText("How many stones does it adorn?");
		int stones = newInt(); // The stones as well as whether it is gold or
								// not, will affect the calculation of the items
								// value later on.
		Jewellery j = new Jewellery(stones, isGold, name);
		valuables.add(j);
	}

	public void createAppliance(String name) {
		displayText("How good is its condition from 1-10 where 10 is top quality, and 1 is total shite?");
		boolean i = true;
		int wear = newInt();
		while (i) {
			if (wear > 0 && wear <= 10) {
				i = false;
			} else {
				displayText("You must enter a number from 1 to 10");
				wear = newInt();
			} // The instructions state that the "wear" ranges from 1-10, it
				// serves a purpose when calculating the item's "value" later
				// on.
		}
		displayText("What price did you originally buy it for?");
		double cost = newDouble();
		Stock s = new Stock(wear, cost, name);
		valuables.add(s);
	}

	public void createStock(String name) {
		displayText("How many stocks are we talking?");
		int quantity = newInt();
		displayText("What's the current course?");
		double course = newDouble();
		Stock s = new Stock(quantity, course, name);
		valuables.add(s); // Basically, the quantity * course will be the
							// calculation later on.
	}

	public void hardcode() { // Just some hardcoded test-valuables. So far, the
								// program has practically 0 functionality; but
								// once the value-calculation algorithms are in
								// place... it's practically done!
		Jewellery j = new Jewellery(12, true, "Steve");
		valuables.add(j);
		Stock s = new Stock(12, 12.8, "Astra Zenica");
		valuables.add(s);
		Appliance a = new Appliance(1, 12000, "Shitty TV");
		valuables.add(a);
	}

	public static void main(String[] Args) { // The main method
		System.out.println("A pointless Program. (For now)");
		Mainmethod m = new Mainmethod(); // This is simply to avoid having to
											// use "static"; by calling upon the
											// methods through the Mainmethod object "m"-.. you get it.
		m.hardcode();
		m.run();
		m.keyboard.close();

	}
}
