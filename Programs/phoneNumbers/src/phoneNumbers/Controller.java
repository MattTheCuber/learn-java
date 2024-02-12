package phoneNumbers;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Controller extends Application {
    String sqlRecId = "";
    String sqlName, sqlHome, sqlCell;
    ObservableList<Model> data;
    Model model;
    
    Statement stmt;
    Connection c;
    
    public static void main(String[] args) {
        launch(args);
    }
    
	@Override public void start(Stage stage) throws FileNotFoundException {
    	View view = new View();
    	view.view();
    }
    
	public void add(TextField txtFName, TextField txtFHome, TextField txtFCell, TableView<Model> table) {
		connect();
	    if ((txtFHome.getText().contains("-"))&&(txtFHome.getText().length() > 7)) {
	        try {
  	           	stmt = c.createStatement();

	    	    String sql = "INSERT INTO PhoneNumbers (Name, Home, Cell) VALUES ('" + txtFName.getText() 
	    	       	+ "', '" + txtFHome.getText() + "', '" + txtFCell.getText() + "');"; 
	            stmt.executeUpdate(sql);

	            Model b = new Model(txtFName.getText(), txtFHome.getText(), txtFCell.getText());
	    	      	        
	   	       	table.getItems().add(b);
	   	   		txtFName.clear();
	       		txtFHome.clear();
	       		txtFCell.clear();
	            stmt.close();
	            c.close();
	        } catch ( Exception e ) {
   	            System.err.println(e.getClass().getName() + ": " + e.getMessage());
  	        }
        } else MessageBox.show("Incorrect Home Number or/and Cell Number", "Error");
	}
	
	public ObservableList<Model> loadData() {
		data = FXCollections.observableArrayList();
		connect();

        try {
			stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM PhoneNumbers;" );
            
            while (rs.next()) {
                sqlName = rs.getString("Name");
                sqlHome = rs.getString("Home");
                sqlCell = rs.getString("Cell");
                
                data.add(new Model(sqlName, sqlHome, sqlCell));
            }

            rs.close();
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
		return data;
	}
	public void remove(int record) {
		connect();

        try {
        	stmt = c.createStatement();
            String sql = "DELETE from PhoneNumbers where RecordId = " + record + ";";
            stmt.executeUpdate(sql);
            
            c.commit();
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
	}
    /*@SuppressWarnings("unchecked")
	public void save(Event e) {
		TableColumn.CellEditEvent<Model, String> ce;
		ce = (TableColumn.CellEditEvent<Model, String>) e;
		System.out.println(ce.toString());
		Model m = ce.getRowValue();
		System.out.println(ce.getRowValue());
		m.setDetails(ce.getNewValue());
		System.out.println(ce.getNewValue());
		//update(ce.toString(), ce.getNewValue(), ce.getRecordId());
   	}
    public void update(String what, String to, String where) {
		connect();
        try {
        	stmt = c.createStatement();
            String sql = "UPDATE Ledger set " + what + " = " + to + " where RecordId = " + where + ";";
            stmt.executeUpdate(sql);
            
            c.commit();
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }*/
    public void connect() {
        c = null;
        stmt = null;
        try {
        	Class.forName("org.sqlite.JDBC");
        } catch ( Exception e ) {
        	System.err.println("Error getting class for name org.sqlite.JDBC");
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        try {
        	c = DriverManager.getConnection("jdbc:sqlite:file:/Users/Matthew/Documents/Data/Phone/"
          		+ "PhoneNumbers.sqlite");
        } catch ( Exception e ) {
        	System.err.println("Error getting connection to Mattssqlite");
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }
}
