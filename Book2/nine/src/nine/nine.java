package nine;

import java.util.Random;
import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.scene.text.*;

public class nine extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override public void start(Stage primaryStage) {
    	Random rNum = new Random();
    	
    	Ellipse ell1 = new Ellipse(175, 130, 75, 125);
    	ell1.setFill(Color.AQUA);
    	ell1.setStroke(Color.AQUAMARINE);
    	ell1.setStrokeWidth(7.5);
    	
    	Line l1 = new Line(5, 5, rNum.nextInt(100), rNum.nextInt(100));
    	l1.setSmooth(true);
    	l1.setStrokeWidth(5);
    	l1.setStroke(Color.MAGENTA);

    	QuadCurve qc1 = new QuadCurve(500, 50, 50, 50, 100, 300);
    	qc1.setFill(Color.LIGHTGOLDENRODYELLOW);
    	
    	QuadCurve qc2 = new QuadCurve(300, 100, 50, 50, 50, 500);
    	qc2.setFill(Color.LIGHTSLATEGREY);
    	qc2.setStrokeWidth(7.5);
    	qc2.setStroke(Color.KHAKI);
    	
    	Rectangle r1 = new Rectangle(100, 350, 64, 35);
    	r1.setFill(Color.DARKRED);
    	
    	LinearGradient grad = new LinearGradient(0, 0, 0, 2, true, CycleMethod.NO_CYCLE
    			, new Stop(.2, Color.web("#580404")), new Stop(.8, Color.web("#23c5f6")));
    	
    	Text txt = new Text("Shapes!");
    	txt.setStyle("-fx-font-size:300px;");
    	txt.setFill(grad);

    	Group group = new Group(ell1, l1, qc1, qc2, r1);
    	StackPane pane = new StackPane(group, txt);
        Scene scene = new Scene(pane);
        
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.setTitle("Shapes");
		primaryStage.show();
	}
}

