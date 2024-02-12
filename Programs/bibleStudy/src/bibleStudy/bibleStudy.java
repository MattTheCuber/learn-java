package bibleStudy;

import static java.lang.System.out;
import java.util.Random;
import java.util.Scanner;
import java.applet.*;
import java.awt.*;

class bibleStudy {
	public static void main(String args[]) {
	    Scanner keyboard = new Scanner(System.in);
	    Random myRandom = new Random();
	    int randomChapter;
	    String book;
	    
    	out.print("Type the first 4 letters of the book you would like to study(2Kin, Phili, Phile): ");
        book = keyboard.next();

        keyboard.close();
        if (book.equals("Gene")) {
        	randomChapter = myRandom.nextInt(50);
        	out.println("Study " + book + ". " + randomChapter);
        } else if (book.equals("Exod")) {
        	randomChapter = myRandom.nextInt(40);
        	out.println("Study " + book + ". " + randomChapter);
        } else if (book.equals("Lavi")) {
        	randomChapter = myRandom.nextInt(27);
        	out.println("Study " + book + ". " + randomChapter);
        } else if (book.equals("Numb")) {
        	randomChapter = myRandom.nextInt(36);
        	out.println("Study " + book + ". " + randomChapter);
        } else if (book.equals("Deut")) {
        	randomChapter = myRandom.nextInt(34);
        	out.println("Study " + book + ". " + randomChapter);
        } else if (book.equals("Josh")) {
        	randomChapter = myRandom.nextInt(24);
        	out.println("Study " + book + ". " + randomChapter);
        } else if (book.equals("Judg")) {
        	randomChapter = myRandom.nextInt(21);
        	out.println("Study " + book + ". " + randomChapter);
        } else if (book.equals("Ruth")) {
        	randomChapter = myRandom.nextInt(4);
        	out.println("Study " + book + ". " + randomChapter);
        } else if (book.equals("1Sam")) {
        	randomChapter = myRandom.nextInt(31);
        	out.println("Study " + book + ". " + randomChapter);
        } else if (book.equals("2Sam")) {
        	randomChapter = myRandom.nextInt(24);
        	out.println("Study " + book + ". " + randomChapter);
        } else if (book.equals("1Kin")) {
        	randomChapter = myRandom.nextInt(22);
        	out.println("Study " + book + ". " + randomChapter);
        } else if (book.equals("2Kin")) {
        	randomChapter = myRandom.nextInt(25);
        	out.println("Study " + book + ". " + randomChapter);
        } else if (book.equals("1Cro")) {
        	randomChapter = myRandom.nextInt(29);
        	out.println("Study " + book + ". " + randomChapter);
        } else if (book.equals("2Cro")) {
        	randomChapter = myRandom.nextInt(36);
        	out.println("Study " + book + ". " + randomChapter);
        } else if (book.equals("Ezra")) {
        	randomChapter = myRandom.nextInt(10);
        	out.println("Study " + book + ". " + randomChapter);
        } else if (book.equals("Nehe")) {
        	randomChapter = myRandom.nextInt(13);
        	out.println("Study " + book + ". " + randomChapter);
        } else if (book.equals("Esth")) {
        	randomChapter = myRandom.nextInt(10);
        	out.println("Study " + book + ". " + randomChapter);
        } else if (book.equals("Job")) {
        	randomChapter = myRandom.nextInt(42);
        	out.println("Study " + book + ". " + randomChapter);
        } else if (book.equals("Psal")) {
        	randomChapter = myRandom.nextInt(150);
        	out.println("Study " + book + ". " + randomChapter);
        } else if (book.equals("Prov")) {
        	randomChapter = myRandom.nextInt(31);
        	out.println("Study " + book + ". " + randomChapter);
        } else if (book.equals("Eccl")) {
        	randomChapter = myRandom.nextInt(12);
        	out.println("Study " + book + ". " + randomChapter);
        } else if (book.equals("SofS")) {
        	randomChapter = myRandom.nextInt(8);
        	out.println("Study " + book + ". " + randomChapter);
        } else if (book.equals("Isai")) {
        	randomChapter = myRandom.nextInt(66);
        	out.println("Study " + book + ". " + randomChapter);
        } else if (book.equals("Jere")) {
        	randomChapter = myRandom.nextInt(52);
        	out.println("Study " + book + ". " + randomChapter);
        } else if (book.equals("Lame")) {
        	randomChapter = myRandom.nextInt(5);
        	out.println("Study " + book + ". " + randomChapter);
        } else if (book.equals("Ezek")) {
        	randomChapter = myRandom.nextInt(48);
        	out.println("Study " + book + ". " + randomChapter);
        } else if (book.equals("Dani")) {
        	randomChapter = myRandom.nextInt(12);
        	out.println("Study " + book + ". " + randomChapter);
        } else if (book.equals("Hose")) {
        	randomChapter = myRandom.nextInt(14);
        	out.println("Study " + book + ". " + randomChapter);
        } else if (book.equals("Joel")) {
        	randomChapter = myRandom.nextInt(3);
        	out.println("Study " + book + ". " + randomChapter);
        } else if (book.equals("Amos")) {
        	randomChapter = myRandom.nextInt(9);
        	out.println("Study " + book + ". " + randomChapter);
        } else if (book.equals("Obad")) {
        	out.println("Study " + book + ". 1");
        } else if (book.equals("Jona")) {
        	randomChapter = myRandom.nextInt(4);
        	out.println("Study " + book + ". " + randomChapter);
        } else if (book.equals("Mica")) {
        	randomChapter = myRandom.nextInt(7);
        	out.println("Study " + book + ". " + randomChapter);
        } else if (book.equals("Nahu")) {
        	randomChapter = myRandom.nextInt(3);
        	out.println("Study " + book + ". " + randomChapter);
        } else if (book.equals("Haba")) {
        	randomChapter = myRandom.nextInt(3);
        	out.println("Study " + book + ". " + randomChapter);
        } else if (book.equals("Zeph")) {
        	randomChapter = myRandom.nextInt(3);
        	out.println("Study " + book + ". " + randomChapter);
        } else if (book.equals("Hagg")) {
        	randomChapter = myRandom.nextInt(2);
        	out.println("Study " + book + ". " + randomChapter);
        } else if (book.equals("Zech")) {
        	randomChapter = myRandom.nextInt(14);
        	out.println("Study " + book + ". " + randomChapter);
        } else if (book.equals("Mala")) {
        	randomChapter = myRandom.nextInt(4);
        	out.println("Study " + book + ". " + randomChapter);
        } else if (book.equals("Matt")) {
        	randomChapter = myRandom.nextInt(28);
        	out.println("Study " + book + ". " + randomChapter);
        } else if (book.equals("Mark")) {
        	randomChapter = myRandom.nextInt(16);
        	out.println("Study " + book + ". " + randomChapter);
        } else if (book.equals("Luke")) {
        	randomChapter = myRandom.nextInt(24);
        	out.println("Study " + book + ". " + randomChapter);
        } else if (book.equals("John")) {
        	randomChapter = myRandom.nextInt(21);
        	out.println("Study " + book + ". " + randomChapter);
        } else if (book.equals("Acts")) {
        	randomChapter = myRandom.nextInt(28);
        	out.println("Study " + book + ". " + randomChapter);
        } else if (book.equals("Roma")) {
        	randomChapter = myRandom.nextInt(16);
        	out.println("Study " + book + ". " + randomChapter);
        } else if (book.equals("1Cor")) {
        	randomChapter = myRandom.nextInt(16);
        	out.println("Study " + book + ". " + randomChapter);
        } else if (book.equals("2Cor")) {
        	randomChapter = myRandom.nextInt(13);
        	out.println("Study " + book + ". " + randomChapter);
        } else if (book.equals("Gala")) {
        	randomChapter = myRandom.nextInt(6);
        	out.println("Study " + book + ". " + randomChapter);
        } else if (book.equals("Ephe")) {
        	randomChapter = myRandom.nextInt(6);
        	out.println("Study " + book + ". " + randomChapter);
        } else if (book.equals("Phili")) {
        	randomChapter = myRandom.nextInt(4);
        	out.println("Study " + book + ". " + randomChapter);
        } else if (book.equals("Colo")) {
        	randomChapter = myRandom.nextInt(4);
        	out.println("Study " + book + ". " + randomChapter);
        } else if (book.equals("1The")) {
        	randomChapter = myRandom.nextInt(5);
        	out.println("Study " + book + ". " + randomChapter);
        } else if (book.equals("2The")) {
        	randomChapter = myRandom.nextInt(3);
        	out.println("Study " + book + ". " + randomChapter);
        } else if (book.equals("1Tim")) {
        	randomChapter = myRandom.nextInt(6);
        	out.println("Study " + book + ". " + randomChapter);
        } else if (book.equals("2Tim")) {
        	randomChapter = myRandom.nextInt(4);
        	out.println("Study " + book + ". " + randomChapter);
        } else if (book.equals("Titu")) {
        	randomChapter = myRandom.nextInt(3);
        	out.println("Study " + book + ". " + randomChapter);
        } else if (book.equals("Phile")) {
        	out.println("Study " + book + ". 1");
        } else if (book.equals("Hebr")) {
        	randomChapter = myRandom.nextInt(13);
        	out.println("Study " + book + ". " + randomChapter);
        } else if (book.equals("Jame")) {
        	randomChapter = myRandom.nextInt(5);
        	out.println("Study " + book + ". " + randomChapter);
        } else if (book.equals("1Pet")) {
        	randomChapter = myRandom.nextInt(5);
        	out.println("Study " + book + ". " + randomChapter);
        } else if (book.equals("2Pet")) {
        	randomChapter = myRandom.nextInt(3);
        	out.println("Study " + book + ". " + randomChapter);
        } else if (book.equals("1Joh")) {
        	randomChapter = myRandom.nextInt(5);
        	out.println("Study " + book + ". " + randomChapter);
        } else if (book.equals("2Joh")) {
        	out.println("Study " + book + ". 1");
        } else if (book.equals("3Joh")) {
        	out.println("Study " + book + ". 1");
        } else if (book.equals("Jude")) {
        	out.println("Study " + book + ". 1");
        } else if (book.equals("Reve")) {
        	randomChapter = myRandom.nextInt(22);
        	out.println("Study " + book + ". " + randomChapter);
        } else {
        	out.println("Sorry please restart.");
        }
	}
}