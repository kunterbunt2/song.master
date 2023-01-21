package de.bushnaq.abdalla.song.master.timeline;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.geom.CubicCurve2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.mpatric.mp3agic.Mp3File;

import de.bushnaq.abdalla.song.master.util.Util;

@Component
@Scope("prototype")
public class Timeline {
	private static final int			CALENDAR_BUTTOM_SLACK		= 250;
	private static final int			CALENDAR_TOP_SLACK			= 150;
	private static final Color			COLOR_DARK_CYAN				= new Color(0x48a0f7);
	private static final Color			COLOR_DARK_GRAY				= new Color(64, 64, 64);
	private static final Color			COLOR_DARK_ORANGE			= new Color(238, 124, 8);
	private static final long			ONE_DAY_MILLIS				= 1000 * 60 * 60 * 24;
	private static final long			ONE_MONTH_MILLLI_SECONDS	= 1000 * 60 * 60 * 24 * 31l;
	private static final int			SONG_DISTANCE				= 128;
	BufferedImage						aImage;
	Font								albumFont					= new Font("Arial", Font.PLAIN, zoom(64));
	int									albumHeight;
	int									calendarX					= 84;
	private boolean						debug						= false;
	@Value("${song.master.filter.directory}")
	private String						filterDirectory;
	Graphics2D							graphics;
	int									imageHeight;
	@Value("${song.master.image.root.url}")
	private String						imageRootUrl;
	int									imageWidth					= 500;
	private Map<Integer, List<Album>>	laneToAlbumMap				= new TreeMap<>();
	private Map<Integer, List<Song>>	laneToSongMap				= new TreeMap<>();
	Font								monthFont					= new Font("Arial", Font.BOLD, zoom(12));
	int									monthHeight;
	Font								songFont					= new Font("Arial", Font.PLAIN, zoom(14));
	int									songHeight;
	PrintWriter							writer;
	Font								yearFont					= new Font("Arial", Font.BOLD, zoom(64));
	int									yearHeight;
	private float						zoom						= 4;

	<T extends Comparable<? super T>> List<T> asSortedList(Collection<T> c) {
		List<T> list = new ArrayList<>(c);
		java.util.Collections.sort(list);
		return list;
	}

	private int calculateEndY(int y, Album album, AlbumList albumList) {
		return y - (int) ((((album.end.getTime()) - albumList.start.getTime()) / ONE_DAY_MILLIS) / getZoom());
	}

	private int calculateStartY(int y, Album album, AlbumList albumList) {
		return y - (int) (((album.start.getTime() - albumList.start.getTime()) / ONE_DAY_MILLIS) / getZoom());
	}

	private void clear() {
		laneToAlbumMap.clear();
		laneToSongMap.clear();
	}

	private void copyToMetaAlbum(AlbumList albumList, Album metaAlbum) {
		for (Album album : albumList) {
			album.list.sort(Comparator.comparing(Song::getEnd));
			for (Song song : album.list) {
				metaAlbum.add(song);
			}
		}
		albumList.sort(Comparator.comparing(Album::getEnd));
		metaAlbum.list.sort(Comparator.comparing(Song::getEnd));
		if (debug) {
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
			for (Song song : metaAlbum.list) {
				System.out.println(String.format("%s %s %s", song.album.name, song.name, formatter.format(song.end.getTime())));
			}
		}
		metaAlbum.calculateStartAndEnd();
	}

