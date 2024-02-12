package eight;

import java.util.Scanner;
import java.util.Random;
import static java.lang.System.out;

class eight {

    public static void main(String args[]) {
        Scanner keyboard = new Scanner(System.in);
        Random myRandom = new Random();
        int randomNumber;

        while (true) {
            int num;
        	out.print("Type your question: ");
            num = keyboard.nextInt();

            randomNumber = myRandom.nextInt(50) + 1;

            if (num == 0) {
            	break;
            }
            
            switch (randomNumber) {
            case 1:
                out.println("Yes. Isn't it obvious?");

            case 2:
                out.println("No, and don't ask again.");

            case 3:
                out.print("Yessir, yessir!");
                out.println(" Three bags full.");

            case 4:
                out.print("What part of 'no'");
                out.println(" don't you understand?");
                break;

            case 5:
                out.println("No chance, Lance.");

            case 6:
                out.println("Sure, whatever.");

            case 7:
                out.print("Yes, but only if");
                out.println(" you're nice to me.");

            case 8:
                out.println("Yes (as if I care).");

            case 9:
                out.print("No, not until");
                out.println(" Cromwell seizes Dover.");

            case 10:
                out.print("No, not until");
                out.println(" Nell squeezes Rover.");
            case 11:
                out.println("Yes. Isn't it obvious?");

            case 12:
                out.println("No, and don't ask again.");

            case 13:
                out.print("Yessir, yessir!");
                out.println(" Three bags full.");

            case 14:
                out.print("What part of 'no'");
                out.println(" don't you understand?");

            case 15:
                out.println("No chance, Lance.");

            case 16:
                out.println("Sure, whatever.");

            case 17:
                out.print("Yes, but only if");
                out.println(" you're nice to me.");

            case 18:
                out.println("Yes (as if I care).");

            case 19:
                out.print("No, not until");
                out.println(" Cromwell seizes Dover.");

            case 20:
                out.print("No, not until");
                out.println(" Nell squeezes Rover.");
            case 21:
                out.println("Yes. Isn't it obvious?");

            case 22:
                out.println("No, and don't ask again.");

            case 23:
                out.print("Yessir, yessir!");
                out.println(" Three bags full.");

            case 24:
                out.print("What part of 'no'");
                out.println(" don't you understand?");

            case 25:
                out.println("No chance, Lance.");

            case 26:
                out.println("Sure, whatever.");

            case 27:
                out.print("Yes, but only if");
                out.println(" you're nice to me.");

            case 28:
                out.println("Yes (as if I care).");

            case 29:
                out.print("No, not until");
                out.println(" Cromwell seizes Dover.");

            case 30:
                out.print("No, not until");
                out.println(" Nell squeezes Rover.");
            case 31:
                out.println("Yes. Isn't it obvious?");

            case 32:
                out.println("No, and don't ask again.");

            case 33:
                out.print("Yessir, yessir!");
                out.println(" Three bags full.");

            case 34:
                out.print("What part of 'no'");
                out.println(" don't you understand?");

            case 35:
                out.println("No chance, Lance.");

            case 36:
                out.println("Sure, whatever.");

            case 37:
                out.print("Yes, but only if");
                out.println(" you're nice to me.");

            case 38:
                out.println("Yes (as if I care).");

            case 39:
                out.print("No, not until");
                out.println(" Cromwell seizes Dover.");

            case 40:
                out.print("No, not until");
                out.println(" Nell squeezes Rover.");
            case 41:
                out.println("Yes. Isn't it obvious?");

            case 42:
                out.println("No, and don't ask again.");

            case 43:
                out.print("Yessir, yessir!");
                out.println(" Three bags full.");

            case 44:
                out.print("What part of 'no'");
                out.println(" don't you understand?");

            case 45:
                out.println("No chance, Lance.");

            case 46:
                out.println("Sure, whatever.");

            case 47:
                out.print("Yes, but only if");
                out.println(" you're nice to me.");

            case 48:
                out.println("Yes (as if I care).");

            case 49:
                out.print("No, not until");
                out.println(" Cromwell seizes Dover.");

            case 50:
                out.print("No, not until");
                out.println(" Nell squeezes Rover.");
                
            default:
                out.print("You think you have");
                out.print(" problems?");
                out.print(" My random number");
                out.println(" generator is broken!");
            }

            out.println("Goodbye");
        }
        
        keyboard.close();
    }
}

