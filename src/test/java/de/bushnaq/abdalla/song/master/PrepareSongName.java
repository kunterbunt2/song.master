package de.bushnaq.abdalla.song.master;

import java.io.File;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import de.bushnaq.abdalla.song.master.util.Util;

@SpringBootTest
@ContextConfiguration(classes = Application.class)
public class PrepareSongName {
	@Value("${song.master.filter.directory}")
	private String filterDirectory;

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
		prepareExtension(folder, filterDirectory, ".mp3");
		prepareExtension(folder, "", ".wav");
		prepareExtension(folder, "", ".png");
	}

}
