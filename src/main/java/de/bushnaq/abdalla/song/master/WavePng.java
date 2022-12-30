package de.bushnaq.abdalla.song.master;

import java.io.File;

import de.bushnaq.abdalla.song.master.timeline.Song;

public class WavePng {

	private String audioDirectory;

	public WavePng(String audioDirectory) {
		this.audioDirectory = audioDirectory;
	}

	public void generate(Song song) throws Exception {
		String	songName	= song.generateSongName();

		File	wavPngFile	= song.generateSongFile(audioDirectory, songName + "-wave", "png");
		File	wavFile		= song.generateSongFile(audioDirectory, "wav");
		File	mp3File		= song.generateSongFile(audioDirectory, "mp3");
		if (Utils.newerThan(mp3File, wavPngFile)) {
			generateWave(audioDirectory, song);
			song.logMessage("generating -wave.png for song");
			WaveGenerator wg = new WaveGenerator();
			wg.generateWaveShape(wavFile);
		}
		if (wavFile.exists())
			wavFile.delete();
	}

	private void generateWave(String audioDirectory, Song song) throws Exception {
		boolean	generateWaveFile	= false;
		File	wavFile				= song.generateSongFile(audioDirectory, "wav");
		if (!wavFile.exists()) {
			// .wav file is missing
			generateWaveFile = true;
		} else {
			File mp3File = song.generateSongFile(audioDirectory, "mp3");
			if (Utils.newerThan(mp3File, wavFile)) {
				// .wav file is older than mp3 file
				generateWaveFile = true;
			}
		}
		if (generateWaveFile) {
			song.logMessage("generating .wav for song");
			String	mp3FileName	= song.generateSongFileName(audioDirectory, "mp3");
			String	wavFileName	= song.generateSongFileName(audioDirectory, "wav");
			{
				String[] command = { "ffmpeg", "-y", "-i", mp3FileName, wavFileName };
				CommandExecuter.execute(command);
			}

		}
	}

}
