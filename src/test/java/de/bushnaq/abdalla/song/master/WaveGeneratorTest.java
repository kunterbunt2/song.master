package de.bushnaq.abdalla.song.master;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

import phonecs.WavFileException;

public class WaveGeneratorTest {

	@Test
	public void test() throws IOException, WavFileException {
		WaveGenerator	wg		= new WaveGenerator();
		String			song	= "C:/data/abdalla.bushnaq.de/sites/fileadmin/audio/10-The_Vast/05-massive.wav";
		File			file	= new File(song);
		wg.generateWaveShape(file);
	}

}
