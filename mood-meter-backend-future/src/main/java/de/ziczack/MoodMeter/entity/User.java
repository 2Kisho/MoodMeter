package de.ziczack.MoodMeter.entity;

import java.util.ArrayList;
import java.util.List;

public class User implements Identifiable {

	private final long id;
	private String name;
	private final List<Sprint> sprints = new ArrayList<>();
	
	public User(long id) {
		this.id = id;
	}
	
	@Override
	public long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
