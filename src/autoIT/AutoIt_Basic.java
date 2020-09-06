package autoIT;

import java.io.IOException;

public class AutoIt_Basic {

	public static void main(String[] args) throws IOException, InterruptedException {

		// provide the path of autoIt app (compiled from xxx.au3)

		String path = "E:\\mahFirst.exe";
		
		// 'title' works as 1st argument : $CmdLine[1]

		String title = "Concourse Lead Poll";
		
		// 'text' works as 2nd argument : $CmdLine[2]

		String text = "Do you vote Srikant for lead?";
		
		//we can add any no. of arguments (if used in AutoIt script too)

		String[] cmd = { path, title, text };

		Runtime.getRuntime().exec(cmd);

		Thread.sleep(3000);

	}

}
