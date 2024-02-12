package rc.view;

import java.util.Calendar;

import javafx.event.Event;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import rc.others.LOG;
import rc.others.Listener;
import rc.stopwatch.StopWatch;

public class MainView {
	Stage primaryStage;
	Listener bl;
	ImageView close;
	StackPane spane;
	LOG LOG;
	String className = "MainView", url;
	Image one = new Image("file:images/icons/close.png");
	Image two = new Image("file:images/icons/closePressed.png");
	Button closeItem, start, stop, reset, stats;
    boolean isRunning = false;
    int ms = 00, am, s = 00, m = 00, h = 00;
    String  l = "0:00.00", cubeType = "3󫢫";
    long startTime;
    StopWatch sw;
    Label field;
    @SuppressWarnings("rawtypes")
	ComboBox combo;

	public MainView(LOG log, String Url, StopWatch stw) {
		LOG = log;
		url = Url;
		sw = stw;
	}

	@SuppressWarnings({ "rawtypes", "unchecked", "static-access" })
	public void startTimingView() {
		am = Calendar.AM;
		primaryStage = new Stage();

		closeItem = new Button("Close");
		closeItem.setOnAction(e -> actionPerformed(e));
		
		start = new Button("Start");
		start.setOnAction(e -> actionPerformed(e));

		stop = new Button("Pause");
		stop.setOnAction(e -> actionPerformed(e));

		reset = new Button("Reset");
		reset.setOnAction(e -> actionPerformed(e));
		
		stats = new Button("Statistics");
		stats.setOnAction(e -> actionPerformed(e));
		
        field = new Label("0:00.00");
        field.setStyle("-fx-font-size:50px;");
        field.setText(l);
        
        combo = new ComboBox();
        combo.getItems().addAll("2󫎾", "3󫢫", "4󫶘", "5󬊅", "6󬝲", "Pyraminx", "Megaminx",
        						"Skewb", "Mirror cube", "Gear cube");
        combo.setEditable(true);        
        combo.setOnAction((Event ev) -> {
            cubeType = combo.getSelectionModel().getSelectedItem().toString();
            changeCube();
        });
        combo.setValue("3󫢫");

		HBox hbox1 = new HBox(start, stop, reset);
		hbox1.setMargin(stop, new Insets(0, 0, 0, 10));
		hbox1.setMargin(reset, new Insets(0, 0, 0, 10));
		HBox hbox2 = new HBox(closeItem, stats);
		hbox2.setMargin(stats, new Insets(0, 0, 0, 10));
		VBox vbox1 = new VBox(combo, field, hbox1, hbox2);
		vbox1.setMargin(combo, new Insets(5, 0, 0, 460));
		vbox1.setMargin(hbox1, new Insets(25, 0, 0, 235));
		vbox1.setMargin(field, new Insets(30, 0, 0, 250));
		vbox1.setMargin(hbox2, new Insets(20, 0, 0, 5));

		BorderPane bpane = new BorderPane(vbox1);
		Scene scene = new Scene(bpane);

		primaryStage.setScene(scene);
		primaryStage.setOnCloseRequest(e -> actionPerformed(e));
		primaryStage.setTitle("Rubik's Cube Timer");
		primaryStage.setWidth(700);
		primaryStage.setHeight(300);
		primaryStage.getIcons().add(new Image(url));
		primaryStage.show();
		LOG.println("MainView shown", className, new Throwable().getStackTrace()[0].getLineNumber(), 5);
	}
	
	private void changeCube() {
		bl.cubeChanged(cubeType);
	}

	public void setListener(Listener bli) {
		this.bl = bli;
	}

	public void actionPerformed(Event e) {
		LOG.println("Action performed", className, new Throwable().getStackTrace()[0].getLineNumber(), 3);
		Object source = (Object) e.getSource();
		if (source != null) {
			if (source == stop) {
				if (stop.getText() == "Stop") {
					stop();
					stop.setText("Pause");
				} else if (stop.getText() == "Pause") {
					sw.suspend();
					stop.setText("Resume");
					stop.setText("Stop");
				}
			} else if (source == start) {
				if (stop.getText() == "Start") {
					sw.start();
					field.setText(l);
				} else if (stop.getText() == "Resume") {
					sw.resume();
					stop.setText("Start");
				}
			} else if (source == reset) {
				sw.reset();
				field.setText("0:00.00");
			} else if (source == stats) {
				bl.openStats(cubeType);
			} else if (source == closeItem) {
				sw.stop();
				System.exit(0);
			}
			System.out.println(l);
		}
	}
	public void stop() {
		sw.stop();
		
		l = Long.toString(sw.getTime());
		int length = l.length();
		if (length == 3) {
			l = l + " milliseconds";
		} else if (length == 4) {
			String last = "";
			String first = "";

			first = "" + l.charAt(0);
			
			last = l.substring(l.length() - 3);
			last = "." + last;
			
			l = first + last + " seconds";
		} else if (length == 5) {
			String last = "";
			String first = "";
			String middle = "";

			first = "" + l.charAt(0) + l.charAt(1);
			if (Integer.parseInt(first) / 60 >= 1) {
				middle = first;
				first = "1:";
			} else {
				last = l.substring(l.length() - 3);
				last = "." + last;
			}
			
			l = first + middle + last;
		} else if (length == 6) {
			String last = "";
			String first = "";
			String middle = "";

			first = "" + l.charAt(0) + l.charAt(1) + l.charAt(2);
			middle = "" + l.charAt(1) + l.charAt(2);
			int newFirst = Integer.parseInt(first) / 60;
			first = Integer.toString(newFirst);
			
			last = l.substring(l.length() - 3);
			last = "." + last;
			
			l = first + ":" + middle + last;
		}
		System.out.println(l);
		field.setText(l);
	}
}
