package de.ziczack.moodmeter.user;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MoodMeterUser {

	@Id
	private Long userId;
	
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

}
