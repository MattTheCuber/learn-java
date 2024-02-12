package calculator;

import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

public class ErrorBox {
	public static void show() {
		Stage stage = new Stage();
		stage.setResizable(false);
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setTitle("Error");
		stage.setMinWidth(250);

		Label lbl = new Label();
		lbl.setText("An error has occurrder please restart the program.");

		Button btnOk = new Button("Close");
		btnOk.setOnAction(e -> System.exit(0));
		
		VBox pane = new VBox(20);
		pane.getChildren().addAll(lbl, btnOk);
		pane.setAlignment(Pos.CENTER);

		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.showAndWait();
	}
}
