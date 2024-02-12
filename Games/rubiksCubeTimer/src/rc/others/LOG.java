package rc.others;

import java.io.File;
import java.io.PrintStream;
import java.util.Date;

public class LOG {
	PrintStream writer;
	File newFile;
	private int loggingLevel = 2;
	LoggingLevels levels;

	@SuppressWarnings("deprecation")
	public LOG() {
		Date d = new Date();
		String day = Integer.toString(d.getDate());
		
		String seconds = Integer.toString(d.getSeconds());
		String minutes = Integer.toString(d.getMinutes());
		String hours = Integer.toString(d.getHours());
		String time =  hours + "h " + minutes + "m " + seconds + "s";

		String dir = "LOG/Day-" + day;
		new File(dir).mkdirs();
		String fileName = dir + "/" + time + ".log";

		newFile = new File(fileName);

		try {
			writer = new PrintStream(newFile);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public void setLoggginLevel(int level) {
		this.loggingLevel = level;
	}

	public void println(int whatType) {
		levels = new LoggingLevels(this.loggingLevel);
		if (levels.levelName == null) {
			levels.setLevelString();
		}
		if (whatType <= levels.getLevelCode()) {
			writer.println();
		}
	}

	public void println(String string, String className, int lineNum, int whatType) {
		levels = new LoggingLevels(this.loggingLevel);
		if (levels.levelName == null) {
			levels.setLevelString();
		}
		if (whatType <= levels.getLevelCode()) {
			try {
				writer.println(levels.levelName[whatType] + ": " + string + "; Line: " + lineNum + "; Class: " + className);
			} catch (Error e) {
				System.out.println(e.toString());
			}
		}
	}

	public void close() {
		writer.println();
		writer.println("Closing LOG");
		writer.close();
	}
}
