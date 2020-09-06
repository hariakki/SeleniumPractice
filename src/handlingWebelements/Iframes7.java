package handlingWebelements;

//program to check that from Frame 3 we can directly jump to main page

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Iframes7 {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
		
		driver.switchTo().frame("frame1").switchTo().frame(0);
		
		driver.switchTo().defaultContent();
		
		System.out.println(driver.getTitle());
		
		driver.switchTo().frame("frame2");
		
		WebElement ele = driver.findElement(By.xpath("//select[@id='animals']"));

		Select sel = new Select(ele);

		sel.selectByValue("big baby cat");

		Thread.sleep(2000);
		
		
		driver.quit();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
