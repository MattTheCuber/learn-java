package timesMath;

import static java.lang.System.out;
import java.util.Random;
import java.util.Scanner;

class Main {
    public static void main(String args[]) {
        Scanner keyboard = new Scanner(System.in);
        Random myRandom = new Random();
        
        int wrongs = 0, score;
        String letterScore, differculty;
        
        out.print("What differculty (Easy/Medium/Hard)? ");
        differculty = keyboard.next();
        differculty = differculty.toUpperCase();
		
		if (differculty.equals("EASY")) {
			out.println("Type your answer as a number, you have 10 questions.\n");
	    	for (int i = 1; i < 11; i++) {
	        	int randomNum1, randomNum2, ra;
	    		String ya;

	    		randomNum1 = myRandom.nextInt(12);
	    		randomNum2 = myRandom.nextInt(5);
	    		
	    		out.print("Question #" + i + ": " + randomNum1 + " * " + randomNum2 + "  = ");
	    		ya = keyboard.next();
	    		
	    		ra = randomNum1 * randomNum2;
	    		
	    		if (Integer.parseInt(ya) == ra) {
	    			out.println("Correct!");
	    		} else {
	        		out.print("Retry: " + randomNum1 +" * 1 = ");
	        		ya = keyboard.next();
	        		
	        		if (Integer.parseInt(ya) == ra) {
	        			out.println("Correct!");
	        		} else {
	        			out.println("Wrong.  Answer: " + ra);
	        			wrongs = wrongs + 10;
	        		}
	    		}
	    	}
	    	score = 100 - wrongs;
	    	
	    	if (score == 100) {
	    		letterScore = "A+";
	    	} else if ((score < 100)&&(score > 94)) {
	    		letterScore = "A";
	    	} else if ((score < 95)&&(score > 89)) {
	    		letterScore = "A-";
	    	} else if ((score < 90)&&(score > 79)) {
	    		letterScore = "B";
	    	} else if ((score < 80)&&(score > 69)) {
	    		letterScore = "C";
	    	} else if ((score < 70)&&(score > 59)) {
	    		letterScore = "D";
	    	} else if ((score < 60)&&(score > 49)) {
	    		letterScore = "E";
	    	} else if ((score < 50)&&(score > 44)) {
	    		letterScore = "F";
	    	} else if (score < 45) {
	    		letterScore = "F-";
	    	} else {
	    		letterScore = "";
	    	}
	    	
	    	out.println("You score: " + score + "% " + letterScore);
		} else if (differculty.equals("MEDIUM")) {
			out.println("Type your answer as a number, you have 10 questions.\n");        
	    	for (int i = 1; i < 11; i++) {
	        	int randomNum1, randomNum2, ra;
	    		String ya;

	    		randomNum1 = myRandom.nextInt(12);
	    		randomNum2 = myRandom.nextInt(12);
	    		
	    		out.print("Question #" + i + ": " + randomNum1 +" * " + randomNum2 + " = ");
	    		ya = keyboard.next();
	    		
	    		ra = randomNum1 * randomNum2;
	    		
	    		if (Integer.parseInt(ya) == ra) {
	    			out.println("Correct!");
	    		} else {
	        		out.print("Retry: " + randomNum1 +" * " + randomNum2 + " = ");
	        		ya = keyboard.next();
	        		
	        		if (Integer.parseInt(ya) == ra) {
	        			out.println("Correct!");
	        		} else {
	        			out.println("Wrong.  Answer: " + ra);
	        			wrongs = wrongs + 10;
	        		}
	    		}
	    	}
	    	score = 100 - wrongs;
	    	
	    	if (score == 100) {
	    		letterScore = "A+";
	    	} else if ((score < 100)&&(score > 94)) {
	    		letterScore = "A";
	    	} else if ((score < 95)&&(score > 89)) {
	    		letterScore = "A-";
	    	} else if ((score < 90)&&(score > 79)) {
	    		letterScore = "B";
	    	} else if ((score < 80)&&(score > 69)) {
	    		letterScore = "C";
	    	} else if ((score < 70)&&(score > 59)) {
	    		letterScore = "D";
	    	} else if ((score < 60)&&(score > 49)) {
	    		letterScore = "E";
	    	} else if ((score < 50)&&(score > 44)) {
	    		letterScore = "F";
	    	} else if (score < 45) {
	    		letterScore = "F-";
	    	} else {
	    		letterScore = "";
	    	}
	    	
	    	out.println("You score: " + score + "% " + letterScore);
		} else if (differculty.equals("HARD")) {
			out.println("Type your answer as a number, you have 10 questions.\n");
	    	for (int i = 1; i < 11; i++) {
	        	int randomNum1, randomNum2, ra;
	    		String ya;

	    		randomNum1 = myRandom.nextInt(20);
	    		randomNum2 = myRandom.nextInt(20);
	    		
	    		out.print("Question #" + i + ": " + randomNum1 +" * " + randomNum2 + " = ");
	    		ya = keyboard.next();
	    		
	    		ra = randomNum1 * randomNum2;
	    		
	    		if (Integer.parseInt(ya) == ra) {
	    			out.println("Correct!");
	    		} else {
	        		out.print("Retry: " + randomNum1 +" * " + randomNum2 + " = ");
	        		ya = keyboard.next();
	        		
	        		if (Integer.parseInt(ya) == ra) {
	        			out.println("Correct!");
	        		} else {
	        			out.println("Wrong.  Answer: " + ra);
	        			wrongs = wrongs + 10;
	        		}
	    		}
	    	}
	    	score = 100 - wrongs;
	    	
	    	if (score == 100) {
	    		letterScore = "A+";
	    	} else if ((score < 100)&&(score > 94)) {
	    		letterScore = "A";
	    	} else if ((score < 95)&&(score > 89)) {
	    		letterScore = "A-";
	    	} else if ((score < 90)&&(score > 79)) {
	    		letterScore = "B";
	    	} else if ((score < 80)&&(score > 69)) {
	    		letterScore = "C";
	    	} else if ((score < 70)&&(score > 59)) {
	    		letterScore = "D";
	    	} else if ((score < 60)&&(score > 49)) {
	    		letterScore = "E";
	    	} else if ((score < 50)&&(score > 44)) {
	    		letterScore = "F";
	    	} else if (score < 45) {
	    		letterScore = "F-";
	    	} else {
	    		letterScore = "";
	    	}
	    	
	    	out.println("You score: " + score + "% " + letterScore);
		} else {
			out.println("Incorrect input.  Please restart.");
		}
		keyboard.close();
    	System.exit(0);
    }
}
