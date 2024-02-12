package ballGame;

import java.sql.Connection;
import java.sql.Statement;

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

public class Login {
	TextField name;
	PasswordField password;
	Stage primaryStage;
    Statement stmt;
    Connection c;
    String allNames, allPasswords;

	public void login() {
		primaryStage = new Stage();
		Controller control = new Controller();
	    String allNames = control.setAllNames(c, stmt);
	    String allPasswords = control.setAllPasswords(c, stmt);
		
		SignIn si = new SignIn();
    	
    	Button cancel = new Button("Cancel");
		cancel.setOnAction(e -> primaryStage.close());
    	Button ok = new Button("OK");
		ok.setOnAction(e -> control.add(name.getText(), password.getText(), allNames, 
				allPasswords, c, stmt, 
				primaryStage));
    	Button signIn = new Button("Sign In");
		signIn.setOnAction(e -> {primaryStage.close(); si.start(primaryStage);});
    	
    	Text user = new Text("User name: ");
    	Text pass = new Text("Password:   ");

    	name = new TextField();
    	name.setPrefWidth(200);
    	
    	password = new PasswordField();
    	password.setPrefWidth(200);
    	
    	Region spacer = new Region();

		HBox top = new HBox(user, name);
    	top.setPadding(new Insets(5, 5, 5, 5));
    	HBox middle = new HBox(pass, password);
    	middle.setPadding(new Insets(5, 5, 5, 5));
    	HBox buttons = new HBox(10, cancel, signIn, ok);
    	buttons.setPadding(new Insets(5, 5, 5, 5));
    	HBox bottom = new HBox(50, spacer, buttons);
    	
    	BorderPane bpane = new BorderPane();
    	bpane.setTop(top);
    	bpane.setCenter(middle);
    	bpane.setBottom(bottom);
        Scene scene = new Scene(bpane);

		primaryStage.setScene(scene);
		primaryStage.setTitle("Login");
		primaryStage.show();
	}
}
