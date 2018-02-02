package com.intuit;

public class Door {
	
	private Alarm anotherAlarm;
	
	public void setAnotherAlarm(Alarm anotherAlarm) {
		this.anotherAlarm = anotherAlarm;
	}
	private Alarm alarm;
	
	public void setAlarm(Alarm alarm) {
		this.alarm = alarm;
	}
	public void open() {
		alarm.activate();
	}
	public void close() {
		alarm.deactivate();
	}
}
