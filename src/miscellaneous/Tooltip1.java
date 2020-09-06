package miscellaneous;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Tooltip1 {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		driver.get("http://seleniumpractise.blogspot.com/2019/08/tooltip-in-selenium-or-help-text-example.html");

		Thread.sleep(3000);

		String title_Expected = "Tooltip text";

		Actions action = new Actions(driver);

		// Mouse hover action to trigger tooltip

		action.moveToElement(driver.findElement(By.xpath("//div[@class='tooltip']"))).perform();;

		WebElement tooltip = driver.findElement(By.xpath("//span[text()='Tooltip text']"));

		String title_Actual = tooltip.getText();

		if (title_Actual.equals(title_Expected)) {

			System.out.println("Congrats ..test case passed !!");

		}

		else {

			System.out.println("test case FAILED !!!");
		}

		driver.quit();

	}

}
