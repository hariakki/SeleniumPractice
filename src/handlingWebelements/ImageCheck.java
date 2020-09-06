package handlingWebelements;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ImageCheck {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("http://newtours.demoaut.com/");

		WebElement logo = driver.findElement(By.xpath("//img[@src='/images/nav/logo.gif']"));

		System.out.println("The logo is present :" + logo.isDisplayed());

		if (driver.findElement(By.xpath("//input[contains(@src,'signin')]")).isEnabled()) {

			driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("chodu");

			driver.findElement(By.xpath("//input[@name='password']")).sendKeys("123456");

			driver.findElement(By.xpath("//input[contains(@src,'signin')]")).click();

		}

		Thread.sleep(4000);

		driver.navigate().to("https://learn.letskodeit.com/p/practice");

		if (driver.findElement(By.xpath("//img[@alt[contains(.,'Let')]]")).isDisplayed()) {

			System.out.println("icon displayed");

			driver.findElement(By.xpath("//img[@alt[contains(.,'Let')]]")).click();
		}

		Thread.sleep(4000);

	}

}
