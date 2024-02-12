package phoneNumbers;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class View extends Application {
	TableView<Model> table;
    TextField txtFName, txtFHome, txtFCell;
    
    @SuppressWarnings("unchecked")
	public void view() {
    	Controller control = new Controller();
    	Stage primaryStage = new Stage();
    	
        Text heading = new Text("Phone Numbers");
		heading.setStyle("-fx-font-size:50px;");
		
        txtFName = new TextField();
        txtFName.setMaxWidth(170);
        txtFName.setPromptText("Name");
        
        txtFHome = new TextField();
        txtFHome.setMaxWidth(220);
        txtFHome.setPromptText("Home Number");

        txtFCell = new TextField();
        txtFCell.setMaxWidth(220);
        txtFCell.setPromptText("Cell Number");
		
        Button btnAdd = new Button("Add");
        btnAdd.setMinWidth(60);
		btnAdd.setOnAction(e -> {
	        try {
	        	control.add(txtFName, txtFHome, txtFCell, table);
			} catch (Exception error) {
				System.out.println(error.getMessage());
			}
		});
		
		table = new TableView<Model>();
        table.setItems(control.loadData());
		
        Button btnDel = new Button("Delete row");
		btnDel.setOnAction(e -> {
	        try {
	    		ObservableList<Model> sel, items;
	    		items = table.getItems();
	    		sel = table.getSelectionModel().getSelectedItems();
	    		int num = table.getSelectionModel().getSelectedIndex();

	    		items.remove(num);
	        	control.remove(num);
			} catch (Exception error) {
				System.err.println(error.getMessage());
			}
		});
        
        Button btnSave = new Button("Save changes");
		btnSave.setOnAction(e -> {
/*	        try {
	        	control.save(e);
			} catch (Exception error) {
				System.err.println(error.getMessage());
			}*/
		});

        TableColumn<Model, String> nameCol = new TableColumn<Model, String>("Name");
        nameCol.setMinWidth(233);
        nameCol.setEditable(true);
        nameCol.setCellValueFactory(new PropertyValueFactory<Model, String>("Name"));

        TableColumn<Model, String> homeCol = new TableColumn<Model, String>("Home Number");
        homeCol.setMinWidth(300);
        homeCol.setEditable(true);
        homeCol.setCellValueFactory(new PropertyValueFactory<Model, String>("Home Number"));

        TableColumn<Model, Double> cellCol = new TableColumn<Model, Double>("Cell Number");
        cellCol.setMinWidth(300);
        cellCol.setEditable(true);
        cellCol.setCellValueFactory(new PropertyValueFactory<Model, Double>("Cell Number"));

		table.getColumns().addAll(nameCol, homeCol, cellCol);

		HBox bottom = new HBox(10, txtFName, txtFHome, txtFCell, btnAdd, btnDel, btnSave);
		
        VBox paneMain = new VBox();
        paneMain.setSpacing(10);
        paneMain.setPadding(new Insets(0, 10, 5, 10));
        paneMain.getChildren().addAll(heading, table, bottom);

		Scene scene = new Scene(paneMain);

		primaryStage.setScene(scene);
		primaryStage.setTitle("Phone Numbers");
		primaryStage.show();
    }
}
