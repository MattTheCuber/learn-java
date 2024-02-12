package rc.controller;

import rc.model.Model;
import rc.others.LOG;
import rc.others.Listener;
import rc.stopwatch.StopWatch;
import rc.view.About;
import rc.view.MainView;
import rc.view.StatsView;

public class Controller implements Listener {
	public LOG LOG;
	MainView mv;
	String className = "Controller";
	About about;
	Model model;
	StopWatch sw;
	StatsView sv;

	public Controller(MainView newMv, LOG log, About abouT, Model mOdel, StopWatch StW, StatsView statsview) {
		model = mOdel;
		mv = newMv;
		LOG = log;
		about = abouT;
		sw = StW;
		sv = statsview;
	}

	@Override
	public void continueClicked(int status) {
		if (status == 1) {
			mv.startTimingView();
		} else if (status == 2) {
			mv.startTimingView();
		} else if (status == 3) {
			mv.startTimingView();
		}
	}

	@Override
	public void closeClicked(int status) {
		int num;
		if (status > 2) {
			LOG.println(5);
			LOG.println("Closing program", className, new Throwable().getStackTrace()[0].getLineNumber(), status);
			num = 0;
		} else {
			LOG.println(1);
			LOG.println("You should close the program by clicking close", className,
					new Throwable().getStackTrace()[0].getLineNumber(), status);
			num = 1;
		}
		LOG.close();
		System.exit(num);
	}

	@Override
	public void about() {
		about.show(model.getVersion(), model.getCopyright(), model.getProgramName());
	}
	
	@Override
	public String getProName() {
		return model.getProgramName();
	}

	@Override
	public void cubeChanged(String cubeType) {
		model.setCubeType(cubeType);
	}

	@Override
	public void openStats(String cubeType) {
		sv.open(cubeType);
	}
}
