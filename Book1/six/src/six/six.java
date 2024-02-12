package six;

import java.util.Scanner;
import java.util.Random;

class six {

    public static void main(String args[]) {
    	Scanner keyboard = new Scanner(System.in);
        Random myRandom = new Random();
        int yourNum;

        while (true) {
            int randomNumber = myRandom.nextInt(1000000) + 1;
            
	        System.out.print("Type your ticket number(1-1000000): ");
	        yourNum = keyboard.nextInt();

	        if (yourNum == 0){
	        	break;
	        }

	        if (yourNum > 1000001){
	            System.out.println("The number \"" + yourNum + "\" is too big.");
	        	continue;
	        }
	        
	        if (yourNum < 0){
	            System.out.println("The number \"" + yourNum + "\" is too small.");
	        	continue;
	        }
	        
	        if (randomNumber == yourNum) {
	            System.out.println("You Win 1,$$$,$$$ dollors!");
	        } else {
	            System.out.println("You loose.");
	        	
	        }
	
	        System.out.print("Winning Ticket: ");
	        System.out.println(randomNumber);
        }
        
        keyboard.close();
    }
}