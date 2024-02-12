package madGabApp;

import java.util.Random;

import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Main extends Application {
	
    Button giveHint, giveAnswer;
    Label lblState;
    writeArray myArray;
    String wantHint, wantAnswer, answer;

    public static void main(String[] args) {
    	Main myMain = new Main();
		try {
			myMain.myArray = new writeArray();
			myMain.myArray.writeArrays();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
        launch(args);
    }
    
    @Override public void start(Stage primaryStage) {
		Random myRandom = new Random();
        int number = myRandom.nextInt(57);
	    //Scanner keyboard = new Scanner(System.in);
	    
        System.out.println("Statment: " + myArray.GetStatement(number));
        System.out.println("Hint: " + myArray.GetHint(number));
        System.out.println("Answer: " + myArray.GetAnswer(number));
	    /*
	    lblState = new Label();
	    lblState.setText(myArray.GetStatement(number));

        wantHint = keyboard.next();
        wantHint = wantHint.toUpperCase();

        giveHint = new Button();
        giveHint.setText("Hint");
        giveHint.setOnAction(e -> {
        	MessageBox.show(myArray.GetHint(number), "");
        });
        giveAnswer = new Button();
        giveAnswer.setText("Answer");
        giveAnswer.setOnAction(e -> {
        	MessageBox.show(myArray.GetAnswer(number), "");
        });
        /*
        if (wantHint.equals("YES")) {
        	System.out.println("Hint: " + myArray.GetHint(number));
        	System.out.print("Type \"Yes\" when you would like the answer: ");
        	wantAnswer = keyboard.next();
        	wantAnswer = wantAnswer.toUpperCase();
            if (wantAnswer.equals("YES")) {
            	System.out.println("Answer: " + myArray.GetAnswer(number));
            	System.out.print("Would you like another question(Yes/No)? ");
            	answer = keyboard.next();
            	answer = answer.toUpperCase();
                if (answer.equals("YES")) {
                	primaryStage.close();
                	launch();
                } else if (answer.equals("NO")) {
            	    System.out.println("\n\n\n\n\t\t\t\t\t\t\tGoodbye!\n\n");
                	System.exit(0);
                } else {
                	System.out.print("Incorrect input.  Please restart.");
                }
            } else {
            	System.out.print("Incorrect input.  Please restart.");
            }
        } else if (wantHint.equals("NO")) {
        	System.out.print("Type \"Yes\" when you would like the answer: ");
        	wantAnswer = keyboard.next();
        	wantAnswer = wantAnswer.toUpperCase();
            if (wantAnswer.equals("YES")) {
            	System.out.println("Answer: " + myArray.GetAnswer(number));
            	System.out.print("Would you like another question(Yes/No)? ");
            	answer = keyboard.next();
            	answer = answer.toUpperCase();
                if (answer.equals("YES")) {
                	launch();
                } else if (answer.equals("NO")) {
            	    System.out.println("\n\n\n\n\t\t\t\t\t\t\tGoodbye!\n\n");
                	System.exit(0);
                } else {
                	System.out.print("Incorrect input.  Please restart.");
                }
            } else {
            	System.out.print("Incorrect input.  Please restart.");
            }
        } else {
        	System.out.print("Incorrect input.  Please restart.");
        }
    	
    	HBox hbox = new HBox(giveHint, giveAnswer);
        HBox.setMargin(giveAnswer, new Insets(25));
        hbox.setAlignment(Pos.BOTTOM_RIGHT);
        
        VBox vbox = new VBox(0, lblState, hbox);
        //VBox.setMargin(, new Insets(5));
            
        Scene scene = new Scene(vbox, 400, 400);
		primaryStage.setScene(scene);
		primaryStage.setWidth(500);
    	primaryStage.setHeight(154);
   		primaryStage.setResizable(false);
   		primaryStage.setTitle("Addition");
    	primaryStage.show();
        keyboard.close();
        System.exit(0);
	*/}
}