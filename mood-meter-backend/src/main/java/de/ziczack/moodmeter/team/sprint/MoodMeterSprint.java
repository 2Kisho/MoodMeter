package de.ziczack.moodmeter.team.sprint;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import de.ziczack.moodmeter.team.question.MoodMeterQuestion;
import de.ziczack.moodmeter.user.MoodMeterUser;

@Entity
public class MoodMeterSprint {

	@Id
	private long sprintId;
	@ManyToOne
	@JoinColumn(name="user_id", nullable = false)
	private MoodMeterUser user;
	@OneToMany(mappedBy = "sprint")
	private List<MoodMeterQuestion> questions;
//	private MoodMeterQuestion questions;
	private Date startDate;
	private Date endDate;
	
	public long getSprintId() {
		return sprintId;
	}
	
	public void setSprintId(long sprintId) {
		this.sprintId = sprintId;
	}
	
	public MoodMeterUser getSprintUser() {
		return user;
	}
	
	public void setSprintUser(MoodMeterUser sprintUser) {
		this.user = sprintUser;
	}
	
	public List<MoodMeterQuestion> getSprintQuestions() {
		MoodMeterQuestion q = new MoodMeterQuestion();
		q.setId(15);
		q.setQuestion("Wie hat dir die bearbeitung der Tasks im letzten Sprint gefallen?");
		q.setSprint(this);
		return Collections.singletonList(q);
	}
	
	public void setQuestions(List<MoodMeterQuestion> questions) {
		this.questions = questions;
	}
	
	public Date getStartDate() {
		return startDate;
	}
	
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	public Date getEndDate() {
		return endDate;
	}
	
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
}
