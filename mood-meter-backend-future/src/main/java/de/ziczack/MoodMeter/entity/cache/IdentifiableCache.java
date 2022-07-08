package de.ziczack.MoodMeter.entity.cache;

import java.util.HashMap;
import java.util.Map;

import de.ziczack.MoodMeter.entity.Identifiable;

public class IdentifiableCache<T extends Identifiable> {

	private final Map<Long, T> cache = new HashMap<>();
	
	
	public void put(T i) {
		cache.put(i.getId(), i);
	}
	
	public void delete(long id) {
		cache.remove(id);
	}
	
	public T get(long id) {
		return cache.get(id);
	}
}
