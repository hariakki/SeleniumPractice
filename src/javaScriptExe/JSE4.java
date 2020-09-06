package javaScriptExe;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JSE4 {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		driver.get("https://www.360logica.com/blog/multiple-ways-to-scroll-a-page-using-selenium-webdriver/");
		
		Thread.sleep(5000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		//Getting size of visible window
		
		long i = (long) js.executeScript("return window.innerHeight;");
		long j = (long) js.executeScript("return window.innerWidth;");
		
		System.out.println("the visible height is : "+i +" pixels");
		System.out.println("the visible width is : "+j +" pixels");
		
		//Getting complete scrollable height
		
		long k = (long) js.executeScript("return document.body.scrollHeight");
		
		System.out.println("total scrollable height is : "+k +" pixels");
		
		driver.quit();

	}

}
