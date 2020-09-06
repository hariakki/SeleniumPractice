package keyboard_mouse_Action;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Actions_MouseHover_multilevel {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("http://automationtesting.in/");

		// Mouse hover

		Actions act = new Actions(driver);

		WebElement toBeHovered1 = driver.findElement(By.xpath("//a[text()='Tools']"));

		Thread.sleep(2000);

		act.moveToElement(toBeHovered1).perform();

		WebElement toBeHovered2 = driver.findElement(By.xpath("//a[text()='Selenium']"));

		act.moveToElement(toBeHovered2).perform();
		
		Thread.sleep(2000);

		driver.findElement(By.xpath("//a[text()='Selenium C# Tutorial']")).click();
		
		//checking the title of page
		
		System.out.println(driver.getTitle());
		
		driver.quit();
		
		
	}

}
