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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Store extends Application {
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
				//control.read3(c, stmt, yourname, coins, points, level);

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
				
		    	Text heading = new Text("Store");
		    	heading.setStyle(font);
		    	
		    	Text t11 = new Text("\t\t\tCoins");
		    	t11.setStyle(font2);
		    	Text t12 = new Text("\t\t\tHandful of Coins");
		    	t12.setStyle(font2);
		    	Text t13 = new Text("\t\t\tPile of Coins");
		    	t13.setStyle(font2);
		    	Text t14 = new Text("\t\t\tChest of Coins");
		    	t14.setStyle(font2);
		    	Text t21 = new Text("\t\t\tPoints");
		    	t21.setStyle(font2);
		    	Text t31 = new Text("Current level: " + control.setCurrentLevelText(c, stmt, 
		    			yourName));
		    	t31.setStyle(font2);

		    	Text l1 = new Text("Level 1 = You own");
		    	l1.setStyle(font2);
		    	Text l2 = new Text("Level 1 = $1,000");
		    	l2.setStyle(font2);
		    	l2.setOnMouseClicked(e -> control.unlock(2, c, stmt, yourName, 1000));

		    	VBox top = new VBox(mb, heading);

		    	Image i11 = new Image("images/handfulofcoins.png");
		    	ImageView iv11 = new ImageView(i11);
		    	Image i12 = new Image("images/ofcoins.png");
		    	ImageView iv12 = new ImageView(i12);
		    	Image i13 = new Image("images/handfulofcoins.png");
		    	ImageView iv13 = new ImageView(i13);
		    	//Image i21 = new Image("images/handfulofcoins.png");
		    	//ImageView iv21 = new ImageView(i21);
		    	//Image i31 = new Image("images/handfulofcoins.png");
		    	//ImageView iv31 = new ImageView(i31);

		    	HBox hoc = new HBox(t12, iv11);
		    	HBox poc = new HBox(t13, iv12);
		    	HBox coc = new HBox(t14, iv13);
		    	HBox p = new HBox(t21);
		    	HBox l = new HBox(l1, l2);
		    	
				VBox middleBox = new VBox(t11, hoc, poc, coc, t21, p, t31, l);
		    	middleBox.setPadding(new Insets(5, 5, 5, 5));
				StackPane middle = new StackPane(r, middleBox);
		    	
		    	BorderPane bpane = new BorderPane();
		    	bpane.setTop(top);
		    	bpane.setCenter(middle);
		        Scene scene = new Scene(bpane);

				primaryStage.setScene(scene);
				primaryStage.setTitle("Store");
				primaryStage.show();
			}

			@Override public void start(Stage primaryStage) {}
}
