package de.ziczack.MoodMeter.entity;

import java.util.Date;

public class Day implements Identifiable {

	private final long id;
	private final Date genDat;
	
	public Day(long id, Date genDat) {
		this.id = id;
		this.genDat = genDat;
	}

	@Override
	public long getId() {
		return id;
	}
}
