package de.ziczack.MoodMeter.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Sprint implements Identifiable {

	private final long id;
	private final List<Day> days = new ArrayList<>();
	private final List<Question> questions = new ArrayList<>();
	private final Map<Date, Integer> dataPoint = new TreeMap<>();
	private String name;
	
	public Sprint(long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public List<Day> getDays() {
		return days;
	}
	
	public List<Question> getQuestions() {
		return questions;
	}
	
	public Map<Date, Integer> getDataPoint() {
		return dataPoint;
	}

	@Override
	public long getId() {
		return id;
	}
	
}
