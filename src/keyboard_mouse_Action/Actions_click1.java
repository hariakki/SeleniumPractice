package keyboard_mouse_Action;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Actions_click1 {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("http://www.uitestpractice.com/Students/Actions");

		Actions act = new Actions(driver);

		WebElement toBeHovered = driver.findElement(By.xpath("//button[text()='Click Me !']"));

		Thread.sleep(2000);

		// click on element with last known coordinate :

		act.moveToElement(toBeHovered, 0, 0).click().perform();

		Thread.sleep(4000);

		driver.quit();

	}

}
