package autoIT;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoIt_MultiFileUpload {

	public static void main(String[] args) throws InterruptedException, IOException {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		driver.get("https://yuilibrary.com/yui/docs/uploader/uploader-multiple.html");

		Thread.sleep(3000);

		WebElement selectFiles_btn = driver.findElement(By.xpath("//button[text()='Select Files']"));

		selectFiles_btn.click();

		Thread.sleep(3000);
		
		//path for <script>.exe

		String autoItPATH = "E:\\UploaderScript.exe";

		Runtime.getRuntime().exec(autoItPATH);

		Thread.sleep(6000);
		driver.quit();

	}

}
