package madGabApp;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class writeArray {
    String statements[], hints[], answers[];

    void writeArrays() throws FileNotFoundException {    
		Scanner statmentScanner = new Scanner(new File("statements.txt"));
		Scanner hintScanner = new Scanner(new File("hints.txt"));
		Scanner answerScanner = new Scanner(new File("answers.txt"));
		
        statements = new String[57];
        hints = new String[57];
        answers = new String[57];
		
        for (int i = 0; i < 57; i++) { statements[i] = statmentScanner.nextLine(); }
        for (int i = 0; i < 57; i++) { hints[i] = hintScanner.nextLine(); }
        for (int i = 0; i < 57; i++) { answers[i] = answerScanner.nextLine(); }

        System.out.println("Statment: " + GetStatement(53));
        System.out.println("Hint: " + GetHint(53));
        System.out.println("Answer: " + GetAnswer(53));
        
        statmentScanner.close();
        hintScanner.close();
        answerScanner.close();
    }
    
    public String GetStatement(int i){
    	return statements[i];
    }
    
    public String GetHint(int i){
    	return hints[i];
    }
    
    public String GetAnswer(int i){
    	return answers[i];
    }
    
}