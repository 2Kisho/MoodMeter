package de.ziczack.moodmeter.team;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MoodMeterTeamController {

	private static final AtomicLong idGenerator = new AtomicLong(1000);
	
	@Autowired
	private MoodMeterTeamRepository repo;
	
	@PostMapping("/team")
	MoodMeterTeam newTeam(@RequestBody MoodMeterTeam newTeam) {
		MoodMeterTeam team = new MoodMeterTeam();
		team.setTeamId(idGenerator.incrementAndGet());
		team.setTeamName(newTeam.getTeamName());
		team.setTeamLink(generateTeamLink());
		return repo.save(team);
	}

	private String generateTeamLink() {
		return null;
	}
}
