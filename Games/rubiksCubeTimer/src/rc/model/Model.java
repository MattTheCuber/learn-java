package rc.model;

import rc.others.LOG;

public class Model {
	LOG LOG;
	String className = "Model";
	private String cubeType = "3󫢫";

	public String getCubeType() {
		return cubeType;
	}

	public void setCubeType(String cubeType) {
		this.cubeType = cubeType;
	}

	public Model(LOG log) {
		LOG = log;
	}

	public String getVersion() {
		return "1.0.0";
	}

	public String getProgramName() {
		return "Rubiks Cube TImer";
	}

	public String getCopyright() {
		return "2015 by Matthew Vine";
	}
}
