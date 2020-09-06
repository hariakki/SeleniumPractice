package keyboard_mouse_Action;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsKeyUpDown2 {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("http://demo.automationtesting.in/Register.html");

		Actions act = new Actions(driver);

		Thread.sleep(2000);

		WebElement firstName = driver.findElement(By.xpath("//input[@placeholder='First Name']"));

		WebElement lastName = driver.findElement(By.xpath("//input[@placeholder='Last Name']"));

		act.sendKeys(firstName, "chandan").perform();

		act.keyDown(lastName, Keys.CONTROL).keyUp(Keys.CONTROL).sendKeys("singha").perform();
		;

		// deleting the entered text on Last name field

		Thread.sleep(2000);

		act.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE)
				.pause(Duration.ofSeconds(2)).perform();

		Thread.sleep(2000);

		driver.quit();

	}

}
