package javaScriptExe;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JSE_click {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		driver.get("https://www.inviul.com/");

		Thread.sleep(3000);

		// BASIC DOWNCASTING OPERATION

		JavascriptExecutor js = (JavascriptExecutor) driver;

		// ENTER VALUE IN TEXTBOX (sendKeys) - way 1

		// js.executeScript("document.getElementById('s').value='avinash';");

		// ENTER VALUE IN TEXTBOX (sendKeys) - way 2

		WebElement searchbox = driver.findElement(By.xpath("//input[@id='s']"));

		js.executeScript("arguments[0].value=' avinash';", searchbox);

		Thread.sleep(4000);

		// RETRIEVE INNER TEXT -way 1

		driver.navigate().to("http://demo.automationtesting.in/");

		String text = (String) js.executeScript("return document.getElementById('btn1').innerText");

		// RETRIEVE INNER TEXT -way 2

		WebElement btn2 = driver.findElement(By.xpath("//button[@id='btn2']"));

		String text2 = (String) js.executeScript("return arguments[0].innerText", btn2);

		System.out.println("The inner text is: " + text + "----" + text2);

		// REFRESH A PAGE

		Thread.sleep(4000);

		WebElement btn3 = driver.findElement(By.xpath("//input[@id='email']"));

		js.executeScript("arguments[0].value='ankushie'", btn3);

		Thread.sleep(3000);

		js.executeScript("window.history.go(0)");

		Thread.sleep(3000);

		driver.quit();

	}

}
