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

	private static final String USER = "/user";
	private static final AtomicLong ID_GENERATOR = new AtomicLong(1000);
	@Autowired
	private MoodMeterUserRespository userRepo;
	
	@PostMapping(USER)
	MoodMeterUser newUser(@RequestBody MoodMeterUserDto newUser) {
		MoodMeterUser user = new MoodMeterUser();
		user.setUserId(ID_GENERATOR.incrementAndGet());
		user.setUserName(newUser.getUserName());
		return userRepo.save(user);
	}
	
	@PutMapping(USER + ID_PATH)
	MoodMeterUser updateUser(@PathVariable long id, @RequestBody MoodMeterUserDto newUser) {
		return userRepo.findById(id).map(user -> {
			user.setUserName(newUser.getUserName());
			return userRepo.save(user);
		}).orElseThrow();
	}
	
	@DeleteMapping(USER + ID_PATH)
	public void deleteUser(@PathVariable long id) {
		userRepo.deleteById(id);
	}
	
	@RequestMapping(USER + ID_PATH)
	MoodMeterUser getUserById(@PathVariable long id) {
		return userRepo.findById(id).orElseThrow();
	}
}
