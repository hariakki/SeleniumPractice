package keyboard_mouse_Action;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Actions_dragging {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://demoqa.com/droppable");

		Actions act = new Actions(driver);

		Thread.sleep(2000);

		WebElement source = driver.findElement(By.xpath("//div[@id='revertable']"));

		act.moveToElement(driver.findElement(By.xpath("//a[text()='Revert Draggable']"))).click().perform();
		

		// drag and drop using dragAndDropBy(source, x oofset, Y offset)

		act.dragAndDropBy(source, 200, 0).pause(Duration.ofSeconds(2)).perform();

		Thread.sleep(2000);

		driver.quit();

	}

}
