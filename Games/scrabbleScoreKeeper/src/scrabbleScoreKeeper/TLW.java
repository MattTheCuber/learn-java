package scrabbleScoreKeeper;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class TLW extends Application {
	Stage primaryStage = new Stage();
	public void twolw() {
        Button close = new Button("Close");
		close.setOnAction(e -> primaryStage.close());

		Text t1 = new Text("a");
		Text t2 = new Text("a");
		Text t3 = new Text("a");
		Text t4 = new Text("a");
		Text t5 = new Text("a");
		Text t6 = new Text("a");
		Text t7 = new Text("a");
		
		VBox left = new VBox(10, t1, t2, t3, t4, t5, t6, t7);
		VBox right = new VBox(10);
		HBox top = new HBox(10, left, right);
        VBox paneMain = new VBox(10, top, close);
        paneMain.setPadding(new Insets(5, 5, 5, 5));

		Scene scene = new Scene(paneMain);

		primaryStage.setScene(scene);
		primaryStage.setX(1290);
		primaryStage.setY(143);
		primaryStage.setResizable(false);
		primaryStage.setTitle("2-letter-words");
		primaryStage.show();
    }
}
