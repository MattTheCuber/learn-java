package bb;

import java.util.ArrayList;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
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
import javafx.util.Duration;

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
    	
    	Rectangle mainR = new Rectangle(1910, 200);
    	mainR.setFill(new LinearGradient(0, 0, 0, 1, true, CycleMethod.NO_CYCLE, 
    			new Stop(0.0, Color.WHITE), new Stop(1.0, Color.LIGHTGRAY)));
    	
    	String fontSize = "-fx-font-size:25px;";

    	MenuItem info = new MenuItem("_Game Information");
    	info.setOnAction(e -> control.info(primaryStage, yourName));
    	MenuItem trophy = new MenuItem("_" + yourName + "'s Trophies");
    	trophy.setOnAction(e -> control.trophy(primaryStage, yourName));
    	MenuItem ls = new MenuItem("_Level Select");
    	ls.setOnAction(e -> control.ls(primaryStage, yourName));
    	MenuItem end = new MenuItem("_Exit");
    	end.setOnAction(e -> {primaryStage.close(); System.exit(0);});

    	MenuItem easy = new MenuItem("_-0.1");
    	easy.setOnAction(e -> {speed += 10.0; speedStr.setText(Double.toString(speed / 100.0));});
    	MenuItem easy2 = new MenuItem("_-1");
    	easy2.setOnAction(e -> {speed += 100.0; speedStr.setText(Double.toString(speed / 100.0));});
    	MenuItem easy3 = new MenuItem("_-10");
    	easy3.setOnAction(e -> {speed += 1000.0; speedStr.setText(Double.toString(speed / 100.0));});
    	
    	MenuItem hard = new MenuItem("_+0.1");
    	hard.setOnAction(e -> {speed -= 10.0; speedStr.setText(Double.toString(speed / 100.0));});
    	MenuItem hard2 = new MenuItem("_+1");
    	hard2.setOnAction(e -> {speed -= 100.0; speedStr.setText(Double.toString(speed / 100.0));});
    	MenuItem hard3 = new MenuItem("_+10");
    	hard3.setOnAction(e -> {speed -= 1000.0; speedStr.setText(Double.toString(speed / 100.0));});
    	
    	Menu mg = new Menu("_Game");
    	Menu mo = new Menu("_Options");
    	Menu sl = new Menu("_Slower");
    	Menu fa = new Menu("_Faster");
    	mg.getItems().addAll(info, trophy, ls, new SeparatorMenuItem(), end);
    	sl.getItems().addAll(easy, easy2, easy3);
    	fa.getItems().addAll(hard, hard2, hard3);
    	mo.getItems().addAll(sl, fa);
    	
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
    	Button stop = new Button("Stop");
		stop.setOnAction(e -> control.move("st", circle, speed));
    	stop.setStyle(fontSize);
    	
    	Button red = new Button();
		red.setOnAction(e -> circle.setFill(new RadialGradient(0.1, 0, 0.4, 0.3, 0.5, true, 
				CycleMethod.NO_CYCLE, new Stop(0.0, Color.WHITE), new Stop(1.0, Color.RED))));
		red.setPrefHeight(50); red.setPrefWidth(50); red.setStyle("-fx-background-color:red;");
    	
    	Button pink = new Button();
		pink.setOnAction(e -> circle.setFill(new RadialGradient(0.1, 0, 0.4, 0.3, 0.5, true, 
				CycleMethod.NO_CYCLE, new Stop(0.0, Color.WHITE), new Stop(1.0, Color.PINK))));
		pink.setPrefHeight(50); pink.setPrefWidth(50); pink.setStyle("-fx-background-color:pink;");
    	
    	Button orange = new Button();
		orange.setOnAction(e -> circle.setFill(new RadialGradient(0.1, 0, 0.4, 0.3, 0.5, true, 
				CycleMethod.NO_CYCLE, new Stop(0.0, Color.WHITE), new Stop(1.0, Color.ORANGE))));
		orange.setPrefHeight(50); orange.setPrefWidth(75); orange.setStyle("-fx-background-color:orange;");
		
    	Button yellow = new Button();
    	yellow.setOnAction(e -> circle.setFill(new RadialGradient(0.1, 0, 0.4, 0.3, 0.5, true, 
				CycleMethod.NO_CYCLE, new Stop(0.0, Color.WHITE), new Stop(1.0, Color.YELLOW))));
    	yellow.setPrefHeight(50); yellow.setPrefWidth(75); yellow.setStyle("-fx-background-color:yellow;");
		
    	Button green = new Button("Green");
    	green.setOnAction(e -> circle.setFill(new RadialGradient(0.1, 0, 0.4, 0.3, 0.5, true, 
				CycleMethod.NO_CYCLE, new Stop(0.0, Color.WHITE), new Stop(1.0, Color.GREEN))));
    	green.setPrefHeight(50); green.setPrefWidth(75); green.setStyle("-fx-background-color:green;");
		
    	Button blue = new Button("Blue");
		blue.setOnAction(e -> circle.setFill(new RadialGradient(0.1, 0, 0.4, 0.3, 0.5, true, 
				CycleMethod.NO_CYCLE, new Stop(0.0, Color.WHITE), new Stop(1.0, Color.BLUE))));
		blue.setPrefHeight(50); blue.setPrefWidth(50); blue.setStyle("-fx-background-color:blue;");
		
    	Button purple = new Button("Purple");
    	purple.setOnAction(e -> circle.setFill(new RadialGradient(0.1, 0, 0.4, 0.3, 0.5, true, 
				CycleMethod.NO_CYCLE, new Stop(0.0, Color.WHITE), new Stop(1.0, Color.PURPLE))));
    	purple.setPrefHeight(50); purple.setPrefWidth(75); purple.setStyle("-fx-background-color:purple;");
    	
    	Stop[] stops = new Stop[] { new Stop(0, Color.RED), new Stop(0.2, Color.ORANGE)
    			, new Stop(0.4, Color.YELLOW), new Stop(0.6, Color.GREEN)
    			, new Stop(0.8, Color.BLUE), new Stop(1, Color.PURPLE)};
    	LinearGradient lg = new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE, stops);
    	
    	Button rainbow = new Button("Rainbow");
    	rainbow.setOnAction(e -> circle.setFill(lg));
    	rainbow.setPrefHeight(50); rainbow.setPrefWidth(100); 
    	rainbow.setTextFill(lg);
    	
    	speedStr = new Text(Double.toString(speed / 100.0));
    	speedStr.setStyle("-fx-font-size:35;");
    	Text start = new Text("Time to get to other side: ");
    	start.setStyle("-fx-font-size:35;");
    	Text header = new Text("Welcome " + yourName + "!");
    	header.setStyle("-fx-font-size:50;");

    	Button minus = new Button("+");
    	minus.setStyle(fontSize);
		minus.setOnAction(e -> {speed += 10.0; speedStr.setText(Double.toString(speed / 100.0));});
    	Button plus = new Button("-");
    	plus.setStyle(fontSize);
		plus.setOnAction(e -> {speed -= 10.0; speedStr.setText(Double.toString(speed / 100.0));});
    	Button minus2 = new Button("++");
    	minus2.setStyle(fontSize);
		minus2.setOnAction(e -> {speed += 100.0; speedStr.setText(Double.toString(speed / 100.0));});
    	Button plus2 = new Button("--");
    	plus2.setStyle(fontSize);
		plus2.setOnAction(e -> {speed -= 100.0; speedStr.setText(Double.toString(speed / 100.0));});
    	Button minus3 = new Button("+++");
    	minus3.setStyle(fontSize);
		minus3.setOnAction(e -> {speed += 1000.0; speedStr.setText(Double.toString(speed / 100.0));});
    	Button plus3 = new Button("---");
    	plus3.setStyle(fontSize);
		plus3.setOnAction(e -> {speed -= 1000.0; speedStr.setText(Double.toString(speed / 100.0));});
		
		VBox middle = new VBox(6, up, down);
		HBox arrows = new HBox(3, left, middle, right);
		
    	HBox hpane = new HBox(10, stop, arrows, start, speedStr, plus, plus2, plus3, minus, 
    			minus2, minus3, red, orange, yellow, green, blue, purple, pink, rainbow);
    	hpane.setPadding(new Insets(20, 5, 5, 5));
    	
    	VBox top = new VBox(mb, circle);
    	
    	StackPane pane = new StackPane(mainR, hpane);
    	
    	KeyFrame kf = new KeyFrame(Duration.millis(100), e -> control.check(r1, circle));
    	Timeline tl = new Timeline(kf);
    	tl.setCycleCount(Timeline.INDEFINITE);
    	tl.play();
    	
    	BorderPane bpane = new BorderPane();
    	bpane.setTop(top);
    	bpane.setCenter(r1);
    	bpane.setBottom(pane);
        Scene scene = new Scene(bpane);
        scene.setOnKeyPressed( new EventHandler<KeyEvent>(){
	        @Override public void handle(KeyEvent ke) {
	       		//key(ke);
	        }
	    });
        
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.setWidth(1920);
		primaryStage.setHeight(1030);
		primaryStage.setY(0);
		primaryStage.setX(0);
		primaryStage.setTitle("Matt's ball game");
		primaryStage.show();
	}
}


