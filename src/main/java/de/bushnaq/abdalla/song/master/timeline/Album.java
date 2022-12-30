package de.bushnaq.abdalla.song.master.timeline;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class Album extends MyPeriod {
	public Color		color;
	public int			id;
	public List<Song>	list						= new ArrayList<>();
	public String		name;
	public boolean		replaceSpaceWithUnderscore	= true;

	public boolean		songsAreNumbered			= false;

	public String		subname;
	public String		url;

	public Album(String name, String url) {
		this.name = name;
		this.url = url;
	}

	public Album(String name, String url, boolean songsAreNumbered, boolean replaceSpaceWithUnderscore) {
		this.name = name;
		this.url = url;
		this.songsAreNumbered = songsAreNumbered;
		this.replaceSpaceWithUnderscore = replaceSpaceWithUnderscore;
	}

	public Album(String name, String subname, String url, boolean songsAreNumbered, boolean replaceSpaceWithUnderscore) {
		this.name = name;
		this.subname = subname;
		this.url = url;
		this.songsAreNumbered = songsAreNumbered;
		this.replaceSpaceWithUnderscore = replaceSpaceWithUnderscore;
	}

	public void add(Song song) {
		song.track = String.format("%02d", list.size() + 1);
		list.add(song);
	}

	public void calculateStartAndEnd() {
		start = new GregorianCalendar(2050, Calendar.JANUARY, 01).getTime();
		end = new GregorianCalendar(1900, Calendar.DECEMBER, 01).getTime();
		lastStart = new GregorianCalendar(1900, Calendar.DECEMBER, 01).getTime();
		firstEnd = new GregorianCalendar(2050, Calendar.JANUARY, 01).getTime();

		for (Song song : list) {
			if (song.start.getTime() < start.getTime())
				start = (Date) song.start.clone();
			if (song.end.getTime() > end.getTime())
				end = (Date) song.end.clone();

			if (song.start.getTime() > lastStart.getTime())
				lastStart = (Date) song.start.clone();
			if (song.end.getTime() < firstEnd.getTime())
				firstEnd = (Date) song.end.clone();
		}
		// SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
		// System.out.println(name);
		// System.out.println(formatter.format(start.getTime()));
		// System.out.println(formatter.format(end.getTime()));
	}

	public String getName() {
		return name;
	}

	public String getSubname() {
		return subname;
	}

}
