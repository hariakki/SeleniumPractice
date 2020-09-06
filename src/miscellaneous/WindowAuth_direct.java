package miscellaneous;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowAuth_direct {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		String username = "admin";

		String password = "admin";

		// creating custom URL to handle window authentication

		String url = "https://" + username + ":" + password + "@" + "the-internet.herokuapp.com/basic_auth";

		// launching the URL

		driver.get(url);

		Thread.sleep(4000);

		String confirm_msg = driver.findElement(By.xpath("//p")).getText();

		System.out.println(confirm_msg);

		driver.quit();

	}

}
