package keyboard_mouse_Action;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Actions_slider {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://rangeslider.js.org/");

		Thread.sleep(3000);

		Actions act = new Actions(driver);

		WebElement slider = driver.findElement(By.cssSelector("div#js-rangeslider-0 div.rangeslider__handle"));

		// Method 1: using dragAndDropBy(WebElement ele, x-offSet ,y-offSet)

		act.dragAndDropBy(slider, -20, 0).perform();

		Thread.sleep(2000);

		// Method 2:

		act.clickAndHold(slider).moveByOffset(20, 0).release(slider).perform();

		driver.quit();

	}

}
