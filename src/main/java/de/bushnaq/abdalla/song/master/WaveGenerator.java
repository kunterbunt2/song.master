package de.bushnaq.abdalla.song.master;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import de.bushnaq.abdalla.song.master.util.Util;
import phonecs.WavFile;
import phonecs.WavFileException;

public class WaveGenerator {
	// light color
	// private Color backgroundColor = new Color(0xffffff);
	// private Color upperBarColor = new Color(0x8c8c8c);
	// private Color upperSeparatorColor = new Color(0xd8d8d8);
	// private Color lowerBarColor = new Color(0xc5c5c5);
	// private Color lowerSeparatorColor = new Color(0xffffff);
	// private Color textColor = new Color(0xd8d8d8);
	// private Color textBackgroundColor = Color.black;
	// private Color nameTextColor=Color.red;
	// dark color
	private Color	backgroundColor		= new Color(0x191919);
	Graphics2D		graphics;
	BufferedImage	image;
	int				imageHeight			= 84;
	int				imageWidth			= 950;
	private Color	lowerBarColor		= new Color(0x555555);
	private Color	lowerSeparatorColor	= new Color(0x202020);
	Font			monthFont			= new Font("Arial", Font.PLAIN, 10);
	private Color	nameTextColor		= new Color(0x48a0f7);
	private Color	textBackgroundColor	= Color.black;
	private Color	textColor			= new Color(0x48a0f7);				// new Color(0xd8d8d8);
	private Color	upperBarColor		= new Color(0xc0c0c0);

	private Color	upperSeparatorColor	= new Color(0x282828);

	private void drawLowerBar(int x, int cy, int y) {
		// y = y*2 / 5;
		graphics.setColor(lowerBarColor);
		graphics.drawLine(x, cy, x, cy + y);
		graphics.drawLine(x + 1, cy, x + 1, cy + y);
		graphics.setColor(lowerSeparatorColor);
		graphics.drawLine(x + 2, cy, x + 2, cy + y);
	}

	private void drawUpperBar(int x, int cy, int y) {
		graphics.setColor(upperBarColor);
		graphics.drawLine(x, cy, x, cy + y);
		graphics.drawLine(x + 1, cy, x + 1, cy + y);
		graphics.setColor(upperSeparatorColor);
		graphics.drawLine(x + 2, cy, x + 2, cy + y);
	}

	private void generateLength(int cy, WavFile wavFile) {
		graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		graphics.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
		graphics.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		long	seconds		= wavFile.getNumFrames() / wavFile.getSampleRate();
		String	SongLength	= Util.formatDuration(seconds);
		graphics.setFont(monthFont);
		int	width	= graphics.getFontMetrics().stringWidth(SongLength) + 4;
		int	x		= imageWidth - width;
		int	height	= graphics.getFontMetrics().getHeight() + 1;
		// int y = cy;
		int	y		= height;
		graphics.setColor(textBackgroundColor);
		graphics.fillRect(x, y - height, width, height);
		graphics.setColor(textColor);
		// graphics.drawString(SongLength, imageWidth - width + 2, cy - 3);
		graphics.drawString(SongLength, imageWidth - width + 2, y - 4);
	}

	private void generateName(String name) {
		graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		graphics.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
		graphics.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		graphics.setFont(monthFont);
		// int width = graphics.getFontMetrics().stringWidth(name) + 4;
		int	x		= 0;
		int	y		= 0;
		int	height	= graphics.getFontMetrics().getHeight() + 1;
		// graphics.setColor(Color.black);
		// graphics.fillRect(x, y, width, height);
		graphics.setColor(nameTextColor);
		graphics.drawString(name, x + 2, y + height - 4);
	}

	void generateWaveShape(File file) throws IOException, WavFileException {

		WavFile wavFile = WavFile.openWavFile(file);
		wavFile.display();
		long numFrames = wavFile.getNumFrames();
		System.out.println("getNumFrames " + numFrames);
		// Get the number of audio channels in the wav file
		int	numChannels		= wavFile.getNumChannels();
		int	sampleSize		= wavFile.getValidBits();
		int	samplesPerPixel	= (int) ((numFrames) / (imageWidth / 3 + 1));

		image = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_ARGB);
		graphics = image.createGraphics();
		graphics.setColor(backgroundColor);
		graphics.fillRect(0, 0, imageWidth, imageHeight);
		int		cy				= 10 * imageHeight / 14;
		int		c				= 0;
		// graphics.setColor(Color.red);
		int		maxAmplitude	= (int) Math.pow(2, sampleSize - 1);

		int[][]	buffer			= new int[numChannels][samplesPerPixel];

		for (int x = 0; x < imageWidth; x += 3) {
			// Create a buffer of 100 frames
			int		framesRead;
			long	min	= Integer.MAX_VALUE;
			long	max	= Integer.MIN_VALUE;

			// Read frames into buffer
			framesRead = wavFile.readFrames(buffer, samplesPerPixel);
			// Loop through frames and look for minimum and maximum value
			for (int s = 0; s < framesRead; s++) {
				if (buffer[c][s] > max)
					max = buffer[c][s];
				if (buffer[c][s] < min)
					min = buffer[c][s];

			}
			int ly = (int) ((min * 10 * imageHeight / 14) / maxAmplitude);

			// System.out.println(String.format("%d %d %d %d", x, ly, min, max));
			drawUpperBar(x, cy - 1, ly);
			ly = (int) ((max * 4 * imageHeight / 14) / maxAmplitude);
			drawLowerBar(x, cy + 1, ly);
		}

		generateLength(cy, wavFile);
		generateName(Util.removeExtension(Util.cleanupSongName(file.getName())));
		wavFile.close();
		try {
			// retrieve image
			String	imageFileName	= Util.removeExtension(file.getAbsolutePath()) + "-wave.png";
			File	outputfile		= new File(imageFileName);
			ImageIO.write(image, "png", outputfile);
		} catch (IOException e) {
			System.out.println(e);
		}
	}

//	public long querySongLength(File file) throws IOException, WavFileException {
//		WavFile	wavFile	= WavFile.openWavFile(file);
//		long	seconds	= wavFile.getNumFrames() / wavFile.getSampleRate();
//		return seconds;
//	}

}
