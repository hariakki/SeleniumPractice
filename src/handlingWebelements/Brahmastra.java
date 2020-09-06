package handlingWebelements;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Brahmastra {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("http://seleniumpractise.blogspot.com/2017/07/multiple-window-examples.html");

		List<WebElement> allelements = driver
				.findElements(By.xpath("//a[text()=' Click this link to start new Tab ']"));

		// we will use <LIST>.get(2) to identify the third link that opens Yahoo.com

		allelements.get(2).click();

		Thread.sleep(5000);

		driver.quit();

	}

}
