package basicdemo1;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Remote {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {

		DesiredCapabilities ds = DesiredCapabilities.chrome();

		ds.setBrowserName("chrome");

		WebDriver driver = new RemoteWebDriver(new URL("http://localhost:9515/"), ds);
		driver.get("https://www.guru99.com/introduction-to-selenium-grid.html");
		Thread.sleep(4000);


		driver.quit();

	}

}
