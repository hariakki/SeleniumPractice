package miscellaneous;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MinimizeBrowser1 {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		Thread.sleep(7000);

		// setting size of browser window

		Dimension d = new Dimension(1000, 500);

		driver.manage().window().setSize(d);

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		driver.get("https://abc.com/");

		Thread.sleep(4000);

		driver.quit();

	}

}
