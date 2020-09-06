package javaScriptExe;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JSE7_newtabLink {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		driver.get("http://omayo.blogspot.com/");

		Thread.sleep(3000);

		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement tobeClciked = driver.findElement(By.xpath("//a[text()='Blogger']"));

		// setting 'target' attribute to '_self'

		js.executeScript("arguments[0].setAttribute('target','_self')", tobeClciked);

		tobeClciked.click();

		Thread.sleep(4000);

		driver.quit();

	}

}
