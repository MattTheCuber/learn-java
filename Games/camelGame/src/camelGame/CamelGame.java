package camelGame;

import static java.lang.System.out;
import java.util.Random;
import java.util.Scanner;

public class CamelGame {
    int cmlDrinks, drinks, cmlDays, pygmyDeleys;
    double plyrMiles, pygmyMiles;
    boolean captured;
	void startGame() {
	    Scanner keyboard = new Scanner(System.in);
        Random myRandom = new Random();
	    if (plyrMiles > 199) {
			out.print("\nYou win, a party is being given in you honor.......\n.......The pygnies are planning to ");
			out.print("attend");
	    	endGame1();
	    }
	    out.println(drinks);
	    drinks -= 1;
	    if (drinks == 1) {
	    	out.println("-----------------WARNING----------------- Get a drink");
	    }
	    if (drinks < 0) {
	    	out.println("You ran out of water...... Sorry chun!!!");
	    	death();
	    }
	    pygmyDeleys += 1;
	    double x2 = myRandom.nextInt(1) * 10;
	    x2 += 2.5;
	    if (captured == false) {
	    	double newMiles = plyrMiles - pygmyMiles;
		    out.print("The pygmies are " + newMiles + " miles behind you.\nYou have traveled " + plyrMiles + "miles");
		    out.println(" alltogether");
		    askCommand();
	    }
	    if (pygmyDeleys < 4) {
		    out.print("You have traveled " + plyrMiles + "miles");
		    out.println(" alltogether");
		    askCommand();
	    }
	    pygmyMiles += x2;
	    if (pygmyMiles < plyrMiles) {
	    	double newMiles = plyrMiles - pygmyMiles;
		    out.print("The pygmies are " + newMiles + " miles behind you.\nYou have traveled " + plyrMiles + "miles");
		    out.println(" alltogether");
		    askCommand();
	    }
	    out.println("The pygmies have catured you. Camel and soup is their favorite dish!!!");
	    endGame1();
	    keyboard.close();
	}
	void showInstrustions() {
	    out.print("\n\tWelcome to Camel.\nThe object is to travel 200 miles across the Great Gobi Desert.");
	    out.print("\nA tribe of knocked kneed pygmies will be chasing you.\nYou will be asked for commands every so ");
	    out.print("often.\n\nCommands:\n1. Drink from your carteen\n2. Ahead moderate speed\n3. Ahead full speed\n4. ");
	    out.print("Stop for the night\n5. Status check\n6. Hope for help\n\n\nYou have 1 quart of water which will ");
	    out.print("last you 6 drinks.\nYou have to reneu your water supply  completely at an oases.\nIf help does not");
	    out.print(" find you after command 6, you lose.\nGood luck and good cameling!!\nYou are in the middle of the ");
	    out.println("desert at a oases.");
	    initialItems();
	    startGame();
	}
	void endGame1() {
		Scanner keyboard = new Scanner(System.in);
		String newGame;
		out.print(".......\n\nWant a new camel and a new game(yes/no)? ");
		newGame = keyboard.next();
		newGame = newGame.toUpperCase();
		if (newGame.equals("NO")) {
			out.println("-----------------\n     Chicken\n-----------------");
	    } else if (newGame.equals("YES")) {
		    showInstrustions();
		} else {
	    	out.println("Sorry incorrect input.  Please restart game.");
	    }
		keyboard.close();
	}
	void death() {
		Random myRandom = new Random();
    	int u = myRandom.nextInt(1) * 10;
    	out.println("You died in the desert.");
    	
    	if (u > 1) {
    		out.println("Your body was eaten by vultures and imported cannibals!!!");
    	} if (u > 3) {
    		out.println("The local sheik now uses your skull for a change purse!!!");
    	} if (u > 5) {
    		out.println("People with little intelligence should stay out of the desert.");
    	} if (u > 7) {
    		out.println("Turkeys should fly, not ride camles!!!!!!!");
    	} else {
    		out.println("The National Camel's Union is not attending you funeral!!!");
    	}
    	endGame1();
	}
	void askCommand() {
		Scanner keyboard = new Scanner(System.in);
		Random myRandom = new Random();
    	String command1;
	    out.println("What is your command?");
	    command1 = keyboard.next();
	    switch(command1) {
	    case "1":
	    	drinks -= 1;
	    	if (drinks < 0) {
	    		death();
	    	}
	    	out.println("Better watch for an oases!");
	    	cmlDrinks = 4;
	    	askCommand();
	    case "2":
	    	cmlDays += 1;
	    	if (cmlDays == 8) {
	    		out.println("You dirty rascallion! You ran your camel to death!!");
	    		death();
	    	}
	    	int ad = myRandom.nextInt(1) * 100;
	    	if (ad > 5) {
	    		//1120
	    	}
	    	out.print("Wild berbers hidden in the sand have captured you.\nLuckily the local sheik has agreed to");
	    	out.print(" their ransom-\ndemands.......BUT.......Watch for the pygmies!!!\nYou have a new choice of ");
	    	out.print("sub-commands:\n#7 Attempt an escape\n#8Wait for payment\nYour sub-command: ");
	    	String subCommand1 = keyboard.next();
	    	if (subCommand1.equals("8")) {
	    		//1040
	    	} else if (subCommand1.equals("7")) {
	    		out.println("Your ransom has been paid and you are free to go.");
	    		captured = false;
	    		startGame();
	    	} else {
	    		out.print("Incorrect input. Please restart game.");
	    		System.exit(0);
	    	}
	    case "3":
	    	cmlDays = cmlDays + 3;
	    	if (cmlDays > 7) {
	    		out.print("You dirty rascallion! You ran your camel to death!!");
	    		death();
	    	}
	    	int ab = myRandom.nextInt(1) * 100;
	    	if (ab > 5) {
	    		ab = myRandom.nextInt(1) * 100;
	    		out.print("You dirty rascallion! You ran your camel to death!!");
	    		death();
	    	}
	    	//900
		case "4":
			out.print("Your camel thanks you!");
			cmlDays = 0;
		    drinks -= 1;
		    if (drinks == 1) {
		    	out.println("-----------------WARNING----------------- Get a drink");
		    }
		    if (drinks < 0) {
		    	out.println("You ran out of water...... Sorry chun!!!");
		    	death();
		    }
		    pygmyDeleys = pygmyDeleys + 1;
		    double x2 = myRandom.nextInt(1) * 10 + 2.5;
		    out.println(x2);
		    if (captured == false) {
		    	double newMiles = plyrMiles - pygmyMiles;
			    out.print("The pygmies are " + newMiles + " miles behind you.\nYou have traveled " + plyrMiles + "miles");
			    out.println(" alltogether");
			    askCommand();
		    }
		    if (pygmyDeleys < 4) {
			    out.print("You have traveled " + plyrMiles + "miles");
			    out.println(" alltogether");
			    askCommand();
		    }
		    pygmyMiles += x2;
		    if (pygmyMiles < plyrMiles) {
		    	double newMiles = plyrMiles - pygmyMiles;
			    out.print("The pygmies are " + newMiles + " miles behind you.\nYou have traveled " + plyrMiles + "miles");
			    out.println(" alltogether");
			    askCommand();
		    }
		    out.println("The pygmies have captured you. Camel and soup is their favorite dish!!!");
		    endGame1();
		case "5":
			int newCmlDays = 7 - cmlDays;
		    out.print("Your camel has " + newCmlDays + " good days left.\nYou have " + cmlDrinks + "drinks left in");
		    out.print("your canteen.\nYou can go " + drinks + " commands without drinking.");
		    cmlDrinks -= 1;
		    if (cmlDrinks < 0) {
		    	death();
		    }
		    out.print("Better watch for an oases!");
		    drinks = 4;
		    askCommand();
	    case "6":
	    	askCommand();
		}
		keyboard.close();
	}
	void initialItems() {
	    captured/*q*/ = false;
	    cmlDrinks/*s*/ = 4; drinks/*z*/= 6;  cmlDays/*f*/ = 0; pygmyDeleys/*p*/ = 0;
	    plyrMiles/*c*/ = 0; pygmyMiles/*c1*/ = 0;
	}
}
