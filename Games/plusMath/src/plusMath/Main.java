package plusMath;

import java.util.Random;
import java.util.Scanner;
import javafx.application.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;

public class Main extends Application {
	public static void main(String[] args) {
        launch(args);
    }

    Button easy, medium, hard;
    Label total, q;
    int wrongs = 0, score, randomNum1, randomNum2, ra;
    String letterScore, differculty;
	String txt, input, WorR, ya;

    @Override public void start(Stage primaryStage1) {
        easy = new Button();
        easy.setText("Easy");
        easy.setOnAction(e -> {
        	primaryStage1.close();
        	easy();
        });
        
        medium = new Button();
        medium.setText("Medium");
        //medium.setOnAction(e -> medium();
       
        hard = new Button();
        hard.setText("Hard");
        //hard.setOnAction(e -> hard();

        HBox HBox = new HBox(10);
        HBox.getChildren().addAll(easy, medium, hard);

        Scene scene = new Scene(HBox, 300, 250);
        
		primaryStage1.setScene(scene);
		primaryStage1.setWidth(204);
		primaryStage1.setHeight(65);
		primaryStage1.setResizable(false);
		primaryStage1.setTitle("Addition");
		primaryStage1.show();
	}
	void easy() {
		Stage primaryStage2 = new Stage();
        Random myRandom = new Random();
        Scanner keyboard = new Scanner(System.in);
        
		txt = "Type your answer as a number, you have 10 questions.\n";
		
    	for (int i = 1; i < 11; i++) {
            TextField textfield = new TextField();
            textfield.setMaxWidth(30);
            textfield.setMinWidth(1);
            textfield.requestFocus();
            
    		randomNum1 = myRandom.nextInt(9);
    		String num = Integer.toString(i);
            q = new Label();
    		q.setText(" Question #" + num + ": " + randomNum1 +" + 1");
            ya = textfield.getText();
    		ra = randomNum1 + 1;
    		System.out.println(ya + ra);
    		
            Button ok = new Button();
            ok.setText("Okay");
            ok.setOnAction(e -> { MessageBox.show(WorR, ""); });
    		
    		if (ya.equals(Integer.toString(ra))) { WorR = "Correct!"; }
    		System.out.println(WorR);
    		/*else { WorR = "Retry: " + randomNum1 + " + 1 = "; ya = keyboard.next();
        		if (ya.equals(Integer.toString(ra))) { WorR = "Correct!"; }
        		else { WorR = "Wrong."; wrongs = wrongs + 10; }
    		}*/
    		/*
    	    score = 100 - wrongs;
        	
    	   	if (score == 100) { letterScore = "A+"; }
    	   	else if ((score < 100)&&(score > 94)) { letterScore = "A"; }
    	   	else if ((score < 95)&&(score > 89)) { letterScore = "A-"; }
    	   	else if ((score < 90)&&(score > 79)) { letterScore = "B"; }
    	   	else if ((score < 80)&&(score > 69)) { letterScore = "C"; }
    	   	else if ((score < 70)&&(score > 59)) { letterScore = "D"; }
    	   	else if ((score < 60)&&(score > 49)) { letterScore = "E"; }
    	   	else if ((score < 50)&&(score > 44)) { letterScore = "F"; }
    	   	else if (score < 45) { letterScore = "F-"; }
    	   	else { letterScore = ""; }

            total = new Label();
            total.setText("You score: " + score + "% " + letterScore);
            */
            
            HBox hbox = new HBox(ok);
            HBox.setMargin(ok, new Insets(15));
            hbox.setAlignment(Pos.BOTTOM_RIGHT);
            
            VBox vbox = new VBox(q, textfield, hbox);
            VBox.setMargin(textfield, new Insets(5));
            
            Scene scene = new Scene(vbox, 400, 400);
    		primaryStage2.setScene(scene);
    		primaryStage2.setWidth(500);
    		primaryStage2.setHeight(154);
    		primaryStage2.setResizable(false);
    		primaryStage2.setTitle("Addition");
    		primaryStage2.show();
    		keyboard.close();
    	}
	}
}
