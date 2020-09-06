package javaScriptExe;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JSE5 {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		driver.get("https://the-internet.herokuapp.com/infinite_scroll");

		Thread.sleep(5000);

		JavascriptExecutor js = (JavascriptExecutor) driver;

		// getting initial scrollable height

		long initialHeight = (long) js.executeScript("return document.body.scrollHeight");

		while (true) {

			js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

			Thread.sleep(2400);

			long currentHeight = (long) js.executeScript("return document.body.scrollHeight");

			// comparing the new height and initial height

			if (currentHeight == initialHeight) {

				break;
			}

			initialHeight = (long) js.executeScript("return document.body.scrollHeight");

		}

		driver.quit();

	}

}
