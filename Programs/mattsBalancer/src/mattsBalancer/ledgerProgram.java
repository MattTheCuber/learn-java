package mattsBalancer;

import java.io.FileNotFoundException;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ledgerProgram extends Application {
	Text txtBalance;
	TableView<ledger> table;
    TextField txtDate, txtDetails, txtCredit, txtDebit;
    Stage primaryStage;
    TableColumn<ledger, String> date;
    double newBalance;
	controller control = new controller();
	
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override public void init() {
    	ledger ledger = new ledger(null, null, 0.0, 0.0, 0.0);
    	ledger.connect();
    }
    
    @SuppressWarnings("unchecked")
	@Override public void start(Stage stage) throws FileNotFoundException {
    	Stage primaryStage = stage;
    	
        Text heading = new Text("Matt's Legder 01/26/2016 - 12/31/2016");
		heading.setStyle("-fx-font-size:50px;");
		
		Text txt = new Text("  Total Balance: ");
		txt.setStyle("-fx-font-size:25px;");
		
		txtBalance = new Text("0.0");
		txtBalance.setStyle("-fx-font-size:25px;");
        
        txtDetails = new TextField();
        txtDetails.setMaxWidth(200);
        txtDetails.setPromptText("Details");
        
        txtCredit = new TextField();
        txtCredit.setMaxWidth(60);
        txtCredit.setPromptText("Credit");

        txtDebit = new TextField();
        txtDebit.setMaxWidth(60);
        txtDebit.setPromptText("Debit");
		
        Button btnAdd = new Button("Add");
        btnAdd.setMinWidth(60);
		btnAdd.setOnAction(e -> {
	        try {
	        	control.add(txtDebit, txtCredit, txtDetails, newBalance, table, txtDate, txtBalance);
			} catch (Exception error) {
				System.out.println(error.getMessage());
			}
		});
		
		table =  new TableView<ledger>();
        table.setItems(control.loadData());
		
        Button btnDel = new Button("Delete row");
		btnDel.setOnAction(e -> {
	        try {
	        	controller control = new controller();
	    		ObservableList<ledger> sel, items;
	    		items = table.getItems();
	    		sel = table.getSelectionModel().getSelectedItems();

	    		for (ledger m : sel) items.remove(m);
	    		
	        	//control.remove(sel.toString());
			} catch (Exception error) {
				System.err.println(error.getMessage());
			}
		});
        
        Button btnSave = new Button("Save changes");
		btnSave.setOnAction(e -> {
	        try {
	        	control.save(e);
			} catch (Exception error) {
				System.err.println(error.getMessage());
			}
		});

		control.setBalance(newBalance, txtBalance);

        date = new TableColumn<ledger, String>("Date");
        date.setMinWidth(150);
        date.setEditable(true);
        date.setCellValueFactory(new PropertyValueFactory<ledger, String>("Date"));
		date.setOnEditCommit( e -> control.save(e) );

        TableColumn<ledger, String> detailsCol = new TableColumn<ledger, String>("Details");
        detailsCol.setMinWidth(350);
        detailsCol.setSortable(false);
        detailsCol.setEditable(true);
        detailsCol.setCellValueFactory(new PropertyValueFactory<ledger, String>("Details"));

        TableColumn<ledger, Double> credit = new TableColumn<ledger, Double>("Credit");
        credit.setMinWidth(200);
        credit.setSortable(false);
        credit.setEditable(true);
        credit.setCellValueFactory(new PropertyValueFactory<ledger, Double>("Credit"));

        TableColumn<ledger, Double> debit = new TableColumn<ledger, Double>("Debit");
        debit.setMinWidth(200);
        debit.setSortable(false);
        debit.setEditable(true);
        debit.setCellValueFactory(new PropertyValueFactory<ledger, Double>("Debit"));
        
        TableColumn<ledger, Double> balanceC = new TableColumn<ledger, Double>("Balance");
        balanceC.setMinWidth(200);
        balanceC.setSortable(false);
        balanceC.setEditable(true);
        balanceC.setCellValueFactory(new PropertyValueFactory<ledger, Double>("Balance"));

		table.getColumns().addAll(date, detailsCol, credit, debit, balanceC);

		HBox bottomStart = new HBox(10, txtDetails, txtCredit, txtDebit, btnAdd);
		HBox bottomMiddle = new HBox(10, btnSave, btnDel, txt, txtBalance);
		HBox bottom = new HBox(260, bottomStart, bottomMiddle);
		
        VBox paneMain = new VBox();
        paneMain.setSpacing(10);
        paneMain.setPadding(new Insets(0, 10, 5, 10));
        paneMain.getChildren().addAll(heading, table, bottom);

		Scene scene = new Scene(paneMain);

		primaryStage.setScene(scene);
		primaryStage.setTitle("Matt's Legder 01/26/2016 - 12/31/2016");
		primaryStage.show();
    }
}
