package autoIT;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AutoIt_MultipleFileUp_2 {

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

		// path for files to be uploaded

		String filepath1 = "C:\\Users\\Ankush420\\Desktop\\Toing.docx";
		String filepath2 = "C:\\Users\\Ankush420\\Desktop\\guru99.txt";

		// two parametrized string array : each for one file

		String[] cmd1 = { autoItPATH, filepath1 };
		String[] cmd2 = { autoItPATH, filepath2 };

		// uploading file 1

		Runtime.getRuntime().exec(cmd1);

		Thread.sleep(5000);

		// clicking on the browse/select/upload button again

		selectFiles_btn.click();

		// uploading file 2

		Runtime.getRuntime().exec(cmd2);

		Thread.sleep(9000);

		driver.quit();

	}

}
