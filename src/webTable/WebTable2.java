package webTable;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTable2 {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://www.techlistic.com/p/demo-selenium-practice.html");

		Thread.sleep(3000);

		// Assignment : Read All the Values from the table row-wise and print them all

		// to find total no. of rows

		List<WebElement> totalRows = driver.findElements(By.xpath("//tbody/tr/th"));

		for (int i = 1; i <= totalRows.size(); i++) {

			System.out.print(driver.findElement(By.xpath("//tbody/tr[" + i + "]/th")).getText() + "---");

			for (int j = 1; j <= 6; j++) {

				System.out.print(driver.findElement(By.xpath("//tbody/tr[" + i + "]/td[" + j + "]")).getText() + "---");

			}
			System.out.println("\n");
		}

		driver.quit();

	}

}
