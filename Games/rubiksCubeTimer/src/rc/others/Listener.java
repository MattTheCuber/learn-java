package rc.others;

public interface Listener {

	void closeClicked(int status);
	String getProName();
	void about();
	void continueClicked(int status);
	void cubeChanged(String cubeType);
	void openStats(String cubeType);
}
