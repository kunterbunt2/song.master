package de.bushnaq.abdalla.song.master.timeline;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import de.bushnaq.abdalla.song.master.util.Util;

public class AlbumList extends ArrayList<Album> {
	// Color color1 = Color.BLACK;
	// Color color2 = Color.DARK_GRAY;
	// Color color3 = new Color(0x1a9f8a);
	// Color color4 = new Color(0xc1392b);
	// Color color5 = new Color(0xe67f22);
	// Color color6 = new Color(0x314a60);
	// Color color7 = new Color(0x8d3fa2);
	// Color color8 = new Color(0x2d95dc);
	private Color[]	colors	= {																												//
			new Color(0xff8800), new Color(0x00ff88), new Color(0x8800ff), new Color(0xff0088), new Color(0x88ff00), new Color(0x0088ff),	//
//			new Color(0xffcc00), new Color(0x00ffcc), new Color(0xcc00ff), new Color(0xff00cc), new Color(0xccff00),new Color(0x00ccff), //
			new Color(0xff4400), new Color(0x00ff44), new Color(0x4400ff), new Color(0xff0044), new Color(0x44ff00), new Color(0x0044ff) };
	public Date		end		= new GregorianCalendar(1900, Calendar.DECEMBER, 01).getTime();
	public Date		start	= new GregorianCalendar(2050, Calendar.JANUARY, 01).getTime();

