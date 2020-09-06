package cookies;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CookiesDeleteAll {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		driver.get("http://tutorialsninja.com/demo/");

		// writing code to login into the application

		driver.findElement(By.xpath("//span[text()='My Account']")).click();

		Thread.sleep(2000);

		driver.findElement(By.xpath("//a[text()='Login']")).click();

		Thread.sleep(2000);

		driver.findElement(By.cssSelector("#input-email")).sendKeys("ankush.kumar@gmail.com");

		driver.findElement(By.cssSelector("#input-password")).sendKeys("KKKkiran");

		driver.findElement(By.xpath("//input[@type='submit']")).click();

		Thread.sleep(3000);

		// refreshing page when cookies are not deleted will keep the user logged in

		driver.navigate().refresh();

		Thread.sleep(3000);

		// deleting all the cookies on browser level

		driver.manage().deleteAllCookies();

		// refreshing page when cookies are deleted will NOT keep the user logged in

		driver.navigate().refresh();

		Thread.sleep(3000);

		driver.quit();

	}

}
