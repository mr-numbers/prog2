package f1_002;
//Carl Herkommer
import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class Main {
	Scanner keyboard = new Scanner(System.in);
	ArrayList<Valuable> valuables = new ArrayList<>();
	/*
	public String newString() {
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

	public int newInt() {
		int i = keyboard.nextInt();
		keyboard.nextLine();
		return i;
	}
	public double newDouble() {
		double d = keyboard.nextDouble();
		keyboard.nextLine();
		return d;
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
			int choice = newInt();
			switch (choice) {
			case 1:
				createValuable();
				break;
			case 2:
				displayAll();
				break;
			case 3:
				i = 1;
			}
		}

	}
	public void runGUI(){
		
		
	}

	public void createValuable() {
		output("What type of valuable will you be adding?\n1. Jewellery\n2. Appliance\n3. Stocks\n");
		int i = newInt();
		boolean keepAdding = true;
		while(keepAdding){
			output("Name: ");
			String name = newString();
		switch (i) {
		case 1:			
			output("Is \""+name+"\" made of gold? y/n");
			boolean isGold=false;
			String answer = newString();
			if(answer.equalsIgnoreCase("y")){
				isGold=true;
			}
			output("\nAnd how many gems does it sport?");
			int stones = newInt();
			valuables.add(new Jewellery (name, isGold, stones));
			break;
		case 2:
			output("From 1-10, how would you rate the wear of \""+name+"\", where 1 is garbage and 10 pristine shape?");
			int wear = newInt();
			output("\nAnd what did you originally buy it for?");
			double cost = newDouble();
			valuables.add(new Appliance (name, cost, wear));
			break;
		case 3:
			output("How many stocks in \""+name+"\" would you like to add?");
			int stocks = newInt();
			output("\nWhat is the current course?");
			double course = newDouble();
			valuables.add(new Stock (name, stocks, course));
			break;
		default:
			break;
		}
		output("Add more? y/n");
		String answer = newString();
		if(answer.equalsIgnoreCase("n")){
			keepAdding=false;
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
	}*/ 
	//This is from when it was a console program.
	
	public void createSampleData() {
		Swing.valuablesList.add(new Appliance("Shitty ass TV", 1200, 2));
		Swing.valuablesList.add(new Appliance("Another shitty ass TV", 2500, 7));
		Swing.valuablesList.add(new Stock("Astra Zenica", 200, 5.43));
		Swing.valuablesList.add(new Stock("Telia", 125, 4.2));
		Swing.valuablesList.add(new Stock("CSS", 2000, 1.27));
		Swing.valuablesList.add(new Jewellery("Gold necklace", true, 39));
		Swing.valuablesList.add(new Jewellery("Gold medallion", true, 57));
		Swing.valuablesList.add(new Jewellery("Brass bracelet", false, 12));
	}


	public static void main(String[] args) {
		Main program = new Main();
		program.createSampleData();
		Swing window = new Swing();
	//	program.run();
	}
}