package all;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class HowSit extends Application {
    public static void main(String[] args) {
        launch(args);
    }

   	Stage stage;
    TextField name, nLike, QorC, otherImprove;
    ColorPicker color;
    CheckBox cant, info2, main2, pics2;
    RadioButton info, main, pics, every;
    ChoiceBox<String> cbox;
    Label txtNumber;
    DatePicker date;

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
		color = new ColorPicker();
		HBox paneColor = new HBox(lblColor, color);

		Label lblOne = new Label("Please Check one:");
		cbox = new ChoiceBox<String>();
		cbox.getItems().addAll("I LOVE your website!", "I like your website.", "Not bad.",
				"Not Good.", "Worst website ever!");
		HBox paneOne = new HBox(lblOne, cbox);
		paneOne.setSpacing(10);
		
		Label lblRate = new Label("Your rating:");
		lblRate.setPrefWidth(100);
		Button arrow1 = new Button("˄");
		arrow1.setFont(new Font(12));
		arrow1.setPadding(new Insets(-2, 10, -2, 10));
		arrow1.setOnAction(e -> growOrShrink(true));
		Button arrow2 = new Button("˅");
		arrow2.setFont(new Font(12));
		arrow2.setPadding(new Insets(-2, 10, -2, 10));
		arrow2.setOnAction(e -> growOrShrink(false));
		txtNumber = new Label();
		txtNumber.setText("10");
		VBox arrows = new VBox(.1, arrow1, arrow2);
		HBox paneNum = new HBox(7.5, lblRate, txtNumber, arrows);

		Label lblLike = new Label("Choose your favorite thing about my website:");
		info = new RadioButton("The Information");
		main = new RadioButton("The Main page");
		pics = new RadioButton("The Pictures");
		every = new RadioButton("Everything");
		ToggleGroup fav = new ToggleGroup();
		info.setToggleGroup(fav);
		main.setToggleGroup(fav);
		pics.setToggleGroup(fav);
		every.setToggleGroup(fav);
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
		
		Label lblDate = new Label();
		lblDate.setText("Date: ");
		date = new DatePicker();
		VBox paneDate = new VBox(5, lblDate, date);

		VBox paneOrder = new VBox(25, paneName, paneColor, paneOne, paneNum, paneLike2,
				paneUnlike, paneImprove2, paneQorC, paneDate);

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
    public void growOrShrink(boolean upOrDown) {
    	int newNum;
		int oldNum = Integer.parseInt(txtNumber.getText());
		if (upOrDown == true) {
			newNum = oldNum + 1;
			if ((newNum < 0)||(newNum > 10)) {
				newNum = newNum - 1;
			}
		} else if (upOrDown == false) {
			newNum = oldNum - 1;
			if ((newNum < 0)||(newNum > 10)) {
				newNum = newNum + 1;
			}
		} else {
			newNum = oldNum;
		}
		txtNumber.setText(Integer.toString(newNum));
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

			fbW.println("---------" + name.getText() + " on " + date.getValue() +"---------");
			fbW.println("Favorite color is: " + color.getValue());
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
			fbW.println("Rated this website from 0-10 at: " + txtNumber.getText());
			fbW.println("Didn't like: \"" + nLike.getText() +  "\"");
			if (info2.isSelected()) { unlikeMsg += "the information, "; }
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
