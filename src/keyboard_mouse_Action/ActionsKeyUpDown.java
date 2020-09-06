package keyboard_mouse_Action;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsKeyUpDown {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://demoqa.com/text-box");

		Actions act = new Actions(driver);

		Thread.sleep(2000);

		WebElement fullName = driver.findElement(By.xpath("//input[@id='userName']"));
		

		// full name in upper case and switch focus to Email

		act.click(fullName).pause(Duration.ofSeconds(2)).keyDown(Keys.SHIFT).sendKeys("abhishek bhardwaj")
				.pause(Duration.ofSeconds(2)).keyUp(Keys.SHIFT).sendKeys(Keys.TAB).perform();
		
		// entering lower case email and switching focus to Current address
		
		act.sendKeys("rumman.ahmed@love.com"+Keys.TAB).perform();
		
		// entering address in Current address, copying it and switch to second current address
		
		act.sendKeys("chatta madan gopal wali gali").keyDown(Keys.CONTROL).sendKeys("a").pause(Duration.ofSeconds(2)).sendKeys("c").keyUp(Keys.CONTROL).sendKeys(Keys.TAB).perform();
		
		// pasting in second address
		
		act.keyDown(Keys.CONTROL).sendKeys("v").pause(Duration.ofSeconds(2)).keyUp(Keys.CONTROL).sendKeys(Keys.TAB).click().perform();
		
		
		
		Thread.sleep(2000);
		
		driver.quit();

	}

}
