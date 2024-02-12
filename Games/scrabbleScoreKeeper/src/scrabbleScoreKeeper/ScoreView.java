package scrabbleScoreKeeper;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ScoreView extends Application {
	TableView<Model> table;
    TextField txtF1, txtF2, txtF3, txtF4;
    
	@SuppressWarnings("unchecked")
	public void view(String p1Name, String p2Name, String p3Name, String p4Name) {
    	Controller control = new Controller();
    	Stage primaryStage = new Stage();
    	
        Text heading = new Text("Scores");
		heading.setStyle("-fx-font-size:45px;");

		CheckBox cb = new CheckBox();
		Text txt = new Text("Last Round");
		
        txtF1 = new TextField();
        txtF1.setMaxWidth(100);
        txtF1.setPromptText(p1Name);
        
        txtF2 = new TextField();
        txtF2.setMaxWidth(100);
        txtF2.setPromptText(p2Name);

        txtF3 = new TextField();
        txtF3.setMaxWidth(100);
        txtF3.setPromptText(p3Name);

        txtF4 = new TextField();
        txtF4.setMaxWidth(100);
        txtF4.setPromptText(p4Name);

        Button btnAdd = new Button("Add");
        btnAdd.setMinWidth(60);
		btnAdd.setOnAction(e -> control.add(txtF1, txtF2, txtF3, txtF4, table, cb, primaryStage));

        Button tlw = new Button("2-letter-words");
		tlw.setOnAction(e -> control.tlw());

        Button letters = new Button("Number of Letters");
		letters.setOnAction(e -> control.letters());
		
		table = new TableView<Model>();
		
		control.setNames(p1Name, p2Name, p3Name, p3Name);

        TableColumn<Model, String> p1Col = new TableColumn<Model, String>(p1Name);
        p1Col.setMinWidth(120);
        p1Col.setCellValueFactory(new PropertyValueFactory<Model, String>(p1Name));

        TableColumn<Model, String> p2Col = new TableColumn<Model, String>(p2Name);
        p2Col.setMinWidth(120);
        p2Col.setEditable(true);
        p2Col.setCellValueFactory(new PropertyValueFactory<Model, String>(p2Name));

        TableColumn<Model, Double> p3Col = new TableColumn<Model, Double>(p3Name);
        p3Col.setMinWidth(120);
        p3Col.setEditable(true);
        p3Col.setCellValueFactory(new PropertyValueFactory<Model, Double>(p3Name));

        TableColumn<Model, Double> p4Col = new TableColumn<Model, Double>(p4Name);
        p4Col.setMinWidth(120);
        p4Col.setEditable(true);
        p4Col.setCellValueFactory(new PropertyValueFactory<Model, Double>(p4Name));

        TableColumn<Model, Double> numCol = new TableColumn<Model, Double>("Round");
        numCol.setMaxWidth(75);
        numCol.setEditable(true);
        numCol.setCellValueFactory(new PropertyValueFactory<Model, Double>("Round"));

		table.getColumns().addAll(numCol, p1Col, p2Col, p3Col, p4Col);
		
		HBox bottom = new HBox(10, txtF1, txtF2, txtF3, txtF4, btnAdd, txt, cb);
		HBox buttons = new HBox(10, tlw, letters);
		
        VBox paneMain = new VBox();
        paneMain.setSpacing(10);
        paneMain.setPadding(new Insets(0, 10, 5, 10));
        paneMain.getChildren().addAll(heading, buttons, table, bottom);

		Scene scene = new Scene(paneMain);
        scene.setOnKeyPressed( new EventHandler<KeyEvent>(){
	        @Override public void handle(KeyEvent ke) {
	       		control.key2(ke, txtF1, txtF2, txtF3, txtF4, table, cb, primaryStage);
	        }
	    });
	
		primaryStage.setScene(scene);
		primaryStage.setOnCloseRequest(e -> {
			Loading.show();
		});
		primaryStage.setTitle("Scores");
		primaryStage.show();
    }
}
