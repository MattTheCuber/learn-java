package ballGame;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javafx.stage.Stage;

public class Model {
	Controller control = new Controller();
	Connection c;
	Statement stmt;
	Stage primaryStage;
	String yourName, yourPassword;
	
	public void unlock(int i, String yourName, int price) {
		connect();

        try {
            ResultSet rs = stmt.executeQuery( "SELECT * FROM " + yourName + ";" );
			stmt = c.createStatement();
			
			int newPrice = rs.getInt("coins") - price;
			
		    String sql = "UPDATE " + yourName + " set level = " + i + ";";
		    stmt.executeUpdate(sql);
			
		    sql = "UPDATE " + yourName + "sLevels SET Own = yes" + " WHERE rowid = " + i;
		    stmt.executeUpdate(sql);
		    
		    sql = "UPDATE " + yourName + " SET coins = " + newPrice;
		    stmt.executeUpdate(sql);
		    
		    rs.close();
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
	}
	public String setCurrentLevelText(String yourName) {
		connect();
		int num = 1;
        try {
			stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM " + yourName + ";" );

            num = rs.getInt("level");

            rs.close();
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
		return Integer.toString(num);
	}
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
        	c = DriverManager.getConnection("jdbc:sqlite:file:/Users/Matthew/Documents/Data/"
          		+ "BallGameData/data.sqlite");
        } catch ( Exception e ) {
        	System.err.println("Error getting connection to sqlite");
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }
	public void add(String name, String password, String allNames, String allPasswords) {
		if ((!name.equals(""))&&(!password.equals(""))) {
			if ((allNames.contains(name))&&(allPasswords.contains(password))) {
	        	MessageBox.show("Sorry, name and password already taken", "Erorr");
			} else if ((!allNames.contains(name))&&(allPasswords.contains(password))) {
	        	MessageBox.show("Sorry, name already taken", "Erorr");
			} else if ((allNames.contains(name))&&(!allPasswords.contains(password))) {
	        	MessageBox.show("Sorry, password already taken", "Erorr");
			} else {
				makeData(name, password);
			}
		}
	}
	public void makeData(String name, String password) {
        try {
    		connect();
        	stmt = c.createStatement();
        	
  	        String sql = "INSERT INTO Passwords (Name, Password) VALUES ('" +  name + "', '" + 
  	        		password + "');";
	  	    stmt.executeUpdate(sql);
	  	        
            sql = "CREATE TABLE " + name + " AS SELECT * FROM Matthew;";
  	        stmt.executeUpdate(sql);
  	        
  	        sql = "INSERT INTO " + name + " " + "(coins, points, level) VALUES ('0', '0', '1');";
  	        stmt.executeUpdate(sql);

  	        sql = "CREATE TABLE " + name + "sTrophies" + " AS SELECT * FROM MatthewsTrophies;";
  	        stmt.executeUpdate(sql);
  	        
  	        sql = "CREATE TABLE " + name + "sLevels" + " AS SELECT * FROM MatthewsLevels;";
  	        stmt.executeUpdate(sql);

            stmt.close();
            c.close();
			control.bg(name);
        } catch ( Exception e ) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
	}
	public String makePasswordsString(String password) {
		String allPasswords = "";
		try {
			connect();
			ResultSet rs = null;
			try {
				stmt = c.createStatement();
				rs = stmt.executeQuery( "SELECT * FROM Passwords;" );
			} catch ( Exception e ) {
	            System.err.println(e.getClass().getName() + ": " + e.getMessage());
	        }
            
            while (rs.next()) {
                String newPassword = rs.getString("Password");
                
        		System.out.println(allPasswords);

                allPasswords += " " + newPassword;
            }
            allPasswords = allPasswords.substring(1);
            
            rs.close();
        } catch ( Exception e ) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
		return allPasswords;
	}
	public String makeNamesString(String name) {
		String allNames = "";
		try {
			connect();
			ResultSet rs = null;
			try {
				stmt = c.createStatement();
				rs = stmt.executeQuery( "SELECT * FROM Passwords;" );
			} catch ( Exception e ) {
	            System.err.println(e.getClass().getName() + ": " + e.getMessage());
	        }
            
            while (rs.next()) {
                String newName = rs.getString("Name");

                allNames += " " + newName;
            }
            allNames = allNames.substring(1);
            
            
            rs.close();
        } catch ( Exception e ) {
            System.err.println("Problem with details");
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
		return allNames;
	}
	public void readInfo(String yourName, String coins, String points, String level) {
		connect();
		
        try {
			stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM " + yourName + ";" );
            
            coins = Integer.toString(rs.getInt("coins"));
            points = Integer.toString(rs.getInt("points"));
            level = Integer.toString(rs.getInt("level"));
            
            rs.close();
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
	}
	public void setYourName(String nyn) {
		this.yourName = nyn;
	}
	public void setYourPassword(String nyp) {
		this.yourPassword = nyp;
	}
	public void setStage(Stage ns) {
		this.primaryStage = ns;
	}
	public String getYourPassword() {
		return this.yourPassword;
	}
	public String getYourName() {
		return this.yourName;
	}
	public Stage getStage() {
		return primaryStage;
	}
}
