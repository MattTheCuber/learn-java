package ballGame;

import java.sql.Connection;
import java.sql.Statement;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class info extends Application {
		TextField name;
		PasswordField password;
		Stage primaryStage;
	    Statement stmt;
	    Connection c;
	    String allNames = "", allPasswords = "";
	    String coins, points, level, yourName;

		public void infoMethod(String yourname) {
			primaryStage = new Stage();
			yourName = yourname;
			Controller control = new Controller();
			control.read3(c, stmt, yourname, coins, points, level);

			BallGame bg = new BallGame();
			LevelSelect ls = new LevelSelect();

	    	MenuItem trophy = new MenuItem("_" + yourName + "'s Trophies");
	    	trophy.setOnAction(e -> control.trophy(primaryStage, yourname));
	    	MenuItem levelLink = new MenuItem("Level select");
	    	levelLink.setOnAction(e -> {primaryStage.close(); ls.level(yourName);});
	    	MenuItem back = new MenuItem("Back");
	    	back.setOnAction(e -> {primaryStage.close(); bg.playGame(yourName);});
	    	MenuItem end = new MenuItem("_Exit");
	    	end.setOnAction(e -> {primaryStage.close(); System.exit(0);});
			
	    	Menu mg = new Menu("_Game");
	    	Menu mo = new Menu("_Options");
	    	mg.getItems().addAll(levelLink, trophy, back, new SeparatorMenuItem(), end);
	    	
	    	MenuBar mb = new MenuBar(mg, mo);
			
	    	Rectangle r = new Rectangle(200, 200);
	    	r.setFill(Color.RED);

			String font = "-fx-font-size:40;";
			String font2 = "-fx-font-size:25;";
			
	    	Text heading = new Text(yourName + "'s Game Information");
	    	heading.setStyle(font);
	    	
	    	Text info1 = new Text("\t\t\tTotal Coins: " + coins);
	    	info1.setStyle(font2);	    	
	    	Text info2 = new Text("\t\t\tTotal Points: " + points);
	    	info2.setStyle(font2);	    	
	    	Text info3 = new Text("\t\t\tCurrent Level: " + level);
	    	info3.setStyle(font2);

	    	VBox top = new VBox(mb, heading);
	    	
			VBox middleBox = new VBox(info1, info2, info3);
	    	middleBox.setPadding(new Insets(5, 5, 5, 5));
			StackPane middle = new StackPane(r, middleBox);
	    	
	    	BorderPane bpane = new BorderPane();
	    	bpane.setTop(top);
	    	bpane.setCenter(middle);
	        Scene scene = new Scene(bpane);

			primaryStage.setScene(scene);
			primaryStage.setTitle(yourName + "'s Game Information");
			primaryStage.show();
		}
		@Override public void start(Stage arg0) throws Exception {}
}
