package handlingWebelements;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alert1 {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("http://demo.automationtesting.in/Alerts.html");

		// --------------------------------------------------------

		String pageLoadStatus = null;

		int count = 1;

		Boolean isJqueryCallDone = false;

		JavascriptExecutor js;

		do {

			js = (JavascriptExecutor) driver;

			pageLoadStatus = (String) js.executeScript("return document.readyState");

			isJqueryCallDone = (Boolean) ((JavascriptExecutor) driver).executeScript("return jQuery.active==0");

			System.out.println("not loaded -" + count);

			count++;

		} while ((!pageLoadStatus.equals("complete")) && (isJqueryCallDone));

		System.out.println("Page Loaded.");

		driver.findElement(By.xpath("//div[@id='OKTab']/button")).click();

		Thread.sleep(2000);

		// creating Alert object

		Alert alert = driver.switchTo().alert();

		alert.accept();

		driver.findElement(By.xpath("//a[text()='Alert with OK & Cancel ']")).click();

		Thread.sleep(2000);

		driver.findElement(By.xpath("//div[@id='CancelTab']/button")).click();

		Thread.sleep(2000);

		// In case of multiple alerts, create a new instance of alert

		//alert = driver.switchTo().alert();

		alert.dismiss();
		;

		Thread.sleep(2000);

		driver.findElement(By.xpath("//a[text()='Alert with Textbox ']")).click();

		Thread.sleep(2000);

		driver.findElement(By.xpath("//div[@id='Textbox']/button")).click();

		Thread.sleep(2000);

		// In case of multiple alerts, create a new instance of alert

		//alert = driver.switchTo().alert();

		System.out.println(alert.getText());

		alert.sendKeys("chatur naar");

		alert.accept();

		Thread.sleep(6000);

		driver.quit();

	}

}
