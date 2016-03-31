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
		
	}

	public static void main(String[] args) {
		Main program = new Main();
		program.run();
	}
}