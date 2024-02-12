/*package plusMath;

import java.util.Random;
import java.util.Scanner;
import javafx.application.*;
import javafx.geometry.Pos;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;

public class Start extends Application {
    Label lbl;
    int wrongs = 0, score, randomNum1, randomNum2, ra;
    String letterScore, differculty;
	String txt, q, input, WorR, ya


	void medium() {
        Random myRandom = new Random();
		txt1 = "Type your answer as a number, you have 10 questions.\n"        
    	for (int i = 1; i < 11; i++) {
        	int randomNum1, randomNum2, ra;
    		String ya;

    		randomNum1 = myRandom.nextInt(9);
    		randomNum2 = myRandom.nextInt(10);
    		
    		System.out.print("Question #" + i + ": " + randomNum1 +" + " + randomNum2 + " = ");
    		ya = keyboard.next();
    		
    		ra = randomNum1 + randomNum2;
    		
    		if (Integer.parseInt(ya) == ra) {
    			System.out.println("Correct!");
    		} else {
        		System.out.print("Retry: " + randomNum1 +" + " + randomNum2 + " = ");
        		ya = keyboard.next();
        		
        		if (Integer.parseInt(ya) == ra) {
        			System.out.println("Correct!");
        		} else {
        			System.out.println("Wrong.");
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
    	
    	System.out.println("You score: " + score + "% " + letterScore);
	}
	void hard() {
        Random myRandom = new Random();
		System.out.println("Type your answer as a number, you have 10 questions.\n");
    	for (int i = 1; i < 11; i++) {
        	int randomNum1, randomNum2, ra;
    		String ya;

    		randomNum1 = myRandom.nextInt(19);
    		randomNum2 = myRandom.nextInt(20);
    		
    		System.out.print("Question #" + i + ": " + randomNum1 +" + " + randomNum2 + " = ");
    		ya = keyboard.next();
    		
    		ra = randomNum1 + randomNum2;
    		
    		if (Integer.parseInt(ya) == ra) {
    			System.out.println("Correct!");
    		} else {
        		System.out.print("Retry: " + randomNum1 +" + " + randomNum2 + " = ");
        		ya = keyboard.next();
        		
        		if (Integer.parseInt(ya) == ra) {
        			System.out.println("Correct!");
        		} else {
        			System.out.println("Wrong.");
        			wrongs = wrongs + 10;
        		}
    		}
    	}
	}
}*/
