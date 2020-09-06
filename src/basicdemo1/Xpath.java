package basicdemo1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Xpath {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		JavascriptExecutor executor = (JavascriptExecutor) driver;

		driver.get("https://www.aljazeera.com/");

		WebElement wbr = driver.findElement(By.cssSelector(
				"#placeholder1>div>div:nth-child(2) >div>div>div>div>section>div:nth-child(2) a.indepth-title"));

		executor.executeScript("arguments[0].click();", wbr);

		Thread.sleep(4000);

		driver.quit();

	}

}
