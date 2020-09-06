package handlingWebelements;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Iframes1 {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("http://demo.guru99.com/test/guru99home/");

		System.out.println(driver.findElements(By.tagName("iframe")).size());

//		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='a077aa5e']")));
//
//		WebElement wb = driver.findElement(By.xpath("//img[@src='Jmeter720.png']"));
//
//		wb.click();
		
		Thread.sleep(5000);

		driver.quit();

	}

}