	private void drawAlbum(int x, int y, Album album, AlbumList albumList) {

		graphics.setFont(albumFont);
		graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		graphics.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
		graphics.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

//		SimpleDateFormat	formatter	= new SimpleDateFormat("dd-MMM-yyyy");
//		System.out.println(album.name);
//		System.out.println("\t start=" + formatter.format(album.start.getTime()));
//		System.out.println("\t end=" + formatter.format(album.end.getTime()));
//		System.out.println("\t lastStart=" + formatter.format(album.lastStart.getTime()));
//		System.out.println("\t firstEnd=" + formatter.format(album.firstEnd.getTime()));
		int		startY	= calculateStartY(y, album, albumList);
		int		endY	= calculateEndY(y, album, albumList);
		Color	color	= new Color(album.color.getRed(), album.color.getGreen(), album.color.getBlue(), 196);
		graphics.setColor(color);

		int	mapX1	= x;
		int	mapY1	= startY/* - graphics.getFontMetrics().stringWidth(album.name) / 2 */;
		int	mapX2	= mapX1 + albumHeight;
		int	mapY2	= endY/* + graphics.getFontMetrics().stringWidth(album.name) */;
		graphics.fillRect(mapX1, mapY2, mapX2 - mapX1, mapY1 - mapY2);
		writer.println(String.format("<area shape=\"rect\" coords=\"%d,%d,%d,%d\" href=\"%s\" >", mapX1, mapY1, mapX2, mapY2, album.url));
		if (debug) {
			graphics.setColor(Color.RED);
			graphics.fillRect(x, startY, 1, 1);
		}
		// name
		{
			int				stringY	= endY + (startY - endY) / 2;
			int				stringX	= x;
			AffineTransform	orig	= graphics.getTransform();
			graphics.setColor(Color.red);
			graphics.fillOval(stringX + albumHeight / 2, stringY - albumHeight / 8, 2, 2);
			graphics.rotate(-Math.PI / 2, stringX + albumHeight / 2, stringY - albumHeight / 8);
			graphics.setColor(Color.white);
			graphics.drawString(album.name, stringX + albumHeight / 8 - graphics.getFontMetrics().stringWidth(album.name) / 2, stringY + albumHeight / 4);
			graphics.setTransform(orig);
		}
	}

	private void drawAlbums(int x, int y, AlbumList albumList) {

		for (int laneId : asSortedList(laneToAlbumMap.keySet())) {
			int ax = x + laneId * (albumHeight + 2);
			for (Album album : laneToAlbumMap.get(laneId)) {
				drawAlbum(ax, y, album, albumList);
			}
		}

	}

	/**
	 * Draw months and years for album map
	 *
	 * @param album
	 * @param x
	 * @param y
	 */
	public void drawCalendar(Album album, int x, int y) {
		if (debug) {
			// draw edge
			graphics.setColor(Color.blue);
			graphics.fillRect(0, 0, imageWidth, 1);
			graphics.fillRect(0, imageHeight - 1, imageWidth, 1);
			graphics.fillRect(0, 0, 1, imageHeight);
			graphics.fillRect(imageWidth - 1, 0, 1, imageHeight);
		}
		// graphics.setColor(backgroundColor);
		// graphics.fillRect(0, 0, imageWidth, imageHeight);

		// draw line
		graphics.setColor(COLOR_DARK_GRAY);
		graphics.fillRect(x - 1, 0, 2, imageHeight);
		Calendar thisMonth = new GregorianCalendar();
		thisMonth.setTime(album.firstEnd);
//		Date d = thisMonth.getTime();
		thisMonth.set(Calendar.DAY_OF_MONTH, 1);
		boolean weDrewOneYear = false;
		for (; thisMonth.getTime().before(album.end); thisMonth.add(Calendar.MONTH, 1)) {
			if (thisMonth.get(Calendar.MONTH) == 0) {
				drawYear(album, x, y, thisMonth);
				weDrewOneYear = true;
			}
			drawMonth(album, x, y, thisMonth);
		}
		if (!weDrewOneYear) {
			// we should draw at least one year to indicate where we are
			thisMonth.setTime(album.firstEnd);
			drawYear(album, x, y, thisMonth);
		}
	}

