package f1_002;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {
	Scanner keyboard = new Scanner(System.in);
	ArrayList<Valuable> valuables = new ArrayList<>();

	public String input() {
		boolean invalid = false;
		String theString = "Invalid";
		while (invalid) {
			theString = keyboard.nextLine();
			if (theString.equals(null)) {
				invalid = true;
			}
			if (theString.length() == 0) {
				invalid = true;
			}
			if (theString.equalsIgnoreCase("sampleText")) {
				invalid = true;
			}
		}
		return theString;
	}

	public void output(String output) {
		System.out.println(output);
	}

	public void menu() {
		System.out.println("main menu\n\n1. Add valuable\n2. Display all\n3. Quit");
	}

	public void run() {
		menu();
		valuables.add(new Appliance("Shitty ass TV", 1200, 2));
		valuables.add(new Appliance("Another shitty ass TV", 2500, 7));
		valuables.add(new Stock("Astra Zenica", 200, 5.43));
		valuables.add(new Stock("Telia", 125, 4.2));
		valuables.add(new Stock("CSS", 2000, 1.27));
		valuables.add(new Jewellery("Gold necklace", true, 39));
		valuables.add(new Jewellery("Gold medallion", true, 57));
		valuables.add(new Jewellery("Brass bracelet", false, 12));
		for(Valuable v : valuables){
			if(v instanceof Appliance){
				output(v.toString());
			}
		}
		
	}

	public static void main(String[] args) {
		Main program = new Main();
		program.run();
	}
}