	public AlbumList() {
		{
			// 12-Vox Machina
			Album album = new Album("12-Vox Machina", "https://abdalla.bushnaq.de/wp/home/12-vox-machina/", true, true);
			add(album);
			album.add(new Song(album, "01-Hold my hand in silence", Genre.POP, new GregorianCalendar(2022, Calendar.NOVEMBER, 30), new GregorianCalendar(2022, Calendar.DECEMBER, 13),
					"https://abdalla.bushnaq.de/wp/home/12-vox-machina/01-hold-my-hand-in-silence/"));
			album.add(new Song(album, "02-The soul door", Genre.POP, new GregorianCalendar(2022, Calendar.NOVEMBER, 27), new GregorianCalendar(2022, Calendar.DECEMBER, 19),
					"https://abdalla.bushnaq.de/wp/home/12-vox-machina/02-the-soul-door/"));
			album.add(new Song(album, "03-I shut down", Genre.POP, new GregorianCalendar(2022, Calendar.NOVEMBER, 23), new GregorianCalendar(2022, Calendar.DECEMBER, 24),
					"https://abdalla.bushnaq.de/wp/home/12-vox-machina/03-i-shut-down/"));
			album.add(new Song(album, "04-it was love", Genre.POP, new GregorianCalendar(2022, Calendar.NOVEMBER, 4), new GregorianCalendar(2023, Calendar.JANUARY, 1),
					"https://abdalla.bushnaq.de/wp/home/12-vox-machina/04-it-was-love/"));
			album.add(new Song(album, "05-when I grew up", Genre.POP, new GregorianCalendar(2022, Calendar.NOVEMBER, 5), new GregorianCalendar(2023, Calendar.JANUARY, 1),
					"https://abdalla.bushnaq.de/wp/home/12-vox-machina/05-when-i-grew-up/"));
		}
		{
			// 11-Pandemus
			Album album = new Album("11-Pandemus", "https://abdalla.bushnaq.de/wp/home/11-pandemus/", true, true);
//			Album album = new Album("11-Pandemus", "https://abdalla.bushnaq.de/index.php?id=219", true, true);
			add(album);
			album.add(new Song(album, "01-de la rosa", Genre.CLASSICAL, new GregorianCalendar(2017, Calendar.MAY, 1), new GregorianCalendar(2020, Calendar.AUGUST, 27),
					"https://abdalla.bushnaq.de/wp/home/11-pandemus/01-de-la-rosa/"));
//			album.add(new Song(album, "01-de la rosa", new GregorianCalendar(2017, Calendar.MAY, 1), new GregorianCalendar(2020, Calendar.AUGUST, 27), "http://abdalla.bushnaq.de/index.php?id=216"));
			album.add(new Song(album, "02-Pandemonium", Genre.CLASSICAL, new GregorianCalendar(2020, Calendar.DECEMBER, 14), new GregorianCalendar(2020, Calendar.DECEMBER, 19),
					"https://abdalla.bushnaq.de/wp/home/11-pandemus/02-pandemonium/"));
//			album.add(new Song(album, "02-Pandemonium", new GregorianCalendar(2020, Calendar.DECEMBER, 14), new GregorianCalendar(2020, Calendar.DECEMBER, 19), "http://abdalla.bushnaq.de/index.php?id=217"));
			album.add(new Song(album, "03-St Marie's, winter 1817", Genre.CLASSICAL, new GregorianCalendar(2020, Calendar.DECEMBER, 23), new GregorianCalendar(2021, Calendar.APRIL, 15),
					"https://abdalla.bushnaq.de/wp/home/11-pandemus/03-st-maries-winter-1817/"));
//			album.add(new Song(album, "03-St Marie's, winter 1817", new GregorianCalendar(2020, Calendar.DECEMBER, 23), new GregorianCalendar(2021, Calendar.APRIL, 15), "http://abdalla.bushnaq.de/index.php?id=218"));
			album.add(new Song(album, "04-vita est fabula", Genre.CLASSICAL, new GregorianCalendar(2020, Calendar.DECEMBER, 27), new GregorianCalendar(2021, Calendar.JUNE, 27),
					"https://abdalla.bushnaq.de/wp/home/11-pandemus/04-vita-est-fabula/"));
//			album.add(new Song(album, "04-vita est fabula", new GregorianCalendar(2020, Calendar.DECEMBER, 27), new GregorianCalendar(2021, Calendar.JUNE, 27), "http://abdalla.bushnaq.de/index.php?id=261"));
			album.add(new Song(album, "05-liberi ludunt bellum", Genre.CLASSICAL, new GregorianCalendar(2021, Calendar.MAY, 15), new GregorianCalendar(2022, Calendar.JANUARY, 11),
					"https://abdalla.bushnaq.de/wp/home/11-pandemus/05-liberi-ludunt-bellum/"));
//			album.add(new Song(album, "05-liberi ludunt bellum", new GregorianCalendar(2021, Calendar.MAY, 15), new GregorianCalendar(2022, Calendar.JANUARY, 11), "https://abdalla.bushnaq.de/index.php?id=262"));
		}
		{
			// 10-The Vast
			Album album = new Album("10-The Vast", "https://abdalla.bushnaq.de/wp/home/10-the-vast/", true, true);
//			Album album = new Album("10-The Vast", "http://abdalla.bushnaq.de/index.php?id=141", true, true);
			add(album);
			album.add(new Song(album, "01-morning", Genre.ELECTRONIC, new GregorianCalendar(2018, Calendar.JULY, 28), new GregorianCalendar(2018, Calendar.JULY, 30),
					"https://abdalla.bushnaq.de/wp/home/10-the-vast/01-morning/"));
//			album.add(new Song(album, "01-morning", new GregorianCalendar(2018, Calendar.JULY, 28), new GregorianCalendar(2018, Calendar.JULY, 30), "http://abdalla.bushnaq.de/index.php?id=142"));
			album.add(new Song(album, "02-time", Genre.SOUNDTRACK, new GregorianCalendar(2019, Calendar.MARCH, 9), new GregorianCalendar(2019, Calendar.JULY, 06),
					"https://abdalla.bushnaq.de/wp/home/10-the-vast/02-time/"));
//			album.add(new Song(album, "02-time", new GregorianCalendar(2019, Calendar.MARCH, 9), new GregorianCalendar(2019, Calendar.JULY, 06), "http://abdalla.bushnaq.de/index.php?id=143"));
			album.add(new Song(album, "03-mysterious", Genre.SOUNDTRACK, new GregorianCalendar(2019, Calendar.JULY, 2), new GregorianCalendar(2019, Calendar.AUGUST, 18),
					"https://abdalla.bushnaq.de/wp/home/10-the-vast/03-mysterious/"));
//			album.add(new Song(album, "03-mysterious", new GregorianCalendar(2019, Calendar.JULY, 2), new GregorianCalendar(2019, Calendar.AUGUST, 18), "http://abdalla.bushnaq.de/index.php?id=144"));
			album.add(new Song(album, "04-envy", Genre.SOUNDTRACK, new GregorianCalendar(2012, Calendar.MAY, 7), new GregorianCalendar(2019, Calendar.AUGUST, 24),
					"https://abdalla.bushnaq.de/wp/home/10-the-vast/04-envy/"));
//			album.add(new Song(album, "04-envy", new GregorianCalendar(2012, Calendar.MAY, 7), new GregorianCalendar(2019, Calendar.AUGUST, 24), "http://abdalla.bushnaq.de/index.php?id=147"));
			album.add(new Song(album, "05-massive", Genre.SOUNDTRACK, new GregorianCalendar(2019, Calendar.SEPTEMBER, 2), new GregorianCalendar(2020, Calendar.FEBRUARY, 8),
					"https://abdalla.bushnaq.de/wp/home/10-the-vast/05-massive/"));
//			album.add(new Song(album, "05-massive", new GregorianCalendar(2019, Calendar.SEPTEMBER, 2), new GregorianCalendar(2020, Calendar.FEBRUARY, 8), "http://abdalla.bushnaq.de/index.php?id=167"));
			album.add(new Song(album, "06-abyss", Genre.SOUNDTRACK, new GregorianCalendar(2020, Calendar.MARCH, 23), new GregorianCalendar(2020, Calendar.AUGUST, 26),
					"https://abdalla.bushnaq.de/wp/home/10-the-vast/06-abyss/"));
//			album.add(new Song(album, "06-abyss(m)", new GregorianCalendar(2020, Calendar.MARCH, 23), new GregorianCalendar(2020, Calendar.AUGUST, 26), "http://abdalla.bushnaq.de/index.php?id=168"));
		}
		{
			{
				// 09-Shards of Music 2016
				Album album = new Album("09-Shards of Music", "2016", "https://abdalla.bushnaq.de/wp/home/09-shards-of-music/09-shards-of-music-2016/", true, true);
//				Album album = new Album("09-Shards of Music", "2016", "http://abdalla.bushnaq.de/index.php?id=138", true, true);
				add(album);
				album.add(new Song(album, "01-circus", new GregorianCalendar(2016, Calendar.MARCH, 6), "https://abdalla.bushnaq.de/wp/home/09-shards-of-music/09-shards-of-music-2016/01-circus/"));
//				album.add(new Song(album, "01-circus", new GregorianCalendar(2016, Calendar.MARCH, 6), "http://abdalla.bushnaq.de/index.php?id=139"));
				album.add(new Song(album, "02-berlin", new GregorianCalendar(2016, Calendar.MARCH, 6), "https://abdalla.bushnaq.de/wp/home/09-shards-of-music/09-shards-of-music-2016/02-berlin/"));
//				album.add(new Song(album, "02-berlin", new GregorianCalendar(2016, Calendar.MARCH, 6), "http://abdalla.bushnaq.de/index.php?id=140"));
				album.add(
						new Song(album, "03-Some Ideas Are Bad", new GregorianCalendar(2016, Calendar.APRIL, 23), "https://abdalla.bushnaq.de/wp/home/09-shards-of-music/09-shards-of-music-2016/03-some-ideas-are-bad/"));
//				album.add(new Song(album, "03-Some Ideas Are Bad", new GregorianCalendar(2016, Calendar.APRIL, 23), "http://abdalla.bushnaq.de/index.php?id=148"));
				album.add(new Song(album, "04-When My Mother Danced", new GregorianCalendar(2016, Calendar.MAY, 4),
						"https://abdalla.bushnaq.de/wp/home/09-shards-of-music/09-shards-of-music-2016/04-when-my-mother-danced/"));
//				album.add(new Song(album, "04-When My Mother Danced", new GregorianCalendar(2016, Calendar.MAY, 4), "http://abdalla.bushnaq.de/index.php?id=149"));
				album.add(new Song(album, "05-Insufficient Time", new GregorianCalendar(2016, Calendar.AUGUST, 14), "https://abdalla.bushnaq.de/wp/home/09-shards-of-music/09-shards-of-music-2016/05-insufficient-time/"));
//				album.add(new Song(album, "05-Insufficient Time", new GregorianCalendar(2016, Calendar.AUGUST, 14), "http://abdalla.bushnaq.de/index.php?id=150"));
			}
			{
				// 09-Shards of Music 2017
				Album album = new Album("09-Shards of Music", "2017", "https://abdalla.bushnaq.de/wp/home/09-shards-of-music/09-shards-of-music-2017/", true, true);
//				Album album = new Album("09-Shards of Music", "2017", "http://abdalla.bushnaq.de/index.php?id=138", true, true);
				add(album);
				album.add(
						new Song(album, "06-Russian Do It Too", new GregorianCalendar(2017, Calendar.FEBRUARY, 1), "https://abdalla.bushnaq.de/wp/home/09-shards-of-music/09-shards-of-music-2017/06-russian-do-it-too/"));
//				album.add(new Song(album, "06-Russian Do It Too", new GregorianCalendar(2017, Calendar.FEBRUARY, 1), "http://abdalla.bushnaq.de/index.php?id=151"));
				album.add(new Song(album, "07-When A Swan Is Born", new GregorianCalendar(2017, Calendar.MARCH, 12),
						"https://abdalla.bushnaq.de/wp/home/09-shards-of-music/09-shards-of-music-2017/07-when-a-swan-is-born/"));
//				album.add(new Song(album, "07-When A Swan Is Born", new GregorianCalendar(2017, Calendar.MARCH, 12), "http://abdalla.bushnaq.de/index.php?id=152"));
				album.add(new Song(album, "08-Sometimes The Neighbors Are Loud", new GregorianCalendar(2017, Calendar.APRIL, 10),
						"https://abdalla.bushnaq.de/wp/home/09-shards-of-music/09-shards-of-music-2017/08-sometimes-the-neighbors-are-loud/"));
//				album.add(new Song(album, "08-Sometimes The Neighbors Are Loud", new GregorianCalendar(2017, Calendar.APRIL, 10), "http://abdalla.bushnaq.de/index.php?id=153"));
				album.add(new Song(album, "09-My Little Secret", new GregorianCalendar(2017, Calendar.APRIL, 29), "https://abdalla.bushnaq.de/wp/home/09-shards-of-music/09-shards-of-music-2017/09-my-little-secret/"));
//				album.add(new Song(album, "09-My Little Secret", new GregorianCalendar(2017, Calendar.APRIL, 29), "http://abdalla.bushnaq.de/index.php?id=154"));
			}
			{
				// 09-Shards of Music 2018
				Album album = new Album("09-Shards of Music", "2018", "https://abdalla.bushnaq.de/wp/home/09-shards-of-music/09-shards-of-music-2018/", true, true);
//				Album album = new Album("09-Shards of Music", "2018", "http://abdalla.bushnaq.de/index.php?id=138", true, true);
				add(album);
				album.add(new Song(album, "10-There Are Things You Cannot Change", new GregorianCalendar(2018, Calendar.MARCH, 3),
						"https://abdalla.bushnaq.de/wp/home/09-shards-of-music/09-shards-of-music-2018/10-there-are-things-you-cannot-change/"));
//				album.add(new Song(album, "10-There Are Things You Cannot Change", new GregorianCalendar(2018, Calendar.MARCH, 3), "http://abdalla.bushnaq.de/index.php?id=155"));
				album.add(new Song(album, "11-The Thought That Kept Coming Back", new GregorianCalendar(2018, Calendar.MARCH, 20),
						"https://abdalla.bushnaq.de/wp/home/09-shards-of-music/09-shards-of-music-2018/11-the-thought-that-kept-coming-back/"));
//				album.add(new Song(album, "11-The Thought That Kept Coming Back", new GregorianCalendar(2018, Calendar.MARCH, 20), "http://abdalla.bushnaq.de/index.php?id=156"));
				album.add(new Song(album, "12-Wonderful Afternoon", new GregorianCalendar(2018, Calendar.APRIL, 30),
						"https://abdalla.bushnaq.de/wp/home/09-shards-of-music/09-shards-of-music-2018/12-wonderful-afternoon/"));
//				album.add(new Song(album, "12-Wonderful Afternoon", new GregorianCalendar(2018, Calendar.APRIL, 30), "http://abdalla.bushnaq.de/index.php?id=157"));
				album.add(new Song(album, "13-Bad Idea My Dear", new GregorianCalendar(2018, Calendar.AUGUST, 19), "https://abdalla.bushnaq.de/wp/home/09-shards-of-music/09-shards-of-music-2018/13-bad-idea-my-dear/"));
//				album.add(new Song(album, "13-Bad Idea My Dear", new GregorianCalendar(2018, Calendar.AUGUST, 19), "http://abdalla.bushnaq.de/index.php?id=158"));
				album.add(new Song(album, "14-The Wonder Of Every Day We Live", new GregorianCalendar(2018, Calendar.AUGUST, 26),
						"https://abdalla.bushnaq.de/wp/home/09-shards-of-music/09-shards-of-music-2018/14-the-wonder-of-every-day-we-live/"));
//				album.add(new Song(album, "14-The Wonder Of Every Day We Live", new GregorianCalendar(2018, Calendar.AUGUST, 26), "http://abdalla.bushnaq.de/index.php?id=159"));
				album.add(new Song(album, "15-In Between Two Thoughts", new GregorianCalendar(2018, Calendar.AUGUST, 26),
						"https://abdalla.bushnaq.de/wp/home/09-shards-of-music/09-shards-of-music-2018/15-in-between-zwo-thoughts/"));
//				album.add(new Song(album, "15-In Between Two Thoughts", new GregorianCalendar(2018, Calendar.AUGUST, 26), "http://abdalla.bushnaq.de/index.php?id=160"));
				album.add(new Song(album, "16-Nothing Serious", new GregorianCalendar(2018, Calendar.AUGUST, 26), "https://abdalla.bushnaq.de/wp/home/09-shards-of-music/09-shards-of-music-2018/16-nothing-serious/"));
//				album.add(new Song(album, "16-Nothing Serious", new GregorianCalendar(2018, Calendar.AUGUST, 26), "http://abdalla.bushnaq.de/index.php?id=161"));
				album.add(new Song(album, "17-Aggressively Beautiful", new GregorianCalendar(2018, Calendar.AUGUST, 27),
						"https://abdalla.bushnaq.de/wp/home/09-shards-of-music/09-shards-of-music-2018/17-aggressively-beautiful/"));
//				album.add(new Song(album, "17-Aggressively Beautiful", new GregorianCalendar(2018, Calendar.AUGUST, 27), "http://abdalla.bushnaq.de/index.php?id=162"));
				album.add(new Song(album, "18-Sleepily Looking Away", new GregorianCalendar(2018, Calendar.SEPTEMBER, 9),
						"https://abdalla.bushnaq.de/wp/home/09-shards-of-music/09-shards-of-music-2018/18-sleepily-looking-away/"));
//				album.add(new Song(album, "18-Sleepily Looking Away", new GregorianCalendar(2018, Calendar.SEPTEMBER, 9), "http://abdalla.bushnaq.de/index.php?id=163"));
				album.add(new Song(album, "19-Masterly Strange And Thoughtful", new GregorianCalendar(2018, Calendar.SEPTEMBER, 22),
						"https://abdalla.bushnaq.de/wp/home/09-shards-of-music/09-shards-of-music-2018/19-masterly-strange-and-thoughtful/"));
//				album.add(new Song(album, "19-Masterly Strange And Thoughtful", new GregorianCalendar(2018, Calendar.SEPTEMBER, 22), "http://abdalla.bushnaq.de/index.php?id=164"));
				album.add(new Song(album, "20-The Lonely Thought", new GregorianCalendar(2018, Calendar.OCTOBER, 27),
						"https://abdalla.bushnaq.de/wp/home/09-shards-of-music/09-shards-of-music-2018/20-the-lonely-thought/"));
//				album.add(new Song(album, "20-The Lonely Thought", new GregorianCalendar(2018, Calendar.OCTOBER, 27), "http://abdalla.bushnaq.de/index.php?id=165"));
			}
			{
				// 09-Shards of Music 2019
				Album album = new Album("09-Shards of Music", "2019", "https://abdalla.bushnaq.de/wp/home/09-shards-of-music/09-shards-of-music-2019/", true, true);
//				Album album = new Album("09-Shards of Music", "2019", "http://abdalla.bushnaq.de/index.php?id=138", true, true);
				add(album);
				album.add(new Song(album, "01-Hamburg", new GregorianCalendar(2019, Calendar.FEBRUARY, 2), "https://abdalla.bushnaq.de/wp/home/09-shards-of-music/09-shards-of-music-2019/01-hamburg/"));
//				album.add(new Song(album, "01-Hamburg", new GregorianCalendar(2019, Calendar.FEBRUARY, 2), "http://abdalla.bushnaq.de/index.php?id=221"));
				album.add(
						new Song(album, "02-When I am with you", new GregorianCalendar(2019, Calendar.APRIL, 10), "https://abdalla.bushnaq.de/wp/home/09-shards-of-music/09-shards-of-music-2019/02-when-i-am-with-you/"));
//				album.add(new Song(album, "02-When I am with you", new GregorianCalendar(2019, Calendar.APRIL, 10), "http://abdalla.bushnaq.de/index.php?id=220"));
				album.add(new Song(album, "03-The memory of that day haunts me", new GregorianCalendar(2019, Calendar.JUNE, 3),
						"https://abdalla.bushnaq.de/wp/home/09-shards-of-music/09-shards-of-music-2019/03-the-memory-of-that-day-haunts-me/"));
//				album.add(new Song(album, "03-The memory of that day haunts me", new GregorianCalendar(2019, Calendar.JUNE, 3), "http://abdalla.bushnaq.de/index.php?id=222"));
				album.add(new Song(album, "04-Every evening when I put you to bed", new GregorianCalendar(2019, Calendar.JUNE, 3),
						"https://abdalla.bushnaq.de/wp/home/09-shards-of-music/09-shards-of-music-2019/04-every-evening-when-i-put-you-to-bed/"));
//				album.add(new Song(album, "04-Every evening when I put you to bed", new GregorianCalendar(2019, Calendar.JUNE, 3), "http://abdalla.bushnaq.de/index.php?id=223"));
				album.add(new Song(album, "05-The Russian doll", new GregorianCalendar(2019, Calendar.AUGUST, 4), "https://abdalla.bushnaq.de/wp/home/09-shards-of-music/09-shards-of-music-2019/05-the-russian-doll/4"));
//				album.add(new Song(album, "05-The Russian doll", new GregorianCalendar(2019, Calendar.AUGUST, 4), "http://abdalla.bushnaq.de/index.php?id=224"));
				album.add(new Song(album, "06-Dancing in the  attic", new GregorianCalendar(2019, Calendar.SEPTEMBER, 26),
						"https://abdalla.bushnaq.de/wp/home/09-shards-of-music/09-shards-of-music-2019/06-dancing-in-the-attic/"));
//				album.add(new Song(album, "06-Dancing in the  attic", new GregorianCalendar(2019, Calendar.SEPTEMBER, 26), "http://abdalla.bushnaq.de/index.php?id=225"));
				album.add(new Song(album, "07-Sunny afternoon", new GregorianCalendar(2019, Calendar.OCTOBER, 11), "https://abdalla.bushnaq.de/wp/home/09-shards-of-music/09-shards-of-music-2019/07-sunny-afternoon/"));
//				album.add(new Song(album, "07-Sunny afternoon", new GregorianCalendar(2019, Calendar.OCTOBER, 11), "http://abdalla.bushnaq.de/index.php?id=226"));
				album.add(new Song(album, "08-Trying too hard", new GregorianCalendar(2019, Calendar.OCTOBER, 11), "https://abdalla.bushnaq.de/wp/home/09-shards-of-music/09-shards-of-music-2019/08-trying-too-hard/"));
//				album.add(new Song(album, "08-Trying too hard", new GregorianCalendar(2019, Calendar.OCTOBER, 11), "http://abdalla.bushnaq.de/index.php?id=227"));
				album.add(new Song(album, "09-Düsseldorf", new GregorianCalendar(2019, Calendar.OCTOBER, 28), "https://abdalla.bushnaq.de/wp/home/09-shards-of-music/09-shards-of-music-2019/09-dusseldorf/"));
//				album.add(new Song(album, "09-Düsseldorf", new GregorianCalendar(2019, Calendar.OCTOBER, 28), "http://abdalla.bushnaq.de/index.php?id=228"));
				album.add(new Song(album, "10-But you did not...", new GregorianCalendar(2019, Calendar.OCTOBER, 28), "https://abdalla.bushnaq.de/wp/home/09-shards-of-music/09-shards-of-music-2019/10-but-you-did-not/"));
//				album.add(new Song(album, "10-But you did not...", new GregorianCalendar(2019, Calendar.OCTOBER, 28), "http://abdalla.bushnaq.de/index.php?id=229"));
			}
			{
				// 09-Shards of Music 2020
				Album album = new Album("09-Shards of Music", "2020", "https://abdalla.bushnaq.de/wp/home/09-shards-of-music/09-shards-of-music-2020/", true, true);
//				Album album = new Album("09-Shards of Music", "2020", "http://abdalla.bushnaq.de/index.php?id=138", true, true);
				add(album);
				album.add(new Song(album, "11-Lissi", new GregorianCalendar(2020, Calendar.FEBRUARY, 23), "https://abdalla.bushnaq.de/wp/home/09-shards-of-music/09-shards-of-music-2020/11-lissi/"));
//				album.add(new Song(album, "11-Lissi", new GregorianCalendar(2020, Calendar.FEBRUARY, 23), "http://abdalla.bushnaq.de/index.php?id=230"));
				album.add(new Song(album, "12-You never actually asked", new GregorianCalendar(2020, Calendar.FEBRUARY, 24),
						"https://abdalla.bushnaq.de/wp/home/09-shards-of-music/09-shards-of-music-2020/12-you-never-actually-asked/"));
//				album.add(new Song(album, "12-You never actually asked", new GregorianCalendar(2020, Calendar.FEBRUARY, 24), "http://abdalla.bushnaq.de/index.php?id=231"));
				album.add(new Song(album, "13-Story of my life", new GregorianCalendar(2020, Calendar.FEBRUARY, 24), "https://abdalla.bushnaq.de/wp/home/09-shards-of-music/09-shards-of-music-2020/13-story-of-my-life/"));
//				album.add(new Song(album, "13-Story of my life", new GregorianCalendar(2020, Calendar.FEBRUARY, 24), "http://abdalla.bushnaq.de/index.php?id=232"));
				album.add(
						new Song(album, "14-When we where young", new GregorianCalendar(2020, Calendar.MARCH, 1), "https://abdalla.bushnaq.de/wp/home/09-shards-of-music/09-shards-of-music-2020/14-when-we-where-young/"));
//				album.add(new Song(album, "14-When we where young", new GregorianCalendar(2020, Calendar.MARCH, 1), "http://abdalla.bushnaq.de/index.php?id=233"));
				album.add(new Song(album, "15-I have a  secret", new GregorianCalendar(2020, Calendar.MARCH, 1), "https://abdalla.bushnaq.de/wp/home/09-shards-of-music/09-shards-of-music-2020/15-i-have-a-secret/"));
//				album.add(new Song(album, "15-I have a  secret", new GregorianCalendar(2020, Calendar.MARCH, 1), "http://abdalla.bushnaq.de/index.php?id=234"));
				album.add(new Song(album, "16-Train ride to Berlin", new GregorianCalendar(2020, Calendar.MARCH, 22),
						"https://abdalla.bushnaq.de/wp/home/09-shards-of-music/09-shards-of-music-2020/16-train-ride-to-berlin/"));
//				album.add(new Song(album, "16-Train ride to Berlin", new GregorianCalendar(2020, Calendar.MARCH, 22), "http://abdalla.bushnaq.de/index.php?id=235"));
				album.add(new Song(album, "17-Time slows down when our eyes meet", new GregorianCalendar(2020, Calendar.MAY, 17),
						"https://abdalla.bushnaq.de/wp/home/09-shards-of-music/09-shards-of-music-2020/17-time-slows-down-when-our-eyes-meet/"));
//				album.add(new Song(album, "17-Time slows down when our eyes meet", new GregorianCalendar(2020, Calendar.MAY, 17), "http://abdalla.bushnaq.de/index.php?id=236"));
				album.add(new Song(album, "18-My childhood", new GregorianCalendar(2020, Calendar.JUNE, 7), "https://abdalla.bushnaq.de/wp/home/09-shards-of-music/09-shards-of-music-2020/18-my-childhood/"));
//				album.add(new Song(album, "18-My childhood", new GregorianCalendar(2020, Calendar.JUNE, 7), "http://abdalla.bushnaq.de/index.php?id=237"));
				album.add(new Song(album, "19-The times we had in the summer", new GregorianCalendar(2020, Calendar.JUNE, 7),
						"https://abdalla.bushnaq.de/wp/home/09-shards-of-music/09-shards-of-music-2020/19-the-times-we-had-in-the-summer/"));
//				album.add(new Song(album, "19-The times we had in the summer", new GregorianCalendar(2020, Calendar.JUNE, 7), "http://abdalla.bushnaq.de/index.php?id=238"));
				album.add(new Song(album, "20-One year later", new GregorianCalendar(2020, Calendar.JUNE, 13), "https://abdalla.bushnaq.de/wp/home/09-shards-of-music/09-shards-of-music-2020/20-one-year-later/"));
//				album.add(new Song(album, "20-One year later", new GregorianCalendar(2020, Calendar.JUNE, 13), "http://abdalla.bushnaq.de/index.php?id=239"));

				album.add(new Song(album, "21-The ball room", new GregorianCalendar(2020, Calendar.JUNE, 19), "https://abdalla.bushnaq.de/wp/home/09-shards-of-music/09-shards-of-music-2020/21-the-ball-room/"));
//				album.add(new Song(album, "21-The ball room", new GregorianCalendar(2020, Calendar.JUNE, 19), "http://abdalla.bushnaq.de/index.php?id=240"));
				album.add(new Song(album, "22-Do you remember", new GregorianCalendar(2020, Calendar.JULY, 2), "https://abdalla.bushnaq.de/wp/home/09-shards-of-music/09-shards-of-music-2020/22-do-you-remember/"));
//				album.add(new Song(album, "22-Do you remember", new GregorianCalendar(2020, Calendar.JULY, 2), "http://abdalla.bushnaq.de/index.php?id=241"));
				album.add(new Song(album, "23-Told you so", new GregorianCalendar(2020, Calendar.JULY, 12), "https://abdalla.bushnaq.de/wp/home/09-shards-of-music/09-shards-of-music-2020/23-told-you-so/"));
//				album.add(new Song(album, "23-Told you so", new GregorianCalendar(2020, Calendar.JULY, 12), "http://abdalla.bushnaq.de/index.php?id=242"));
				album.add(new Song(album, "24-Those where the days", new GregorianCalendar(2020, Calendar.JULY, 12),
						"https://abdalla.bushnaq.de/wp/home/09-shards-of-music/09-shards-of-music-2020/24-those-where-the-days/"));
//				album.add(new Song(album, "24-Those where the days", new GregorianCalendar(2020, Calendar.JULY, 12), "http://abdalla.bushnaq.de/index.php?id=243"));
				album.add(new Song(album, "25-Maybe", new GregorianCalendar(2020, Calendar.JULY, 12), "https://abdalla.bushnaq.de/wp/home/09-shards-of-music/09-shards-of-music-2020/25-maybe/"));
//				album.add(new Song(album, "25-Maybe", new GregorianCalendar(2020, Calendar.JULY, 12), "http://abdalla.bushnaq.de/index.php?id=244"));
				album.add(new Song(album, "26-Here I am", new GregorianCalendar(2020, Calendar.AUGUST, 3), "https://abdalla.bushnaq.de/wp/home/09-shards-of-music/09-shards-of-music-2020/26-here-i-am/"));
//				album.add(new Song(album, "26-Here I am", new GregorianCalendar(2020, Calendar.AUGUST, 3), "http://abdalla.bushnaq.de/index.php?id=245"));
				album.add(new Song(album, "27-All I ever wanted", new GregorianCalendar(2020, Calendar.AUGUST, 27), "https://abdalla.bushnaq.de/wp/home/09-shards-of-music/09-shards-of-music-2020/27-all-i-ever-wanted/"));
//				album.add(new Song(album, "27-All I ever wanted", new GregorianCalendar(2020, Calendar.AUGUST, 27), "http://abdalla.bushnaq.de/index.php?id=246"));
				album.add(new Song(album, "28-The complex sozial event called dance", new GregorianCalendar(2020, Calendar.AUGUST, 29),
						"https://abdalla.bushnaq.de/wp/home/09-shards-of-music/09-shards-of-music-2020/28-the-complex-sozial-event-called-dance/"));
//				album.add(new Song(album, "28-The complex sozial event called dance", new GregorianCalendar(2020, Calendar.AUGUST, 29), "http://abdalla.bushnaq.de/index.php?id=247"));
				album.add(new Song(album, "29-No more a child", new GregorianCalendar(2020, Calendar.SEPTEMBER, 23), "https://abdalla.bushnaq.de/wp/home/09-shards-of-music/09-shards-of-music-2020/29-no-more-a-child/"));
//				album.add(new Song(album, "29-No more a child", new GregorianCalendar(2020, Calendar.SEPTEMBER, 23), "http://abdalla.bushnaq.de/index.php?id=248"));
				album.add(new Song(album, "30-This is My life", new GregorianCalendar(2020, Calendar.OCTOBER, 9), "https://abdalla.bushnaq.de/wp/home/09-shards-of-music/09-shards-of-music-2020/30-this-is-my-life/"));
//				album.add(new Song(album, "30-This is My life", new GregorianCalendar(2020, Calendar.OCTOBER, 9), "http://abdalla.bushnaq.de/index.php?id=249"));

				album.add(new Song(album, "31-The wedding", new GregorianCalendar(2020, Calendar.OCTOBER, 30),
						"https://abdalla.bushnaq.de/wp/home/09-shards-of-music/09-shards-of-music-2020/31-the-wedding-%e2%98%85%e2%98%85%e2%98%85%e2%98%85%e2%98%85/"));
//				album.add(new Song(album, "31-The wedding", new GregorianCalendar(2020, Calendar.OCTOBER, 30), "http://abdalla.bushnaq.de/index.php?id=250"));
				album.add(new Song(album, "32-Give me a kiss", new GregorianCalendar(2020, Calendar.OCTOBER, 30),
						"https://abdalla.bushnaq.de/wp/home/09-shards-of-music/09-shards-of-music-2020/32-give-me-a-kiss-%e2%98%85%e2%98%85%e2%98%85%e2%98%85/"));
//				album.add(new Song(album, "32-Give me a kiss", new GregorianCalendar(2020, Calendar.OCTOBER, 30), "http://abdalla.bushnaq.de/index.php?id=251"));
				album.add(new Song(album, "33-Strolling down the streets", new GregorianCalendar(2020, Calendar.NOVEMBER, 1),
						"https://abdalla.bushnaq.de/wp/home/09-shards-of-music/09-shards-of-music-2020/33-strolling-down-the-streets-%e2%98%85%e2%98%85%e2%98%85%e2%98%85%e2%98%85/"));
//				album.add(new Song(album, "33-Strolling down the streets", new GregorianCalendar(2020, Calendar.NOVEMBER, 1), "http://abdalla.bushnaq.de/index.php?id=252"));
				album.add(new Song(album, "34-Memories", new GregorianCalendar(2020, Calendar.DECEMBER, 2),
						"https://abdalla.bushnaq.de/wp/home/09-shards-of-music/09-shards-of-music-2020/34-memories-%e2%98%85%e2%98%85%e2%98%85%e2%98%85/"));
//				album.add(new Song(album, "34-Memories", new GregorianCalendar(2020, Calendar.DECEMBER, 2), "http://abdalla.bushnaq.de/index.php?id=253"));
				album.add(new Song(album, "35-Getting to know you better every day", new GregorianCalendar(2020, Calendar.DECEMBER, 6),
						"https://abdalla.bushnaq.de/wp/home/09-shards-of-music/09-shards-of-music-2020/35-getting-to-know-you-better-every-day-%e2%98%85%e2%98%85%e2%98%85%e2%98%85%e2%98%85/"));
//				album.add(new Song(album, "35-Getting to know you better every day", new GregorianCalendar(2020, Calendar.DECEMBER, 6), "http://abdalla.bushnaq.de/index.php?id=254"));
				album.add(new Song(album, "36-A short story", new GregorianCalendar(2020, Calendar.DECEMBER, 31),
						"https://abdalla.bushnaq.de/wp/home/09-shards-of-music/09-shards-of-music-2020/36-a-short-story-%e2%98%85%e2%98%85%e2%98%85%e2%98%85%e2%98%85/"));
//				album.add(new Song(album, "36-A short story", new GregorianCalendar(2020, Calendar.DECEMBER, 31), "http://abdalla.bushnaq.de/index.php?id=255"));

			}
			{
				// 09-Shards of Music 2021
				Album album = new Album("09-Shards of Music", "2021", "https://abdalla.bushnaq.de/wp/home/09-shards-of-music/09-shards-of-music-2021/", true, true);
//				Album album = new Album("09-Shards of Music", "2021", "http://abdalla.bushnaq.de/index.php?id=138", true, true);
				add(album);
				album.add(new Song(album, "37-Münster", new GregorianCalendar(2021, Calendar.FEBRUARY, 25), "https://abdalla.bushnaq.de/wp/home/09-shards-of-music/09-shards-of-music-2021/37-munster/"));
//				album.add(new Song(album, "37-Münster", new GregorianCalendar(2021, Calendar.FEBRUARY, 25), "http://abdalla.bushnaq.de/index.php?id=256"));
				album.add(new Song(album, "38-Gazing out onto the street", new GregorianCalendar(2021, Calendar.MARCH, 27),
						"https://abdalla.bushnaq.de/wp/home/09-shards-of-music/09-shards-of-music-2021/38-gazing-out-onto-the-street/"));
//				album.add(new Song(album, "38-Gazing out onto the street", new GregorianCalendar(2021, Calendar.MARCH, 27), "http://abdalla.bushnaq.de/index.php?id=257"));
				album.add(new Song(album, "39-Thank you for being you", new GregorianCalendar(2021, Calendar.MARCH, 27),
						"https://abdalla.bushnaq.de/wp/home/09-shards-of-music/09-shards-of-music-2021/39-thank-you-for-being-you/"));
//				album.add(new Song(album, "39-Thank you for being you", new GregorianCalendar(2021, Calendar.MARCH, 27), "http://abdalla.bushnaq.de/index.php?id=258"));
			}
		}
		{
			// 08-on the road
			Album album = new Album("08-on the road", "https://abdalla.bushnaq.de/wp/home/08-on-the-road/", true, true);
//			Album album = new Album("08-on the road", "http://abdalla.bushnaq.de/index.php?id=127", true, true);
			add(album);
			// A Story Told 2014.-.- - 2015.Sep.20
			album.add(new Song(album, "01-A Story Told", Genre.ELECTRONIC, new GregorianCalendar(2015, Calendar.NOVEMBER, 24), new GregorianCalendar(2017, Calendar.DECEMBER, 1),
					"https://abdalla.bushnaq.de/wp/home/08-on-the-road/01-a-story-told/"));
//			album.add(new Song(album, "01-A Story Told", new GregorianCalendar(2015, Calendar.NOVEMBER, 24), new GregorianCalendar(2017, Calendar.DECEMBER, 1), "http://abdalla.bushnaq.de/index.php?id=128"));
			// I had a dream 2014.-.- - 2015.Sep.20
			album.add(new Song(album, "02-I had a dream", Genre.INSTRUMENTAL_POP, new GregorianCalendar(2015, Calendar.NOVEMBER, 24), new GregorianCalendar(2017, Calendar.NOVEMBER, 21),
					"https://abdalla.bushnaq.de/wp/home/08-on-the-road/02-i-had-a-dream/"));
//			album.add(new Song(album, "02-I had a dream", new GregorianCalendar(2015, Calendar.NOVEMBER, 24), new GregorianCalendar(2017, Calendar.NOVEMBER, 21), "http://abdalla.bushnaq.de/index.php?id=129"));
			// The Dark Army 2014.-.- - 2015.Sep.20
			album.add(new Song(album, "03-The Dark Army", Genre.INSTRUMENTAL_ROCK, new GregorianCalendar(2019, Calendar.FEBRUARY, 16), new GregorianCalendar(2019, Calendar.FEBRUARY, 16),
					"https://abdalla.bushnaq.de/wp/home/08-on-the-road/03-the-dark-army/"));
//			album.add(new Song(album, "03-The Dark Army", new GregorianCalendar(2019, Calendar.FEBRUARY, 16), new GregorianCalendar(2019, Calendar.FEBRUARY, 16), "http://abdalla.bushnaq.de/index.php?id=130"));
			// Windmills in Germany 2014.-.- - 2015.Sep.20
			album.add(new Song(album, "04-Windmills in Germany", Genre.INSTRUMENTAL_ROCK, new GregorianCalendar(2015, Calendar.NOVEMBER, 24), new GregorianCalendar(2017, Calendar.NOVEMBER, 21),
					"https://abdalla.bushnaq.de/wp/home/08-on-the-road/04-windmills-in-germany/"));
//			album.add(new Song(album, "04-Windmills in Germany", new GregorianCalendar(2015, Calendar.NOVEMBER, 24), new GregorianCalendar(2017, Calendar.NOVEMBER, 21), "http://abdalla.bushnaq.de/index.php?id=131"));
		}
		{
			// 07-New World
			Album album = new Album("07-New World", "https://abdalla.bushnaq.de/wp/home/07-new-world/", true, true);
//			Album album = new Album("07-New World", "http://abdalla.bushnaq.de/index.php?id=102", true, true);
			add(album);
			// nothing is keeping us 2013.Nov.02 - 2017.Feb.12
			album.add(new Song(album, "01-nothing is keeping us", Genre.POP, new GregorianCalendar(2013, Calendar.NOVEMBER, 2), new GregorianCalendar(2017, Calendar.FEBRUARY, 12),
					"https://abdalla.bushnaq.de/wp/home/07-new-world/01-nothing-is-keeping-us/"));
//			album.add(new Song(album, "01-nothing is keeping us", new GregorianCalendar(2013, Calendar.NOVEMBER, 2), new GregorianCalendar(2017, Calendar.FEBRUARY, 12), "http://abdalla.bushnaq.de/index.php?id=103"));
			// Summer Day 2014.Feb.15 - 2017.Feb.12
			album.add(new Song(album, "02-Summer Day", Genre.INSTRUMENTAL_POP, new GregorianCalendar(2014, Calendar.FEBRUARY, 15), new GregorianCalendar(2017, Calendar.FEBRUARY, 12),
					"https://abdalla.bushnaq.de/wp/home/07-new-world/02-summer-day/"));
//			album.add(new Song(album, "02-Summer Day", new GregorianCalendar(2014, Calendar.FEBRUARY, 15), new GregorianCalendar(2017, Calendar.FEBRUARY, 12), "http://abdalla.bushnaq.de/index.php?id=133"));
			// Signal 2016.Jan.09 - 2017.Feb.12
			album.add(new Song(album, "03-Signal", Genre.ELECTRONIC, new GregorianCalendar(2016, Calendar.JANUARY, 9), new GregorianCalendar(2017, Calendar.FEBRUARY, 12),
					"https://abdalla.bushnaq.de/wp/home/07-new-world/03-signal/"));
//			album.add(new Song(album, "03-Signal", new GregorianCalendar(2016, Calendar.JANUARY, 9), new GregorianCalendar(2017, Calendar.FEBRUARY, 12), "http://abdalla.bushnaq.de/index.php?id=132"));
			album.add(new Song(album, "04-precious little things", Genre.POP, new GregorianCalendar(2014, Calendar.MAY, 26), new GregorianCalendar(2019, Calendar.AUGUST, 24),
					"https://abdalla.bushnaq.de/wp/home/07-new-world/04-precious-little-things/"));
//			album.add(new Song(album, "04-precious little things", new GregorianCalendar(2014, Calendar.MAY, 26), new GregorianCalendar(2019, Calendar.AUGUST, 24), "http://abdalla.bushnaq.de/index.php?id=134"));
			// The creature from the sea 2017.Apr.30 - 2017.Apr.30
			album.add(new Song(album, "05-The creature from the sea", Genre.SOUNDTRACK, new GregorianCalendar(2016, Calendar.APRIL, 30), new GregorianCalendar(2017, Calendar.APRIL, 30),
					"https://abdalla.bushnaq.de/wp/home/07-new-world/05-the-creature-from-the-sea/"));
//			album.add(new Song(album, "05-The creature from the sea", new GregorianCalendar(2016, Calendar.APRIL, 30), new GregorianCalendar(2017, Calendar.APRIL, 30), "http://abdalla.bushnaq.de/index.php?id=135"));
			// Don't play in the wood 2017.Apr.30 - 2017.Apr.30
			album.add(new Song(album, "06-Don't play in the woods", Genre.SOUNDTRACK, new GregorianCalendar(2016, Calendar.APRIL, 30), new GregorianCalendar(2017, Calendar.APRIL, 30),
					"https://abdalla.bushnaq.de/wp/home/07-new-world/06-dont-play-in-the-woods/"));
//			album.add(new Song(album, "06-Don't play in the woods", new GregorianCalendar(2016, Calendar.APRIL, 30), new GregorianCalendar(2017, Calendar.APRIL, 30), "http://abdalla.bushnaq.de/index.php?id=136"));
			// Defying the gods 2015.Dec.19 - 2017.May.07
			album.add(new Song(album, "07-Defying the gods", Genre.SOUNDTRACK, new GregorianCalendar(2015, Calendar.DECEMBER, 19), new GregorianCalendar(2017, Calendar.MARCH, 7),
					"https://abdalla.bushnaq.de/wp/home/07-new-world/07-defying-the-gods/"));
//			album.add(new Song(album, "07-Defying the gods", new GregorianCalendar(2015, Calendar.DECEMBER, 19), new GregorianCalendar(2017, Calendar.MARCH, 7), "http://abdalla.bushnaq.de/index.php?id=137"));
		}
		{
			// 06-fidelitas
			Album album = new Album("06-fidelitas", "https://abdalla.bushnaq.de/wp/home/06-fidelitas/", true, true);
//			Album album = new Album("06-fidelitas", "http://abdalla.bushnaq.de/index.php?id=92", true, true);
			add(album);
			// fidelias 2013.Feb.09 - 2013.Jun.21
			album.add(new Song(album, "01-fidelitas", Genre.ELECTRONIC, new GregorianCalendar(2013, Calendar.FEBRUARY, 9), new GregorianCalendar(2013, Calendar.JUNE, 21),
					"https://abdalla.bushnaq.de/wp/home/06-fidelitas/01-fidelitas/"));
//			album.add(new Song(album, "01-fidelitas", new GregorianCalendar(2013, Calendar.FEBRUARY, 9), new GregorianCalendar(2013, Calendar.JUNE, 21), "http://abdalla.bushnaq.de/index.php?id=94"));
			// methodica 2013.Mar.24 - 2013.Sep.06
			album.add(new Song(album, "02-methodica", Genre.ELECTRONIC, new GregorianCalendar(2013, Calendar.MARCH, 24), new GregorianCalendar(2013, Calendar.SEPTEMBER, 6),
					"https://abdalla.bushnaq.de/wp/home/06-fidelitas/02-methodica/"));
//			album.add(new Song(album, "02-methodica", new GregorianCalendar(2013, Calendar.MARCH, 24), new GregorianCalendar(2013, Calendar.SEPTEMBER, 6), "http://abdalla.bushnaq.de/index.php?id=95"));
			// exploratio 2013.Aug.24 - 2013.Sep.17
			album.add(new Song(album, "03-exploratio", Genre.ELECTRONIC, new GregorianCalendar(2013, Calendar.AUGUST, 24), new GregorianCalendar(2013, Calendar.SEPTEMBER, 17),
					"https://abdalla.bushnaq.de/wp/home/06-fidelitas/03-exploratio/"));
//			album.add(new Song(album, "03-exploratio", new GregorianCalendar(2013, Calendar.AUGUST, 24), new GregorianCalendar(2013, Calendar.SEPTEMBER, 17), "http://abdalla.bushnaq.de/index.php?id=96"));
			// miraculum 2014.Mar.24 - 2014.Apr.06
			album.add(new Song(album, "04-miraculum", Genre.ELECTRONIC, new GregorianCalendar(2014, Calendar.MARCH, 24), new GregorianCalendar(2014, Calendar.APRIL, 6),
					"https://abdalla.bushnaq.de/wp/home/06-fidelitas/04-miraculum/"));
//			album.add(new Song(album, "04-miraculum", new GregorianCalendar(2014, Calendar.MARCH, 24), new GregorianCalendar(2014, Calendar.APRIL, 6), "http://abdalla.bushnaq.de/index.php?id=99"));
			album.add(new Song(album, "05-destiny", Genre.POP, new GregorianCalendar(2012, Calendar.FEBRUARY, 25), new GregorianCalendar(2019, Calendar.AUGUST, 23),
					"https://abdalla.bushnaq.de/wp/home/06-fidelitas/05-destiny/"));
//			album.add(new Song(album, "05-destiny", new GregorianCalendar(2012, Calendar.FEBRUARY, 25), new GregorianCalendar(2019, Calendar.AUGUST, 23), "http://abdalla.bushnaq.de/index.php?id=145"));
			album.add(new Song(album, "06-five", Genre.POP, new GregorianCalendar(2014, Calendar.MARCH, 24), new GregorianCalendar(2019, Calendar.AUGUST, 25), "https://abdalla.bushnaq.de/wp/home/06-fidelitas/06-five/"));
//			album.add(new Song(album, "06-five", new GregorianCalendar(2014, Calendar.MARCH, 24), new GregorianCalendar(2019, Calendar.AUGUST, 25), "http://abdalla.bushnaq.de/index.php?id=146"));
		}
		{
			// 05-Humans
			Album album = new Album("05-Humans", "https://abdalla.bushnaq.de/wp/home/05-humans/", true, true);
//			Album album = new Album("05-Humans", "http://abdalla.bushnaq.de/index.php?id=81", true, true);
			add(album);
			// Humans 2008.Oct.15 - 2012.Jun.03
			album.add(new Song(album, "01-Humans", Genre.POP, new GregorianCalendar(2008, Calendar.OCTOBER, 15), new GregorianCalendar(2012, Calendar.JUNE, 3), "https://abdalla.bushnaq.de/wp/home/05-humans/01-humans/"));
//			album.add(new Song(album, "01-Humans", new GregorianCalendar(2008, Calendar.OCTOBER, 15), new GregorianCalendar(2012, Calendar.JUNE, 3), "http://abdalla.bushnaq.de/index.php?id=37"));
			// Burst like bubbles 2012.May.07 - 2012.Jun.03
			album.add(new Song(album, "02-Burst like bubbles", Genre.POP, new GregorianCalendar(2012, Calendar.MARCH, 7), new GregorianCalendar(2012, Calendar.JUNE, 3),
					"https://abdalla.bushnaq.de/wp/home/05-humans/02-burst-like-bubbles/"));
//			album.add(new Song(album, "02-Burst like bubbles", new GregorianCalendar(2012, Calendar.MARCH, 7), new GregorianCalendar(2012, Calendar.JUNE, 3), "http://abdalla.bushnaq.de/index.php?id=83"));
			// I wish I was
			album.add(new Song(album, "03-I wish I was", Genre.POP, new GregorianCalendar(2011, Calendar.SEPTEMBER, 8), new GregorianCalendar(2013, Calendar.MARCH, 15),
					"https://abdalla.bushnaq.de/wp/home/05-humans/03-i-wish-i-was/"));
//			album.add(new Song(album, "03-I wish I was", new GregorianCalendar(2011, Calendar.SEPTEMBER, 8), new GregorianCalendar(2013, Calendar.MARCH, 15), "https://abdalla.bushnaq.de/index.php?id=63"));
			// Try it for the day
			album.add(new Song(album, "04-Try it for the day", Genre.POP, new GregorianCalendar(2011, Calendar.OCTOBER, 18), new GregorianCalendar(2013, Calendar.MARCH, 31),
					"https://abdalla.bushnaq.de/wp/home/05-humans/04-try-it-for-the-day/"));
//			album.add(new Song(album, "04-Try it for the day", new GregorianCalendar(2011, Calendar.OCTOBER, 18), new GregorianCalendar(2013, Calendar.MARCH, 31), "http://abdalla.bushnaq.de/index.php?id=84"));
			// What would you do 2012.Aug.26 - 2013.Feb.12
			album.add(new Song(album, "05-What would you do", Genre.POP, new GregorianCalendar(2012, Calendar.AUGUST, 26), new GregorianCalendar(2013, Calendar.FEBRUARY, 12),
					"https://abdalla.bushnaq.de/wp/home/05-humans/05-what-would-you-do/"));
//			album.add(new Song(album, "05-What would you do", new GregorianCalendar(2012, Calendar.AUGUST, 26), new GregorianCalendar(2013, Calendar.FEBRUARY, 12), "http://abdalla.bushnaq.de/index.php?id=85"));
			// Uranos 2012.Aug.12 - 2012.Aug.25
			album.add(new Song(album, "06-Uranos", Genre.INSTRUMENTAL_POP, new GregorianCalendar(2012, Calendar.AUGUST, 12), new GregorianCalendar(2012, Calendar.AUGUST, 25),
					"https://abdalla.bushnaq.de/wp/home/05-humans/06-uranos/"));
//			album.add(new Song(album, "06-Uranos", new GregorianCalendar(2012, Calendar.AUGUST, 12), new GregorianCalendar(2012, Calendar.AUGUST, 25), "http://abdalla.bushnaq.de/index.php?id=86"));
			// Sometimes 2009.May.21 - 2012.Aug.25
			album.add(new Song(album, "07-Sometimes", Genre.POP, new GregorianCalendar(2009, Calendar.MAY, 21), new GregorianCalendar(2012, Calendar.AUGUST, 25),
					"https://abdalla.bushnaq.de/wp/home/05-humans/07-sometimes/"));
//			album.add(new Song(album, "07-Sometimes", new GregorianCalendar(2009, Calendar.MAY, 21), new GregorianCalendar(2012, Calendar.AUGUST, 25), "http://abdalla.bushnaq.de/index.php?id=87"));
			// Serious Girl 2013.Mar.31 - 2013.May.30
			album.add(new Song(album, "08-Serious Girl", Genre.POP, new GregorianCalendar(2013, Calendar.MARCH, 31), new GregorianCalendar(2013, Calendar.MAY, 30),
					"https://abdalla.bushnaq.de/wp/home/05-humans/08-serious-girl/"));
//			album.add(new Song(album, "08-Serious Girl", new GregorianCalendar(2013, Calendar.MARCH, 31), new GregorianCalendar(2013, Calendar.MAY, 30), "http://abdalla.bushnaq.de/index.php?id=91"));
			// Mary from upstairs 2012.Aug.18 - 2014.Feb.23
			album.add(new Song(album, "09-Mary from upstairs", Genre.POP, new GregorianCalendar(2012, Calendar.AUGUST, 18), new GregorianCalendar(2014, Calendar.FEBRUARY, 23),
					"https://abdalla.bushnaq.de/wp/home/05-humans/09-mary-from-upstairs/"));
//			album.add(new Song(album, "09-Mary from upstairs", new GregorianCalendar(2012, Calendar.AUGUST, 18), new GregorianCalendar(2014, Calendar.FEBRUARY, 23), "http://abdalla.bushnaq.de/index.php?id=97"));
			// Morning dew 2013.Dec.25 - 2014.Mar.09
			album.add(new Song(album, "10-Morning dew", Genre.INSTRUMENTAL_POP, new GregorianCalendar(2013, Calendar.DECEMBER, 25), new GregorianCalendar(2014, Calendar.MARCH, 9),
					"https://abdalla.bushnaq.de/wp/home/05-humans/10-morning-dew/"));
//			album.add(new Song(album, "10-Morning dew", new GregorianCalendar(2013, Calendar.DECEMBER, 25), new GregorianCalendar(2014, Calendar.MARCH, 9), "http://abdalla.bushnaq.de/index.php?id=98"));
			// Jesus set you up 2014.Feb.28 - 2014.Apr.11
			album.add(new Song(album, "11-Jesus set you up", Genre.POP, new GregorianCalendar(2014, Calendar.FEBRUARY, 28), new GregorianCalendar(2014, Calendar.APRIL, 11),
					"https://abdalla.bushnaq.de/wp/home/05-humans/11-jesus-set-you-up/"));
//			album.add(new Song(album, "11-Jesus set you up", new GregorianCalendar(2014, Calendar.FEBRUARY, 28), new GregorianCalendar(2014, Calendar.APRIL, 11), "http://abdalla.bushnaq.de/index.php?id=100"));
			// Thankfulness 2014.Mar.15 - 2014.Jun.01
			album.add(new Song(album, "12-Thankfulness", Genre.POP, new GregorianCalendar(2014, Calendar.MARCH, 15), new GregorianCalendar(2014, Calendar.JUNE, 1),
					"https://abdalla.bushnaq.de/wp/home/05-humans/12-thankfulness/"));
//			album.add(new Song(album, "12-Thankfulness", new GregorianCalendar(2014, Calendar.MARCH, 15), new GregorianCalendar(2014, Calendar.JUNE, 1), "http://abdalla.bushnaq.de/index.php?id=101"));
			album.add(new Song(album, "13-it took you", Genre.POP, new GregorianCalendar(2007, Calendar.OCTOBER, 29), new GregorianCalendar(2019, Calendar.AUGUST, 23),
					"https://abdalla.bushnaq.de/wp/home/05-humans/13-it-took-you/"));
//			album.add(new Song(album, "13-it took you", new GregorianCalendar(2007, Calendar.OCTOBER, 29), new GregorianCalendar(2019, Calendar.AUGUST, 23), "http://abdalla.bushnaq.de/index.php?id=82"));
		}
		{
			// 04-Magic_Everywhere
			Album album = new Album("04-Magic_Everywhere", "https://abdalla.bushnaq.de/wp/home/04-magic-everywhere/", true, true);
//			Album album = new Album("04-Magic_Everywhere", "http://abdalla.bushnaq.de/index.php?id=10", true, true);
			add(album);
			// Carton box 2007.Jul.15 - 2009.Apr.06
			album.add(new Song(album, "01-Carton box", Genre.INSTRUMENTAL_POP, new GregorianCalendar(2007, Calendar.JULY, 15), new GregorianCalendar(2009, Calendar.APRIL, 6),
					"https://abdalla.bushnaq.de/wp/home/04-magic-everywhere/01-carton-box/"));
//			album.add(new Song(album, "01-Carton box", new GregorianCalendar(2007, Calendar.JULY, 15), new GregorianCalendar(2009, Calendar.APRIL, 6), "http://abdalla.bushnaq.de/index.php?id=31"));
			// Wake up 2008.Jan.20 - 2009.Apr.19
			album.add(new Song(album, "02-Wake up", Genre.POP, new GregorianCalendar(2008, Calendar.JANUARY, 20), new GregorianCalendar(2009, Calendar.APRIL, 19),
					"https://abdalla.bushnaq.de/wp/home/04-magic-everywhere/02-wake-up/"));
//			album.add(new Song(album, "02-Wake up", new GregorianCalendar(2008, Calendar.JANUARY, 20), new GregorianCalendar(2009, Calendar.APRIL, 19), "http://abdalla.bushnaq.de/index.php?id=29"));
			// Afterwards 2008.Jan.27 - 2009.Apr.19
			album.add(new Song(album, "03-Afterwards", Genre.POP, new GregorianCalendar(2008, Calendar.JANUARY, 27), new GregorianCalendar(2009, Calendar.APRIL, 19),
					"https://abdalla.bushnaq.de/wp/home/04-magic-everywhere/03-afterwards/"));
//			album.add(new Song(album, "03-Afterwards", new GregorianCalendar(2008, Calendar.JANUARY, 27), new GregorianCalendar(2009, Calendar.APRIL, 19), "http://abdalla.bushnaq.de/index.php?id=32"));
			// Little Girl 2009.May.21 - 2010.Aug.05
			album.add(new Song(album, "04-Little Girl", Genre.POP, new GregorianCalendar(2009, Calendar.MAY, 21), new GregorianCalendar(2010, Calendar.AUGUST, 5),
					"https://abdalla.bushnaq.de/wp/home/04-magic-everywhere/04-little-girl/"));
//			album.add(new Song(album, "04-Little Girl", new GregorianCalendar(2009, Calendar.MAY, 21), new GregorianCalendar(2010, Calendar.AUGUST, 5), "http://abdalla.bushnaq.de/index.php?id=30"));
			// Texas boogie 2006.Dec.02 - 2012.Apr.28
			album.add(new Song(album, "05-Texas boogie", Genre.INSTRUMENTAL_POP, new GregorianCalendar(2006, Calendar.DECEMBER, 2), new GregorianCalendar(2012, Calendar.APRIL, 28),
					"https://abdalla.bushnaq.de/wp/home/04-magic-everywhere/05-texas-boogie/"));
//			album.add(new Song(album, "05-Texas boogie", new GregorianCalendar(2006, Calendar.DECEMBER, 2), new GregorianCalendar(2012, Calendar.APRIL, 28), "http://abdalla.bushnaq.de/index.php?id=75"));
			// I want to 2011.Oct.14 - 2011.Dec.25
			album.add(new Song(album, "06-I want to", Genre.POP, new GregorianCalendar(2011, Calendar.OCTOBER, 14), new GregorianCalendar(2011, Calendar.DECEMBER, 25),
					"https://abdalla.bushnaq.de/wp/home/04-magic-everywhere/06-i-want-to/"));
//			album.add(new Song(album, "06-I want to", new GregorianCalendar(2011, Calendar.OCTOBER, 14), new GregorianCalendar(2011, Calendar.DECEMBER, 25), "http://abdalla.bushnaq.de/index.php?id=33"));
			// Magic everywhere 2009.May.21 - 2011.Sep.08
			album.add(new Song(album, "07-Magic everywhere", Genre.POP, new GregorianCalendar(2009, Calendar.MAY, 21), new GregorianCalendar(2011, Calendar.SEPTEMBER, 8),
					"https://abdalla.bushnaq.de/wp/home/04-magic-everywhere/07-magic-everywhere/"));
//			album.add(new Song(album, "07-Magic everywhere", new GregorianCalendar(2009, Calendar.MAY, 21), new GregorianCalendar(2011, Calendar.SEPTEMBER, 8), "http://abdalla.bushnaq.de/index.php?id=62"));
			// God don't give a damn 2012.Jan.30 - 2012.Apr.29
			album.add(new Song(album, "08-God don't give a damn", Genre.POP, new GregorianCalendar(2012, Calendar.JANUARY, 30), new GregorianCalendar(2012, Calendar.APRIL, 29),
					"https://abdalla.bushnaq.de/wp/home/04-magic-everywhere/08-god-dont-give-a-damn/"));
//			album.add(new Song(album, "08-God don't give a damn", new GregorianCalendar(2012, Calendar.JANUARY, 30), new GregorianCalendar(2012, Calendar.APRIL, 29), "http://abdalla.bushnaq.de/index.php?id=79"));
			// Grace 2002.Aug.07 - 2012.Apr.29
			album.add(new Song(album, "09-Grace", Genre.POP, new GregorianCalendar(2002, Calendar.AUGUST, 7), new GregorianCalendar(2012, Calendar.APRIL, 29),
					"https://abdalla.bushnaq.de/wp/home/04-magic-everywhere/09-grace/"));
//			album.add(new Song(album, "09-Grace", new GregorianCalendar(2002, Calendar.AUGUST, 7), new GregorianCalendar(2012, Calendar.APRIL, 29), "http://abdalla.bushnaq.de/index.php?id=80"));
		}
		{
			// 03-Toyshop
			Album album = new Album("03-Toyshop", "https://abdalla.bushnaq.de/wp/home/03-toyshop-2/", true, true);
//			Album album = new Album("03-Toyshop", "http://abdalla.bushnaq.de/index.php?id=11", true, true);
			add(album);
			// ToyShop 29.5.2003 - 20.8.2006
			album.add(new Song(album, "01-ToyShop", Genre.INSTRUMENTAL_POP, new GregorianCalendar(2003, Calendar.MAY, 29), new GregorianCalendar(2006, Calendar.AUGUST, 10),
					"https://abdalla.bushnaq.de/wp/home/03-toyshop-2/01-toyshop/"));
//			album.add(new Song(album, "01-ToyShop", new GregorianCalendar(2003, Calendar.MAY, 29), new GregorianCalendar(2006, Calendar.AUGUST, 10), "http://abdalla.bushnaq.de/index.php?id=43"));
			// Echo of Joy 4.7.2003 - 25.8.2006
			album.add(new Song(album, "02-Echo of Joy", Genre.INSTRUMENTAL_POP, new GregorianCalendar(2003, Calendar.APRIL, 4), new GregorianCalendar(2006, Calendar.AUGUST, 25),
					"https://abdalla.bushnaq.de/wp/home/03-toyshop-2/02-echo-of-joy/"));
//			album.add(new Song(album, "02-Echo of Joy", new GregorianCalendar(2003, Calendar.APRIL, 4), new GregorianCalendar(2006, Calendar.AUGUST, 25), "http://abdalla.bushnaq.de/index.php?id=38"));
			// Irish Tale 29.5.2003 - 27.8.2006
			album.add(new Song(album, "03-Irish Tale", Genre.INSTRUMENTAL_POP, new GregorianCalendar(2003, Calendar.MAY, 29), new GregorianCalendar(2006, Calendar.AUGUST, 27),
					"https://abdalla.bushnaq.de/wp/home/03-toyshop-2/03-irish-tale/"));
//			album.add(new Song(album, "03-Irish Tale", new GregorianCalendar(2003, Calendar.MAY, 29), new GregorianCalendar(2006, Calendar.AUGUST, 27), "http://abdalla.bushnaq.de/index.php?id=39"));
			// Falling Leaves 6.7.2003 - 27.8.2006
			album.add(new Song(album, "04-Falling Leaves", Genre.INSTRUMENTAL_POP, new GregorianCalendar(2003, Calendar.JULY, 6), new GregorianCalendar(2006, Calendar.AUGUST, 27),
					"https://abdalla.bushnaq.de/wp/home/03-toyshop-2/04-falling-leaves/"));
//			album.add(new Song(album, "04-Falling Leaves", new GregorianCalendar(2003, Calendar.JULY, 6), new GregorianCalendar(2006, Calendar.AUGUST, 27), "http://abdalla.bushnaq.de/index.php?id=40"));
			// Gothic -.-.---- - 29.6.2003
			album.add(new Song(album, "05-Gothic", Genre.INSTRUMENTAL_POP, new GregorianCalendar(2003, Calendar.JUNE, 29), new GregorianCalendar(2003, Calendar.JUNE, 29),
					"https://abdalla.bushnaq.de/wp/home/03-toyshop-2/05-gothic/"));
//			album.add(new Song(album, "05-Gothic", new GregorianCalendar(2003, Calendar.JUNE, 29), new GregorianCalendar(2003, Calendar.JUNE, 29), "http://abdalla.bushnaq.de/index.php?id=44"));
			// Construction plant 28.10.2002 - 20.8.2006
			album.add(new Song(album, "06-Construction plant", Genre.INSTRUMENTAL_POP, new GregorianCalendar(2002, Calendar.OCTOBER, 28), new GregorianCalendar(2006, Calendar.AUGUST, 20),
					"https://abdalla.bushnaq.de/wp/home/03-toyshop-2/06-construction-plant/"));
//			album.add(new Song(album, "06-Construction plant", new GregorianCalendar(2002, Calendar.OCTOBER, 28), new GregorianCalendar(2006, Calendar.AUGUST, 20), "http://abdalla.bushnaq.de/index.php?id=45"));
			// Electronic Church 27.2.2002 - 22.7.2002
			album.add(new Song(album, "07-Electronic Church", Genre.INSTRUMENTAL_POP, new GregorianCalendar(2002, Calendar.FEBRUARY, 27), new GregorianCalendar(2002, Calendar.JULY, 22),
					"https://abdalla.bushnaq.de/wp/home/03-toyshop-2/07-electronic-church/"));
//			album.add(new Song(album, "07-Electronic Church", new GregorianCalendar(2002, Calendar.FEBRUARY, 27), new GregorianCalendar(2002, Calendar.JULY, 22), "http://abdalla.bushnaq.de/index.php?id=41"));
			// Caroline 22.4.2002 - 20.8.2006
			album.add(new Song(album, "08-Caroline", Genre.INSTRUMENTAL_POP, new GregorianCalendar(2002, Calendar.APRIL, 22), new GregorianCalendar(2006, Calendar.AUGUST, 20),
					"https://abdalla.bushnaq.de/wp/home/03-toyshop-2/08-caroline/"));
//			album.add(new Song(album, "08-Caroline", new GregorianCalendar(2002, Calendar.APRIL, 22), new GregorianCalendar(2006, Calendar.AUGUST, 20), "http://abdalla.bushnaq.de/index.php?id=46"));
			// Rain on a Japanese Lake 19.4.2003 - 15.8.2003
			album.add(new Song(album, "09-Rain on a Japanese Lake", Genre.INSTRUMENTAL_POP, new GregorianCalendar(2003, Calendar.APRIL, 19), new GregorianCalendar(2003, Calendar.AUGUST, 15),
					"https://abdalla.bushnaq.de/wp/home/03-toyshop-2/09-rain-on-a-japanese-lake/"));
//			album.add(new Song(album, "09-Rain on a Japanese Lake", new GregorianCalendar(2003, Calendar.APRIL, 19), new GregorianCalendar(2003, Calendar.AUGUST, 15), "http://abdalla.bushnaq.de/index.php?id=42"));
		}
		{
			// 02-Across the universe
			Album album = new Album("02-Across the universe", "https://abdalla.bushnaq.de/wp/home/02-across-the-universe/", true, true);
//			Album album = new Album("02-Across the universe", "http://abdalla.bushnaq.de/index.php?id=cetest_firstpage0", true, true);
			add(album);
			// Earth 21.3.2001 - 27.1.2002
			album.add(new Song(album, "01-Earth", Genre.INSTRUMENTAL_POP, new GregorianCalendar(2002, Calendar.MARCH, 21), new GregorianCalendar(2002, Calendar.JANUARY, 27),
					"https://abdalla.bushnaq.de/wp/home/02-across-the-universe/01-earth/"));
//			album.add(new Song(album, "01-Earth", new GregorianCalendar(2002, Calendar.MARCH, 21), new GregorianCalendar(2002, Calendar.JANUARY, 27), "http://abdalla.bushnaq.de/index.php?id=65"));
			// Orion 19.5.2001 - 17.8.2001
			album.add(new Song(album, "02-Orion", Genre.INSTRUMENTAL_POP, new GregorianCalendar(2001, Calendar.MAY, 19), new GregorianCalendar(2001, Calendar.AUGUST, 17),
					"https://abdalla.bushnaq.de/wp/home/02-across-the-universe/02-orion/"));
//			album.add(new Song(album, "02-Orion", new GregorianCalendar(2001, Calendar.MAY, 19), new GregorianCalendar(2001, Calendar.AUGUST, 17), "http://abdalla.bushnaq.de/index.php?id=66"));
			// Homeland 28.1.2001 - 18.8.2001
			album.add(new Song(album, "03-Homeland", Genre.INSTRUMENTAL_POP, new GregorianCalendar(2001, Calendar.JANUARY, 28), new GregorianCalendar(2001, Calendar.AUGUST, 18),
					"https://abdalla.bushnaq.de/wp/home/02-across-the-universe/03-homeland/"));
//			album.add(new Song(album, "03-Homeland", new GregorianCalendar(2001, Calendar.JANUARY, 28), new GregorianCalendar(2001, Calendar.AUGUST, 18), "http://abdalla.bushnaq.de/index.php?id=67"));
			// Fast Pace 18.3.2001 - 27.1.2002
			album.add(new Song(album, "04-Fast Pace", Genre.INSTRUMENTAL_POP, new GregorianCalendar(2001, Calendar.MARCH, 18), new GregorianCalendar(2002, Calendar.JANUARY, 27),
					"https://abdalla.bushnaq.de/wp/home/02-across-the-universe/04-fast-pace/"));
//			album.add(new Song(album, "04-Fast Pace", new GregorianCalendar(2001, Calendar.MARCH, 18), new GregorianCalendar(2002, Calendar.JANUARY, 27), "http://abdalla.bushnaq.de/index.php?id=68"));
			// Jupiter 16.2.2001 - 14.2.2002
			album.add(new Song(album, "05-Jupiter", Genre.INSTRUMENTAL_POP, new GregorianCalendar(2001, Calendar.FEBRUARY, 26), new GregorianCalendar(2002, Calendar.APRIL, 12),
					"https://abdalla.bushnaq.de/wp/home/02-across-the-universe/05-jupiter/"));
//			album.add(new Song(album, "05-Jupiter", new GregorianCalendar(2001, Calendar.FEBRUARY, 26), new GregorianCalendar(2002, Calendar.APRIL, 12), "http://abdalla.bushnaq.de/index.php?id=69"));
			// PO Film 6.2.1999 - 11.3.2001
			album.add(new Song(album, "06-PO Film", Genre.INSTRUMENTAL_POP, new GregorianCalendar(1999, Calendar.FEBRUARY, 6), new GregorianCalendar(2001, Calendar.MARCH, 11),
					"https://abdalla.bushnaq.de/wp/home/02-across-the-universe/06-po-film/"));
//			album.add(new Song(album, "06-PO Film", new GregorianCalendar(1999, Calendar.FEBRUARY, 6), new GregorianCalendar(2001, Calendar.MARCH, 11), "http://abdalla.bushnaq.de/index.php?id=70"));
			// Pluto 8.6.2001 - 17.8.2001
			album.add(new Song(album, "07-Pluto", Genre.INSTRUMENTAL_POP, new GregorianCalendar(2001, Calendar.JUNE, 8), new GregorianCalendar(2001, Calendar.AUGUST, 17),
					"https://abdalla.bushnaq.de/wp/home/02-across-the-universe/07-pluto/"));
//			album.add(new Song(album, "07-Pluto", new GregorianCalendar(2001, Calendar.JUNE, 8), new GregorianCalendar(2001, Calendar.AUGUST, 17), "http://abdalla.bushnaq.de/index.php?id=71"));
			// Rock 23.1.2001 - 15.3.2001
			album.add(new Song(album, "08-Rock", Genre.INSTRUMENTAL_POP, new GregorianCalendar(2001, Calendar.JANUARY, 23), new GregorianCalendar(2001, Calendar.MARCH, 15),
					"https://abdalla.bushnaq.de/wp/home/02-across-the-universe/08-rock/"));
//			album.add(new Song(album, "08-Rock", new GregorianCalendar(2001, Calendar.JANUARY, 23), new GregorianCalendar(2001, Calendar.MARCH, 15), "http://abdalla.bushnaq.de/index.php?id=72"));
			// Soul door 11.12.2001 - 27.1.2002
			album.add(new Song(album, "09-Soul door", Genre.INSTRUMENTAL_POP, new GregorianCalendar(2001, Calendar.DECEMBER, 11), new GregorianCalendar(2002, Calendar.JANUARY, 27),
					"https://abdalla.bushnaq.de/wp/home/02-across-the-universe/09-soul-door/"));
//			album.add(new Song(album, "09-Soul door", new GregorianCalendar(2001, Calendar.DECEMBER, 11), new GregorianCalendar(2002, Calendar.JANUARY, 27), "http://abdalla.bushnaq.de/index.php?id=73"));
		}
		{
			// 01-Recreation of a knowledge seeking mind
			Album album = new Album("01-Recreation of a knowledge seeking mind", "https://abdalla.bushnaq.de/wp/home/01-recreation-of-a-knowledge-seeking-mind/", true, true);
//			Album album = new Album("01-Recreation of a knowledge seeking mind", "http://abdalla.bushnaq.de/index.php?id=cetest_firstpage", true, true);
			add(album);
			// God 31.10.1998 - 7.11.1998
			album.add(new Song(album, "01-God", Genre.INSTRUMENTAL_POP, new GregorianCalendar(1998, Calendar.OCTOBER, 31), new GregorianCalendar(1998, Calendar.NOVEMBER, 7),
					"https://abdalla.bushnaq.de/wp/home/01-recreation-of-a-knowledge-seeking-mind/01-god/"));
//			album.add(new Song(album, "01-God", new GregorianCalendar(1998, Calendar.OCTOBER, 31), new GregorianCalendar(1998, Calendar.NOVEMBER, 7), "http://abdalla.bushnaq.de/index.php?id=47"));
			// Whales 31.10.1998 - 7.11.1998
			album.add(new Song(album, "02-Whales", Genre.INSTRUMENTAL_POP, new GregorianCalendar(1998, Calendar.OCTOBER, 31), new GregorianCalendar(1998, Calendar.NOVEMBER, 7),
					"https://abdalla.bushnaq.de/wp/home/01-recreation-of-a-knowledge-seeking-mind/02-whales/"));
//			album.add(new Song(album, "02-Whales", new GregorianCalendar(1998, Calendar.OCTOBER, 31), new GregorianCalendar(1998, Calendar.NOVEMBER, 7), "http://abdalla.bushnaq.de/index.php?id=48"));
			// Tauglanz 31.10.1998 - 7.11.1998
			album.add(new Song(album, "03-Tauglanz", Genre.INSTRUMENTAL_POP, new GregorianCalendar(1998, Calendar.OCTOBER, 31), new GregorianCalendar(1998, Calendar.NOVEMBER, 7),
					"https://abdalla.bushnaq.de/wp/home/01-recreation-of-a-knowledge-seeking-mind/03-tauglanz/"));
//			album.add(new Song(album, "03-Tauglanz", new GregorianCalendar(1998, Calendar.OCTOBER, 31), new GregorianCalendar(1998, Calendar.NOVEMBER, 7), "http://abdalla.bushnaq.de/index.php?id=49"));
			// Person to person call to God 31.10.1998 - 7.11.1998
			album.add(new Song(album, "04-Person to person call to God", Genre.INSTRUMENTAL_POP, new GregorianCalendar(1998, Calendar.OCTOBER, 31), new GregorianCalendar(1998, Calendar.NOVEMBER, 7),
					"https://abdalla.bushnaq.de/wp/home/01-recreation-of-a-knowledge-seeking-mind/04-person-to-person-call-to-god/"));
//			album.add(new Song(album, "04-Person to person call to God", new GregorianCalendar(1998, Calendar.OCTOBER, 31), new GregorianCalendar(1998, Calendar.NOVEMBER, 7), "http://abdalla.bushnaq.de/index.php?id=50"));
			// Pandance 1.11.1998 - 7.11.1998
			album.add(new Song(album, "05-Pandance", Genre.INSTRUMENTAL_POP, new GregorianCalendar(1998, Calendar.NOVEMBER, 1), new GregorianCalendar(1998, Calendar.NOVEMBER, 7),
					"https://abdalla.bushnaq.de/wp/home/01-recreation-of-a-knowledge-seeking-mind/05-pandance/"));
//			album.add(new Song(album, "05-Pandance", new GregorianCalendar(1998, Calendar.NOVEMBER, 1), new GregorianCalendar(1998, Calendar.NOVEMBER, 7), "http://abdalla.bushnaq.de/index.php?id=51"));
			// Profit 1.11.1998 - 7.11.1998
			album.add(new Song(album, "06-Profit", Genre.INSTRUMENTAL_POP, new GregorianCalendar(1998, Calendar.NOVEMBER, 1), new GregorianCalendar(1998, Calendar.NOVEMBER, 7),
					"https://abdalla.bushnaq.de/wp/home/01-recreation-of-a-knowledge-seeking-mind/06-profit/"));
//			album.add(new Song(album, "06-Profit", new GregorianCalendar(1998, Calendar.NOVEMBER, 1), new GregorianCalendar(1998, Calendar.NOVEMBER, 7), "http://abdalla.bushnaq.de/index.php?id=52"));
			// Freedom to the rest of my people 1.11.1998 - 1.11.1998
			album.add(new Song(album, "07-Freedom to the rest of my people", Genre.INSTRUMENTAL_POP, new GregorianCalendar(1998, Calendar.NOVEMBER, 1), new GregorianCalendar(1998, Calendar.NOVEMBER, 1),
					"https://abdalla.bushnaq.de/wp/home/01-recreation-of-a-knowledge-seeking-mind/07-freedom-to-the-rest-of-my-people/"));
//			album.add(new Song(album, "07-Freedom to the rest of my people", new GregorianCalendar(1998, Calendar.NOVEMBER, 1), new GregorianCalendar(1998, Calendar.NOVEMBER, 1),"http://abdalla.bushnaq.de/index.php?id=53"));
			// Natural 2.11.1998 - 2.11.1998
			album.add(new Song(album, "08-Natural", Genre.INSTRUMENTAL_POP, new GregorianCalendar(1998, Calendar.NOVEMBER, 2), new GregorianCalendar(1998, Calendar.NOVEMBER, 2),
					"https://abdalla.bushnaq.de/wp/home/01-recreation-of-a-knowledge-seeking-mind/08-natural/"));
//			album.add(new Song(album, "08-Natural", new GregorianCalendar(1998, Calendar.NOVEMBER, 2), new GregorianCalendar(1998, Calendar.NOVEMBER, 2), "http://abdalla.bushnaq.de/index.php?id=54"));
			// Soldiers in the desert 2.11.1998 - 2.11.1998
			album.add(new Song(album, "09-Soldiers in the desert", Genre.INSTRUMENTAL_POP, new GregorianCalendar(1998, Calendar.NOVEMBER, 2), new GregorianCalendar(1998, Calendar.NOVEMBER, 2),
					"https://abdalla.bushnaq.de/wp/home/01-recreation-of-a-knowledge-seeking-mind/09-soldiers-in-the-desert/"));
//			album.add(new Song(album, "09-Soldiers in the desert", new GregorianCalendar(1998, Calendar.NOVEMBER, 2), new GregorianCalendar(1998, Calendar.NOVEMBER, 2), "http://abdalla.bushnaq.de/index.php?id=55"));
			// Growing up 17.1.1998 - 2.12.1998
			album.add(new Song(album, "10-Growing up", Genre.INSTRUMENTAL_POP, new GregorianCalendar(1998, Calendar.JANUARY, 17), new GregorianCalendar(1998, Calendar.DECEMBER, 2),
					"https://abdalla.bushnaq.de/wp/home/01-recreation-of-a-knowledge-seeking-mind/10-growing-up/"));
//			album.add(new Song(album, "10-Growing up", new GregorianCalendar(1998, Calendar.JANUARY, 17), new GregorianCalendar(1998, Calendar.DECEMBER, 2), "http://abdalla.bushnaq.de/index.php?id=56"));
			// Morning Break 17.1.1998 - 4.12.1998
			album.add(new Song(album, "11-Morning Break", Genre.INSTRUMENTAL_POP, new GregorianCalendar(1998, Calendar.JANUARY, 17), new GregorianCalendar(1998, Calendar.DECEMBER, 4),
					"https://abdalla.bushnaq.de/wp/home/01-recreation-of-a-knowledge-seeking-mind/11-morning-break/"));
//			album.add(new Song(album, "11-Morning Break", new GregorianCalendar(1998, Calendar.JANUARY, 17), new GregorianCalendar(1998, Calendar.DECEMBER, 4), "http://abdalla.bushnaq.de/index.php?id=57"));
			// Carousel 17.1.1998 - 4.12.1998
			album.add(new Song(album, "12-Carousel", Genre.INSTRUMENTAL_POP, new GregorianCalendar(1998, Calendar.JANUARY, 17), new GregorianCalendar(1998, Calendar.DECEMBER, 4),
					"https://abdalla.bushnaq.de/wp/home/01-recreation-of-a-knowledge-seeking-mind/12-carousel/"));
//			album.add(new Song(album, "12-Carousel", new GregorianCalendar(1998, Calendar.JANUARY, 17), new GregorianCalendar(1998, Calendar.DECEMBER, 4), "http://abdalla.bushnaq.de/index.php?id=58"));
			// Dancing Day 16.4.1998 - 17.3.2001
			album.add(new Song(album, "13-Dancing Day", Genre.INSTRUMENTAL_POP, new GregorianCalendar(1998, Calendar.APRIL, 16), new GregorianCalendar(2001, Calendar.MARCH, 17),
					"https://abdalla.bushnaq.de/wp/home/01-recreation-of-a-knowledge-seeking-mind/13-dancing-day/"));
//			album.add(new Song(album, "13-Dancing Day", new GregorianCalendar(1998, Calendar.APRIL, 16), new GregorianCalendar(2001, Calendar.MARCH, 17), "http://abdalla.bushnaq.de/index.php?id=59"));
			// Train drive through spring rain 16.4.1998 - 7.11.1998
			album.add(new Song(album, "14-Train drive through spring rain", Genre.INSTRUMENTAL_POP, new GregorianCalendar(1998, Calendar.APRIL, 16), new GregorianCalendar(1998, Calendar.NOVEMBER, 7),
					"https://abdalla.bushnaq.de/wp/home/01-recreation-of-a-knowledge-seeking-mind/14-train-drive-through-spring-rain/"));
//			album.add(new Song(album, "14-Train drive through spring rain", new GregorianCalendar(1998, Calendar.APRIL, 16), new GregorianCalendar(1998, Calendar.NOVEMBER, 7), "http://abdalla.bushnaq.de/index.php?id=60"));
			// Far from you 28.10.1998 - 11.12.2001
			album.add(new Song(album, "15-Far from you", Genre.INSTRUMENTAL_POP, new GregorianCalendar(1998, Calendar.OCTOBER, 28), new GregorianCalendar(2001, Calendar.DECEMBER, 11),
					"https://abdalla.bushnaq.de/wp/home/01-recreation-of-a-knowledge-seeking-mind/15-far-from-you/"));
//			album.add(new Song(album, "15-Far from you", new GregorianCalendar(1998, Calendar.OCTOBER, 28), new GregorianCalendar(2001, Calendar.DECEMBER, 11), "http://abdalla.bushnaq.de/index.php?id=61"));
		}
		calculateStartAndEnd();
	}

	@Override
	public boolean add(Album album) {
		album.id = this.size();
		album.color = colors[album.id % colors.length];
		return super.add(album);
	}

	private void calculateStartAndEnd() {
		for (Album album : this) {
			album.calculateStartAndEnd();
			for (Song song : album.list) {
				if (song.end.getTime() < start.getTime())
					start = (Date) song.end.clone();
				if (song.end.getTime() > end.getTime())
					end = (Date) song.end.clone();
			}
		}
	}

	/**
	 * generates mapping between a song name and the album name
	 *
	 * @return
	 */
	public Map<String, String> generateMap() {
		Map<String, String> songMap = new HashMap<>();
		for (Album a : this) {
			int id = 1;
			for (Song s : a.list) {
				String songName;
				if (a.songsAreNumbered) {
					songName = String.format("%s", s.name);
				} else {
					songName = String.format("%02d-%s", id, s.name);
				}
				// String songName = String.format("%02d-%s", id, s.name);
				songName = songName.toLowerCase();
				songName = Util.prepareSongName(songName);
				songMap.put(songName, s.album.name);
				id++;
			}
		}
		return songMap;
	}

}