	/**
	 * Draw years for albumList map
	 *
	 * @param albumList
	 * @param x
	 * @param y
	 */
	public void drawCalendar(AlbumList albumList, int x, int y) {
		if (debug) {
			// draw edge
			graphics.setColor(Color.blue);
			graphics.fillRect(0, 0, imageWidth, 1);
			graphics.fillRect(0, imageHeight - 1, imageWidth, 1);
			graphics.fillRect(0, 0, 1, imageHeight);
			graphics.fillRect(imageWidth - 1, 0, 1, imageHeight);
		}
		// graphics.setColor(backgroundColor);
		// graphics.fillRect(0, 0, imageWidth, imageHeight);

		Calendar thisMonth = new GregorianCalendar();
		thisMonth.setTime(albumList.start);
		thisMonth.set(Calendar.DAY_OF_MONTH, 1);
		for (; thisMonth.getTimeInMillis() < albumList.end.getTime() + ONE_MONTH_MILLLI_SECONDS; thisMonth.add(Calendar.MONTH, 1)) {
			int delta = zoom(((thisMonth.getTimeInMillis() - albumList.start.getTime()) / ONE_DAY_MILLIS));
			if (thisMonth.get(Calendar.MONTH) == 0) {
				String _marker = String.valueOf(thisMonth.get(Calendar.YEAR));
				drawYear(x - 20, y - delta + 10 - zoom(ONE_MONTH_MILLLI_SECONDS / ONE_DAY_MILLIS) / 2, _marker);
			}
		}
	}

	private void drawMonth(Album album, int x, int y, Calendar thisMonth) {
		int delta = zoom((thisMonth.getTimeInMillis() - album.firstEnd.getTime()) / ONE_DAY_MILLIS);
		drawMonth(x, y - delta - zoom(ONE_MONTH_MILLLI_SECONDS / ONE_DAY_MILLIS) / 2, thisMonth);
	}

	private void drawMonth(int x, int y, Calendar thisMonth) {
		graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		graphics.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
		graphics.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		// month box
		int MONTH_SIZE = 20;
		graphics.setColor(COLOR_DARK_CYAN);
		graphics.fillRect(x - MONTH_SIZE / 2, y - MONTH_SIZE / 2, MONTH_SIZE, MONTH_SIZE);
		graphics.setColor(Color.WHITE);
		graphics.setFont(monthFont);
		String	_marker		= String.valueOf(thisMonth.get(Calendar.MONTH) + 1);
		int		halfWidth	= graphics.getFontMetrics().stringWidth(_marker) / 2;
		int		halfHeight	= monthHeight / 2 - 3;
		graphics.setColor(Color.WHITE);
		graphics.drawString(_marker, x - halfWidth, y + halfHeight);
		// System.out.println(_marker);
		// point
		if (debug) {
			graphics.setColor(Color.RED);
			graphics.fillRect(x, y, 1, 1);
		}
	}

	/**
	 * @param x
	 * @param y
	 * @param album
	 * @param song
	 * @return false if we had to draw further than image width
	 */
	private boolean drawSong(int x, int y, int shift, Album album, Song song, boolean testRun) {
		boolean success = true;

		graphics.setFont(songFont);
		graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		graphics.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
		graphics.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		graphics.setBackground(Color.black);
		graphics.setStroke(new BasicStroke(0.5f));
		String	_marker	= song.name;
		int		delta	= (int) ((song.end.getTime() - album.firstEnd.getTime()) / ONE_DAY_MILLIS);
		y = y - delta;
		song.y = y + shift * songHeight;
		int		_x			= x + SONG_DISTANCE;

		Color	color		= new Color(song.album.color.getRed(), song.album.color.getGreen(), song.album.color.getBlue(), 196);
		int		songIndex	= album.list.indexOf(song);
		boolean	updated		= false;
		do {
			updated = false;
			for (int i = songIndex - 1; i > -1; i--) {
				Song lastSong = album.list.get(i);
				if (lastSong.y - song.y < songHeight) {
					song.y -= songHeight;
					updated = true;
				}
			}
		} while (updated);
		if (song.y + songHeight / 2 - 2 < songHeight)
			success = false;

		if (!testRun) {
			// connect song to calendar release day
			graphics.setColor(Color.LIGHT_GRAY);
			{
				float	x1		= x;
				float	y1		= y;
				float	ctrlx1	= x1 + SONG_DISTANCE / 2;
				float	ctrly1	= y1;
				float	x2		= x + SONG_DISTANCE - 2;
				float	y2		= song.y;
				float	ctrlx2	= x2 - SONG_DISTANCE / 2;
				float	ctrly2	= y2;
				graphics.draw(new CubicCurve2D.Float(x1, y1, ctrlx1, ctrly1, ctrlx2, ctrly2, x2, y2));
			}
			// draw song name
			graphics.setColor(color/* song.album.color */);
			graphics.drawString(_marker, _x, song.y + songHeight / 2 - 2);
			// map
			graphics.setColor(Color.LIGHT_GRAY);
			int	mapX1	= _x;
			int	mapY1	= song.y - songHeight / 2 - 2;
			int	mapX2	= mapX1 + graphics.getFontMetrics().stringWidth(song.name);
			int	mapY2	= mapY1 + songHeight;
			if (debug)
				graphics.drawRect(mapX1, mapY1, mapX2 - mapX1, mapY2 - mapY1);
			writer.println(String.format("<area shape=\"rect\" coords=\"%d,%d,%d,%d\" href=\"%s\" >", mapX1, mapY1, mapX2, mapY2, song.url));
			if (debug) {
				graphics.setColor(Color.RED);
				graphics.fillRect(_x, song.y, 1, 1);
			}
		}
		return success;
	}

