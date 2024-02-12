package scrabbleScoreKeeper;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class startUpView extends Application {
    TextField p1, p2, p3, p4;
    
    @SuppressWarnings("unchecked")
	public void view() {
    	Controller control = new Controller();
    	Stage primaryStage = new Stage();
		
        p1 = new TextField();
        p1.setMaxWidth(200);
        p1.setPromptText("Player 1");
        
        p2 = new TextField();
        p2.setMaxWidth(200);
        p2.setPromptText("Player 2");

        p3 = new TextField();
        p3.setMaxWidth(200);
        p3.setPromptText("Player 3");
        
        p4 = new TextField();
        p4.setMaxWidth(200);
        p4.setPromptText("Player 4");
		
        Button btnOk = new Button("Okay");
		btnOk.setOnAction(e -> control.startScores(p1.getText(), p2.getText(), p3.getText(),
				p4.getText(), primaryStage));
		
		Region spacer = new Region();

		HBox top = new HBox(10, p1, p2);
		HBox middle = new HBox(10, p3, p4);
		HBox bottom = new HBox(330, spacer, btnOk);
        VBox paneMain = new VBox(5, top, middle, bottom);
        paneMain.setPadding(new Insets(5, 5, 5, 5));

		Scene scene = new Scene(paneMain);
        scene.setOnKeyPressed( new EventHandler<KeyEvent>(){
	        @Override public void handle(KeyEvent ke) {
	       		control.key(ke, p1.getText(), p2.getText(), p3.getText(), p4.getText(), primaryStage);
	        }
	    });

		primaryStage.setScene(scene);
		primaryStage.setTitle("Players");
		primaryStage.show();
    }
}
