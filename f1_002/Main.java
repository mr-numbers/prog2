package f1_002;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {
	Scanner keyboard = new Scanner(System.in);
	ArrayList<Valuable> valuables = new ArrayList<>();

	public String stringInput() {
		String theString = null;
		boolean invalid = false;
		do {
			invalid = false;
			theString = keyboard.nextLine();
			if (theString.equals(null)) {
				invalid = true;
				System.out.println("String is null - invalid");
			}
			if (theString.length() == 0) {
				invalid = true;
				System.out.println("Empty string - invalid");
			}
		} while (invalid);

		return theString;
	}

	public int intInput() {
		int i = keyboard.nextInt();
		keyboard.nextLine();
		return i;
	}

	public void menu() {
		System.out.println("main menu\n\n1. Add valuable\n2. Display all\n3. Quit");
	}

	public void output(String text) {
		System.out.println(text);
	}

	public void run() {
		int i = 0;
		while (i < 1) {
			menu();
			int choice = keyboard.nextInt();
			switch (choice) {
			case 1:
				createValuable();
				break;
			case 2:
				displayAll();
				break;
			case 3:
				i = 0;
			}
		}

	}

	public void createValuable() {
		output("What type of valuable will you be adding?\n1. Appliance\n2. Stocks\n3. Jewellery\n");
		int i = intInput();
		boolean keepAdding = false;
		while(keepAdding){
		switch (i) {
		case 1:
			break;
		case 2:
			break;
		case 3:
			break;
		default:
			break;
		}
		output("Add more? y/n");
		String answer = stringInput();
		if(answer.equalsIgnoreCase("y")){
			keepAdding=true;
		}
		}

	}

	public void displayAll() {
		for (Valuable v : valuables) {
			if (v instanceof Appliance) {
				v.calculateValue();
				output("Appliance: " + v.toString());
			}
			if (v instanceof Jewellery) {
				output("Jewellery: " + v.toString());
			}
			if (v instanceof Stock) {
				output("Stock: " + v.toString());
			}
		}
	}

	public void createSampleData() {
		valuables.add(new Appliance("Shitty ass TV", 1200, 2));
		valuables.add(new Appliance("Another shitty ass TV", 2500, 7));
		valuables.add(new Stock("Astra Zenica", 200, 5.43));
		valuables.add(new Stock("Telia", 125, 4.2));
		valuables.add(new Stock("CSS", 2000, 1.27));
		valuables.add(new Jewellery("Gold necklace", true, 39));
		valuables.add(new Jewellery("Gold medallion", true, 57));
		valuables.add(new Jewellery("Brass bracelet", false, 12));
	}

	public static void main(String[] args) {
		Main program = new Main();
		program.createSampleData();
		program.run();
	}
}