	/**
	 * @param album
	 * @param x
	 * @param y
	 * @return false if we had to draw further than image width
	 */
	private boolean drawSongs(Album album, int x, int y) {
		boolean	result	= true;
		int		shift	= 0;
		album.list.sort(Comparator.comparing(Song::getEnd));
		// find the correct shift
		do {
			result = true;
			for (Song song : album.list) {
				if (!drawSong(x, y, shift, album, song, true))
					result = false;
			}
			shift++;
		} while (!result);
		for (Song song : album.list) {
			if (!drawSong(x, y, shift, album, song, false))
				result = false;
		}
		return result;
	}

	private void drawYear(Album album, int x, int y, Calendar thisMonth) {
		int		delta	= zoom((thisMonth.getTimeInMillis() - album.firstEnd.getTime()) / ONE_DAY_MILLIS);
		String	_marker	= String.valueOf(thisMonth.get(Calendar.YEAR));
		drawYear(x - 20, y - delta + 10 - zoom(ONE_MONTH_MILLLI_SECONDS / ONE_DAY_MILLIS) / 2, _marker);
	}

	private void drawYear(int x, int y, String _marker) {
		graphics.setFont(yearFont);
		graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		graphics.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
		graphics.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		final int	_xOffset	= x;
		final int	_yOffset	= y;
		graphics.setColor(COLOR_DARK_ORANGE);
		AffineTransform orig = graphics.getTransform();
		graphics.rotate(-Math.PI / 2, _xOffset, _yOffset);
		graphics.drawString(_marker, _xOffset, _yOffset);
		graphics.setTransform(orig);
	}

	private int findFirstFreeLane(TimePeriod o) {
		Date	oStartDate	= o.getStart();
		Date	oEndDate	= o.getEnd();
		if (oStartDate != null && oEndDate != null) {
			long	os	= oStartDate.getTime();
			long	of	= oEndDate.getTime();
			// find
			for (int laneId : asSortedList(laneToAlbumMap.keySet())) {
				boolean overlapping = false;
				for (TimePeriod p : laneToAlbumMap.get(laneId)) {
					Date	pStartDate	= p.getStart();
					Date	pEndDate	= p.getEnd();
					if (pStartDate != null && pEndDate != null) {
						// ---overlapping
						long	ps	= pStartDate.getTime();
						long	pf	= pEndDate.getTime();
						overlapping = Util.isOverlapping(os, of, overlapping, ps, pf);
						// if (overlapping) {
						// logger.trace(String.format("Project '%s' overlaps project '%s'", o.issue.key,
						// p.issue.key));
						// }
					}
				}
				if (!overlapping) {
					return laneId;
				}
			}
			return laneToAlbumMap.keySet().size();
		}
		return -1;
	}

