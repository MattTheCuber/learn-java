package ballGame;

import java.sql.Connection;
import java.sql.Statement;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SignIn extends Application {
	public Stage signIn() {
		Stage primaryStage = new Stage();
		Controller control = new Controller();
		Model model = new Model();
		model.connect();
		
    	TextField name = new TextField();
    	name.setPrefWidth(200);
    	
    	PasswordField password = new PasswordField();
    	password.setPrefWidth(200);
    	//control.ok(name.getText(), password.getText(), primaryStage);
    	
    	Button cancel = new Button("Cancel");
		cancel.setOnAction(e -> primaryStage.close());
    	Button ok = new Button("OK");
		ok.setOnAction(e -> control.onOK(name.getText(), password.getText(), primaryStage));
    	Button login= new Button("New account");
		login.setOnAction(e -> {primaryStage.close(); control.login(name.getText());});
    	
    	Text user = new Text("User name: ");
    	Text pass = new Text("Password:   ");
    	
    	Region spacer = new Region();

		HBox top = new HBox(user, name);
    	top.setPadding(new Insets(5, 5, 5, 5));
    	HBox middle = new HBox(pass, password);
    	middle.setPadding(new Insets(5, 5, 5, 5));
    	HBox buttons = new HBox(10, cancel, login, ok);
    	buttons.setPadding(new Insets(5, 5, 5, 5));
    	HBox bottom = new HBox(30, spacer, buttons);
    	
    	BorderPane bpane = new BorderPane();
    	bpane.setTop(top);
    	bpane.setCenter(middle);
    	bpane.setBottom(bottom);
        Scene scene = new Scene(bpane);

		primaryStage.setScene(scene);
		primaryStage.setTitle("Sign In");
		
		return primaryStage;
	}
}

