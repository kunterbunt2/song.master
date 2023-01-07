package de.bushnaq.abdalla.song.master;

import java.io.File;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import de.bushnaq.abdalla.song.master.timeline.Album;
import de.bushnaq.abdalla.song.master.timeline.AlbumList;
import de.bushnaq.abdalla.song.master.timeline.Song;
import de.bushnaq.abdalla.song.master.timeline.Timeline;
import de.bushnaq.abdalla.song.master.util.Util;

@Component
@Scope("prototype")
public class SongMaster {
	private AlbumList	albumList	= new AlbumList();
	@Value("${song.master.audio.directory}")
	private String		audioDirectory;
	@Value("${song.master.generate.mp4}")
	private boolean		generateMp4;
	@Value("${song.master.generate.wave.png}")
	private boolean		generateWavePng;
	@Value("${song.master.handle.mp3}")
	private boolean		handleMp3;
	@Value("${song.master.html.directory}")
	private String		htmlDirectory;
	@Value("${song.master.image.directory}")
	private String		imageDirectory;

	public Map<String, String> generateMap(String directory, String exclude, String extension) {
		Map<String, String>	songMap		= new HashMap<>();
		File[]				allFiles	= Util.queryAllFiles(directory, exclude, extension);
		for (File f : allFiles) {
			String songName = f.getName();
			songName = Util.removeExtension(songName);
			songName = Util.prepareSongName(songName);
			songMap.put(songName, songName);
		}
		return songMap;
	}

	public Map<String, String> generateMp3Map(String directory) {
		return generateMap(directory, "00-The_Lost_Tapes", ".mp3");
	}

	public Map<String, String> generateWaveMap(String directory) {
		return generateMap(directory, "", ".wav");
	}

	private void handleAllSongs(String audioDirectory) throws Exception {
		albumList.sort(Comparator.comparing(Album::getName));
		for (Album album : albumList) {
			for (Song song : album.list) {
//				if (album.name.equals("01-Recreation of a knowledge seeking mind"))
				handleSong(audioDirectory, song);
			}
		}
	}

	private void handleSong(String audioDirectory, Song song) throws Exception {
		song.logMessage("");
		if (handleMp3)
			new Mp3(audioDirectory).updateMp3(song);
		if (generateWavePng)
			new WavePng(audioDirectory).generate(song);
		if (generateMp4)
			new Mp4(audioDirectory).generate(song);
	}

	void start() throws Exception {
		testAllSongsInAlbumeListExistOnHdd(audioDirectory);
		testAllSongsOnHddExistInAlbumList(audioDirectory);
		handleAllSongs(audioDirectory);

		{
			System.out.println("/*-----------------------------------------------------------------");
			System.out.println("* generate the map files");
			System.out.println("-----------------------------------------------------------------*/");
			{
				// all songs in one map
				Timeline timeline = new Timeline();
				timeline.generateMetaAlbumMap(htmlDirectory, imageDirectory);
			}
			{
				// all albums in one map
				Timeline timeline = new Timeline();
				timeline.generateAlbumMap(htmlDirectory, imageDirectory);
			}
			for (Album album : albumList) {
				// all songs of one album
				Timeline	timeline	= new Timeline();
				String		albumName	= album.name;
				String		subName		= album.subname;
				timeline.generateSongMaps(album, audioDirectory, albumName, subName, htmlDirectory, imageDirectory);
			}
			{
				Timeline timeline = new Timeline();
				timeline.generateStatistics(audioDirectory);
			}
			CommandExecuter.close();
			System.out.println("success");
		}
	}

	/**
	 * check if all songs in the album list exist on hard disk
	 *
	 * @param audioDirectory
	 * @throws Exception
	 */
	private void testAllSongsInAlbumeListExistOnHdd(String audioDirectory) throws Exception {
		{
//			System.out.println("/*-----------------------------------------------------------------");
			System.out.println("test if all songs in the album list exist on HDD");
//			System.out.println("-----------------------------------------------------------------*/");
//			Map<String, String>	wavMap	= generateWaveMap(audioDirectory);
			Map<String, String> mp3Map = generateMp3Map(audioDirectory);
//			String				root	= audioDirectory;
			albumList.sort(Comparator.comparing(Album::getName));
			for (Album album : albumList) {
				String albumName = album.name;
				albumName = Util.prepareAlbumName(albumName);
				String subalbumName = album.subname;
				subalbumName = Util.prepareAlbumName(subalbumName);
				// System.out.println(album.name);
				int id = 1;
				for (Song song : album.list) {
					String songName;
					if (album.songsAreNumbered) {
						songName = String.format("%s", song.name);
					} else {
						songName = String.format("%02d-%s", id, song.name);
					}
					songName = songName.toLowerCase();
					songName = Util.prepareSongName(songName);
					// System.out.println(String.format("\t %s", songName));
					id++;
//					if (!waveFileExists(root, albumName, subalbumName, songName))
//						throw new Exception(String.format("missing song on HDD '%s/%s/%s/%s.wav'", root, albumName, subalbumName, songName));
//					if (wavMap.get(songName) == null)
//						throw new Exception(String.format("missing song in catalog '%s/%s/%s'", albumName, subalbumName, songName + ".wav"));
					if (mp3Map.get(songName) == null)
						throw new Exception(song.generateMessage("missing song in catalog"));
				}
			}
//			System.out.println("Success");
		}
	}

	/**
	 * Test if all songs on hard disk exist in the album list
	 *
	 * @param audioDirectory
	 * @throws Exception
	 */
	private void testAllSongsOnHddExistInAlbumList(String audioDirectory) throws Exception {
		{
//			System.out.println("/*-----------------------------------------------------------------");
			System.out.println("test if songs on HDD exist in the album list");
//			System.out.println("-----------------------------------------------------------------*/");

			Map<String, String>	albumListMap	= albumList.generateMap();
			File[]				allFiles		= Util.queryAllFiles(audioDirectory, "00-The_Lost_Tapes", ".mp3");
			for (int i = 0; i < allFiles.length; i++) {
				File	file		= allFiles[i];
				String	songName	= file.getName();
				String	albumName	= file.getAbsolutePath();
				albumName = albumName.substring(0, albumName.lastIndexOf(songName) - 1);
				albumName = albumName.substring(albumName.lastIndexOf('\\') + 1, albumName.length());

				songName = Util.removeExtension(songName);
				songName = Util.prepareSongName(songName);
				if (albumListMap.get(songName) == null)
					throw new Exception(String.format("missing song in album list '%s/%s'", albumName, songName));
			}
//			System.out.println("Success");
		}
	}

}
