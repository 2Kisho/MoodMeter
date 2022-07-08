package de.ziczack.MoodMeter.rest.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class QuestionDto {

	private long id;
	private String title;
	private String question;
	private List<AnswerDto> answers = new ArrayList<>();
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getQuestion() {
		return question;
	}
	
	public void setQuestion(String question) {
		this.question = question;
	}
	
	public List<AnswerDto> getAnswers() {
		return answers;
	}
	
	public void addAnswer(AnswerDto answer) {
		this.answers.add(answer);
	}
}
