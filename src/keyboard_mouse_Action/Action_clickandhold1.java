package keyboard_mouse_Action;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Action_clickandhold1 {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("http://www.uitestpractice.com/Students/Actions");

		Actions act = new Actions(driver);

		Thread.sleep(2000);

		// using click and hold(WebElement xxx) & release(WebElement XXX)

		act.clickAndHold(driver.findElement(By.xpath("//li[text()='7']")))
		.moveToElement(driver.findElement(By.xpath("//li[text()='10']"))).release().perform();
		
	

		Thread.sleep(4000);

		driver.quit();

	}

}
