package handlingWebelements;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Bootstrap1 {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://www.makemytrip.com/");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0]. click();", driver.findElement(By.xpath("//span[text()=' More ']")));

		Thread.sleep(3000);

		List<WebElement> store = driver.findElements(By.xpath("//div[@id='moreOpt']/p"));
		
		
	

		for (WebElement ts : store)

		{
			System.out.println(ts.getAttribute("innerHTML"));
		}
		
		for (WebElement ts : store)

		if (ts.getAttribute("innerHTML").contains("Train")){
			
			js.executeScript("arguments[0]. click();", ts);
			break;
		}
		
		js.executeScript("arguments[0]. click();", 	driver.findElement(By.xpath("//p[text()='7 Cool Ideas for Trips by Road from Delhi with Your Fam...']/preceding-sibling::img")));
		
	

		
		Thread.sleep(3000);
		
		
		driver.quit();

	}

}