	/**
	 * all albums in one map
	 *
	 * @param imageOutputDirectory
	 * @throws FileNotFoundException
	 * @throws UnsupportedEncodingException
	 */
	public void generateAlbumMap(String htmlOutputDirectory, String imageOutputDirectory) throws FileNotFoundException, UnsupportedEncodingException {
		clear();
		String imageFilenName = "album_map.png";
		setZoom(4);
		AlbumList albumList = new AlbumList();
		init(albumList);
		// System.out.println(String.format("%d songs in %d albums",
		// metaAlbum.list.size(), albumList.size()));
		int y = imageHeight - CALENDAR_BUTTOM_SLACK;
		drawCalendar(albumList, 84, y);
		writer = new PrintWriter(htmlOutputDirectory + "/" + "album_map.html", "UTF-8");
		writer.println(String.format("<img src=\"" + imageRootUrl + "2022/12/%s\" usemap=\"#album_map\">", imageFilenName));
		writer.println("<map name=\"album_map\">");
		drawAlbums(84 + 32, y, albumList);
		try {
			File outputfile = new File(imageOutputDirectory + "/" + imageFilenName);
			ImageIO.write(aImage, "png", outputfile);
		} catch (IOException e) {
			System.out.println(e);
		}
		writer.println("</map>");
		writer.close();
	}

	/**
	 * all songs in one map
	 *
	 * @throws FileNotFoundException
	 * @throws UnsupportedEncodingException
	 */
	public void generateMetaAlbumMap(String htmlOutputDirectory, String imageOutputDirectory) throws FileNotFoundException, UnsupportedEncodingException {
		clear();
		String		imageFilenName	= "meta_album_map.png";
		AlbumList	albumList		= new AlbumList();
		Album		metaAlbum		= new Album("meta", null);
		copyToMetaAlbum(albumList, metaAlbum);
		setZoom(1f);
		init(metaAlbum);
		// System.out.println(String.format("%d songs in %d albums",
		// metaAlbum.list.size(), albumList.size()));
		int y = imageHeight - CALENDAR_BUTTOM_SLACK;
		writer = new PrintWriter(htmlOutputDirectory + "/" + "meta_album_map.html", "UTF-8");
		writer.println(String.format("<img src=\"" + imageRootUrl + "2022/12/%s\" usemap=\"#meta_album_map\">", imageFilenName));
		writer.println("<map name=\"meta_album_map\">");
		drawSongs(metaAlbum, calendarX, y);
		drawCalendar(metaAlbum, calendarX, y);
		try {
			File outputfile = new File(imageOutputDirectory + "/" + imageFilenName);
			ImageIO.write(aImage, "png", outputfile);
		} catch (IOException e) {
			System.out.println(e);
		}
		writer.println("</map>");
		writer.close();
	}

	public void generateSongMaps(Album album, String path, String albumName, String subName, String htmlOutputDirectory, String imageOutputDirectory) throws FileNotFoundException, UnsupportedEncodingException {
		clear();
		boolean success = true;
		setZoom(1);
		do {
			albumName = albumName.toLowerCase();
			albumName = Util.prepareAlbumName(albumName);
			String imageFilenName;
			init(album);
			// System.out.println(String.format("%d songs in %d albums",
			// metaAlbum.list.size(), albumList.size()));
			int y = imageHeight - CALENDAR_BUTTOM_SLACK;
			if (subName != null) {
				imageFilenName = albumName + "_" + subName + "_map.png";
				writer = new PrintWriter(String.format(htmlOutputDirectory + "/" + "%s_%s_map.html", albumName, subName), "UTF-8");
				writer.println(String.format("<img src=\"" + imageRootUrl + "%s\" usemap=\"#%s_%s_map\">", imageFilenName, albumName, subName));
				writer.println(String.format("<map name=\"%s_%s_map\">", albumName, subName));
			} else {
				imageFilenName = albumName + "_map.png";
				writer = new PrintWriter(String.format(htmlOutputDirectory + "/" + "%s_map.html", albumName), "UTF-8");
				writer.println(String.format("<img src=\"" + imageRootUrl + "%s\" usemap=\"#%s_map\">", imageFilenName, albumName));
				writer.println(String.format("<map name=\"%s_map\">", albumName));
			}
			success = drawSongs(album, calendarX, y);
			drawCalendar(album, calendarX, y);
			try {
				// retrieve image
				File outputfile = new File(imageOutputDirectory + "/" + imageFilenName);
				ImageIO.write(aImage, "png", outputfile);
			} catch (IOException e) {
				System.out.println(e);
			}
			writer.println("</map>");
			writer.close();
			if (!success)
				setZoom(getZoom() + 1);
		} while (!success);
	}

