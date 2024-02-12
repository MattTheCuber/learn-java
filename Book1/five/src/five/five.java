package five;

import java.util.Scanner;
import java.util.Random;

class five {

  public static void main(String args[]) {
    Scanner keyboard = new Scanner(System.in);
    Random myRandom = new Random();
    int randomNumber;

    while (true) {
	    System.out.print("Type your yes or no quesiton: ");
	    keyboard.nextLine();
	
	    randomNumber = myRandom.nextInt(10) + 1;
	
	    if (randomNumber > 5) {
	      System.out.println("Yes.");
	    } else {
	      System.out.println("No.");
	    }
	
	    keyboard.close();
    }
  }
}
