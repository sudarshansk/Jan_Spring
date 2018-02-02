package com.intuit.lab01;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class SessionPlannerImpl implements SessionPlanner{

	//private Map<String, String> topics;
	private Properties topics;
	private List<String> sixtyMinutesTopics;
	private List<String> fiftyMinutesTopics;
	private List<String> fortyFiveMinutesTopics;
	
	public void setTopics(Properties topics) {
		this.topics = topics;
		splitAndPopulateTopicsBasedOnDuration();
	}

	private void splitAndPopulateTopicsBasedOnDuration() {
		sixtyMinutesTopics = new ArrayList<String>();
		fiftyMinutesTopics = new ArrayList<String>();
		fortyFiveMinutesTopics = new ArrayList<String>();
		topics.forEach((key,value) -> {
			if(value.toString().contains("60"))
				sixtyMinutesTopics.add(key.toString());
			else if(value.toString().contains("50"))
				fiftyMinutesTopics.add(key.toString());
			else if(value.toString().contains("45"))
				fortyFiveMinutesTopics.add(key.toString());
		});
	}

	@Override
	public List<String> get60MinutesTopics() {
		return sixtyMinutesTopics;
	}

	@Override
	public List<String> get50MinutesTopics() {
		return fiftyMinutesTopics;
	}

	@Override
	public List<String> get45MinutesTopics() {
		return fortyFiveMinutesTopics;
	}

}
