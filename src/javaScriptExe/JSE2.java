package javaScriptExe;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JSE2 {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		driver.get("http://demo.automationtesting.in/");

		WebElement txtbox1 = driver.findElement(By.xpath("//input[@id='email']"));

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].value='ankushie';", txtbox1);

		Thread.sleep(3000);

		WebElement btn = driver.findElement(By.xpath("//img[@id='enterimg']"));

		js.executeScript("arguments[0].click();", btn);

		Thread.sleep(3000);

		// NAVIGATING BACK

		js.executeScript("window.history.back()");

		Thread.sleep(3000);

		// NAVIGATING FORWARD

		js.executeScript("window.history.forward()");

		Thread.sleep(3000);

		// NAVIGATE TO A PARTICULAR URL -way 1

		String url = "https://www.google.com";
		String script = "window.location = \'" + url + "\'";

		js.executeScript(script);

		// NAVIGATE TO A PARTICULAR URL -way 2

		// js.executeScript("window.location='https://google.com'");

		// FETCH DOMAIN NAME

		String domainname = js.executeScript("return document.domain;").toString();

		System.out.println("The domain name is : " + domainname);

		// FETCH URL

		String urlFound = js.executeScript("return document.URL").toString();
		System.out.println("URL of the site = " + urlFound);

		// FETCH TITLE

		String TitleName = js.executeScript("return document.title").toString();
		System.out.println("Title of the page = " + TitleName);

		Thread.sleep(3000);

		driver.quit();

	}

}
