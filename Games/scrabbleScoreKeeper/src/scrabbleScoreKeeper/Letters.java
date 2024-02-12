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

public class Letters extends Application {
	Stage primaryStage = new Stage();
	public void showLetters() {
        Button close = new Button("Close");
		close.setOnAction(e -> primaryStage.close());
		
		VBox left = new VBox(10);
		VBox right = new VBox(10);
		HBox top = new HBox(10, left, right);
        VBox paneMain = new VBox(10, top, close);
        paneMain.setPadding(new Insets(5, 5, 5, 5));

		Scene scene = new Scene(paneMain);

		primaryStage.setScene(scene);
		primaryStage.setX(1290);
		primaryStage.setY(503);
		primaryStage.setResizable(false);
		primaryStage.setTitle("Letters");
		primaryStage.show();
    }
}
