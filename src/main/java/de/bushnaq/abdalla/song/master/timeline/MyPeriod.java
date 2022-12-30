package de.bushnaq.abdalla.song.master.timeline;

import java.util.Calendar;
import java.util.Date;

public class MyPeriod {
	public Date	end			= null;
	public Date	firstEnd	= null;
	public Date	lastStart	= null;
	public Date	start		= null;

	public MyPeriod() {
	}

	public MyPeriod(Calendar start, Calendar end) {
		this.start = start.getTime();
		this.end = end.getTime();
	}

	public Date getEnd() {
		return end;
	}

	public Date getStart() {
		return start;
	}

}
