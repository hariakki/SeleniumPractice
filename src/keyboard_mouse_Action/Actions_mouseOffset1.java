package keyboard_mouse_Action;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Actions_mouseOffset1 {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("http://www.uitestpractice.com/Students/Actions");

		Actions act = new Actions(driver);

		WebElement toBeHovered1 = driver.findElement(By.xpath("//div[@id='droppable']/following-sibling::div"));

		Thread.sleep(2000);

		// Mouse hover on the middle of the element

//		act.moveToElement(toBeHovered1).contextClick().perform();
//
//		Thread.sleep(3000);

		// Mouse hover on a specific offset---change coordinates to understand better

		act.moveToElement(toBeHovered1, 50, 50).contextClick().perform();

		Thread.sleep(3000);

		driver.quit();

	}

}
