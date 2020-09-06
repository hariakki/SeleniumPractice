package webTable;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTable3 {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		driver.get("http://makeseleniumeasy.com/2017/07/14/how-to-handle-a-web-table-in-selenium-webdriver/");

		Thread.sleep(3000);

		// Assignment : Find number of columns for each row

		// no of rows

		List<WebElement> totalRows = driver.findElements(By.xpath("//table [@name='BookTable']/tbody/tr/td[1]"));

		for (int i = 2; i <= (totalRows.size() + 1); i++) {

			List<WebElement> totalCol = driver
					.findElements(By.xpath("//table [@name='BookTable']/tbody/tr[" + i + "]/td"));

			System.out.println("Total no. of column in row " + (i - 1) + " is:" + totalCol.size());

		}

		System.out.println("*********************************");

		// Assignment : List all books whose price is greater than or equal to 1000.

		System.out.println("Books with price greater than and equal to 1000 are below:");

		for (int i = 2; i <= (totalRows.size() + 1); i++) {

			WebElement price_string = driver
					.findElement(By.xpath("//table [@name='BookTable']/tbody/tr[" + i + "]/td[4]"));

			int price = Integer.parseInt(price_string.getText());

			if (price >= 1000) {

				System.out.println(driver.findElement(By.xpath("//table [@name='BookTable']/tbody/tr[" + i + "]/td[1]"))
						.getText());

			}

		}

		System.out.println("*********************************");

		// Assignment : Print total cost of all books listed in table.

		int sumTot = 0;

		for (int i = 2; i <= (totalRows.size() + 1); i++) {

			WebElement price_string = driver
					.findElement(By.xpath("//table [@name='BookTable']/tbody/tr[" + i + "]/td[4]"));

			int price = Integer.parseInt(price_string.getText());

			sumTot = sumTot + price;

		}

		System.out.println("Kindly pay the total sum for all books as:" + sumTot);

		System.out.println("*********************************");

		// Assignment : Finding column index using column name

		List<WebElement> colName = driver.findElements(By.xpath("//table [@name='BookTable']/tbody/tr/th"));

		String colNameToBeFound = "Price";

		int count = 0;

		for (WebElement wb : colName) {

			count++;

			if (wb.getText().equalsIgnoreCase(colNameToBeFound)) {

				System.out.println("For column name " + colNameToBeFound + " the column index is " + (count - 1));

				break;

			}

		}

		driver.quit();

	}

}
