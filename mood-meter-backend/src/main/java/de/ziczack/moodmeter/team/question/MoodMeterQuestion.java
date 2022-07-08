package de.ziczack.moodmeter.team.question;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import de.ziczack.moodmeter.team.sprint.MoodMeterSprint;

@Entity
public class MoodMeterQuestion {

	@Id
	private long questionId;
	private String question;
	@ManyToOne
	@JoinColumn(name = "sprint_id")
	private MoodMeterSprint sprint;
	
	public long getId() {
		return questionId;
	}
	
	public void setId(long id) {
		this.questionId = id;
	}
	
	public String getQuestion() {
		return question;
	}
	
	public void setQuestion(String question) {
		this.question = question;
	}
	
	public MoodMeterSprint getSprint() {
		return sprint;
	}
	
	public void setSprint(MoodMeterSprint sprint) {
		this.sprint = sprint;
	}
}
