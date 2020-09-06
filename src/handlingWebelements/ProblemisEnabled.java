package handlingWebelements;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ProblemisEnabled {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new FirefoxDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-automate-radio-button-in.html");

		driver.get("https://www.alaskaair.com/");
		
		WebElement wb = driver.findElement(By.xpath("//label[text()='Return date']/parent::div"));
		

		
		System.out.println(wb.isDisplayed());
		System.out.println(wb.isEnabled());
		System.out.println(wb.isSelected());
		
		Thread.sleep(2000);
		
			driver.findElement(By.xpath("//input[@id='oneWay']")).click();
			System.out.println("after click:"+wb.isDisplayed());
			System.out.println("after click:"+wb.isEnabled());
			System.out.println("after click:"+wb.isSelected());
			
		driver.quit();
		
		

	}

}
