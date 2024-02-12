package twelve;

import java.util.Random;
import static java.lang.System.out;

class twelve {
    public static void main(String args[]) {
        Random myRandom = new Random();
        int number;
        
        number = myRandom.nextInt(1000);
            
        out.print("Your number:" + number);
    }
}