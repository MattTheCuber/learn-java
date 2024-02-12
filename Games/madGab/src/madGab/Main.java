package madGab;

import static java.lang.System.out;
import java.util.Random;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

class Main {
    public static void main(String args[]) throws FileNotFoundException {
    	play();
    }
    static void play() throws FileNotFoundException {
		Scanner statmentScanner = new Scanner(new File("statments.txt"));
		Scanner hintScanner = new Scanner(new File("hints.txt"));
		Scanner answerScanner = new Scanner(new File("answers.txt"));
	    Scanner keyboard = new Scanner(System.in);
		Random myRandom = new Random();

        int	number;
        String statments[], hints[], answers[], wantHint, wantAnswer, answer;
        statments = new String[57];
        hints = new String[57];
        answers = new String[57];
        number = myRandom.nextInt(57);
        
        for (int i = 0; i < 57; i++) {
        	statments[i] = statmentScanner.nextLine();
        }
        for (int i = 0; i < 57; i++) {
        	hints[i] = hintScanner.nextLine();
        }
        for (int i = 0; i < 57; i++) {
        	answers[i] = answerScanner.nextLine();
        }
        
        out.println("Statment: " + statments[number]);
        out.print("Would you like a hint(Yes/No)? ");
        wantHint = keyboard.next();
        wantHint = wantHint.toUpperCase();
        
        if (wantHint.equals("YES")) {
        	out.println("Hint: " + hints[number]);
        	out.print("Type \"Yes\" when you would like the answer: ");
        	wantAnswer = keyboard.next();
        	wantAnswer = wantAnswer.toUpperCase();
            if (wantAnswer.equals("YES")) {
            	out.println("Answer: " + answers[number]);
            	out.print("Would you like another question(Yes/No)? ");
            	answer = keyboard.next();
            	answer = answer.toUpperCase();
                if (answer.equals("YES")) {
                	play();
                } else if (answer.equals("NO")) {
                	System.exit(0);
                } else {
                	out.print("Incorrect input.  Please restart.");
                }
            } else {
            	out.print("Incorrect input.  Please restart.");
            }
        } else if (wantHint.equals("NO")) {
        	out.print("Type \"Yes\" when you would like the answer: ");
        	wantAnswer = keyboard.next();
        	wantAnswer = wantAnswer.toUpperCase();
            if (wantAnswer.equals("YES")) {
            	out.println("Answer: " + answers[number]);
            	out.print("Would you like another question(Yes/No)? ");
            	answer = keyboard.next();
            	answer = answer.toUpperCase();
                if (answer.equals("YES")) {
                	play();
                } else if (answer.equals("NO")) {
                	System.exit(0);
                } else {
                	out.print("Incorrect input.  Please restart.");
                }
            } else {
            	out.print("Incorrect input.  Please restart.");
            }
        } else {
        	out.print("Incorrect input.  Please restart.");
        }
        
        keyboard.close();
        statmentScanner.close();
        hintScanner.close();
        answerScanner.close();
        System.exit(0);
    }
}/*
	function getStatment() { number = randInt(57); $("#statment").html(statments[number]); }
	function showAnswer() { $("#answer").animate({height:60}, 1000); $("#answer").html(answers[number]); }
	function showHint() { $("#hint").animate({height:60}, 1000); $("#hint").html(hints[number]); }*/
