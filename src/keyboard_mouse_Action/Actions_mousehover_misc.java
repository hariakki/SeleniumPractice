package keyboard_mouse_Action;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Actions_mousehover_misc {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("http://shop.demoqa.com/");

		// Mouse hover

		Actions act = new Actions(driver);

		WebElement toBeHovered = driver.findElement(By.xpath(
				"//div[@class='vc_row wpb_row vc_row-fluid vc_custom_1465285769156']/descendant::div[@class='noo-product-inner noo-product-inner2'][1]/div[1]/a"));

		WebElement toBeHovered2 = driver.findElement(By.xpath("//a[@data-original-product-id='1497']"));

		act.moveToElement(toBeHovered).perform();

		Thread.sleep(3000);

		act.moveToElement(toBeHovered2).perform();
		

		driver.findElement(By.xpath("//a[@data-original-product-id='1497']")).click();

		Thread.sleep(5000);

	     WebElement clickagain = driver.findElement(By.xpath("//a[@data-title='Browse Wishlist']"));
		
		//act.moveToElement(clickagain).click().perform();
	     
	     clickagain.click();
		
		Thread.sleep(5000);

		driver.quit();

	}

}
