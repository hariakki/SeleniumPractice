package keyboard_mouse_Action;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Actions_KeyBoardEvents1 {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://demoqa.com/text-box");

		Actions act = new Actions(driver);

		Thread.sleep(2000);

		// Scrolling the webpage : sendkeys working on entire browser

		act.sendKeys(Keys.PAGE_DOWN).pause(Duration.ofSeconds(2)).sendKeys(Keys.PAGE_UP).perform();

		Thread.sleep(2000);

		act.sendKeys(Keys.END).pause(Duration.ofSeconds(2)).sendKeys(Keys.HOME).perform();

		Thread.sleep(2000);

		// Filling a text box using sendKeys():

		act.click(driver.findElement(By.xpath("//input[@id='userName']"))).sendKeys("ranjha jogi").perform();

		Thread.sleep(3000);

		// deleteing the filled value using KEYS.CHORD does not work with Actions class

		act.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE)).perform();

		Thread.sleep(3000);

		driver.quit();

	}

}
