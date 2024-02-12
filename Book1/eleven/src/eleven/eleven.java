package eleven;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import static java.lang.System.out;

class eleven {
    
    public static void main(String args[]) 
                         throws FileNotFoundException {
    	Scanner keyboard = new Scanner(System.in);
        
        PrintStream diskWriter = new PrintStream("newWords.txt");
        
    	out.println("Write what you would like to store in \"newWords.txt?\"");
	    String words = keyboard.nextLine();
	    
	    diskWriter.println(words);

	    out.print("You words have been saved.");
	    
        keyboard.close();
        diskWriter.close();
    }
}
