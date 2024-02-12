package hackingDevice;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import static java.lang.System.out;

class Main {
    public static void main(String args[]) 
                         throws FileNotFoundException {
        Scanner wordScanner = new Scanner(new File("words.txt"));
        Scanner numberScanner = new Scanner(new File("numbers.txt"));
        String words[];
        words = new String[1];
        int numbers[];
        numbers = new int[1000000];
        String pswrd = "593134";
        pswrd = pswrd.toUpperCase();
        for (int i = 0; i < 1; i++) {
        	words[i] = wordScanner.next();
        	if (words[i].equals(pswrd)) {
        		out.println("Found password: " + words[i]);
        	}
        }
        for (int i = 0; i < 1000000; i++) {
        	numbers[i] = numberScanner.nextInt();
        	int newPswrd = Integer.parseInt(pswrd);
        	if (numbers[i] == newPswrd) {
        		out.println("Found password: " + numbers[i]);
        	}
        }
        wordScanner.close();
        numberScanner.close();
        System.exit(0);
    }
}
