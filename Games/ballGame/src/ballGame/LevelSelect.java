package ballGame;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LevelSelect extends Application {
			Stage primaryStage;
			public void level(String yourname) {
				String yourName = yourname;
				primaryStage = new Stage();
				Controller control = new Controller();
				Model model = new Model();

		    	MenuItem trophy = new MenuItem("_" + yourName + "'s Trophies");
		    	//trophy.setOnAction(e -> {primaryStage.close(); tr.trophys(yourName);});
		    	MenuItem info = new MenuItem("Back");
		    	//info.setOnAction(e -> {primaryStage.close(); control.info(primaryStage, 
		    	//		yourName);});
		    	MenuItem end = new MenuItem("_Exit");
		    	//end.setOnAction(e -> {primaryStage.close(); System.exit(0);});
				
		    	Menu mg = new Menu("_Game");
		    	Menu mo = new Menu("_Options");
		    	mg.getItems().addAll(trophy, info, new SeparatorMenuItem(), end);
		    	
		    	MenuBar mb = new MenuBar(mg, mo);

				String font = "-fx-font-size:40;";
				
		    	Text heading = new Text("Level select");
		    	heading.setStyle(font);
		    	
		    	Image locki = new Image("lock.png");
		    	ImageView lock = new ImageView(locki);
		    	lock.setOnMouseClicked(e -> model.unlock(2));

		    	Button b1 = new Button("1"); b1.setOnAction(e -> control.select(1));
		    	
		    	VBox top = new VBox(mb, heading);
				HBox middle = new HBox(15, b1, lock);
		    	
		    	BorderPane bpane = new BorderPane();
		    	bpane.setTop(top);
		    	bpane.setCenter(middle);
		        Scene scene = new Scene(bpane);

				primaryStage.setScene(scene);
				primaryStage.setTitle("Level select");
				primaryStage.show();
			}
			@Override public void start(Stage arg0) throws Exception {}
}
