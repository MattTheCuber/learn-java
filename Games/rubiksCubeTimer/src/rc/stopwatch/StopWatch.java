package rc.stopwatch;

public class StopWatch {
	static final int STATE_UNSTARTED = 0;
	static final int STATE_RUNNING = 1;
	static final int STATE_STOPPED = 2;
	static final int STATE_SUSPENDED = 3;
	
	int runningState = STATE_UNSTARTED;

	long startTime = -1;
	long stopTime = -1;
	
	public void start() {
		if (this.runningState == STATE_STOPPED) {
			throw new IllegalStateException("Stopwatch must be reset before being restarted. ");
		}
		if (this.runningState != STATE_UNSTARTED) {
			throw new IllegalStateException("Stopwatch already started. ");
		}
		this.stopTime = -1;
		this.startTime = System.currentTimeMillis();
		this.runningState = STATE_RUNNING;
	}
	
	public void stop() {
		if (this.runningState != STATE_RUNNING && this.runningState != STATE_SUSPENDED) {
			throw new IllegalStateException("Stopwatch is not running. ");
		}
		if (this.runningState == STATE_RUNNING) {
			this.stopTime = System.currentTimeMillis();
		}
		this.runningState = STATE_STOPPED;
	}
	
	public void reset() {
		this.runningState = STATE_UNSTARTED;
		this.startTime = -1;
		this.stopTime = -1;
	}
	
	public void suspend() {
		if (this.runningState != STATE_RUNNING) {
			throw new IllegalStateException("Stopwatch must be running to suspend. ");
		}
		this.stopTime = System.currentTimeMillis();
		this.runningState = STATE_SUSPENDED;
	}
	
	public void resume() {
		if (this.runningState != STATE_SUSPENDED) {
			throw new IllegalStateException("Stopwatch must be suspended to resume. ");
		}
		this.startTime += (System.currentTimeMillis() - this.stopTime);
		this.stopTime = -1;
		this.runningState = STATE_RUNNING;
	}
	
	public long getTime() {
		if (this.runningState == STATE_STOPPED || this.runningState == STATE_SUSPENDED) {
			return this.stopTime - this.startTime;
		} else if (this.runningState == STATE_UNSTARTED) {
			return 0;
		} else if (this.runningState == STATE_RUNNING) {
			return System.currentTimeMillis() - this.startTime;
		}
		throw new RuntimeException("Illegal running state has occured. ");
	}
	
	public long getStartTime() {
		if (this.runningState == STATE_UNSTARTED) {
			throw new IllegalStateException("Stopwatch has not been started");
		}
		return this.startTime;
	}
	
	/*public String toString() {
		return DurationFormatUtils.formatDurationHMS(getTime());
	}*/
}