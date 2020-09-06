package keyboard_mouse_Action;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Action_dragAndDrop1 {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("http://www.uitestpractice.com/Students/Actions");

		Actions act = new Actions(driver);

		Thread.sleep(2000);

		WebElement source = driver.findElement(By.xpath("//div[@id='draggable']"));

		WebElement target = driver.findElement(By.xpath("//div[@id='droppable']"));

		// drag and drop using Actions class method chaining

		act.moveToElement(source).clickAndHold().pause(Duration.ofSeconds(2)).moveToElement(target)
				.pause(Duration.ofSeconds(2)).release().perform();

		// drag and drop using dragAndDrop(source, target) method

		// act.dragAndDrop(source, target).perform();;

		Thread.sleep(5000);

		driver.quit();

	}

}
