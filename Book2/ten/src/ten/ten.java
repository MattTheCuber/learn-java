package ten;

import java.util.ArrayList;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.*;
import javafx.geometry.Bounds;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
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

public class ten extends Application {
	double speed = 2000.0;
	Circle circle;
	Rectangle r1;
	boolean collisionDetected = false;
	ArrayList<Rectangle> nodes;
	interface INTERSECT { void collide(); }
	
    public static void main(String[] args) {
        launch(args);
    }

	@Override public void start(Stage primaryStage) {
    	circle = new Circle(100);
    	circle.setFill(new RadialGradient(0.1, 0, 0.4, 0.3, 0.5, true, CycleMethod.NO_CYCLE, 
    			new Stop(0.0, Color.WHITE), new Stop(1.0, Color.RED)));

    	r1 = new Rectangle(1000, 500, 100, 100);
    	r1.setFill(Color.FIREBRICK);
    	
    	String fontSize = "-fx-font-size:25px;";
    	
    	Button up = new Button("˄");
		up.setOnAction(e -> move("u"));
		up.setFont(new Font(19));
		up.setPadding(new Insets(-2, 10, -2, 10));
    	Button down = new Button("˅");
		down.setOnAction(e -> move("d"));
		down.setFont(new Font(19));
		down.setPadding(new Insets(-2, 10, -2, 10));
    	Button left = new Button("<");
		left.setOnAction(e -> move("l"));
    	left.setStyle(fontSize);
    	Button right = new Button(">");
    	right.setStyle(fontSize);
		right.setOnAction(e -> move("r"));
    	Button stop = new Button("Stop");
		stop.setOnAction(e -> move("st"));
    	stop.setStyle(fontSize);
    	
    	Button red = new Button("Red");
		red.setOnAction(e -> circle.setFill(new RadialGradient(0.1, 0, 0.4, 0.3, 0.5, true, 
				CycleMethod.NO_CYCLE, new Stop(0.0, Color.WHITE), new Stop(1.0, Color.RED))));
		red.setPrefHeight(50); red.setPrefWidth(50); red.setStyle("-fx-background-color:red;");
    	
    	Button pink = new Button("Pink");
		pink.setOnAction(e -> circle.setFill(new RadialGradient(0.1, 0, 0.4, 0.3, 0.5, true, 
				CycleMethod.NO_CYCLE, new Stop(0.0, Color.WHITE), new Stop(1.0, Color.PINK))));
		pink.setPrefHeight(50); pink.setPrefWidth(50); pink.setStyle("-fx-background-color:pink;");
    	
    	Button orange = new Button("Orange");
		orange.setOnAction(e -> circle.setFill(new RadialGradient(0.1, 0, 0.4, 0.3, 0.5, true, 
				CycleMethod.NO_CYCLE, new Stop(0.0, Color.WHITE), new Stop(1.0, Color.ORANGE))));
		orange.setPrefHeight(50); orange.setPrefWidth(75); orange.setStyle("-fx-background-color:orange;");
		
    	Button yellow = new Button("Yellow");
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
    	
    	Text speedStr = new Text(Double.toString(speed / 100.0));
    	speedStr.setStyle("-fx-font-size:35;");
    	Text start = new Text("Time to get to other side: ");
    	start.setStyle("-fx-font-size:35;");

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
    	
    	KeyFrame kf = new KeyFrame(Duration.millis(100), e -> check());
    	Timeline tl = new Timeline(kf);
    	tl.setCycleCount(Timeline.INDEFINITE);
    	tl.play();
    	
    	BorderPane bpane = new BorderPane();
    	bpane.setTop(circle);
    	bpane.setCenter(r1);
    	bpane.setBottom(hpane);
        Scene scene = new Scene(bpane);
        scene.setOnKeyPressed( new EventHandler<KeyEvent>(){
	        @Override public void handle(KeyEvent ke) {
	       		key(ke);
	        }
	    });
        
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.setWidth(1920);
		primaryStage.setHeight(1030);
		primaryStage.setY(0);
		primaryStage.setX(0);
		primaryStage.setTitle("Moving ball");
		primaryStage.show();
	}
	public void key() {
		
	}

	public void move(String dir) {
		TranslateTransition tt = new TranslateTransition(Duration.millis(speed), circle);
		if (dir.equals("u")) {
			tt.setToY(0);
			tt.setInterpolator(Interpolator.LINEAR);
			tt.play();
		} else if (dir.equals("d")) {
			tt.setToY(794);
			tt.setInterpolator(Interpolator.LINEAR);
			tt.play();
		} else if (dir.equals("l")) {
			tt.setToX(0);
			tt.setInterpolator(Interpolator.LINEAR);
			tt.play();
		} else if (dir.equals("r")) {
			tt.setToX(1713);
			tt.setInterpolator(Interpolator.LINEAR);
			tt.play();
		} else if (dir.equals("st")) {
			tt.stop();
		}
	}
	public void check() {
		Bounds r1Boundary = r1.getLayoutBounds();
		if (circle.intersects(r1Boundary)) {
			System.out.println("You loose!!");
			collide();
		}
	}
	public void collide() {
		System.out.println("You loose!");
	}
	@SuppressWarnings("static-access")
	public void key(KeyEvent code) {
		if (code.getCode() == KeyEvent.VK_UP) {
			System.out.println("Up arrow");;
		} else {
			System.out.println("Sorry cant find key :(");
		}
	}
}

