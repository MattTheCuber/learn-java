package mattsBalancer;

import java.io.FileNotFoundException;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class controller {
    int sqlRecId;
    String sqlDate, sqlDetails;
    double sqlDebit, sqlCredit, sqlBalance;
    ObservableList<ledger> data;
    
	public void setBalance(double newBalance, Text txtBalance) throws FileNotFoundException {
		ledger ledger = new ledger(sqlDate, sqlDate, sqlBalance, sqlBalance, sqlBalance);
		ledger.connect();

        try {
        	ResultSet rs = ledger.stmt.executeQuery( "SELECT * FROM Ledger;" );
    		while (rs.next()) {
    		    double minus = rs.getDouble("Credit");
    		    double plus = rs.getDouble("Debit");
    		    
    		    newBalance = newBalance - minus;
    		    newBalance = newBalance + plus;
    		}
    		txtBalance.setText(Double.toString(newBalance));
            rs.close();
            ledger.stmt.close();
            ledger.c.close();
        } catch ( Exception e ) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
	}
    
	public void add(TextField txtDebit, TextField txtCredit, TextField txtDetails, double newBalance, 
			TableView<ledger> table, TextField txtDate, Text txtBalance) {
		ledger ledger = new ledger(sqlDate, sqlDate, sqlBalance, sqlBalance, sqlBalance);
		ledger.connect();
        try {
    		setNewBalance(newBalance, txtDebit, txtCredit, txtBalance);
    		
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
    		
    		ledger b = new ledger(newDate, txtDetails.getText(), newCredit, newDebit, newBalance);
        	
        	ResultSet rs = ledger.stmt.executeQuery( "SELECT * FROM Ledger;" );
        	ledger.stmt = ledger.c.createStatement();
        	
  	        String sql = "INSERT INTO Ledger (Date, Details, Credit, Debit, Balance) VALUES ("
  	        		+ newDate + ", " + txtDetails.getText() + ", " + newCredit + ", " + 
					  newDebit + ", " + newBalance + ");"; 
  	        ledger.stmt.executeUpdate(sql);
  	        
    		table.getItems().add(b);
    		txtDate.clear();
    		txtDetails.clear();
    		txtCredit.clear();
    		txtDebit.clear();
            rs.close();
            ledger.stmt.close();
            ledger.c.close();
        } catch ( Exception e ) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
	}

	public void setNewBalance(double newBalance, TextField txtDebit, TextField txtCredit, 
							  Text txtBalance) {
		if (Double.parseDouble(txtDebit.getText()) != 0.0) {
			newBalance = newBalance + Double.parseDouble(txtDebit.getText());
		} else {
			newBalance = newBalance - Double.parseDouble(txtCredit.getText());
		}
		txtBalance.setText(Double.toString(newBalance));
	}    
	
	public ObservableList<ledger> loadData() {
		data = FXCollections.observableArrayList();
		
		ledger ledger = new ledger(sqlDate, sqlDate, sqlBalance, sqlBalance, sqlBalance);
		ledger.connect();

        try {
			ledger.stmt = ledger.c.createStatement();
            ResultSet rs = ledger.stmt.executeQuery( "SELECT * FROM Ledger;" );
            
            while (rs.next()) {
               sqlRecId = rs.getInt("RecordID");
               sqlDate = rs.getString("Date");
               sqlDetails = rs.getString("Details");
               sqlDebit = rs.getDouble("Debit");
               sqlCredit = rs.getDouble("Credit");
               sqlBalance = rs.getDouble("Balance");
               data.add(new ledger(sqlDate, sqlDetails, sqlDebit, sqlCredit, sqlBalance));
            }
            
            rs.close();
            ledger.stmt.close();
            ledger.c.close();
        } catch ( Exception e ) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
		return data;
	}
	public void remove(String recordId) {
		ledger ledger = new ledger(sqlDate, sqlDate, sqlBalance, sqlBalance, sqlBalance);
		ledger.connect();

        try {
        	ledger.stmt = ledger.c.createStatement();
            String sql = "DELETE from Ledger where RecordId = " + recordId + ";";
            ledger.stmt.executeUpdate(sql);
            
            ledger.c.commit();
            ledger.stmt.close();
            ledger.c.close();
        } catch ( Exception e ) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
	}
    @SuppressWarnings("unchecked")
	public void save(Event e) {
		TableColumn.CellEditEvent<ledger, String> ce;
		ce = (TableColumn.CellEditEvent<ledger, String>) e;
		System.out.println(ce.toString());
		ledger m = ce.getRowValue();
		System.out.println(ce.getRowValue());
		m.setDetails(ce.getNewValue());
		System.out.println(ce.getNewValue());
		//update(ce.toString(), ce.getNewValue(), ce.getRecordId());
   	}
    public void update(String what, String to, String where) {
		ledger ledger = new ledger(sqlDate, sqlDate, sqlBalance, sqlBalance, sqlBalance);
		ledger.connect();
        try {
        	ledger.stmt = ledger.c.createStatement();
            String sql = "UPDATE Ledger set " + what + " = " + to + " where RecordId = " + where + ";";
            ledger.stmt.executeUpdate(sql);
            
            ledger.c.commit();
            ledger.stmt.close();
            ledger.c.close();
        } catch ( Exception e ) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }

    }
}