	public void generateStatistics(String audioDirectory) throws Exception {
		clear();
		AlbumList	albumList	= new AlbumList();
		Album		metaAlbum	= new Album("meta", null);
		copyToMetaAlbum(albumList, metaAlbum);
		// {
		// LocalDate localStart =
		// metaAlbum.start.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		// LocalDate localEnd =
		// metaAlbum.end.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		// long daysBetween = Duration.between(localStart.atStartOfDay(),
		// localEnd.atStartOfDay()).toDays();
		// System.out.println(String.format("%d Days spent composing music",
		// daysBetween));
		// }
		{
			LocalDate	localStart	= metaAlbum.start.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			LocalDate	localEnd	= metaAlbum.end.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			Period		diff		= Period.between(localStart.withDayOfMonth(1), localEnd.withDayOfMonth(1));
			System.out.println(String.format("%d years %s months spent composing music", diff.getYears(), diff.getMonths()));
		}
		{
			long	seconds		= 0;
			File[]	allFiles	= Util.queryAllFiles(audioDirectory, filterDirectory, ".mp3");
			for (int i = 0; i < allFiles.length; i++) {
				File	file	= allFiles[i];
				Mp3File	mp3file	= new Mp3File(file.getAbsoluteFile());
				seconds += mp3file.getLengthInSeconds();
			}
			if (metaAlbum.list.size() != allFiles.length) {
				throw new Exception(String.format("Number of songs in all albums %s does nto match number of mp3 in folders %d", metaAlbum.list.size(), allFiles.length));
			}
			String SongLength = Util.formatDurationWithUnits(seconds);
			System.out.println(String.format("%d songs in %d albums and a total of %s of music composed", metaAlbum.list.size(), albumList.size(), SongLength));
		}
	}
	// private int getNumberOfMonths() {
	// int _numberOfMonths = 0;
	// for (Calendar thisMonth = (Calendar) albumList.start.clone();
	// thisMonth.getTimeInMillis() < albumList.end
	// .getTimeInMillis(); thisMonth.add(Calendar.MONTH, 1)) {
	// _numberOfMonths++;
	// }
	// return _numberOfMonths;
	// }
	//

	public float getZoom() {
		return zoom;
	}

