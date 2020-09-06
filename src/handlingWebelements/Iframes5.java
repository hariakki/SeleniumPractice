package handlingWebelements;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Iframes5 {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("http://omayo.blogspot.com/");

		Thread.sleep(4000);

		if ( driver.findElement(By.xpath("//input[@id='prompta']")).isDisplayed()) {
			
			System.out.println("Promot button is present...");
		}
		
		else {
			
			System.out.println("Promot button is NOT present...");
		}
	 ;
		
		
		
		driver.quit();

	}

}
