package de.bushnaq.abdalla.song.master;

import java.io.File;

import org.junit.Test;

import de.bushnaq.abdalla.song.master.util.Util;

public class PrepareSongName {

	private void prepareExtension(String folder, String exclude, String extension) throws Exception {
		File[] allFiles = Util.queryAllFiles(folder, exclude, extension);
		for (File f : allFiles) {
			String	songPath	= f.getParent();
			String	songName	= f.getName();
			songName = songName.toLowerCase();
			songName = Util.prepareSongName(songName);
			File newFile = new File(songPath + "/" + songName);
			if (f.getAbsoluteFile().renameTo(newFile)) {

			} else {
				throw new Exception(String.format("renaming %s to %s failed", f.getAbsoluteFile(), newFile.getAbsoluteFile()));
			}
		}
	}

	@Test
	public void test() throws Exception {
		String folder = "C:/data/abdalla.bushnaq.de/sites/fileadmin/audio/12-The_White_Elefant";
		prepareExtension(folder, "00-The_Lost_Tapes", ".mp3");
		prepareExtension(folder, "", ".wav");
		prepareExtension(folder, "", ".png");
	}

}
