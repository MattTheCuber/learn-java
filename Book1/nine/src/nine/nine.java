package nine;

import java.util.Random;
import static java.lang.System.out;

class nine {

	static void printDie(int cnt, int die1, int die2, int die3, int die4){
        out.print(cnt);
        out.print(": ");
        out.print(die1);
        out.print(", ");
        out.print(die2);
        out.print(", ");
        out.print(die3);
        out.print(", ");
        out.println(die4);
		
	}
    public static void main(String args[]) {
        Random myRandom = new Random();
        int die1 = 0, die2 = 0, die3 = 0, die4 = 0, cnt = 0;

        while (die1 + die2 + die3 + die4 != 24 && die1 + die2 + die3 + die4 != 4) {
            die1 = myRandom.nextInt(6) + 1;
            die2 = myRandom.nextInt(6) + 1;
            die3 = myRandom.nextInt(6) + 1;
            die4 = myRandom.nextInt(6) + 1;
            cnt++;
            
            printDie(cnt, die1, die2, die3, die4);

        }

        out.print("Rolled ");
        out.println(die1 + die2 + die3 + die4);
    }
}
