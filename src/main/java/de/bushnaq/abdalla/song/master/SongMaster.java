package de.bushnaq.abdalla.song.master;

import java.io.File;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import de.bushnaq.abdalla.song.master.timeline.Album;
import de.bushnaq.abdalla.song.master.timeline.AlbumList;
import de.bushnaq.abdalla.song.master.timeline.Song;
import de.bushnaq.abdalla.song.master.timeline.Timeline;
import de.bushnaq.abdalla.song.master.util.Util;

public class SongMaster {

	public static void main(String[] args) throws Exception {
		SongMaster main = new SongMaster();
		main.start();
	}

	AlbumList albumList = new AlbumList();

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
		new Mp3(audioDirectory).updateMp3(song);
		new WavePng(audioDirectory).generate(song);
		new Mp4(audioDirectory).generate(song);
	}

	private void start() throws Exception {
		String	audioDirectory	= "C:/data/abdalla.bushnaq.de/sites/fileadmin/audio";
		String	imageDirectory	= "C:/data/abdalla.bushnaq.de/sites/fileadmin/images";
		String	htmlDirectory	= "C:/data/abdalla.bushnaq.de/sites/fileadmin/html";
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
			Map<String, String>	wavMap	= generateWaveMap(audioDirectory);
			Map<String, String>	mp3Map	= generateMp3Map(audioDirectory);
			String				root	= audioDirectory;
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
