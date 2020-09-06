package autoIT;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ObebyOneUpload {

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

		// printing all file names and upload them one by one

		for (File f : allFiles) {

			System.out.println(f.getName());

			driver.findElement(By.id("files")).sendKeys(f.getAbsolutePath());

		}

		Thread.sleep(6000);

		driver.quit();

	}

}
