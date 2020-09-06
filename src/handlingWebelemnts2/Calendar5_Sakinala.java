package handlingWebelemnts2;

import java.time.LocalDate;
import java.time.Month;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Calendar5_Sakinala {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("http://demo.automationtesting.in/Datepicker.html");

		// Handling "Datepicker disabled"

		driver.findElement(By.xpath("//input[@id='datepicker1']")).click();

		// selecting month and year (date navigatio both previous and future)

		// calendar logic- getting the date to befound and retreiving year, month and
		// date.

		LocalDate calendar_tobefound = LocalDate.of(2021, Month.JANUARY,21);

		Integer dateint_tobefound = calendar_tobefound.getDayOfMonth();

		String date_tobefound = dateint_tobefound.toString();

		Month monthval_tobefound = calendar_tobefound.getMonth();

		String month_tobefound = monthval_tobefound.name();

		Integer yearint_tobefound = calendar_tobefound.getYear();

		String year_tobefound = yearint_tobefound.toString();

		// getting today's date

		LocalDate today = LocalDate.now();

		WebElement label = driver.findElement(By.cssSelector("div.ui-datepicker-title"));

		while (!label.getText().equalsIgnoreCase(month_tobefound + " " + year_tobefound)) {

			if (calendar_tobefound.isBefore(today)) {

				driver.findElement(By.xpath("//span[text()='Prev']")).click();

			}

			else {

				driver.findElement(By.xpath("//span[text()='Next']")).click();

			}
			label = driver.findElement(By.cssSelector("div.ui-datepicker-title"));

		}

		// selecting day - using customized xpath

		outer:

		for (int i = 1; i <= 5; i++) {

			for (int j = 1; j <= 7; j++) {

				if (driver.findElement(By.xpath("//tr[" + i + "]//td[" + j + "]")).getAttribute("class").equals(" ")||driver.findElement(By.xpath("//tr[" + i + "]//td[" + j + "]")).getAttribute("class").equals(" ui-datepicker-week-end ")) {

					if (driver.findElement(By.xpath("//tr[" + i + "]//td[" + j + "]/a")).getText()
							.equals(date_tobefound)) {

						driver.findElement(By.xpath("//tr[" + i + "]//td[" + j + "]")).click();

						break outer;

					}

				}

			}

		}
			
			
		Thread.sleep(4000);

		driver.quit();

	}

}
