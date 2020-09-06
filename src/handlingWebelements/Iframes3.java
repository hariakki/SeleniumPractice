package handlingWebelements;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Iframes3 {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("http://omayo.blogspot.com/");

		Thread.sleep(4000);

		// Taking total count by executing java script

		JavascriptExecutor exe = (JavascriptExecutor) driver;

		Integer noOfFrames = Integer.parseInt(exe.executeScript("return window.length").toString());

		System.out.println("No. of iframes on the page are " + noOfFrames);

		// Taking iframe as a normal webelement

		WebElement weForFrame = driver.findElement(By.xpath("//iframe[@id='iframe1']"));

		// Passing WebElement as parameter to frame() function

		driver.switchTo().frame(weForFrame);

		// Some action-clik on home button in mercury travels

		driver.findElement(By.xpath("//a[text()='Flights']")).click();

		// The below two statements print the main url and title only

		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());

		Thread.sleep(7000);

		driver.quit();

	}

}
