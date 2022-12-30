package de.bushnaq.abdalla.song.master.util;

public class CmdExec {

	public static void execute(String[] command) {
		try {
//			String			line;
//			OutputStream	stdin	= null;
//			InputStream		stderr	= null;
//			InputStream		stdout	= null;

			Process p = new ProcessBuilder().inheritIO().command(command).start();

			// launch the command and grab stdin/stdout and stderr
//			Process			process	= Runtime.getRuntime().exec(command);
//			stdin = process.getOutputStream();
//			stderr = process.getErrorStream();
//			stdout = process.getInputStream();
//
//			// You could write to sdtin too but it's useless for the ls we are doing ;)
//			line = "param1" + "n";
//			stdin.write(line.getBytes());
//			stdin.flush();
//
//			line = "param2" + "n";
//			stdin.write(line.getBytes());
//			stdin.flush();
//
//			stdin.close();
//
//			// clean up if any output in stdout
//			BufferedReader brCleanUp = new BufferedReader(new InputStreamReader(stdout));
//			while ((line = brCleanUp.readLine()) != null) {
//				System.out.println("[Stdout] " + line);
//			}
//			brCleanUp.close();
//
//			// clean up if any output in stderr
//			brCleanUp = new BufferedReader(new InputStreamReader(stderr));
//			while ((line = brCleanUp.readLine()) != null) {
//				 System.out.println ("[Stderr] " + line);
//			}
//			brCleanUp.close();
//
//			System.out.println("Exit value: " + process.exitValue());
			while (p.isAlive()) {
				Thread.sleep(100);
			}
			p.destroy();
		} catch (Exception err) {
			err.printStackTrace();
		}
	}
}