package handlingWebelements;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Button {

	public static void main(String[] args) throws InterruptedException {
	
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("http://omayo.blogspot.com/");
		
		Thread.sleep(3000);
		
		
		driver.findElement(By.xpath("//a[text()='compendiumdev']")).click();
		
		Thread.sleep(3000);
		
		driver.quit();
		
		

	}

}
