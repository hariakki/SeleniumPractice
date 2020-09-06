package handlingWebelements;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Dropdown {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.get("https://www.spicejet.com/");
		
		WebElement wb = driver.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_originStation1_CTXT']"));;
		
		wb.click();
		
		driver.findElement(By.xpath("//a[text()[contains(.,'DED')] and ./ancestor::div[@id='glsctl00_mainContent_ddl_originStation1_CTNR']]")).click();
		
		driver.findElement(By.xpath("//a[text()[contains(.,'MCT')] and ./ancestor::div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR']]")).click();
		
	Thread.sleep(3000);
	
	driver.quit();
		
		
		
		

	}

}
