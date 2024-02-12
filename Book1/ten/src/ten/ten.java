package ten;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import static java.lang.System.out;

class ten {
    
    public static void main(String args[]) 
                         throws FileNotFoundException {
    	
    	Scanner keyboard = new Scanner(System.in);
        Scanner diskScanner = new Scanner(new File("Numbers.txt"));
        
    		out.print("What number to multiply by pi? ");
	        int number = keyboard.nextInt();
	        
	        int one = diskScanner.nextInt();
	        one = number;
	        double two = diskScanner.nextDouble();
	        
	        double newNum = one * two;
	        
	        out.print(newNum);

        keyboard.close();
        diskScanner.close();
    }
}
