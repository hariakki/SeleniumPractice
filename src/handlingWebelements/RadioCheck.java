package handlingWebelements;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioCheck {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("http://seleniumpractise.blogspot.com/");

		WebElement wb = driver.findElement(By.xpath("//a[text()[contains(.,'2016')]]/preceding-sibling::a/span"));

		wb.click();

		driver.findElement(By.xpath(
				"//a[text()[contains(.,'August')] and ./ancestor::ul/preceding-sibling::a[contains(.,'2016')]]/preceding-sibling::a/span"))
				.click();

		driver.findElement(By.xpath(
				"//a[text()[contains(.,'August')] and ./ancestor::ul/preceding-sibling::a[contains(.,'2016')]]/following-sibling::ul/li/a[contains(text(),'radio')]"))
				.click();

		System.out.println(driver.getTitle());

		List<WebElement> li = driver.findElements(By.xpath("//input[@name='lang' and @type='radio']"));

		for (WebElement tm : li) {

			System.out.println("The radio buttons are" + tm.getAttribute("value"));

		}

		for (WebElement tm : li) {

			if (tm.getAttribute("value").contains("UB")) {

				tm.click();

				break;
			}

		}

		Thread.sleep(3000);
		driver.quit();

	}

}
