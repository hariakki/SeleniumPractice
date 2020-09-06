package autoIT;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Downloader {

	public static void main(String[] args) throws IOException, InterruptedException {

		WebDriver driver = new FirefoxDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://omayo.blogspot.com/p/page7.html");

		// getting path of AutoIt .exe file

		String autoItScriptPath = "E:\\Downloader.exe";

		// getting URL from where file needs to be downloaded

		String downloadFrom = "https://github.com/arunmotoori/DownloadDemo/archive/master.zip";

		// getting folder location where downloaded file needs to be saved-can take any
		// name of file
		// extension of file getting downloaded must be correct and specified explicitly
		// e.g: 'XXX.zip'

		String downloadTo =
				System.getProperty("user.dir") + "\\resource\\images\\ummah.zip";

		// creating string array to pass path to AutoIt .exe file and arguments

		String[] cmd = { autoItScriptPath, downloadFrom, downloadTo };

		// running the autoIt.exe file

		Runtime.getRuntime().exec(cmd);

		Thread.sleep(5000);

		File myFile = new File(downloadTo);

		// to check whether file exists i.e. download successful or not

		if (myFile.exists()) {

			System.out.println("<<<<<<<< File downloaded successfully >>>>>");

		}

		else {

			System.out.println("<<<<<<<< File not downloaded >>>>>>>>");
		}

		Thread.sleep(3000);

		driver.quit();

	}

}
