package com.intuit;

import java.util.List;
import java.util.Map;

public class Book {
	private String name;
	private String author;
	
	private Map<String, String> interestedPublishers;
	private List<String> publishers;
	
	
	public Map<String, String> getInterestedPublishers() {
		return interestedPublishers;
	}
	public void setInterestedPublishers(Map<String, String> interestedPublishers) {
		this.interestedPublishers = interestedPublishers;
	}
	public List<String> getPublishers() {
		return publishers;
	}
	public void setPublishers(List<String> publishers) {
		this.publishers = publishers;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getName() {
		return name;
	}
	public String getAuthor() {
		return author;
	}
}
