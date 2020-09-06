package handlingWebelements;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Iframes2 {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("http://demo.automationtesting.in/Frames.html");

		System.out.println(driver.findElements(By.tagName("iframe")).size());

		// switching to single frame

		driver.switchTo().frame(0);

		// Entering value in text box

		WebElement wb = driver.findElement(By.xpath("//input[@type='text' and ./ancestor::html]"));

		wb.sendKeys("chaman khaabra");

		Thread.sleep(3000);
		;

		// switching to default page = parent page

		driver.switchTo().defaultContent();

		driver.findElement(By.xpath("//a[text()='Iframe with in an Iframe']")).click();

		Thread.sleep(3000);

		// Entering frame inside 'iframe within an iframe' - method 1 (direct)

		driver.switchTo().frame(1).switchTo().frame(0);

		driver.findElement(By.xpath("/html[1]/body[1]/section[1]/div[1]/div[1]/div[1]/input[1]"))
				.sendKeys("roman ji...");

		// Entering frame inside 'iframe within an iframe' - method 2

//		int size = driver.findElements(By.tagName("iframe")).size();
//
//		if (size >= 1) {
//
//			driver.switchTo().frame(0);
//
//			driver.findElement(By.xpath("/html[1]/body[1]/section[1]/div[1]/div[1]/div[1]/input[1]"))
//					.sendKeys("roman ji...");
//
//			Thread.sleep(2000);
//
//		}
//
//		else {
//
//			System.out.println("no internal frames");
//		}

		Thread.sleep(3000);

		driver.quit();

	}

}
