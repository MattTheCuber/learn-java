package scrabbleScoreKeeper;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Finish extends Application {
    
	public void finish(String winnerName, int p1S, String secondName, int p2S, String thirdName, 
			int p3S, String fourthName, int p4S, Stage stage) {
		stage.close();
    	Stage primaryStage = new Stage();

    	Rectangle first = new Rectangle(100, 400);
    	first.setFill(Color.BLUE);
    	Rectangle second = new Rectangle(100, 300);
    	second.setFill(Color.RED);
    	Rectangle third = new Rectangle(100, 200);
    	third.setFill(Color.YELLOW);
    	Rectangle fourth = new Rectangle(100, 100);
    	fourth.setFill(Color.gray(0.1));
		
        Button btnOk = new Button("Close");
		btnOk.setOnAction(e -> primaryStage.close());
		
		Region spacer = new Region();

		Text p1Score = new Text(Integer.toString(p1S));
		Text p2Score = new Text(Integer.toString(p2S));
		Text p3Score = new Text(Integer.toString(p3S));
		Text p4Score = new Text(Integer.toString(p4S));
		Text winnerTxt = new Text("Winner");

		VBox firstV = new VBox(10, winnerTxt, p1Score, first);
		VBox secondV = new VBox(10, p2Score, second);
		VBox thirdV = new VBox(330, p3Score, third);
        VBox fourthV = new VBox(5, p4Score, fourth);
        HBox pane = new HBox(15, fourthV, secondV, firstV, thirdV);
        HBox paneMain = new HBox(200, spacer, pane);
        paneMain.setPadding(new Insets(5, 5, 5, 5));

		Scene scene = new Scene(pane);

		primaryStage.setScene(scene);
		primaryStage.setTitle("Winners");
		primaryStage.show();
    }
}
