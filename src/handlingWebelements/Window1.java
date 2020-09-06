package handlingWebelements;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Window1 {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("http://omayo.blogspot.com/");

		// retrieving title before opening child window

		System.out.println("before : " + driver.getTitle());

		// Clicking on link

		driver.findElement(By.xpath("//a[text()='Open a popup window']")).click();

		Thread.sleep(3000);

		// retrieving title to observe where the actual focus of selenium is.

		System.out.println("after : " + driver.getTitle());

		driver.quit();

	}

}