	private void init(Album album) {
		monthFont = new Font("Arial", Font.BOLD, zoom(12));
		yearFont = new Font("Arial", Font.BOLD, zoom(64));
		songFont = new Font("Arial", Font.PLAIN, zoom(14));
		albumFont = new Font("Arial", Font.PLAIN, zoom(64));
		// numberOfMonths = getNumberOfMonths();
		// numberOfDays = getNumberOfDays();
		aImage = new BufferedImage(10, 10, BufferedImage.TYPE_INT_ARGB);
		graphics = aImage.createGraphics();
		graphics.setFont(monthFont);
		monthHeight = graphics.getFontMetrics().getHeight();
		graphics.setFont(yearFont);
		yearHeight = graphics.getFontMetrics().getHeight();
		graphics.setFont(songFont);
		songHeight = graphics.getFontMetrics().getHeight();
		graphics.setFont(albumFont);
		albumHeight = graphics.getFontMetrics().getHeight() * 2;

		{
			// calculate difference in time between the start of all songs
			Calendar tend = new GregorianCalendar();
			tend.setTime(album.end);
			tend.set(Calendar.DAY_OF_MONTH, tend.getActualMaximum(Calendar.DAY_OF_MONTH));
			Calendar tstart = new GregorianCalendar();
			tstart.setTime(album.firstEnd);
			tstart.set(Calendar.DAY_OF_MONTH, 1);
			int delta = zoom(((tend.getTimeInMillis() - tstart.getTimeInMillis()) / ONE_DAY_MILLIS));
			aImage = new BufferedImage(imageWidth, delta + CALENDAR_BUTTOM_SLACK + CALENDAR_TOP_SLACK, BufferedImage.TYPE_INT_ARGB);
		}
		imageHeight = aImage.getHeight(null);
		graphics = aImage.createGraphics();
		laneToSongMap.clear();
		for (Song song : album.list) {
			// logger.trace(String.format("[%s][%s][%s][%s]", sprint.issue.key,
			// sprint.issue.summary, Util.createDateString(getStartDate(sprint).getTime()),
			// Util.createDateString(getEndDate(sprint).getTime())));
			int laneId = findFirstFreeLane(album);
			if (laneId != -1) {
				List<Song> list = laneToSongMap.get(laneId);
				if (list == null) {
					list = new ArrayList<>();
					laneToSongMap.put(laneId, list);
				}
				list.add(song);
			}
		}

	}

	private void init(AlbumList albumList) {
		monthFont = new Font("Arial", Font.BOLD, zoom(12));
		yearFont = new Font("Arial", Font.BOLD, zoom(64));
		songFont = new Font("Arial", Font.PLAIN, zoom(14));
		albumFont = new Font("Arial", Font.PLAIN, zoom(64));
		// copyToMetaAlbum();
		// numberOfMonths = getNumberOfMonths();
		// numberOfDays = getNumberOfDays();
		aImage = new BufferedImage(10, 10, BufferedImage.TYPE_INT_ARGB);
		graphics = aImage.createGraphics();
		graphics.setFont(monthFont);
		monthHeight = graphics.getFontMetrics().getHeight();
		graphics.setFont(yearFont);
		yearHeight = graphics.getFontMetrics().getHeight();
		graphics.setFont(songFont);
		songHeight = graphics.getFontMetrics().getHeight();
		graphics.setFont(albumFont);
		albumHeight = graphics.getFontMetrics().getHeight() * 2;

		{
			Calendar tend = new GregorianCalendar();
			tend.setTime(albumList.end);
			tend.set(Calendar.DAY_OF_MONTH, tend.getActualMaximum(Calendar.DAY_OF_MONTH));
			Calendar tstart = new GregorianCalendar();
			tstart.setTime(albumList.start);
			tstart.set(Calendar.DAY_OF_MONTH, 1);
			int delta = zoom(((tend.getTimeInMillis() - tstart.getTimeInMillis()) / ONE_DAY_MILLIS));
			aImage = new BufferedImage(imageWidth, delta + CALENDAR_BUTTOM_SLACK + CALENDAR_TOP_SLACK, BufferedImage.TYPE_INT_ARGB);
		}
		imageHeight = aImage.getHeight(null);
		graphics = aImage.createGraphics();

		laneToAlbumMap.clear();
		for (Album album : albumList) {
			// logger.trace(String.format("[%s][%s][%s][%s]", sprint.issue.key,
			// sprint.issue.summary, Util.createDateString(getStartDate(sprint).getTime()),
			// Util.createDateString(getEndDate(sprint).getTime())));
			int laneId = findFirstFreeLane(album);
			if (laneId != -1) {
				List<Album> list = laneToAlbumMap.get(laneId);
				if (list == null) {
					list = new ArrayList<>();
					laneToAlbumMap.put(laneId, list);
				}
				list.add(album);
			}
		}

	}

	public void setZoom(float zoom) {
		this.zoom = zoom;
	}

	int zoom(int value) {
		if (getZoom() >= 1.0f)
			return (int) (value / getZoom());
		else
			return (int) (value / 1.0f);
	}

	int zoom(long value) {
		return (int) (value / getZoom());
	}

}
