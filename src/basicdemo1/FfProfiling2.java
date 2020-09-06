package basicdemo1;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class FfProfiling2 {

	public static void main(String[] args) throws InterruptedException {

		Proxy proxy = new Proxy();

		proxy.setHttpProxy("<HOST:PORT>");

		ChromeOptions options = new ChromeOptions();

		// setting capability with options class

		options.setCapability("proxy", proxy);

		WebDriver driver = new ChromeDriver(options);

		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		driver.quit();

		Thread.sleep(5000);

		driver.quit();

	}

}
