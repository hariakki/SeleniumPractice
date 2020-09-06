package miscellaneous;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Pagination1 {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		driver.get("https://datatables.net/examples/advanced_init/dt_events");

		// click and fetch names until the NEXT button is disabled

		while (!driver.findElement(By.xpath("//a[@id='example_next']")).getAttribute("class").contains("disabled")) {

			List<WebElement> allnames = driver.findElements(By.xpath("//table[@id='example']/tbody/tr/td[1]"));

			for (WebElement wb : allnames) {

				System.out.println(wb.getText());

			}

			// clicking Next button after each iteration until next button is disabled.

			driver.findElement(By.xpath("//a[text()='Next']")).click();

		}

		// total number of names

		String str = driver.findElement(By.xpath("//div[@id='example_info']")).getText();

		System.out.println(str);

		// The string is : "showing XX to YY of ZZ entries", we are extracting ZZ here.

		System.out.println("Total number of names are : " + str.split(" ")[5]);

		driver.quit();

	}

}
