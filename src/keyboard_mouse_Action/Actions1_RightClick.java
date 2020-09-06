package keyboard_mouse_Action;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Actions1_RightClick {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");

		Thread.sleep(3000);

		// instantiate an Actions class

		Actions act = new Actions(driver);

		// performing right/context click

		WebElement tobecliked = driver.findElement(By.xpath("//span[text()='right click me']"));

		act.contextClick(tobecliked).build().perform();

		Thread.sleep(5000);

		// clicking option after right click

		driver.findElement(By.xpath("//span[text()='Paste']")).click();

		Thread.sleep(2000);

		// switching to alert and getting text of alert

		Alert al = driver.switchTo().alert();

		System.out.println(al.getText());

		al.accept();

		Thread.sleep(3000);

		driver.quit();

	}

}
