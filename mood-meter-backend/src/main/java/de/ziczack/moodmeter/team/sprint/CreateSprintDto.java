package de.ziczack.moodmeter.team.sprint;

import java.util.List;

public class CreateSprintDto {

	private long sprintOwnerId;
	private List<Long> sprintQuestionIds;
	
	public long getSprintOwnerId() {
		return sprintOwnerId;
	}
	
	public void setSprintOwnerId(long sprintOwnerId) {
		this.sprintOwnerId = sprintOwnerId;
	}
	
	public List<Long> getSprintQuestionIds() {
		return sprintQuestionIds;
	}
	
	public void setSprintQuestionIds(List<Long> sprintQuestionIds) {
		this.sprintQuestionIds = sprintQuestionIds;
	}
	
}
