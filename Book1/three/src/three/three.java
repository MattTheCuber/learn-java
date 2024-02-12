package three;

import java.util.Scanner;

class three {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		double gas;
		double electricity;
		double water;
		double total;

		System.out.println("How much for Gas, Electricity, and water? (only decimals, no dollar signs): ");

		gas = keyboard.nextDouble();
		electricity = keyboard.nextDouble();
		water = keyboard.nextDouble();
		
		total = gas + electricity + water;
		
		System.out.print("Your bill is $");
		System.out.print(total);
		System.out.println(".");
		
		keyboard.close();
	}

}
