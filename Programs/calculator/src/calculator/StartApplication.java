package calculator;

import javafx.application.Application;
import javafx.stage.Stage;

public class StartApplication extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		Model m = new Model();
		View v = new View();
		
		Controller c = new Controller(m, v);
		
		v.setInterface(c);
	}
}
