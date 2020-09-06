package autoIT;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class OnebyOneUpload_AutoIT {

	public static void main(String[] args) throws InterruptedException, IOException {

		WebDriver driver = new FirefoxDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		driver.get("https://yuilibrary.com/yui/docs/uploader/uploader-multiple.html");

		Thread.sleep(3000);

		WebElement selectFiles_btn = driver.findElement(By.xpath("//button[text()='Select Files']"));

		// clicking on the browse/select/upload button

		selectFiles_btn.click();

		Thread.sleep(3000);

		// path for <script>.exe

		String autoItPATH = "E:\\UploaderScript.exe";

		// getting all files in a directory and using them one by one

		// creating a directory

		File directory = new File(".\\resource\\images");

		// taking all files in directory into an array

		File[] allFiles = directory.listFiles();

		// uploading all files in directory one by one

		for (int i = 0; i < allFiles.length; i++) {

			System.out.println(allFiles[i].getAbsolutePath());

			String[] cmd = { autoItPATH, allFiles[i].getAbsolutePath() };

			Runtime.getRuntime().exec(cmd);

			Thread.sleep(3000);

			// Don't click on SELECT button if last file is already uploaded

			if (!(i == allFiles.length - 1)) {
				
				// getting SELECT button locator again to avoid STALE ELEMENT exception

				selectFiles_btn = driver.findElement(By.xpath("//button[text()='Select Files']"));

				selectFiles_btn.click();

			}

			Thread.sleep(3000);

		}

		Thread.sleep(9000);

		driver.quit();

	}

}
