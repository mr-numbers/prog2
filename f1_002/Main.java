package f1_002;

//Klass skapad av Carl Herkommer, för inlämning 1 för kursen Prog2, VT2016

import java.util.ArrayList;

public class Main {

	ArrayList<Valuable> valuables = new ArrayList<>();

	public void createSampleData() {
		Swing.valuablesList.add(new Appliance("Shitty ass TV", 1200, 2));
		Swing.valuablesList.add(new Appliance("Another shitty ass TV", 2500, 7));
		Swing.valuablesList.add(new Stock("Astra Zenica", 200, 5.43));
		Swing.valuablesList.add(new Stock("Telia", 125, 4.2));
		Swing.valuablesList.add(new Stock("Telia S", 500, 7.2));
		Swing.valuablesList.add(new Stock("Medicwave", 2000, 12.9));
		Swing.valuablesList.add(new Stock("CSS", 2000, 1.27));
		Swing.valuablesList.add(new Jewellery("Gold necklace", true, 39));
		Swing.valuablesList.add(new Jewellery("Gold medallion", true, 57));
		Swing.valuablesList.add(new Jewellery("Brass bracelet", false, 12));
	}

	public static void main(String[] args) {
		Main program = new Main();
		program.createSampleData();
		Swing window = new Swing();
	}
}