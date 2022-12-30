package de.bushnaq.abdalla.song.master.timeline;

import java.io.File;
import java.util.Calendar;

import de.bushnaq.abdalla.song.master.util.Util;

public class Song extends MyPeriod {
	public Album	album;
	public String	genre;
	public String	name;
	public String	track;
	String			url;
	int				y;

	public Song(Album album, String name, Calendar start, String url) {
		super(start, start);
		this.album = album;
		this.name = name;
		this.url = url;
	}

	public Song(Album album, String name, String genre, Calendar start, Calendar end, String url) {
		super(start, end);
		this.album = album;
		this.name = name;
		this.genre = genre;
		this.url = url;
	}

	public String generateAlbumeName() {
		String albumName = album.name;
		albumName = Util.prepareAlbumName(albumName);
		return albumName;
	}

	public String generateMessage(String string) {
		String	albumName		= generateAlbumeName();
		String	subalbumName	= generateSubalbumeName();
		String	songName		= generateSongName();
		if (subalbumName != null)
			if (string != null && string.length() != 0)
				return String.format("%41s - %4s - %s (%s)", albumName, subalbumName, songName, string);
			else
				return String.format("%41s - %4s - %s.", albumName, subalbumName, songName);
		else if (string != null && string.length() != 0)
			return String.format("%48s - %s (%s)", albumName, songName, string);
		else
			return String.format("%48s - %s.", albumName, songName);
	}

	public File generateSongFile(String root, String extension) {
		String songName = generateSongName();
		return generateSongFile(root, songName, extension);
	}

	public File generateSongFile(String root, String songName, String extension) {
		return new File(generateSongFileName(root, songName, extension));
	}

	public String generateSongFileName(String root, String extension) {
		String songName = generateSongName();
		return generateSongFileName(root, songName, extension);
	}

	public String generateSongFileName(String root, String songName, String extension) {
		String	albumName		= generateAlbumeName();
		String	subalbumName	= generateSubalbumeName();
		String	path;
		if (subalbumName != null)
			path = root + "/" + albumName + "/" + subalbumName + "/" + songName + "." + extension;
		else
			path = root + "/" + albumName + "/" + songName + "." + extension;
		return path;
	}

	public String generateSongName() {
		String songName;
		if (album.songsAreNumbered) {
			songName = String.format("%s", name);
		} else {
			songName = String.format("%s-%s", track, name);
		}
		songName = songName.toLowerCase();
		songName = Util.prepareSongName(songName);
		return songName;
	}

	public String generateSubalbumeName() {
		String subalbumName = album.subname;
		subalbumName = Util.prepareAlbumName(subalbumName);
		return subalbumName;
	}

	public void logMessage(String string) {
		System.out.println(generateMessage(string));
	}

}
