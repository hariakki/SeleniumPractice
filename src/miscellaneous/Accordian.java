package miscellaneous;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Accordian {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		driver.get("https://demoqa.com/accordian");

		int card_no = 2;

		// writing a generic string to click on card

		String xpath = "//div[@id='section" + card_no + "Heading']";

		// writing a generic string to check open and close

		String xpathChecker = "//div[@id='section" + card_no + "Content']/parent::div";

		Accordian.doAccordianCheck(card_no, driver, xpathChecker);

		// clicking on card 3 to open

		JavascriptExecutor js = (JavascriptExecutor) driver;
		Actions act = new Actions(driver);

		js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(xpath)));

		Thread.sleep(2000);

		act.moveToElement(driver.findElement(By.xpath(xpath))).click().perform();

		Thread.sleep(2000);

		Accordian.doAccordianCheck(card_no, driver, xpathChecker);
		
		// clicking on card 3 to close again
		
		js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(xpath)));
		
		Thread.sleep(2000);

		act.moveToElement(driver.findElement(By.xpath(xpath))).click().perform();
		
		Accordian.doAccordianCheck(card_no, driver, xpathChecker);

		driver.quit();

	}

	// CUSTOM METHOD- checks if accordian is closed or not

	public static void doAccordianCheck(int k, WebDriver driver, String xpath) {

		// to verify in beginning card XX of accordian is not opened

		String result = driver.findElement(By.xpath(xpath)).getAttribute("class");

		if (result.equalsIgnoreCase("collapse")) {

			System.out.println("The card number " + k + " of Accordian is Closed");
		}

		else {

			System.out.println("The card number " + k + " of Accordian is Opened");
		}

	}

}
