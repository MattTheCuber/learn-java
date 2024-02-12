package three;

import javafx.application.*;
import javafx.geometry.Pos;
import javafx.stage.*;
import javafx.scene.*;
//import javafx.scene.layout.*;
import javafx.scene.control.*;

public class three extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    Label lbl;

    @Override public void start(Stage primaryStage) {
        lbl = new Label();
        lbl.setText("Hello world!");
		lbl.setAlignment(Pos.CENTER);

        Scene scene = new Scene(lbl, 300, 250);
        
		primaryStage.setScene(scene);
		primaryStage.setWidth(250);
		primaryStage.setResizable(false);
		primaryStage.toFront();
		primaryStage.setY(300);
		primaryStage.setX(750);
		primaryStage.setTitle("1st styling");
		primaryStage.show();
	}
}
