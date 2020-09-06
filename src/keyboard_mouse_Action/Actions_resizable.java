package keyboard_mouse_Action;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Actions_resizable {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://demoqa.com/resizable");

		Actions act = new Actions(driver);

		Thread.sleep(2000);

		WebElement resizeHandler = driver.findElement(By.xpath("//div[@id='resizableBoxWithRestriction']/span"));

		// method 1:

		act.dragAndDropBy(resizeHandler, 20, 20).perform();

		Thread.sleep(3000);

		// method 2:

		act.clickAndHold(resizeHandler).moveByOffset(-20, -20).release().perform();
		;

		driver.quit();

	}

}
