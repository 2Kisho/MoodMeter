package de.ziczack.MoodMeter.entity;

public class Question implements Identifiable {

	private final long id;
	private String title;
	
	public Question(long id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public long getId() {
		return id;
	}
}
