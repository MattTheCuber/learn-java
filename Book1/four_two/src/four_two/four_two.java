package four_two;

import java.util.Scanner;

class four_two {

  public static void main(String args[]) {
    Scanner keyboard = new Scanner(System.in);
    String c1;
    
    System.out.println("Type your sentence: ");
    
    while (answer != "") {
        answer = keyboard.findWithinHorizon(".", 0).charAt(0);

        System.out.print(answer);	
    }

    keyboard.close();
  }
}
