package de.ziczack.moodmeter.team.question;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MoodMeterQuestion {

	@Id
	private long questionId;
	private String question;
	
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
}
