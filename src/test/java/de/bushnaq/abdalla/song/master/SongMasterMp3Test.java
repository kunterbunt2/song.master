package de.bushnaq.abdalla.song.master;

import java.io.IOException;

import org.junit.Test;

import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.Mp3File;
import com.mpatric.mp3agic.UnsupportedTagException;

import phonecs.WavFileException;

public class SongMasterMp3Test {

	@Test
	public void test() throws IOException, WavFileException, UnsupportedTagException, InvalidDataException {
		// SongMaster main = new SongMaster();
		String	song		= "C:/data/abdalla.bushnaq.de/sites/fileadmin/audio/10-The Vast/01.morning.wav";
		Mp3File	mp3file		= new Mp3File(song);
		long	numFrames	= mp3file.getFrameCount();
		System.out.println("getNumFrames " + numFrames);
		// Get the number of audio channels in the wav file
		// int numChannels = wavFile.getNumChannels();
		// int sampleSize = mp3file.wavFile.getValidBits();
		// int samplesPerPixel = (int) ((numFrames) / (imageWidth / 3 + 1));
	}

}
