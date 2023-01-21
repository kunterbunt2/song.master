package de.bushnaq.abdalla.song.master;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * class to read stdin or stderr for running thread. used by CommandExecuter.java
 *
 * @author abdalla
 *
 */
class StdxReader extends Thread {
	private BufferedReader	ibr;
	private boolean			useStderr;

	public StdxReader(InputStream is, boolean useStderr) {
		InputStreamReader isr = new InputStreamReader(is);
		ibr = new BufferedReader(isr);
		this.useStderr = useStderr;
		start();// start the thread
	}

	@Override
	public void run() {
		try {
			String line;
			while ((line = ibr.readLine()) != null) {
				if (useStderr)
					System.err.println(line);
				else
					System.out.println(line);
			}
			ibr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}