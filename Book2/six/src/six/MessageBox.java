package six;

import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;


public class MessageBox
{
	public static void show(String message, String title)
	{
		Stage stage = new Stage();
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setTitle(title);
		stage.setMinWidth(250);

		Label lbl = new Label();
		lbl.setText(message);

		boolean send;
		send = false;

		Button btnSend = new Button();
		btnSend.setText("Send");
		btnSend.setOnAction(e -> {
			//change send to true
			stage.close();
		});

		Button btnCancel = new Button();
		btnCancel.setText("Cancel");
		btnCancel.setOnAction(e -> {
			//send stays at false
			stage.close();
		});
		
		HBox hbox = new HBox(btnSend, btnCancel);

		VBox pane = new VBox(20);
		pane.getChildren().addAll(lbl, hbox);
		pane.setAlignment(Pos.CENTER);

		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.showAndWait();
	}
}
