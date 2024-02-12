package bb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.geometry.Bounds;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Controller {
	public void move(String dir, Circle circle, double speed) {
		TranslateTransition tt = new TranslateTransition(Duration.millis(speed), circle);
		RotateTransition rt = new RotateTransition();
		rt.setNode(circle);
		rt.setDuration(Duration.millis(speed));
		rt.setAxis(Rotate.Z_AXIS);
		rt.setByAngle(360);
		rt.setCycleCount(1);
		rt.setInterpolator(Interpolator.LINEAR);
		
		if (dir.equals("u")) {
			tt.setToY(0);
			tt.setInterpolator(Interpolator.LINEAR);
			tt.play();
		} else if (dir.equals("d")) {
			tt.setToY(764);
			tt.setInterpolator(Interpolator.LINEAR);
			tt.play();
		} else if (dir.equals("l")) {
			tt.setToX(0);
			tt.setInterpolator(Interpolator.LINEAR);
			tt.play();
		} else if (dir.equals("r")) {
			tt.setToX(1713);
			tt.setInterpolator(Interpolator.LINEAR);
			tt.play();
		} else if (dir.equals("st")) {
			tt.stop();
		}
		rt.play();
	}
	public void check(Rectangle r, Circle c) {
		Bounds r1Boundary = r.getLayoutBounds();
		if (c.intersects(r1Boundary)) {
			System.out.println("You loose!!");
			collide();
		}
	}
	public void collide() {
		System.out.println("You loose!");
	}
	public void key(KeyEvent code) {
		/*if (code.getCode() == KeyEvent.VK_UP) {
			System.out.println("Up arrow");;
		} else {
			System.out.println("Sorry cant find key :(");
		}*/
	}
    public void connect(Connection c, Statement stmt) {
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
	public void add(String name, String password, String allNames, String allPasswords, 
			Connection c, Statement stmt, Stage s) {
		if ((!name.equals(""))&&(!password.equals(""))) {
			if ((allNames.contains(name))&&
					(allPasswords.contains(password))) {
	        	MessageBox.show("Sorry, name and password already taken", "Erorr");
			} else if ((!allNames.contains(name))&&
					(allPasswords.contains(password))) {
	        	MessageBox.show("Sorry, name already taken", "Erorr");
			} else if ((allNames.contains(name))&&
					(!allPasswords.contains(password))) {
	        	MessageBox.show("Sorry, password already taken", "Erorr");
			} else {
		        try {
		    		connect(c, stmt);
		        	stmt = c.createStatement();
		        	
		  	        String sql = "INSERT INTO Passwords (Name, Password) VALUES ('" + 
		  	        		name + "', '" + password + "');";
			  	        stmt.executeUpdate(sql);
	        	} catch ( Exception e ) {
		            System.err.println(e.getClass().getName() + ": " + e.getMessage());
		        }
		        	
	        	try {
		            String tableSql = "CREATE TABLE " + name +
		                    "( coins          INT    NOT NULL, " + 
		                    " points          INT    NOT NULL, " + 
		                    " level           INT    NOT NULL);";
		  	        stmt.executeUpdate(tableSql);
		  	        
		  	        String sql2 = "INSERT INTO " + name + " "
		  	        		+ "(coins, points, level) VALUES ('0', '0', '1');";
		  	        stmt.executeUpdate(sql2);

		  	        String tableSql2 = "CREATE TABLE " + name + "sTrophies" +
		  	        		" AS SELECT * FROM MatthewsTrophies;";
		  	        stmt.executeUpdate(tableSql2);
		  	        
		  	        String tableSql3 = "CREATE TABLE " + name + "sLevels" +
		  	        		" AS SELECT * FROM MatthewsLevels;";
		  	        stmt.executeUpdate(tableSql3);

		            stmt.close();
		            c.close();
					s.close();
					bg(s, name);
		        } catch ( Exception e ) {
		            System.err.println(e.getClass().getName() + ": " + e.getMessage());
		        }
			}
		}
	}
	public void check2(String name, String password, String allNames, String allPasswords, 
			Stage s) {
		if ((!name.equals(""))&&(!password.equals(""))) {
			if ((allNames.contains(name))&&
					(allPasswords.contains(password))) {
				s.close();
				bg(s, name);
			} else {
	        	MessageBox.show("Incorect input", 
	        			"Erorr");
			}
		} else if  ((name.equals(""))&&(password.equals(""))) {
			MessageBox.show("Please enter a name and password", 
        			"Erorr");
		} else {
        	MessageBox.show("Sorry an error has occurred, please restart the program", 
        			"Erorr");
		}
	}
	public void read3(Connection c, Statement stmt, String yourName, String coins, String points
			, String level) {
		connect(c, stmt);
		
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
	public void select(int i) {
		
	}
	public void unlock(int i, Connection c, Statement stmt, String yourName) {
		connect(c, stmt);
		
        try {
			stmt = c.createStatement();
			
		    String sql = "UPDATE " + yourName + " set level = " + i + ";";
		    stmt.executeUpdate(sql);
			
		    sql = "UPDATE " + yourName + "sLevels SET Own = " + i + " WHERE rowid " + i + 
		    		"= yes;";
		    stmt.executeUpdate(sql);
		      
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
	}
	public String setAllNames(Connection c, Statement stmt) {
		connect(c, stmt);
		String allNames = "";
		
        try {
			stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM Passwords;" );
            
            while (rs.next()) {
                String newName = rs.getString("Name");
                
                allNames += " " + newName;
            }
            allNames = allNames.substring(1);
            
            rs.close();
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return allNames;
	}
	public String setAllPasswords(Connection c, Statement stmt) {
		connect(c, stmt);
		String allPasswords = "";
		
        try {
			stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM Passwords;" );
            
            while (rs.next()) {
                String newPassword = rs.getString("Password");
                
                allPasswords += " " + newPassword;
            }
            allPasswords = allPasswords.substring(1);
            
            rs.close();
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return allPasswords;
	}
	public String setCurrentLevelText(Connection c, Statement stmt, String yourName) {
		connect(c, stmt);
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
}
