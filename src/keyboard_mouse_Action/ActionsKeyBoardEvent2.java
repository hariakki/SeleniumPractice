package keyboard_mouse_Action;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsKeyBoardEvent2 {

	public static void main(String[] args) throws InterruptedException {
	
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://demoqa.com/text-box");

		Actions act = new Actions(driver);

		Thread.sleep(2000);
		
		//Scrolling the webpage : sendkeys working on entire browser

		act.moveToElement(driver.findElement(By.xpath("//input[@id='userName']"))).click().sendKeys(Keys.chord(Keys.CONTROL,"charminar")).perform();
		
		Thread.sleep(2000);
		driver.quit();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
