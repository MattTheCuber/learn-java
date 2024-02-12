package rc.view;

import javafx.event.Event;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import rc.others.LOG;
import rc.others.Listener;

public class StatsView {
	Listener bl;
	Stage primaryStage;
	LOG LOG;
	String cubeType, className = "StatsView";

	public StatsView(String cubeTypee, LOG logg) {
		cubeType = cubeTypee;
		LOG = logg;
	}

	public void open(String cubeTypee) {
		cubeType = cubeTypee;
		primaryStage = new Stage();

		Text cubeTypeText = new Text("3󫢫");

		HBox hbox1 = new HBox(cubeTypeText);
		
		Scene scene = new Scene(hbox1);
		primaryStage.setScene(scene);
		primaryStage.setOnCloseRequest(e -> actionPerformed(e));
		primaryStage.setTitle("Chores");
		//primaryStage.getIcons().add(new Image(url));
		primaryStage.show();
		LOG.println("StartUpView shown", className, new Throwable().getStackTrace()[0].getLineNumber(), 5);
	}

	public void setListener(Listener bli) {
		this.bl = bli;
	}

	public void actionPerformed(Event e) {
		LOG.println("Action performed", className, new Throwable().getStackTrace()[0].getLineNumber(), 3);
		Object source = (Object) e.getSource();
		if (bl != null) {
			if (source == primaryStage) {
				primaryStage.close();
				bl.closeClicked(2);
			}
		}
	}

	public void c(Event e) {
		primaryStage.close();
		actionPerformed(e);
	}
}