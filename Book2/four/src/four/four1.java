package four;

import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;

public class four1 extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    Button btn;
    
    @Override public void start(Stage primaryStage) {
    	// Create the button
        btn = new Button();
        btn.setText("Show Popup");
        btn.setOnAction(e -> buttonClick());

        // Add the button to a layout pane
		BorderPane pane = new BorderPane();
		pane.setCenter(btn);

        // Add the layout pane to a scene
        Scene scene = new Scene(pane, 250, 150);

        // Add the scene to the stage, set the title
        // and show the stage
		primaryStage.setScene(scene);
		primaryStage.setTitle("The Popup maker");
		primaryStage.show();
	}

    public void buttonClick() {
			MessageBox.show("This is a popup.", "Popup");
    }

}

