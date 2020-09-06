package miscellaneous;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AddingExtension {

	public static void main(String[] args) throws InterruptedException {

		ChromeOptions options = new ChromeOptions();

		File myCRXFile = new File("E://DOWNLOAD//Talend-API-Tester-Free-Edition_vR2020-01.crx");

		options.addExtensions(myCRXFile);

		WebDriver driver = new ChromeDriver(options);

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		driver.get("https://www.goibibo.com/");

		Thread.sleep(4500);

		driver.quit();

	}

}
