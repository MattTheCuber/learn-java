package fourteen;

import static java.lang.System.out;

class fourteen { 

    enum Symbol {
        one, two, three, four, five, six, seven, eight, nine, ten 
    }

    public static void main(String args[]) {
        
        for (Symbol firstLeftReel : Symbol.values()) {
        	for (Symbol secondLeftReel : Symbol.values()) {
        		for (Symbol middleReel : Symbol.values()) {
        			for (Symbol firstRightReel : Symbol.values()) {
        				for (Symbol lastRightReel : Symbol.values()) {
        					out.print(firstLeftReel);
        					out.print(" ");
        					out.print(secondLeftReel);
        					out.print(" ");
        					out.print(middleReel);
        					out.print(" ");
        					out.print(firstRightReel);
        					out.print(" ");
        					out.println(lastRightReel);
        				}
        			}
        		}
        	}
        }
    }
}
