package autoIT;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sendkeys_multipleUpload {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		driver.get("https://yuilibrary.com/yui/docs/uploader/uploader-multiple.html ");

		Thread.sleep(3000);
		
		//using multiple sendKeys() commands for each file
		
		WebElement selectFiles_btn = driver.findElement(By.xpath("//input[@type='file']"));
		
		//uploading 1st file
		
		selectFiles_btn.sendKeys("C:\\Users\\Ankush420\\Desktop\\Toing.docx");
		
		Thread.sleep(3000);
		
		//writing the button element again to remove "STALE ELEMENT EXCEPTION"
		
		selectFiles_btn = driver.findElement(By.xpath("//input[@type='file']"));
		
		//uploading 2nd file
		
		selectFiles_btn.sendKeys("C:\\Users\\Ankush420\\Desktop\\guru99.txt");
		
		Thread.sleep(6000);
		
		
		driver.quit();

	}

}
