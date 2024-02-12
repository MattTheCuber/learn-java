package eight;

import java.text.SimpleDateFormat;
import java.util.Date;
import javafx.application.*;
import javafx.geometry.Pos;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;

public class eight extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    TreeView<String> treeview;
    Button btn;
    @Override public void start(Stage primaryStage) {
    	Date now = new Date();
    	SimpleDateFormat df = new SimpleDateFormat("hh:mm:ss a");
    	Text txt = new Text(df.format(now));
		txt.setFont(new Font(25));
		
		Region spacer = new Region();
		
		treeview = new TreeView<String>();
		
		btn = new Button();
		btn.setText("(btn text goes here)");
		btn.setOnAction(e -> primaryStage.close());
		btn.setAlignment(Pos.CENTER);
		
		HBox hbox = new HBox(125, spacer, btn);
		VBox vbox = new VBox(20, txt, hbox);
		
        Scene scene = new Scene(vbox);
        
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.setHeight(125);
		primaryStage.setWidth(300);
		primaryStage.toFront();
		primaryStage.setTitle("(title goes here)");
		primaryStage.show();
	}
}

