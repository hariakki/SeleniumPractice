package handlingWebelements;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Iframes4 {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");

		System.out.println("The no. of iframes are: " + driver.findElements(By.tagName("iframe")).size());

		// switching to frame 1 from main page using frame name/id

		driver.switchTo().frame("frame1");

		Thread.sleep(2000);

		driver.findElement(By.xpath("//b[@id='topic']/following-sibling::input")).sendKeys("churni ganguly");

		// Printing internal frames inside frame 1

		System.out
				.println("The no. of iframes inside frame 1 are: " + driver.findElements(By.tagName("iframe")).size());

		// switching to internal frame 3 of frame 1

		driver.switchTo().frame("frame3");

		if (!driver.findElement(By.xpath("//input[@id='a']")).isSelected()) {

			driver.findElement(By.xpath("//input[@id='a']")).click();
		}

		// usage of parent switch (and not default switch)--switches from frame 3 to
		// frame 1

		driver.switchTo().parentFrame();

		Thread.sleep(2000);

		driver.findElement(By.xpath("//b[@id='topic']/following-sibling::input")).clear();

		// usage of default content- switches from frame 1 to main page

		driver.switchTo().defaultContent();

		System.out.println(driver.findElement(By.xpath("//label[text()[contains(.,'Topic')]]/span")).getText());

		// switching from main page to frame 2

		driver.switchTo().frame("frame2");

		WebElement ele = driver.findElement(By.xpath("//select[@id='animals']"));

		Select sel = new Select(ele);

		sel.selectByValue("big baby cat");

		Thread.sleep(2000);

		driver.quit();

	}

}
