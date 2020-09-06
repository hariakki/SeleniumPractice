package basicdemo1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class AllBrowser {

	public static void main(String[] args) throws InterruptedException {

		String s = "IE";

		WebDriver driver = null;

		switch (s) {

		case "Chrome":
			driver = new ChromeDriver();
			break;
		case "Firefox":
			driver = new FirefoxDriver();
			break;
		case "IE":
			driver = new InternetExplorerDriver();
			break;

		}
		
		driver.get("https://google.com");
		Thread.sleep(9000);
		driver.quit();

	}

}
