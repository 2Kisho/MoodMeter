package de.ziczack.moodmeter.user;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import de.ziczack.moodmeter.team.sprint.MoodMeterSprint;

@Entity
public class MoodMeterUser {

	@Id
	private Long userId;
	
	@OneToMany(mappedBy = "user")
	private List<MoodMeterSprint> sprints;
	
	private String userName;
	
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	public Long getUserId() {
		return userId;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getUserName() {
		return userName;
	}

	
	public List<MoodMeterSprint> getUserSprints() {
		return sprints;
	}
}
