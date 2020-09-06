package miscellaneous;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SeleniumWithManuallyOpenedBrowser {

	public static void main(String[] args) throws InterruptedException {

		ChromeOptions options = new ChromeOptions();

		options.setExperimentalOption("debuggerAddress", "127.0.0.1:9222");

		WebDriver driver = new ChromeDriver(options);

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		// verifying the page title of the last site browsed manually

		System.out.println("manually opened website is : " + driver.getTitle());

		driver.get("http://omayo.blogspot.com/");

		// verifying the page title of the site opened using code

		System.out.println("Selenium opened website is : " + driver.getTitle());

		Thread.sleep(3000);

		driver.findElement(By.cssSelector("#ta1")).sendKeys("jeene ke hain chaar din..ohohoho..");

		Thread.sleep(3000);

		System.out.println("Driver quitted");

		driver.quit();

	}

}
