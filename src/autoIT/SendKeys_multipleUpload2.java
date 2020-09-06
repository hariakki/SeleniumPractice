package autoIT;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SendKeys_multipleUpload2 {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_input_multiple");

		Thread.sleep(3000);

		driver.switchTo().frame("iframeResult");

		// creating a directory

		File directory = new File(".\\resource\\images");

		// taking all files in directory into an array

		File[] allFiles = directory.listFiles();

		String completePathOfAllFilesWithnewline = "";

		// create a String variable with paths of all files separated by \n i.e. New
		// line

		for (int i = 0; i < allFiles.length; i++) {

			completePathOfAllFilesWithnewline = completePathOfAllFilesWithnewline + allFiles[i].getAbsolutePath();
			
			//make sure '\n' is not added after the last file's path is concatenated to String var

			if (!(i == (allFiles.length) - 1)) {

				completePathOfAllFilesWithnewline = completePathOfAllFilesWithnewline + "\n";

			}

		}

		System.out.println(completePathOfAllFilesWithnewline);
		
		//uploading all the files in one go

		driver.findElement(By.id("files")).sendKeys(completePathOfAllFilesWithnewline);

		Thread.sleep(5000);

		driver.quit();

	}

}
