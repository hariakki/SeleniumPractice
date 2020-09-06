package basicdemo1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigateChck {

	public static void main(String[] args) throws InterruptedException {
		

		
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://omayo.blogspot.com/");
		
		Thread.sleep(3000);
		
        By by = By.xpath("//a[text()=' Selenium143 ' and .//ancestor::div[@id='HTML3']]");
		
		driver.findElement(by).click();
		
		driver.navigate().back();
		
	    Thread.sleep(3000);
		
		driver.navigate().forward();
		
	    Thread.sleep(3000);
	    
	    driver.navigate().refresh();
		
	    Thread.sleep(3000);
	    
	    Navigation nav = driver.navigate();
	    
	    nav.to("https://google.co.in");
	    
	    Thread.sleep(3000);

	}

}
