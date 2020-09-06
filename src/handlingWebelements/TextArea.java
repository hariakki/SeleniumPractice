package handlingWebelements;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TextArea {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new FirefoxDriver();
		
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "null");

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("http://www.uitestpractice.com/Students/Form");
		
		driver.findElement(By.xpath("//textarea")).sendKeys("main hoon don \t ankush mera naam hai");
		
		Thread.sleep(3000);
		
		driver.quit();

	}

}
