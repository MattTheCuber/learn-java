package five;

import javafx.application.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.scene.control.*;
import javafx.scene.effect.Glow;

public class five extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    Button rightEye, leftEye, m1;

    @Override public void start(Stage primaryStage) {
    	leftEye = new Button();
    	leftEye.setText("•");
    	rightEye = new Button();
    	rightEye.setText("•");
    	
    	m1 = new Button();
    	m1.setText("-----------------");
    	m1.requestFocus();
    	
    	HBox hbox = new HBox(50, leftEye, rightEye);
    	hbox.setMargin(leftEye, new Insets(10));
    	hbox.setMargin(rightEye, new Insets(10));
    	hbox.setAlignment(Pos.TOP_CENTER);
    	
    	VBox vbox = new VBox(0, hbox, m1);
    	vbox.setAlignment(Pos.CENTER);

        Scene scene = new Scene(vbox);
        
		primaryStage.setScene(scene);
		primaryStage.setWidth(300);
		primaryStage.setResizable(false);
		primaryStage.toFront();
		primaryStage.setTitle("Smily Face");
		primaryStage.show();
	}
}

