package thirteen;

import java.io.File;
import java.util.Scanner;

class thirteen {

  public static void main(String args[]) {

    Scanner keyboard = new Scanner(System.in);
    char reply;
    String fileName;
    
    System.out.print("What file would you like to delete? ");
    fileName = keyboard.next();

    do {
      System.out.print("Reply with Y or N...");
      System.out.print("  Delete the importantData file? ");
      reply = keyboard.findWithinHorizon(".", 0).charAt(0);

    } while (reply != 'Y' && reply != 'N');

    if (reply == 'Y') {
      new File(fileName + ".txt").delete();
      System.out.println("Deleted!");
    } else {
      System.out.println("Just checking!");
    }

    keyboard.close();
  }
}
