package de.ziczack.moodmeter.team;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import de.ziczack.moodmeter.team.question.MoodMeterQuestion;
import de.ziczack.moodmeter.user.MoodMeterUser;

@Entity
public class MoodMeterTeam {

	@Id
	private Long teamId;
	
	private String teamName;
	
	private String teamLink;
	
//	private MoodMeterUser teamOwner;
	
//	@OneToMany
//	private List<MoodMeterUser> teamMember;
	
	@OneToMany
	private List<MoodMeterQuestion> questions;
	
	public Long getTeamId() {
		return teamId;
	}
	
	public void setTeamId(Long teamId) {
		this.teamId = teamId;
	}
	
	public String getTeamName() {
		return teamName;
	}
	
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	
	public String getTeamLink() {
		return teamLink;
	}
	
	public void setTeamLink(String teamLink) {
		this.teamLink = teamLink;
	}
	
//	public MoodMeterUser getTeamOwner() {
//		return teamOwner;
//	}
//	
//	public void setTeamOwner(MoodMeterUser teamOwner) {
//		this.teamOwner = teamOwner;
//	}
	
//	public List<MoodMeterUser> getTeamMember() {
//		return teamMember;
//	}
//	
//	public void setTeamMember(List<MoodMeterUser> teamMember) {
//		this.teamMember = teamMember;
//	}
//	
//	public void addTeamMember(MoodMeterUser user) {
//		this.teamMember.add(user);
//	}

	public void addQuestion(MoodMeterQuestion question) {
		this.questions.add(question);
	}
	
	public List<MoodMeterQuestion> getQuestions() {
		return questions;
	}
}
