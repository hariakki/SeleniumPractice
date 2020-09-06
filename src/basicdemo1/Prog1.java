package basicdemo1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Prog1 {

	public static void main(String[] args) throws InterruptedException {

		// Invoking Firefox

		// System.setProperty("webdriver.gecko.driver",
		// "D:\\SELENIUM_REF\\DRIVERS\\geckodriver.exe");

		WebDriver driver = new FirefoxDriver();
		driver.get("https://google.com");
		System.out.println(driver.getTitle());
		Thread.sleep(5000);
		driver.quit();

		// invoking IE
//		WebDriver driver = new InternetExplorerDriver();
//		driver.get("https://google.com");
//		Thread.sleep(3000);
//		driver.quit();
//		

	}

}
