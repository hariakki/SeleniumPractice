package handlingWebelements;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Bootstrap2 {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("http://seleniumpractise.blogspot.com/2016/08/bootstrap-dropdown-example-for-selenium.html#");

		driver.findElement(By.xpath("//button[@id='menu1']")).click();

		List<WebElement> lopa = driver.findElements(By.xpath("//button[@id='menu1']/following-sibling::ul/li [./a]"));

		for (WebElement ts : lopa) {

			if (ts.getAttribute("innerHTML").contains("Sc")) {

				ts.click();
				break;

			}

		}

		Thread.sleep(3000);

		driver.quit();

	}

}
