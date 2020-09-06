package miscellaneous;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class AddingExtension1 {

	public static void main(String[] args) throws InterruptedException {

		ChromeOptions options = new ChromeOptions();

		File myCRXFile = new File("D://SELENIUM_REF//CRX files//app.crx");

		options.addExtensions(myCRXFile);

		WebDriver driver = new ChromeDriver(options);

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		driver.get("chrome-extension://mgijmajocgfcbeboacabfgobmjgjcoja/options.html");

		// select language as ENGLISH US

		Select select = new Select(driver.findElement(By.xpath("//select[@id='language-selector']")));

		select.selectByVisibleText("English (US)");

		getData(driver);

		Thread.sleep(4500);

		driver.quit();

	}

	private static void getData(WebDriver driver) throws InterruptedException {
		// action page
		driver.get("chrome-extension://mgijmajocgfcbeboacabfgobmjgjcoja/browser_action.html");
		driver.findElement(By.id("query-field")).sendKeys("grass");
		driver.findElement(By.id("define-btn")).click();

		Thread.sleep(5000);
		String text = driver.findElement(By.className("headword")).getText();
		System.out.println(text);
	}

}
