package two;

import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;

public class two extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    Button minus;
    Button one;
    Button two;
    Button three;
    Button four;
    Button five;
    Button six;
    Button seven;
    Button eight;
    Button nine;
    Label lbl;
    int total = 0;

    @Override public void start(Stage primaryStage) {
	    minus = new Button();
	    minus.setText("Subtract 1");
	    minus.setOnAction(e -> {
	    	total--;
	    	lbl.setText(Integer.toString(total));
	    });
	    one = new Button();
	    one.setText("Add 1");
	    one.setOnAction(e -> {
	    	total += 1;
	    	lbl.setText(Integer.toString(total));
	    });
	    two = new Button();
	    two.setText("Add 2");
	    two.setOnAction(e -> {
	    	total += 2;
	    	lbl.setText(Integer.toString(total));
	    });
	    three = new Button();
	    three.setText("Add 3");
	    three.setOnAction(e -> {
	    	total += 3;
	    	lbl.setText(Integer.toString(total));
	    });
	    four = new Button();
	    four.setText("Add 4");
	    four.setOnAction(e -> {
	    	total += 4;
	    	lbl.setText(Integer.toString(total));
	    });
	    five = new Button();
	    five.setText("Add 5");
	    five.setOnAction(e -> {
	    	total += 5;
	    	lbl.setText(Integer.toString(total));
	    });
	    six = new Button();
	    six.setText("Add 6");
	    six.setOnAction(e -> {
	    	total += 6;
	    	lbl.setText(Integer.toString(total));
	    });
	    seven = new Button();
	    seven.setText("Add 7");
	    seven.setOnAction(e -> {
	    	total += 7;
	    	lbl.setText(Integer.toString(total));
	    });
	    eight = new Button();
	    eight.setText("Add 8");
	    eight.setOnAction(e -> {
	    	total += 8;
	    	lbl.setText(Integer.toString(total));
	    });
	    nine = new Button();
	    nine.setText("Add 9");
	    nine.setOnAction(e -> {
	    	total += 9;
	    	lbl.setText(Integer.toString(total));
	    });

        lbl = new Label();
        lbl.setText(Integer.toString(total));

        HBox pane = new HBox(5);
        pane.getChildren().addAll(lbl,minus,one,two,three,four,five,six,seven,eight,nine);

        Scene scene = new Scene(pane,200, 75);

		primaryStage.setScene(scene);
		primaryStage.setWidth(800);
		primaryStage.setTitle("Numbers");
		primaryStage.show();
	}
}
