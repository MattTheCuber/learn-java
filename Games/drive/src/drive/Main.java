package drive;

import java.util.Scanner;

public class Main {
	static boolean doIHaveACar;
	static int money = 3000;
	
	public static void main(String[] args) {
		doIHaveACar = false;
		check();
	}

	private static void buyOne() {
		if (money > 1499) {
			money -= 1500;
			doIHaveACar = true;
			check();
		} else {
			System.out.print("Not enough money");
			check();
		}
	}

	private static void driveIt() {
		if (doIHaveACar == true) {
			System.out.print("\nHow far do you want to drive? ");
			Scanner keyboard = new Scanner(System.in);
			
			int miles = keyboard.nextInt();
			
			if (money - (miles * 2) > -1) {
				money -= miles * 2;
			} else {
				System.out.print("Not enough money");
				check();
			}
			
			check();
			
			keyboard.close();
		} else {
			System.out.print("You do not have a car.");
			check();
		}
	}

	private static void check() {
		System.out.println("\nMoney: " + money);
		System.out.println("Do you have a car: " + doIHaveACar);
		
		System.out.print("Your command(buy/drive/earn)? ");
		
		Scanner keyboard = new Scanner(System.in);
		
		String command = keyboard.next();
		
		if (command.equals("drive")) {
			driveIt();
		} else if (command.equals("buy")) {
			buyOne();
		} else if (command.equals("earn")) {
			earnMoney();
		} else {
			check();
		}
		
		keyboard.close();
	}

	private static void earnMoney() {
		System.out.println("\nHow many hours do you want to work? ");
		Scanner keyboard = new Scanner(System.in);
		
		int hours = keyboard.nextInt();

		System.out.println("Please wait while you are working");

		if (hours > 1000) {
			for (int i = 0; i < 101; i += 5) {
				try {
					Thread.sleep(hours);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(i + "% Complete");
			}
		} else {
			int hour = hours / 5;
			for (int i = 0; i < 101; i += 20) {
				try {
					Thread.sleep(hour * 100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(i + "% Complete");
			}
		}
		money += hours * 20;
		
		System.out.println("$" + hours * 20 + " has been added to your bank.");
		
		check();
		
		keyboard.close();	
	}
}