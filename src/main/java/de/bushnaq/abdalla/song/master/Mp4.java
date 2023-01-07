package de.bushnaq.abdalla.song.master;

import java.io.File;
import java.util.Calendar;
import java.util.GregorianCalendar;

import de.bushnaq.abdalla.song.master.timeline.Song;

public class Mp4 {

	private String audioDirectory;

	public Mp4(String audioDirectory) {
		this.audioDirectory = audioDirectory;
	}

	public void generate(Song song) throws Exception {
		Calendar releaseDate = new GregorianCalendar();
		releaseDate.setTime(song.end);
		boolean	generateMp4File	= false;

		File	mp4File			= song.generateSongFile(audioDirectory, "mp4");
		if (!mp4File.exists()) {
			// .mp4 file is missing
			generateMp4File = true;
		} else {
			File mp3File = song.generateSongFile(audioDirectory, "mp3");
			if (Utils.newerThan(mp3File, mp4File)) {
				// .mp4 file is older than mp3 file
				generateMp4File = true;
			}
		}
//		{
//			String[] command = { "ffmpeg", "-encoders" };
//			CommandExecuter.execute(command);
//		}

//		{
//			String	mp3FileName			= song.generateSongFileName(audioDirectory, "mp3");
//			IsoFile	isoFile				= new IsoFile(mp4File);
//			long	mp4LengthInSeconds	= (isoFile.getMovieBox().getMovieHeaderBox().getDuration()) / isoFile.getMovieBox().getMovieHeaderBox().getTimescale();
//			Mp3File	mp3file				= new Mp3File(mp3FileName);
//			long	mp3LengthInnSeconds	= mp3file.getLengthInSeconds();
//			if (mp4LengthInSeconds != mp3LengthInnSeconds)
//				generateMp4File = true;
//			isoFile.close();
//		}
		if (generateMp4File) {
			String	mp3FileName			= song.generateSongFileName(audioDirectory, "mp3");
			String	imageFileName		= song.generateSongFileName(audioDirectory, "png");
			String	temp2Mp4FileName	= song.generateSongFileName(audioDirectory, "temp2", "mp4");
			String	mp4FileName			= song.generateSongFileName(audioDirectory, "mp4");
			song.logMessage("generating video for song");
			{
				String[] command = { "ffmpeg", "-y", "-loop", "1", "-i", imageFileName, "-i", mp3FileName, "-c:v", "libx264", "-tune", "stillimage", "-c:a", "aac", "-b:a", "192k", "-pix_fmt", "yuv420p", "-shortest",
						mp4FileName };
				CommandExecuter.execute(command);
			}
			song.logMessage("assign metatags to mp4 file");
			{
				String[] command = { "ffmpeg", "-y", "-i", mp4FileName, "-c", "copy", //
						"-map_metadata", "-1", // remove all metadata
						"-metadata", "title=" + song.name, //
						"-metadata", "artist=Abdalla Bushnaq", //
						"-metadata", "album_artist=Abdalla Bushnaq", //
						"-metadata", "composer=Abdalla Bushnaq", //
						"-metadata", "album=" + song.album.getName(), //
						"-metadata", "year=\"" + releaseDate.get(Calendar.YEAR) + "\"", //
						"-metadata", "track=" + song.track, //
						"-metadata", "genre=" + song.genre, //
						temp2Mp4FileName };
				CommandExecuter.execute(command);
				Utils.copyFile(temp2Mp4FileName, mp4FileName);
				new File(temp2Mp4FileName).delete();
			}
		}
	}

}
