package keyboard_mouse_Action;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Actions1_DoubleClick {

	public static void main(String[] args) throws InterruptedException {
		
		
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("http://omayo.blogspot.com/");

		Thread.sleep(3000);

		// instantiate an Actions class

		Actions act = new Actions(driver);

		// performing double click

		WebElement tobecliked = driver.findElement(By.xpath("//button[text()=' Double click Here   ']"));

		act.doubleClick(tobecliked).build().perform();

		Thread.sleep(3000);


		// switching to alert and getting text of alert

		Alert al = driver.switchTo().alert();

		System.out.println(al.getText());

		al.accept();

		Thread.sleep(3000);

		driver.quit();

	}

}
