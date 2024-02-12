package scrabbleScoreKeeper;

import java.io.FileNotFoundException;

import javafx.application.Application;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class Controller extends Application {
    int num = 1, p1S, p2S, p3S, p4S;
    Model b;
    String p1N, p2N, p3N, p4N;
    String winner, second, third, fourth;
    
    public static void main(String[] args) {
        launch(args);
    }
    
	@Override public void start(Stage stage) throws FileNotFoundException {
		b = new Model();
    	startUpView view = new startUpView();
    	view.view();
    }
	public void key(KeyEvent e, String p1, String p2, String p3, String p4, Stage s) {
		if (e.getCode().equals(KeyCode.ENTER)) {
			startScores(p1, p2, p3, p4, s);
		}
	}
	public void key2(KeyEvent e, TextField p1, TextField p2, TextField p3, TextField p4, 
			TableView<Model> table, CheckBox cb, Stage s) {
		if (e.getCode().equals(KeyCode.ENTER)) {
			add(p1, p2, p3, p4, table, cb, s);
		}
	}
    
	public void add(TextField p1, TextField p2, TextField p3, TextField p4, TableView<Model> table,
			CheckBox cb, Stage s) {
	    try {
	    	if ((num % 2 == 0)&&(num != 1)) {
	    		addOdd(p1, p2, p3, p4, table);
	    	} else {
	    		int p3Int, p4Int;
		    	if (p3.getText().equals("")) {
		    		p3Int = 0;
		    	} else {
		    		p3Int = Integer.parseInt(p3.getText());
		    	}
		    	
		    	if (p4.getText().equals("")) {
		    		p4Int = 0;
		    	} else {
		    		p4Int = Integer.parseInt(p4.getText());
		    	}

		    	p1S += Integer.parseInt((p1.getText()));
		    	p2S += Integer.parseInt((p2.getText()));
		    	p3S += Integer.parseInt((p3.getText()));
		    	p4S += Integer.parseInt((p4.getText()));
		    	
		        b.addRecord(num, Integer.parseInt((p1.getText())), Integer.parseInt((p2.getText())),
		        		p3Int, p4Int);
	    	    
		   	    table.getItems().add(b);
		   	  	p1.clear();
		   		p2.clear();
	     		p3.clear();
		       	p4.clear();
	    	}
	    	if (cb.isSelected()) {
	    		checkWinners(s);
	    	} else if (num == 20) {
	    		checkWinners(s);
	    	}
	    } catch ( Exception e ) {
   	        System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
	}

	private void checkWinners(Stage stage) {
        int arr[] = {p1S, p2S, p3S, p4S};
        int largest = arr[0];
        int secondLargest = arr[0];
        int thirdLargest = arr[0];
        int fourthLargest = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > largest) {
            	fourthLargest = thirdLargest;
            	thirdLargest = secondLargest;
                secondLargest = largest;
                largest = arr[i];
            } else if (arr[i] > secondLargest) {
                secondLargest = arr[i];
            } else if (thirdLargest < arr[i]) {
           	 	thirdLargest = arr[i];
            } else if (fourthLargest < arr[i]) {
            	fourthLargest = arr[i];
            }
        }
		if (largest == p1S) winner = p1N;
		else if (largest == p2S) winner = p2N;
		else if (largest == p3S) winner = p3N;
		else if (largest == p4S) winner = p4N;
		
		if (secondLargest == p1S) second = p1N;
		else if (secondLargest == p2S) second = p2N;
		else if (secondLargest == p3S) second = p3N;
		else if (secondLargest == p4S) second = p4N;
		
		if (thirdLargest == p1S) third = p1N;
		else if (thirdLargest == p2S) third = p2N;
		else if (thirdLargest == p3S) third = p3N;
		else if (thirdLargest == p4S) third = p4N;
		
		if (fourthLargest == p1S) fourth = p1N;
		else if (fourthLargest == p2S) fourth = p2N;
		else if (fourthLargest == p3S) fourth = p3N;
		else if (fourthLargest == p4S) fourth = p4N;
		
		Finish fin = new Finish();
		fin.finish(winner, p1S, second, p2S, third, p3S, fourth, p4S, stage);
	}

	private void addOdd(TextField p1, TextField p2, TextField p3, TextField p4, TableView<Model> table) {
	    try {
	    	int newP3Int;
	    	if (p3.getText().equals("")) {
	    		newP3Int = 0;
	    	} else {
	    		newP3Int = Integer.parseInt(p3.getText());
	    	}
	    	
	    	int newP4Int;
	    	if (p4.getText().equals("")) {
	    		newP4Int = 0;
	    	} else {
	    		newP4Int = Integer.parseInt(p4.getText());
	    	}
	        b.addRecord(num, Integer.parseInt((p1.getText())) + p1S, 
	        		Integer.parseInt((p2.getText())) + p2S, newP3Int + p3S, newP4Int + p4S);

	    	p1S += Integer.parseInt((p1.getText()));
	    	p2S += Integer.parseInt((p2.getText()));
	    	p3S += Integer.parseInt((p3.getText()));
	    	p4S += Integer.parseInt((p4.getText()));
    	    
	   	    table.getItems().add(b);
	   	  	p1.clear();
	   		p2.clear();
     		p3.clear();
	       	p4.clear();
	       	
	       	num++;
	    } catch ( Exception e ) {
   	        System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
	}

	public void startScores(String p1, String p2, String p3, String p4, Stage s) {
		s.close();
		ScoreView sv = new ScoreView();
		sv.view(p1, p2, p3, p4);
	}

	public void setNames(String p1, String p2, String p3, String p4) {
		p1N = p1; p2N = p2; p3N = p3; p3N = p3;
	}

	public void letters() {
		Letters l = new Letters();
		l.showLetters();
	}

	public void tlw() {
		TLW tlw = new TLW();
		tlw.twolw();
	}
}
