package autoIT;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoITMultiUpload3 {

	public static void main(String[] args) throws InterruptedException {
		
		
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		driver.get("https://focusinfotech.com/Reg/");

		Thread.sleep(3000);

		WebElement selectFiles_btn = driver.findElement(By.id("use_var_TNresume"));

		// clicking on the browse/select/upload button

		selectFiles_btn.click();
		
		Thread.sleep(6000);
		
		driver.quit();


	}

}
