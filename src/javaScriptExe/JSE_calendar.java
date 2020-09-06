package javaScriptExe;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JSE_calendar {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		driver.get("https://jqueryui.com/resources/demos/datepicker/dropdown-month-year.html");

		Thread.sleep(3000);

		String date = "10/09/2020";

		String CSSLocator = "input#datepicker";

		setCalendarByJS(driver, date, CSSLocator);

		Thread.sleep(3000);

		driver.quit();

	}

	public static void setCalendarByJS(WebDriver driver, String date, String CSSselector) {

		JavascriptExecutor js = ((JavascriptExecutor) driver);

		//WebElement argument = driver.findElement(By.cssSelector(CSSselector));

		String script = "window.document.querySelector('input#datepicker').setAttribute('" + date + "');";

		js.executeScript(script);

	}

}
