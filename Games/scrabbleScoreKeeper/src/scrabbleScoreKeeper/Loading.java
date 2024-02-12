package scrabbleScoreKeeper;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Loading {
	static double num;
	public static void show() {
		Stage stage = new Stage();
		stage.setResizable(false);
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setTitle("Loading");
		stage.setMinWidth(250);

		Label lbl = new Label("Loading");
		
		ProgressIndicator load = new ProgressIndicator();
		
		VBox pane = new VBox(20);
		pane.getChildren().addAll(lbl, load);
		pane.setAlignment(Pos.CENTER);

		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.show();
		
    	KeyFrame kf = new KeyFrame(Duration.millis(500), e -> System.exit(0));
    	Timeline tl = new Timeline(kf);
    	tl.play();
	}
}
