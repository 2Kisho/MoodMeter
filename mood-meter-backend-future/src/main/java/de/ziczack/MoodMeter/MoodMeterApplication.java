package de.ziczack.MoodMeter;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import de.ziczack.MoodMeter.rest.cache.MapCache;
import de.ziczack.MoodMeter.rest.dto.AnswerDto;
import de.ziczack.MoodMeter.rest.dto.QuestionDto;

@SpringBootApplication
public class MoodMeterApplication {

	public static void main(String[] args) {
		initCaches();
		SpringApplication.run(MoodMeterApplication.class, args);
	}
	
	public static void initCaches() {
		QuestionDto q = new QuestionDto();
		q.setId(17);
		q.setQuestion("Wie zufrieden warst du ...");
		q.setTitle("Zufriedenheit");
		MapCache.getQuestionCache().put(q.getId(), q);
		
		AnswerDto answer = new AnswerDto();
		answer.setId(19);
		answer.setDate(new Date());
		answer.setNote("blablubb");
		answer.setValue(5);
		q.addAnswer(answer);
		MapCache.getAnswerCache().put(answer.getId(), answer);
	}

}
