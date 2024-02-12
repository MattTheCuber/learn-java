package sixteen;

import static java.lang.System.out;

class sixteen {
//I did it, I made a real program!!!
    public static void main(String args[]) {
    	int num1 = 1, num2 = 1, total;

        for (int i = 1; i < 21; i++) {
            num1 = 1;
            for (num1 = 1; num1 < 21; num1++) {
            	num2 = i;
                total = num1 * num2;
            	out.println(num1 + " * " + num2 + " = " + total);
            }
        }
    }
}

