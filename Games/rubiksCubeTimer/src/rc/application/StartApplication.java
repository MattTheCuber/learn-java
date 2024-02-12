package rc.application;

import javafx.application.Application;
import javafx.stage.Stage;
import rc.controller.Controller;
import rc.model.Model;
import rc.others.LOG;
import rc.stopwatch.StopWatch;
import rc.view.MainView;
import rc.view.StatsView;

public class StartApplication extends Application {
	String url;
	LOG log;
	Model model;
	Controller controller;
	MainView mv;
	String className = "StartApplication";
	StopWatch sw;
	StatsView sv;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage arg0) throws Exception {
		url = setIcon();
		log = new LOG();
		sw = new StopWatch();
		model = new Model(log);
		mv = new MainView(log, url, sw);
		sv = new StatsView("3", log);
		controller = new Controller(mv, log, null, model, sw, sv);
		
		log.println("Application classes made", "StartApplication", new Throwable().getStackTrace()[0].getLineNumber(),
				5);
		
		loadStartData();
	}

	private void loadStartData() {
		log.setLoggginLevel(2);
		mv.startTimingView();
	}

	public String setIcon() {
		return "file:images/icons/icon3-large.png";
	}
}
