package miscellaneous;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LimitingScope {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");

		// taking all the anchor /links on the webpage

		List<WebElement> allLinks = driver.findElements(By.tagName("a"));

		System.out.println("Total no. of links on the entire webpage is: " + allLinks.size());

		// limiting scope of webdriver to footer

		WebElement footer = driver.findElement(By.xpath("//div[@id='gf-BIG']"));

		List<WebElement> footerLinks = footer.findElements(By.tagName("a"));

		System.out.println("Total no. of links on the FOOTER is: " + footerLinks.size());

		// limiting scope of webdriver to first column of Footer and printing all the
		// links

		WebElement first_col_footer = driver.findElement(By.xpath("//ul[./li[.='Discount Coupons']]"));

		List<WebElement> first_col_footer_links = first_col_footer.findElements(By.tagName("a"));

		System.out.println("Total no. of links on 1st col of footer is: " + first_col_footer_links.size());

		// starting from index 1 , as 'DISCOUNT' is not supposed to be clicked.

		for (int i = 1; i < first_col_footer_links.size(); i++) {

			System.out.println(first_col_footer_links.get(i).getText());

			// opening each link in separate tabs

			first_col_footer_links.get(i).sendKeys(Keys.chord(Keys.CONTROL, Keys.ENTER));
			;

			Thread.sleep(1500);
			;

		}

		driver.quit();

	}

}
