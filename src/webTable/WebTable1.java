package webTable;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTable1 {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://demoqa.com/webtables");

		Thread.sleep(3000);

		String nameToFound = "Cierra";

		// print the email of 'nameToFound'

		List<WebElement> allfirstNames = driver.findElements(By.xpath("//div[@class='rt-tr-group']/div/div[1]"));

		for (int i = 0; i < allfirstNames.size(); i++) {

			if (allfirstNames.get(i).getText().equalsIgnoreCase(nameToFound)) {

				System.out.println(driver
						.findElement(By.xpath("//div[@class='rt-tr-group'][" + (i + 1) + "]/div/div[" + "4" + "]"))
						.getText());
				
				break;

			}

		}

	}

}
