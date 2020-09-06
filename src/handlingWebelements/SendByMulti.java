package handlingWebelements;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SendByMulti {

	public static void main(String[] args) throws InterruptedException {
	
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("http://omayo.blogspot.com/");
		
	WebElement wb =	driver.findElement(By.xpath("//select[@id='multiselect1']"));
	
	wb.sendKeys("Volvo");
	
	Thread.sleep(2000);
	wb.sendKeys("Audi");
	
	Thread.sleep(2000);
	
	driver.quit();
		
		
		
		
		
		

	}

}
