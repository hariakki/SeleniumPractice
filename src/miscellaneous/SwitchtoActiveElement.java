package miscellaneous;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwitchtoActiveElement {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		driver.get("https://www.etihadguest.com/en/login-standalone.html");

		driver.findElement(By.cssSelector("input#emailOrGuestNumber")).sendKeys("abhishek@gmail.com");

		// leave the password field blank and click on SUBMIT button

		driver.findElement(By.cssSelector("#submitLogin")).click();

		// check if the cursor moves to Password field as active field

		String idValueforPassword = driver.switchTo().activeElement().getAttribute("id");

		System.out.println(idValueforPassword);

		driver.quit();

	}

}
