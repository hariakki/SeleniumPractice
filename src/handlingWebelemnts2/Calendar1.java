package handlingWebelemnts2;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Calendar1 {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://freecrm.co.in/");

		WebElement login_btn = driver.findElement(By.xpath("//a[./span[text()='Log In']]"));

		login_btn.click();

		WebElement email_txt = driver.findElement(By.xpath("//input[@name='email']"));

		WebElement pwd_txt = driver.findElement(By.xpath("//input[@name='password']"));

		email_txt.sendKeys("reddragonsmediacorps.office@gmail.com");

		pwd_txt.sendKeys("soulonrent@7A");

		WebElement login_click_btn = driver.findElement(By.xpath("//div[text()='Login']"));

		login_click_btn.click();

		Thread.sleep(3000);

		WebElement calendar_icon_clk = driver.findElement(By.xpath("//a[./span[text()='Calendar']]"));

		calendar_icon_clk.click();

		// calendar logic- getting the date to befound and retreiving year, month and
		// date.

		LocalDate calendar_tobefound = LocalDate.of(2019, Month.JUNE, 28);

		Integer dateint_tobefound = calendar_tobefound.getDayOfMonth();

		String date_tobefound = dateint_tobefound.toString();

		Month monthval_tobefound = calendar_tobefound.getMonth();

		String month_tobefound = monthval_tobefound.name();

		Integer yearint_tobefound = calendar_tobefound.getYear();

		String year_tobefound = yearint_tobefound.toString();

		// getting current date

		LocalDate today = LocalDate.now();

		Integer today_dayint_val = today.getDayOfMonth();

		String today_day_val = today_dayint_val.toString();

		WebElement calendar_mid_title = driver
				.findElement(By.xpath("//div[@class='rbc-calendar']//span[@class='rbc-toolbar-label']"));

		// setting current month and year

		while (!calendar_mid_title.getText().equalsIgnoreCase(month_tobefound + " " + year_tobefound)) {
			
			//logic to check if specified date is before or after today to click >> or <<  accordingly

			if (calendar_tobefound.isAfter(today)) {

				driver.findElement(By.xpath("//button/i[@class='chevron right icon']")).click();

			}

			else {

				driver.findElement(By.xpath("//button/i[@class='chevron left icon']")).click();

			}

		}
		
		Thread.sleep(4000);

		// setting date
		// ** This application does not select the current day in any month from below
		// LIST
		// as its class='rbc-date-cell rbc-current' and NOT class='rbc-date-cell'

		List<WebElement> alldates = driver.findElements(
				By.xpath("//div[@class='rbc-month-row']//div[@class='rbc-row ']//div[@class='rbc-date-cell']/a"));

		for (int i = 0; i < alldates.size(); i++) {
			
			//is specified day to be found is equal to current day or not? if no, then:

			if (!date_tobefound.equals(today_day_val)) {

				if (alldates.get(i).getText().equalsIgnoreCase(date_tobefound)) {

					alldates.get(i).click();

					break;

				}

			}
			
			//if specified day to be found is equal to current day, then

			else {

				driver.findElement(By.xpath(
						"//div[@class='rbc-month-row']//div[@class='rbc-row ']//div[@class='rbc-date-cell rbc-current']/a"))
						.click();
				break;

			}

		}

		Thread.sleep(6000);

		driver.quit();

	}

}
