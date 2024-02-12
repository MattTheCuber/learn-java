package ballGame;

import java.util.ArrayList;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class BallGame {
	double speed = 2000.0;
	Circle circle;
	Rectangle r1;
	boolean collisionDetected = false;
	ArrayList<Rectangle> nodes;
	Text speedStr;
	Stage primaryStage;
	String yourName;

	public void playGame(String yourname) {
		yourName = yourname;
		Controller control = new Controller();
		
		primaryStage = new Stage();
    	circle = new Circle(100);
    	circle.setFill(new RadialGradient(0.1, 0, 0.4, 0.3, 0.5, true, CycleMethod.NO_CYCLE, 
    			new Stop(0.0, Color.WHITE), new Stop(1.0, Color.RED)));

    	r1 = new Rectangle(1000, 500, 100, 100);
    	r1.setFill(Color.FIREBRICK);
    	
    	Rectangle mainR = new Rectangle(1910, 165);
    	mainR.setFill(new LinearGradient(0, 0, 0, 1, true, CycleMethod.NO_CYCLE, 
    			new Stop(0.0, Color.web("#ececec")), new Stop(1.0, Color.LIGHTGRAY)));
    	mainR.setStyle("-fx-border-top:1px, solid, black;");
    	
    	String fontSize = "-fx-font-size:25px;";

    	MenuItem info = new MenuItem("_Game Information");
    	info.setOnAction(e -> control.info(yourName));
    	MenuItem trophy = new MenuItem("_" + yourName + "'s Trophies");
    	trophy.setOnAction(e -> control.trophy(yourName));
    	MenuItem ls = new MenuItem("_Level Select");
    	ls.setOnAction(e -> control.ls(yourName));
    	MenuItem end = new MenuItem("_Exit");
    	end.setOnAction(e -> {primaryStage.close(); System.exit(0);});

    	MenuItem easy = new MenuItem("_Easy");
    	easy.setOnAction(e -> speed = 3000.0);
    	MenuItem medium = new MenuItem("_Medium");
    	medium.setOnAction(e -> speed = 2000.0);
    	MenuItem hard = new MenuItem("_Hard");
    	hard.setOnAction(e -> speed = 1000.0);
    	
    	Menu mg = new Menu("_Game");
    	Menu mo = new Menu("_Options");
    	mg.getItems().addAll(info, trophy, ls, new SeparatorMenuItem(), end);
    	mo.getItems().addAll(easy, medium, hard);
    	
    	MenuBar mb = new MenuBar(mg, mo);
    	
    	Button up = new Button("˄");
		up.setOnAction(e -> control.move("u", circle, speed));
		up.setFont(new Font(19));
		up.setPadding(new Insets(-2, 10, -2, 10));
    	Button down = new Button("˅");
		down.setOnAction(e -> control.move("d", circle, speed));
		down.setFont(new Font(19));
		down.setPadding(new Insets(-2, 10, -2, 10));
    	Button left = new Button("<");
		left.setOnAction(e -> control.move("l", circle, speed));
    	left.setStyle(fontSize);
    	Button right = new Button(">");
    	right.setStyle(fontSize);
		right.setOnAction(e -> control.move("r", circle, speed));
    	
    	Button red = new Button();
		red.setOnAction(e -> circle.setFill(new RadialGradient(0.1, 0, 0.4, 0.3, 0.5, true, 
				CycleMethod.NO_CYCLE, new Stop(0.0, Color.WHITE), new Stop(1.0, Color.RED))));
		red.setPrefHeight(75); red.setPrefWidth(75); red.setStyle("-fx-background-color:red;");
    	
    	Button orange = new Button();
		orange.setOnAction(e -> circle.setFill(new RadialGradient(0.1, 0, 0.4, 0.3, 0.5, true, 
				CycleMethod.NO_CYCLE, new Stop(0.0, Color.WHITE), new Stop(1.0, Color.ORANGE))));
		orange.setPrefHeight(75); orange.setPrefWidth(75); orange.setStyle("-fx-background-color:orange;");
		
    	Button yellow = new Button();
    	yellow.setOnAction(e -> circle.setFill(new RadialGradient(0.1, 0, 0.4, 0.3, 0.5, true, 
				CycleMethod.NO_CYCLE, new Stop(0.0, Color.WHITE), new Stop(1.0, Color.YELLOW))));
    	yellow.setPrefHeight(75); yellow.setPrefWidth(75); yellow.setStyle("-fx-background-color:yellow;");
		
    	Button green = new Button("");
    	green.setOnAction(e -> circle.setFill(new RadialGradient(0.1, 0, 0.4, 0.3, 0.5, true, 
				CycleMethod.NO_CYCLE, new Stop(0.0, Color.WHITE), new Stop(1.0, Color.GREEN))));
    	green.setPrefHeight(75); green.setPrefWidth(75); green.setStyle("-fx-background-color:green;");
		
    	Button blue = new Button("");
		blue.setOnAction(e -> circle.setFill(new RadialGradient(0.1, 0, 0.4, 0.3, 0.5, true, 
				CycleMethod.NO_CYCLE, new Stop(0.0, Color.WHITE), new Stop(1.0, Color.BLUE))));
		blue.setPrefHeight(75); blue.setPrefWidth(75); blue.setStyle("-fx-background-color:blue;");
		
    	Button indigo = new Button("");
    	indigo.setOnAction(e -> circle.setFill(new RadialGradient(0.1, 0, 0.4, 0.3, 0.5, true, 
				CycleMethod.NO_CYCLE, new Stop(0.0, Color.WHITE), new Stop(1.0, Color.INDIGO))));
    	indigo.setPrefHeight(75); indigo.setPrefWidth(75); indigo.setStyle("-fx-background-color:indigo;");
		
    	Button violet = new Button("");
    	violet.setOnAction(e -> circle.setFill(new RadialGradient(0.1, 0, 0.4, 0.3, 0.5, true, 
				CycleMethod.NO_CYCLE, new Stop(0.0, Color.WHITE), new Stop(1.0, Color.VIOLET))));
    	violet.setPrefHeight(75); violet.setPrefWidth(75); violet.setStyle("-fx-background-color:violet;");
    	
    	Stop[] stops = new Stop[] { new Stop(0, Color.RED), new Stop(0.17, Color.ORANGE)
    			, new Stop(0.33, Color.YELLOW), new Stop(0.5, Color.GREEN)
    			, new Stop(0.67, Color.BLUE), new Stop(0.83, Color.INDIGO)
    			, new Stop(1, Color.VIOLET)};
    	LinearGradient lg = new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE, stops);
    	
    	Button rainbow = new Button("");
    	rainbow.setOnAction(e -> circle.setFill(lg));
    	rainbow.setPrefHeight(75); rainbow.setPrefWidth(75); 
    	rainbow.setStyle("-fx-background-color: linear-gradient(red 0%, orange 16.67%, yellow "
    				   + "33.33%, green 50%, blue 66.67%, indigo 83.33%, violet 100%);");
    	

    	Button easySpeed = new Button("Easy");
    	easySpeed.setStyle(fontSize);
    	easySpeed.setOnAction(e -> speed = 3000.0);
    	Button mediumSpeed = new Button("Medium");
    	mediumSpeed.setStyle(fontSize);
    	mediumSpeed.setOnAction(e -> speed = 2000.0);
    	Button hardSpeed = new Button("Hard");
    	hardSpeed.setStyle(fontSize);
    	hardSpeed.setOnAction(e -> speed = 1000.0);

    	Region spacer = new Region();
		
    	TilePane colors = new TilePane(red, orange, yellow, green, blue, indigo, violet, rainbow);
        colors.setPadding(new Insets(5, 5, 5, 5));
        colors.setVgap(5);
        colors.setHgap(5);
        colors.setPrefColumns(4);
        
        ColorPicker cp = new ColorPicker();
        cp.setStyle("-fx-font-size:25px;");
        cp.setPrefWidth(100);
        cp.setOnAction(e -> {
        	Color cpc = cp.getValue();
        	circle.setFill(new RadialGradient(0.1, 0, 0.4, 0.3, 0.5, true, CycleMethod.NO_CYCLE,
        			new Stop(0.0, Color.WHITE), new Stop(1.0, cpc)));
        	});
        
        Image bimage = new Image("file:images/panel.png");
        ImageView bpanel = new ImageView(bimage);
        
		VBox middle = new VBox(6, up, down);
		HBox arrowS = new HBox(3, left, middle, right);
		HBox arrows = new HBox(45, arrowS, cp);
    	HBox diff = new HBox(5, easySpeed, mediumSpeed, hardSpeed);
    	VBox v = new VBox(33, arrows, diff);
    	v.setPadding(new Insets(20, 5, 5, 5));
    	HBox pane1 = new HBox(15, v, colors);
    	HBox pane2 = new HBox(600, spacer, pane1);
    	VBox top = new VBox(mb, circle);
    	StackPane panel = new StackPane(bpanel, pane2);
    	
    	//KeyFrame kf = new KeyFrame(Duration.millis(100), e -> control.checkBoundries(r1, circle));
    	//Timeline tl = new Timeline(kf);
    	//tl.setCycleCount(Timeline.INDEFINITE);
    	//tl.play();
    	
    	BorderPane bpane = new BorderPane();
    	bpane.setTop(top);
    	bpane.setCenter(r1);
    	bpane.setBottom(panel);
        Scene scene = new Scene(bpane);
        scene.setOnKeyPressed( new EventHandler<KeyEvent>(){
	        @Override public void handle(KeyEvent ke) {
	       		control.key(ke, circle, speed);
	        }
	    });
        
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.setWidth(1920);
		primaryStage.setHeight(1030);
		primaryStage.setY(0);
		primaryStage.setX(0);
		primaryStage.setTitle(yourName + "'s ball game");
		primaryStage.show();
	}
}



