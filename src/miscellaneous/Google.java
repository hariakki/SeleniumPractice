package miscellaneous;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Google {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		driver.get("https://www.google.co.in");

		// String to be searched

		String exp = "jayabharathi";

		// Entering the text

		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("jaibhara");
		;

		Thread.sleep(2000);

		// Creating a list to store all the suggestions

		List<WebElement> allSuggestions = driver
				.findElements(By.xpath("//ul[@role='listbox']/li//div[@class='sbl1']/span"));

		for (WebElement wb : allSuggestions) {

			// If suggestion is equal to expected string, then click

			if (wb.getText().equalsIgnoreCase(exp)) {

				wb.click();

				break;
			}

		}

		Thread.sleep(8000);

		driver.quit();

	}

}
