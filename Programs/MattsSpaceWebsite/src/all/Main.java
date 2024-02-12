package all;

import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.*;

public class Main extends Application {
    public static void main(String[] args) {
    	launch(args);
    }
    Stage stage;
    @Override public void start(Stage primaryStage) {
    	stage = primaryStage;
		/*MenuBar menuBar = new MenuBar();
		Menu menu1 = new Menu("Space");
		menu1.getChildren().addAll(facts, pics, moon);
	
		MenuItem facts = new MenuItem("Space Facts");
		MenuItem pics = new MenuItem("Pictures");
		MenuItem moon = new MenuItem("Moon");
	*/
		Rectangle headerShape = new Rectangle(1000, 250);
		headerShape.setId("header");
		headerShape.setFill(Color.web("#580404"));
		
		Rectangle recentQuestionsShape = new Rectangle(5, 5, 215, 300);
		recentQuestionsShape.setId("recentQuestionsShape");
		recentQuestionsShape.setFill(Color.web("#23C5F6"));
		
		Text recentQuestionsTxt = new Text("Question by Eli David Vine: How\nfast do spaceships go?\n\n"
				+ "Answer from NASA: To\nkeep orbit: 17,500mph\n\n"
				+ "Answer from Caleb A.\nScharf: New Horizons\nmade the record of\n100,000mph when\n"
				+ "it flew by jupiter\n\n"
				+ "Answer from coolcosmos.com:\nYou need to travel at least\n 25,000mph to completely\nescape earth's gavity to travel\nto another moon or planet");
		
		Image motto = new Image("file:C:Users/Matthew/Documents/Web/matts_space_website/images/motto.png");
		ImageView mottoV = new ImageView(motto);
		
		StackPane header = new StackPane(headerShape, mottoV);
		StackPane recentQuestionPane = new StackPane(recentQuestionsShape, recentQuestionsTxt);
		HBox top = new HBox(recentQuestionPane, header);
		
		BorderPane paneMain = new BorderPane();
		paneMain.setTop(top);
		
		Scene scene = new Scene(paneMain);
		stage.setScene(scene);
		stage.setWidth(1250);
		stage.setHeight(750);
		stage.setTitle("Hows my website");
		stage.show();
    }
}
