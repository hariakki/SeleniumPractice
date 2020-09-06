package handlingWebelemnts2;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Calendar3_MMT {

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

//		System.out.println(driver.findElements(By.tagName("iframe")).size());
//
//		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id[contains(.,'notification-frame')]]")));
//
//		driver.findElement(By.xpath("//a[@id[contains(.,'webklipper-publisher-widget-container-notification-close')]]"))
//				.click();
//
//		driver.switchTo().defaultContent();

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

		Thread.sleep(900);

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

//			System.out.println(check1 + "--------------" + check2);
//
//			System.out.println(checker);

			if (checker) {
				depAuto1.click();

				break;

			}

		}

		WebElement arrcityTo = driver.findElement(By.xpath("//input[@placeholder='To']"));

		arrcityTo.sendKeys("dallas");

		Thread.sleep(900);

		WebElement arrAuto1 = driver.findElement(By.xpath("//li[@id='react-autowhatever-1-section-0-item-0']"));

		while (true) {

			String check1 = driver
					.findElement(By.xpath("//li[@id='react-autowhatever-1-section-0-item-0']/div/div/p[1]"))
					.getAttribute("innerHTML");
			String check2 = driver
					.findElement(By.xpath("//li[@id='react-autowhatever-1-section-0-item-0']/div/div/p[2]"))
					.getAttribute("innerHTML");

			Boolean checker = (check1.contains("Dallas") || check2.contains("Dallas"));

//			System.out.println(check1 + "--------------" + check2);
//
//			System.out.println(checker);

			if (checker) {
				arrAuto1.click();

				break;

			}

		}

		// handling calendar for one way

		// the date to be selected (dd/mm/yy)

		LocalDate calendar_tobefound = LocalDate.of(2020, Month.NOVEMBER, 1);

		Integer dateint_tobefound = calendar_tobefound.getDayOfMonth();

		String date_tobefound = dateint_tobefound.toString();

		Month monthval_tobefound = calendar_tobefound.getMonth();

		String month_tobefound = monthval_tobefound.name();

		Integer yearint_tobefound = calendar_tobefound.getYear();

		String year_tobefound = yearint_tobefound.toString();

		// clicking on departure

		driver.findElement(By.xpath("//span[text()='DEPARTURE']")).click();

		Thread.sleep(2000);

		// selecting desired month and year

		List<WebElement> leftrightlabel = driver.findElements(By.xpath("//div[@class='DayPicker-Caption']/div"));

		String label_desired = month_tobefound + " " + year_tobefound;

		while (!leftrightlabel.get(0).getText().equalsIgnoreCase(label_desired)) {

			driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();

		}

		// selecting day- Naveen Method using xpath

		outer:
		
		for (int i = 1; i <= 5; i++) {

			for (int k = 1; k <= 7; k++) {

				if (driver
						.findElement(By.xpath(
								"//div[@class='DayPicker-wrapper']//div[1]//div[3]//div[" + i + "]//div[" + k + "]"))
						.getAttribute("class").equalsIgnoreCase("DayPicker-Day")) {

					String desired_xpath = "//div[@class='DayPicker-wrapper']//div[1]//div[3]//div[" + i + "]//div[" + k
							+ "]//div[1]//p[1]";

					WebElement cust_xpath = driver.findElement(By.xpath(desired_xpath));

					if (cust_xpath.getText().equals(date_tobefound)) {

						cust_xpath.click();

						break outer;
					}

				}

			}

		}

		driver.findElement(By.xpath("//span[text()[contains(.,'Travelli')]]")).click();
		driver.findElement(By.xpath("//ul[@class='travelForPopup']/li[text()='Work']")).click();

		driver.findElement(By.xpath("//a[text()='Search']")).click();

		Thread.sleep(4000);

		driver.quit();

	}

}
