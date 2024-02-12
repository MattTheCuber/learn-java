package camelGame;

import java.util.Scanner;
import static java.lang.System.out;

public class camelRace {
    int cmlDrinks, drinks, cmlDays, pygmyDeleys;
    double plyrMiles, pygmyMiles;
    boolean captured;
	public static void main(String[] args) {
		CamelGame camelGame = new CamelGame();
		Scanner keyboard = new Scanner(System.in);
		String instructions;
		out.println("\t\t\t\t\t\t\t\tCAMEL\n\t\t\t\t\t\t\t   Creative Computing\n\t\t\t\t\t\t\t Morristown, New Jersey");
		out.print("Would you like instructions(yes/no)? ");
	    instructions = keyboard.next();
	    instructions = instructions.toUpperCase();
	    if (instructions.equals("NO")) {
		    out.println("Good luck and good cameling!!\nYou are in the middle of the desert at a oases.");
	    	camelGame.initialItems();
	    	camelGame.startGame();
	    } else if (instructions.equals("YES")) {
	    	camelGame.showInstrustions();
	    } else {
	    	out.println("Sorry incorrect input.  Please restart game.");
	    }
	    keyboard.close();
		System.exit(0);
	}
}