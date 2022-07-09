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
		q.setQuestion("Wie zufrieden warst du mit deinen Aufgaben im letzten Sprint?");
		q.setTitle("Zufriedenheit");
		MapCache.getQuestionCache().put(q.getId(), q);

		AnswerDto answer1 = new AnswerDto();
		answer1.setId(18);
		answer1.setDate(new Date(System.currentTimeMillis()-72*60*60*1000));
		answer1.setNote("Summ Summ Summ, der Kollege");
		answer1.setValue(3);
		q.addAnswer(answer1);

		AnswerDto answer2 = new AnswerDto();
		answer2.setId(18);
		answer2.setDate(new Date(System.currentTimeMillis()-48*60*60*1000));
		answer2.setNote("Summ Summ Summ, der Kollege");
		answer2.setValue(5);
		q.addAnswer(answer2);

		AnswerDto answer3 = new AnswerDto();
		answer3.setId(19);
		answer3.setDate(new Date(System.currentTimeMillis()-24*60*60*1000));
		answer3.setNote("Summ Summ Summ, der Kollege macht mich dumm");
		answer3.setValue(4);
		q.addAnswer(answer3);

		MapCache.getAnswerCache().put(answer1.getId(), answer1);
		MapCache.getAnswerCache().put(answer2.getId(), answer2);
		MapCache.getAnswerCache().put(answer3.getId(), answer3);
	}

}
