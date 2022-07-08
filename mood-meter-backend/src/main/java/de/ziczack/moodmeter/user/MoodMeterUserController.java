package de.ziczack.moodmeter.user;

import static de.ziczack.moodmeter.MoodMeterConstants.ID_PATH;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MoodMeterUserController {

	private static final AtomicLong idGenerator = new AtomicLong(1000);
	@Autowired
	private MoodMeterUserRespository repo;
	
	@PostMapping("/user")
	MoodMeterUser newUser(@RequestBody MoodMeterUser user) {
		user.setUserId(idGenerator.incrementAndGet());
		return repo.save(user);
	}
	
	@PutMapping("/updateuser/" + ID_PATH)
	MoodMeterUser updateUser(@PathVariable long id, @RequestBody MoodMeterUser newUser) {
		return repo.findById(id).map(user -> {
			user.setUserName(newUser.getUserName());
			return repo.save(user);
		}).orElseThrow();
	}
	
	@DeleteMapping("/deleteuser/" + ID_PATH)
	public void deleteUser(@PathVariable long id) {
		repo.deleteById(id);
	}
	
	@RequestMapping("/user/" + ID_PATH)
	MoodMeterUser getUserById(@PathVariable long id) {
		return repo.findById(id).orElseThrow();
	}
}
