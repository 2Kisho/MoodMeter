package de.ziczack.MoodMeter.rest.cache;

import java.util.HashMap;
import java.util.Map;

import de.ziczack.MoodMeter.rest.dto.AnswerDto;
import de.ziczack.MoodMeter.rest.dto.QuestionDto;

public class MapCache {

	private static final HashMap<Long, AnswerDto> answerCache = new HashMap<>();
	private static final HashMap<Long, QuestionDto> questionCache = new HashMap<>();
	
	public static Map<Long, AnswerDto> getAnswerCache() {
		return answerCache;
	}
	
	public static Map<Long, QuestionDto> getQuestionCache() {
		return questionCache;
	}
}
