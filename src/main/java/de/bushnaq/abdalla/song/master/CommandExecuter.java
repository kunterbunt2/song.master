package de.bushnaq.abdalla.song.master;

import java.util.ArrayList;
import java.util.List;

public class CommandExecuter {
	static private List<StdxReader> readers = new ArrayList<>();

	public static void close() throws InterruptedException {
		System.out.println("waiting for all threads to terminate...");
		for (StdxReader reader : readers) {
			reader.join();// wait for thread to terminate
		}
	}

	public static void execute(String[] command) throws Exception {
		ProcessBuilder	pb	= new ProcessBuilder();
		String[]		cmd	= new String[command.length + 2];
		cmd[0] = "cmd";
		cmd[1] = "/c";
		for (int i = 0; i < command.length; i++)
			cmd[i + 2] = command[i];
		pb.command(cmd);
		Process process = pb.start();
		readers.add(new StdxReader(process.getInputStream(), false));
		readers.add(new StdxReader(process.getErrorStream(), true));
		int exitVal = process.waitFor();
		if (exitVal != 0)
			throw new Exception("error in executing command");

	}

//	public static void execute(String[] command) throws Exception {
//		ProcessBuilder	pb	= new ProcessBuilder();
//		String[]		cmd	= new String[command.length + 2];
//		cmd[0] = "cmd";
//		cmd[1] = "/c";
//		for (int i = 0; i < command.length; i++)
//			cmd[i + 2] = command[i];
//		pb.command(cmd);
//		Process				process	= pb.start();
//		InputStream			is		= process.getInputStream();
//		InputStreamReader	isr		= new InputStreamReader(is);
//		InputStream			es		= process.getErrorStream();
//		InputStreamReader	esr		= new InputStreamReader(es);
//		BufferedReader		ibr		= new BufferedReader(isr);
//		BufferedReader		ebr		= new BufferedReader(esr);
//		String				line;
//		while ((line = ebr.readLine()) != null) {
//			System.err.println(line);
//		}
//		while ((line = ibr.readLine()) != null) {
//			System.out.println(line);
//		}
//		int exitVal = process.waitFor();
//		if (exitVal != 0)
//			throw new Exception("error in executing command");
//		CmdExec.execute(command);
//	}

}
