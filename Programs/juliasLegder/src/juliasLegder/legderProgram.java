package juliasLegder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import javafx.application.Application;
import javafx.collections.FXCollections;
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

public class legderProgram extends Application {
	Text txtBalance;
	TableView<legder> table;
    TextField txtDate, txtDetails, txtCredit, txtDebit;
    Stage primaryStage;
    TableColumn<legder, String> date;
    double newBalance;
	
    public static void main(String[] args) {
        launch(args);
    }
    
    @SuppressWarnings("unchecked")
	@Override public void start(Stage stage) throws FileNotFoundException {
    	Stage primaryStage = stage;
    	
        Text heading = new Text("Julia's Legder 01/30/2016 - 12/31/2016");
		heading.setStyle("-fx-font-size:50px;");
		
		Text txt = new Text("\t\t\t\t\t\t\tTotal Balance: ");
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
	        	add();
			} catch (Exception error) {
				System.out.println(error.getMessage());
			}
		});

		setBalance();
	
		table =  new TableView<legder>();
        table.setItems(loadData());
        
        date = new TableColumn<legder, String>("Date");
        date.setMinWidth(100);
        date.setEditable(true);
        date.setCellValueFactory(new PropertyValueFactory<legder, String>("Date"));

        TableColumn<legder, String> detailsCol = new TableColumn<legder, String>("Details");
        detailsCol.setMinWidth(300);
        detailsCol.setSortable(false);
        detailsCol.setEditable(true);
        detailsCol.setCellValueFactory(new PropertyValueFactory<legder, String>("Details"));

        TableColumn<legder, Double> credit = new TableColumn<legder, Double>("Credit");
        credit.setMinWidth(235);
        credit.setSortable(false);
        credit.setEditable(true);
        credit.setCellValueFactory(new PropertyValueFactory<legder, Double>("Credit"));

        TableColumn<legder, Double> debit = new TableColumn<legder, Double>("Debit");
        debit.setMinWidth(200);
        debit.setSortable(false);
        debit.setEditable(true);
        debit.setCellValueFactory(new PropertyValueFactory<legder, Double>("Debit"));
        
        TableColumn<legder, Double> balanceC = new TableColumn<legder, Double>("Balance");
        balanceC.setMinWidth(200);
        balanceC.setSortable(false);
        balanceC.setEditable(true);
        balanceC.setCellValueFactory(new PropertyValueFactory<legder, Double>("Balance"));

		table.getColumns().addAll(date, detailsCol, credit, debit, balanceC);
		
		HBox bottom = new HBox(10, txtDetails, txtCredit, txtDebit, btnAdd, txt, txtBalance);
		
        VBox paneMain = new VBox();
        paneMain.setSpacing(10);
        paneMain.setPadding(new Insets(0, 10, 5, 10));
        paneMain.getChildren().addAll(heading, table, bottom);

		Scene scene = new Scene(paneMain);

		primaryStage.setScene(scene);
		primaryStage.setTitle("Julia's Legder 01/30/2016 - 12/31/2016");
		primaryStage.show();
    }
	
	public void setBalance() throws FileNotFoundException {
	    Scanner r = new Scanner(new File("legder.txt"));
		
		while (r.hasNextLine()) {
			r.next();
			r.next();
		    double minus = r.nextDouble();
		    double plus = r.nextDouble();
		    
		    newBalance = newBalance - minus;
		    newBalance = newBalance + plus;
		    
		    r.nextDouble();
		}
		txtBalance.setText(Double.toString(newBalance));
		r.close();
	}
    
	public void add() throws FileNotFoundException {
		PrintStream balWriter = new PrintStream(new FileOutputStream("legder.txt", true));
		
		setNewBalance();
		
		Date d = new Date();
	    SimpleDateFormat date = new SimpleDateFormat ("MM/dd/yy");
		String newDate = date.format(d);
		
		double newDebit;
		if (txtDebit.getText().equals(null)) {
			newDebit = 0.0;
		} else {
			newDebit = Double.parseDouble(txtDebit.getText());
		}
		
		double newCredit;
		if (txtCredit.getText().equals(null)) {
			newCredit = 0.0;
		} else {
			newCredit = Double.parseDouble(txtCredit.getText());
		}
		
		legder b = new legder(newDate, txtDetails.getText(), newCredit, newDebit, newBalance);
		
		balWriter.print("\n" + newDate + " " + txtDetails.getText() + " " + newCredit + " " + 
						  newDebit + " " + newBalance);
		
		table.getItems().add(b);
		txtDate.clear();
		txtDetails.clear();
		txtCredit.clear();
		txtDebit.clear();
		
		balWriter.close();
	}

	public void setNewBalance() {
		if (Double.parseDouble(txtDebit.getText()) != 0.0) {
			newBalance = newBalance + Double.parseDouble(txtDebit.getText());
		} else {
			newBalance = newBalance - Double.parseDouble(txtCredit.getText());
		}
		txtBalance.setText(Double.toString(newBalance));
	}

	public ObservableList<legder> loadData() throws FileNotFoundException {
	    Scanner r = new Scanner(new File("legder.txt"));
		ObservableList<legder> data = FXCollections.observableArrayList();
		
		while (r.hasNextLine()) {
			data.add(new legder(r.next(), r.next(), r.nextDouble(), r.nextDouble(), r.nextDouble()));
		}

		r.close();
		return data;
	}
}
