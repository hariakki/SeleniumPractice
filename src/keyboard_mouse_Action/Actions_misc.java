package keyboard_mouse_Action;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Actions_misc {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("http://www.uitestpractice.com/Students/Actions");
		


		Actions act = new Actions(driver);
		

		Thread.sleep(2000);

		// Here the mouse pointer moves from (0,0) i.e top left corner

		act.moveByOffset(550, 550).contextClick().perform();
		
		Thread.sleep(2000);
		

		driver.quit();

	}

}
