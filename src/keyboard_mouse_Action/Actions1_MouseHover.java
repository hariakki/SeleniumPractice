package keyboard_mouse_Action;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Actions1_MouseHover {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("http://automationtesting.in/");

		// Mouse hover

		Actions act = new Actions(driver);

		WebElement toBeHovered = driver.findElement(By.xpath("//a[text()='Reports']"));
		
		act.moveToElement(toBeHovered).perform();
		
		Thread.sleep(2000);

		driver.findElement(By.xpath("//li[@id='menu-item-108']/a")).click();
		
		System.out.println(driver.getTitle());

		Thread.sleep(2000);

		driver.quit();

	}

}
