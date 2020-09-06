package handlingWebelements;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Temp1 {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://demoqa.com/text-box");
		
		  driver.findElement(By.xpath("//input[@id='userName']")).sendKeys("saale sudhar jaaa");
		
		  
		  Thread.sleep(3000);
		
        driver.findElement(By.xpath("//input[@id='userName']")).sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.DELETE));
        
        Thread.sleep(3000);
		
		
		driver.quit();
		
		
		
		
	
		
		

	}

}
