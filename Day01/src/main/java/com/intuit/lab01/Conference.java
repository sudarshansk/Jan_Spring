package com.intuit.lab01;

public class Conference {
	private SessionPlanner sessionPlanner;

	public void setSessionPlanner(SessionPlanner sessionPlanner) {
		this.sessionPlanner = sessionPlanner;
	}
	public int get50MinutesTopicsCount() {
		return sessionPlanner.get50MinutesTopics().size();
	}
	public int get60MinutesTopicsCount() {
		return sessionPlanner.get60MinutesTopics().size();
	}
	public int get45MinutesTopicsCount() {
		return sessionPlanner.get45MinutesTopics().size();
	}
}
