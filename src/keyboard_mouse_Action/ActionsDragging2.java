package keyboard_mouse_Action;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsDragging2 {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://demoqa.com/dragabble");

		Actions act = new Actions(driver);

		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//a[text()='Container Restricted']")).click();

		WebElement source = driver.findElement(By.xpath("//div[@id='containmentWrapper']/div"));
		
		//performing draggging

		act.dragAndDropBy(source, 800,200 ).pause(Duration.ofSeconds(2)).perform();

		Thread.sleep(2000);

		driver.quit();

	}

}
