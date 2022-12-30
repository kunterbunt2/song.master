package de.bushnaq.abdalla.song.master;

import java.io.File;
import java.util.Calendar;
import java.util.GregorianCalendar;

import com.mpatric.mp3agic.ID3v1;
import com.mpatric.mp3agic.ID3v1Genres;
import com.mpatric.mp3agic.ID3v2;
import com.mpatric.mp3agic.Mp3File;

import de.bushnaq.abdalla.song.master.timeline.Song;

public class Mp3 {
	private static final String	MP3_META_DATA_ALBUM_ARTIST	= "Abdalla Bushnaq";
	private static final String	MP3_META_DATA_ARTIST		= "Abdalla Bushnaq";
	private static final String	MP3_META_DATA_COMPOSER		= "Abdalla Bushnaq";

	private String				audioDirectory;

	public Mp3(String audioDirectory) {
		this.audioDirectory = audioDirectory;
	}

	void updateMp3(Song song) throws Exception {
		Calendar releaseDate = new GregorianCalendar();
		releaseDate.setTime(song.end);

		String	mp3FileName			= song.generateSongFileName(audioDirectory, "mp3");
		String	imageFileName		= song.generateSongFileName(audioDirectory, "png");
		String	temp1Mp3FileName	= song.generateSongFileName(audioDirectory, "temp1", "mp3");
		Mp3File	mp3file				= new Mp3File(mp3FileName);
		boolean	coverArtExists		= true;
		boolean	metadataExists		= true;

		if (mp3file.hasId3v1Tag()) {
			ID3v1	id3v1Tag	= mp3file.getId3v1Tag();
			String	year		= id3v1Tag.getYear();
			if (year == null || !year.equals("" + releaseDate.get(Calendar.YEAR))) {
				metadataExists = false;
				song.logMessage(String.format("mismatching year detected in mp3 file, expected %s found %s", "" + releaseDate.get(Calendar.YEAR), year));
			}
		}
		if (mp3file.hasId3v2Tag()) {
			ID3v2	id3v2Tag	= mp3file.getId3v2Tag();
			byte[]	albumImage	= id3v2Tag.getAlbumImage();
			if (albumImage == null || albumImage.length == 0) {
				coverArtExists = false;
			}
			String title = id3v2Tag.getTitle();
			if (title == null || !title.equals(song.name)) {
				metadataExists = false;
				song.logMessage(String.format("mismatching title detected in mp3 file, expected %s found %s", song.name, title));
			}
			String artist = id3v2Tag.getArtist();
			if (artist == null || !artist.equals(MP3_META_DATA_ARTIST)) {
				metadataExists = false;
				song.logMessage(String.format("mismatching artist detected in mp3 file, expected %s found %s", MP3_META_DATA_ARTIST, artist));
			}
			String albumArtist = id3v2Tag.getAlbumArtist();
			if (albumArtist == null || !albumArtist.equals(MP3_META_DATA_ALBUM_ARTIST)) {
				metadataExists = false;
				song.logMessage(String.format("mismatching album artist detected in mp3 file, expected %s found %s", MP3_META_DATA_ALBUM_ARTIST, albumArtist));
			}
			String composer = id3v2Tag.getComposer();
			if (composer == null || !composer.equals(MP3_META_DATA_COMPOSER)) {
				metadataExists = false;
				song.logMessage(String.format("mismatching composer detected in mp3 file, expected %s found %s", MP3_META_DATA_COMPOSER, composer));
			}
			String album = id3v2Tag.getAlbum();
			if (album == null || !album.equals(song.album.getName())) {
				metadataExists = false;
				song.logMessage(String.format("mismatching album detected in mp3 file, expected %s found %s", song.album.getName(), album));
			}
			String track = id3v2Tag.getTrack();
			if (track == null || !track.equals(song.track)) {
				metadataExists = false;
				song.logMessage(String.format("mismatching track detected in mp3 file, expected %s found %s", song.track, track));
			}
			int genre = id3v2Tag.getGenre();
			if (genre != ID3v1Genres.matchGenreDescription(song.genre)) {
				metadataExists = false;
				song.logMessage(String.format("mismatching genre detected in mp3 file, expected %d found %d", ID3v1Genres.matchGenreDescription(song.genre), genre));
			}
		}
		if (!coverArtExists) {
			song.logMessage("assign cover art to mp3 file");
			String[] command = { "ffmpeg", "-y", "-i", mp3FileName, "-i", imageFileName, "-c", "copy", "-map", "0", "-map", "1", temp1Mp3FileName };
			CommandExecuter.execute(command);
			Utils.copyFile(temp1Mp3FileName, mp3FileName);
			new File(temp1Mp3FileName).delete();
		}
		if (!metadataExists) {
			song.logMessage("assign metatags to mp3 file");
//			String[] command = { "ffmpeg", "-y", "-i", mp3FileName, "-c", "copy", //
//					"-map_metadata", "-1", // remove all metadata
//					"-metadata", "title=" + song.name, //
//					"-metadata", "artist=Abdalla Bushnaq", //
//					"-metadata", "album_artist=Abdalla Bushnaq", //
//					"-metadata", "composer=Abdalla Bushnaq", //
//					"-metadata", "album=" + song.album.getName(), //
//					"-metadata", "date=" + releaseDate.get(Calendar.YEAR), //
//					"-metadata", "track=" + song.track, //
//					"-metadata", "genre=" + song.genre, //
//					temp1Mp3FileName };
//			CommandExecuter.execute(command);
			ID3v1 id3v1Tag = mp3file.getId3v1Tag();
			id3v1Tag.setYear("" + releaseDate.get(Calendar.YEAR));
			ID3v2 id3v2Tag = mp3file.getId3v2Tag();
			id3v2Tag.setTitle(song.name);
			id3v2Tag.setArtist(MP3_META_DATA_ARTIST);
			id3v2Tag.setAlbumArtist(MP3_META_DATA_ALBUM_ARTIST);
			id3v2Tag.setComposer(MP3_META_DATA_COMPOSER);
			id3v2Tag.setAlbum(song.album.getName());
			id3v2Tag.setTrack(song.track);
			id3v2Tag.setGenre(ID3v1Genres.matchGenreDescription(song.genre));

			mp3file.save(temp1Mp3FileName);
			Utils.copyFile(temp1Mp3FileName, mp3FileName);
			new File(temp1Mp3FileName).delete();
		}
	}

}
