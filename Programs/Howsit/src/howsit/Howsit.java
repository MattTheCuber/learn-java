package howsit;

import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;
import javafx.scene.text.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;


public class Howsit extends Application {
    public static void main(String[] args) {
        launch(args);
    }

   	Stage stage;
    TextField name, nLike, QorC, otherImprove;
    //Color color;
    //Number rating;
    CheckBox info, main, pics, every, cant, info2, main2, pics2;
    ChoiceBox<String> cbox;

    @Override public void start(Stage primaryStage) throws FileNotFoundException {
		stage = primaryStage;

		Text textHeading = new Text("How's my Website?");
		textHeading.setFont(new Font(50));
		HBox paneTop = new HBox(textHeading);
		paneTop.setPadding(new Insets(20, 10, 20, 10));

		Label lblName = new Label("Full Name:");
		lblName.setPrefWidth(100);
		name = new TextField();
		name.setPrefColumnCount(20);
		name.setPromptText("Enter name here");
		name.setMaxWidth(Double.MAX_VALUE);
		HBox paneName = new HBox(lblName, name);

		Label lblColor = new Label("Favorite color:");
		lblColor.setPrefWidth(100);
		//color = new Color(10, 10, 10, 10);
		Label txtColor = new Label();
		txtColor.setText("Sorry can't make color button :(");
		HBox paneColor = new HBox(lblColor, txtColor);

		Label lblOne = new Label("Please Check one:");
		cbox = new ChoiceBox<String>();
		cbox.getItems().addAll("I LOVE your website!", "I like your website.", "Not bad.",
				"Not Good.", "Worst website ever!");
		HBox paneOne = new HBox(lblOne, cbox);
		paneOne.setSpacing(10);
		
		Label lblRate = new Label("Your rating:");
		lblRate.setPrefWidth(100);
		//rating = new Number(10);
		Label txtNumber = new Label();
		txtNumber.setText("Sorry can't make number field :(");
		HBox paneNum = new HBox(lblRate, txtNumber);

		Label lblLike = new Label("Choose what you like about my website:");
		info = new CheckBox("The Information");
		main = new CheckBox("The Main page");
		pics = new CheckBox("The Pictures");
		every = new CheckBox("Everything");
		VBox paneLike = new VBox(10, info, main, pics, every);
		paneLike.setPadding(new Insets(10, 0, 10, 0));
		VBox paneLike2 = new VBox(lblLike, paneLike);
		
		Label lblUnlike = new Label("What don't you like about my website?");
		lblUnlike.setPrefWidth(275);
		nLike = new TextField();
		HBox paneUnlike = new HBox(lblUnlike, nLike);
		
		Label lblWork = new Label("What do I need to work on:\n\n");
		info2 = new CheckBox("The Information  ");
		main2 = new CheckBox("The Main page  ");
		pics2 = new CheckBox("The Pictures  ");
		cant = new CheckBox("You can't\n");
		HBox paneWork = new HBox(info2, main2, pics2, cant);
		VBox paneImprove2 = new VBox(lblWork, paneWork);
		
		Label lblQorC = new Label();
		lblQorC.setText("Questions or Coments:");
		QorC = new TextField();
		QorC.setMaxWidth(400);
		QorC.setPrefHeight(100);
		VBox paneQorC = new VBox(5, lblQorC, QorC);

		VBox paneOrder = new VBox(25, paneName, paneColor, paneOne, paneNum, paneLike2,
				paneUnlike, paneImprove2, paneQorC);

		HBox paneCenter = new HBox(20, paneOrder);
		paneCenter.setPadding(new Insets(0,10, 0, 10));

		Button btnSubmit = new Button("Submit");
		btnSubmit.setPrefWidth(80);
			btnSubmit.setOnAction(e -> 
				{
					try {
						submit(); 
					} catch (Exception e1) {
						System.out.println(e1.getMessage());
					}
				});

		Button btnCancel = new Button("Cancel");
		btnCancel.setPrefWidth(80);
		btnCancel.setOnAction(e -> stage.close() );

		Region spacer = new Region();

		HBox paneBottom = new HBox(10, spacer, btnSubmit, btnCancel);
		HBox.setHgrow(spacer, Priority.ALWAYS);
		paneBottom.setPadding(new Insets(20, 10, 20, 10));

		BorderPane paneMain = new BorderPane();
		paneMain.setTop(paneTop);
		paneMain.setCenter(paneCenter);
		paneMain.setBottom(paneBottom);

		Scene scene = new Scene(paneMain);
		primaryStage.setScene(scene);
		primaryStage.setWidth(750);
		primaryStage.setTitle("Hows my website");
		primaryStage.show();
	}
	public void submit() throws FileNotFoundException {
		PrintStream fbW = new PrintStream(new FileOutputStream("feedback.txt", true));
		//validate
		String msg = "";
		String likeMsg = "Liked: ";
		String unlikeMsg = "Thought you should improve: ";
		if ((name.getLength() < 3)&&(name.getLength() > 0)) {
			msg += "Please enter a name with 3+ letters.\n";
		} else if (name.getLength() == 0) {
			msg += "Please enter your name.\n";
		} else {
			msg = "Your feedback has been sent.";

			fbW.println("---------" + name.getText() + "---------");
			fbW.println("Rated this website at: \"" + 
				cbox.getValue() +  "\"");
			if (info.isSelected()) { likeMsg += "the information, "; }
			if (main.isSelected()) { likeMsg += "the main page, "; }
			if (pics.isSelected()) { likeMsg += "the pictures, "; }
			if (every.isSelected()) { likeMsg += "everything"; }
			if ((!info.isSelected())&&(!main.isSelected())&&(!pics.isSelected())&&
					(!every.isSelected())) { likeMsg += "nothing"; }
			likeMsg += ".";
			fbW.println(likeMsg);
			fbW.println("Didn't like: \"" + nLike.getText() +  "\"");
			if (info2.isSelected()) { likeMsg += "the information, "; }
			if (main2.isSelected()) { unlikeMsg += "the main page, "; }
			if (pics2.isSelected()) { unlikeMsg += "the pictures, "; }
			if (cant.isSelected()) { unlikeMsg += "nothing"; }
			unlikeMsg += ".";
			fbW.println(unlikeMsg);
			fbW.println("Questions or/and Comments: \"" + QorC.getText() +  "\"\n");
			
			MessageBox.show(msg, "");
			
			stage.close();
			System.exit(0);
		}
		MessageBox.show(msg, "");
		fbW.close();
	}
}
