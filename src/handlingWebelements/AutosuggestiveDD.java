package handlingWebelements;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutosuggestiveDD {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://www.makemytrip.com/");

		// --JS code here--------------------

		String pageLoadStatus = null;

		JavascriptExecutor js;

		do {

			js = (JavascriptExecutor) driver;

			pageLoadStatus = (String) js.executeScript("return document.readyState");

		} while ((!pageLoadStatus.equals("complete")));

		System.out.println("Page Loaded.");
		Thread.sleep(3000);

		// -------end of JS code

		// handling ICICI ad withing iframe--if you dont find it --comment the below
		// highlighted code

		System.out.println(driver.findElements(By.tagName("iframe")).size());

		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id[contains(.,'notification-frame')]]")));

		driver.findElement(By.xpath("//a[@id[contains(.,'webklipper-publisher-widget-container-notification-close')]]"))
				.click();

		driver.switchTo().defaultContent();

		// ---end of iframe code

		// removing jabardasti login/signin

		driver.findElement(By.xpath("//li[@data-cy='account']")).click();

		// end of removing jabardasti sign in

		WebElement onewayButton = driver.findElement(By.xpath("//li[text()[contains(.,'One')]]/span"));

		onewayButton.click();

		WebElement depcitylabel = driver.findElement(By.xpath("//input[@id='fromCity']/parent::label"));

		depcitylabel.click();

		WebElement depcity = driver.findElement(By.xpath("//div[@id='react-autowhatever-1']/preceding-sibling::input"));

		depcity.sendKeys("colom");

		depcity.sendKeys(Keys.BACK_SPACE);

		// ---------------------------------------------

		WebElement depAuto1 = driver.findElement(By.xpath("//li[@id='react-autowhatever-1-section-0-item-0']"));

		while (true) {

			String check1 = driver
					.findElement(By.xpath("//li[@id='react-autowhatever-1-section-0-item-0']/div/div/p[1]"))
					.getAttribute("innerHTML");
			String check2 = driver
					.findElement(By.xpath("//li[@id='react-autowhatever-1-section-0-item-0']/div/div/p[2]"))
					.getAttribute("innerHTML");

			Boolean checker = (check1.contains("Colombo") || check2.contains("Colombo"));

			System.out.println(check1 + "--------------" + check2);

			System.out.println(checker);

			if (checker) {
				depAuto1.click();

				break;

			}

		}

		WebElement arrcityTo = driver.findElement(By.xpath("//input[@placeholder='To']"));

		arrcityTo.sendKeys("dallas");

		WebElement arrAuto1 = driver.findElement(By.xpath("//li[@id='react-autowhatever-1-section-0-item-0']"));

		while (true) {

			String check1 = driver
					.findElement(By.xpath("//li[@id='react-autowhatever-1-section-0-item-0']/div/div/p[1]"))
					.getAttribute("innerHTML");
			String check2 = driver
					.findElement(By.xpath("//li[@id='react-autowhatever-1-section-0-item-0']/div/div/p[2]"))
					.getAttribute("innerHTML");

			Boolean checker = (check1.contains("Dallas") || check2.contains("Dallas"));

			System.out.println(check1 + "--------------" + check2);

			System.out.println(checker);

			if (checker) {
				arrAuto1.click();

				break;

			}

		}

		driver.findElement(By.xpath("//span[text()[contains(.,'Travelli')]]")).click();

		driver.findElement(By.xpath("//ul[@class='travelForPopup']/li[text()='Work']")).click();

		driver.findElement(By.xpath("//a[text()='Search']")).click();

		Thread.sleep(4000);

		driver.quit();

	}

}
