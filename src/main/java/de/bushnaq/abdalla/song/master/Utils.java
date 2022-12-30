package de.bushnaq.abdalla.song.master;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;

public class Utils {

	public static void copyFile(String o, String c) throws IOException {
		File	original		= new File(o);
		Path	copied			= Paths.get(c);
		Path	originalPath	= original.toPath();
		Files.copy(originalPath, copied, StandardCopyOption.REPLACE_EXISTING);
	}

	public static boolean newerThan(File file, File fileCompare) throws IOException {
		Path	path1	= Paths.get(file.getAbsolutePath());
		Path	path2	= Paths.get(fileCompare.getAbsolutePath());
		if (!file.exists())
			return false;
		if (!fileCompare.exists())
			return true;
		BasicFileAttributes	attr1	= Files.readAttributes(path1, BasicFileAttributes.class);
		BasicFileAttributes	attr2	= Files.readAttributes(path2, BasicFileAttributes.class);
		return attr1.lastModifiedTime().toMillis() > attr2.lastModifiedTime().toMillis();
	}

}
