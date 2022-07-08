package de.ziczack.moodmeter.team.sprint;

import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import de.ziczack.moodmeter.team.question.MoodMeterQuestionRepository;
import de.ziczack.moodmeter.user.MoodMeterUserRespository;

@RestController
public class MoodMeterSprintController {

	private static final AtomicLong ID_GENERATOR = new AtomicLong(1000);
	
	@Autowired
	private MoodMeterSprintRepository sprintRepo;

	@Autowired
	private MoodMeterUserRespository userRepo;
	
	@Autowired
	private MoodMeterQuestionRepository questionRepo;
	
//	public void endSprint(long sprintId) {
//		
//	}
	
	@PostMapping ("/sprint")
	public MoodMeterSprint createSprint(@RequestBody CreateSprintDto dto) {
		MoodMeterSprint sprint = new MoodMeterSprint();
		sprint.setSprintId(ID_GENERATOR.incrementAndGet());
		sprint.setStartDate(new Date());
		sprint.setSprintUser(userRepo.findById(dto.getSprintOwnerId()).orElseThrow());
//		sprint.setQuestions(questionRepo.findAll());
		return sprintRepo.save(sprint);
	}
}
