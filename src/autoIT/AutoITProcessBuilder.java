package autoIT;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class AutoITProcessBuilder {

	public static void main(String[] args) throws IOException {

		// provide the path of autoIt app (compiled from xxx.au3)

		String path = "E:\\mahFirst.exe";

		// 'title' works as 1st argument : $CmdLine[1]

		String title = "Concourse Lead Poll";

		// 'text' works as 2nd argument : $CmdLine[2]

		String text = "Do you vote Srikant for lead?";

		// we can add any no. of arguments (if used in AutoIt script too)

		// LIST <String> to be passed as parameter in Processbuilder should have:
		// path to the autoIt .exe file and all the parameters

		List<String> allscripts = Arrays.asList(path, title, text);

		// using ProcessBuilder().exe

		new ProcessBuilder(allscripts).start();

	}

}
