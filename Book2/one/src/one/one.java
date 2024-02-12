package one;

import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;

public class one extends Application {
    public static void main(String[] args) {
    	System.out.println("Starting JavaFX");
        launch(args);
        System.out.println("Ending Program");
    }

    Button btn;
    Label lbl;
    int bCount = 0;
    String txt;

    @Override public void start(Stage primaryStage) {
    	System.out.println("Creating Button");
        btn = new Button();
        btn.setText("Click me please!");
        btn.setOnAction(e -> buttonClick());
        
        System.out.println("Creating Label");
        lbl = new Label();
        lbl.setText(txt);
        
        System.out.println("Adding Label and Button to Program");
		BorderPane pane = new BorderPane();
		pane.setBottom(lbl);
		pane.setCenter(btn);
        Scene scene = new Scene(pane, 300, 250);

		primaryStage.setScene(scene);
		primaryStage.setWidth(500);
		primaryStage.setTitle("The Click Me App");
		primaryStage.show();
	}

    public void buttonClick() {
    	bCount++;
    	if (bCount == 1) {
        	txt = "\t\t\t\tYou have clicked the button " + Integer.toString(bCount) + " time.";
            lbl.setText(txt);	
    	} else if ((bCount > 9)&&(bCount < 100)) {
        	txt = "\t\t\t   You have clicked the button " + Integer.toString(bCount) + " times.";
            lbl.setText(txt);	
    	} else if ((bCount > 99)&&(bCount < 1000)) {
        	txt = "\t\t\t  You have clicked the button " + Integer.toString(bCount) + " times.";
            lbl.setText(txt);	
    	} else if ((bCount > 999)&&(bCount < 10000)) {
        	txt = "\t\t\t You have clicked the button " + Integer.toString(bCount) + " times.";
            lbl.setText(txt);	
    	} else if ((bCount > 9999)&&(bCount < 100000)) {
        	txt = "\t\t   You have clicked the button " + Integer.toString(bCount) + " times.";
            lbl.setText(txt);	
    	} else if ((bCount > 99999)&&(bCount < 1000000)) {
        	txt = "\t\t  You have clicked the button " + Integer.toString(bCount) + " times.";
            lbl.setText(txt);	
    	} else if ((bCount > 999999)&&(bCount < 10000000)) {
        	txt = "\t\t You have clicked the button " + Integer.toString(bCount) + " times.";
            lbl.setText(txt);	
    	} else if ((bCount > 9999999)&&(bCount < 100000000)) {
        	txt = "\t\tYou have clicked the button " + Integer.toString(bCount) + " times.";
            lbl.setText(txt);	
    	} else if ((bCount > 99999999)&&(bCount < 1000000000)) {
        	txt = "\t   You have clicked the button " + Integer.toString(bCount) + " times.";
            lbl.setText(txt);	
    	} else {
        	txt = "\t\t\t\tYou have clicked the button " + Integer.toString(bCount) + " times.";
            lbl.setText(txt);
    	}
        System.out.println("Waiting for Program to respond...");
        if (btn.getText() == "Click me please!") {
        	String bTxt = btn.getText();
        	btn.setText("You clicked me!");
            System.out.println("Program responded with changing button text to: \"" + bTxt + "\"");
        } else {
        	String bTxt = btn.getText();
         	btn.setText("Click me please!");
            System.out.println("Program responded with changing button text to: \"" + bTxt + "\"");
        }
    }

}
