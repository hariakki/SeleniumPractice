package javaScriptExe;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class JSE8_sortable {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		driver.get("https://demoqa.com/sortable");

		Thread.sleep(3000);

		Actions act = new Actions(driver);

		// working with List sortable

		WebElement mover = driver
				.findElement(By.xpath("//div[text()='Two' and ./ancestor::div[@id='demo-tabpane-list']]"));

		WebElement target = driver
				.findElement(By.xpath("//div[text()='Five' and ./ancestor::div[@id='demo-tabpane-list']]"));

		act.clickAndHold(mover).moveToElement(target).release().perform();

		Thread.sleep(3000);

		driver.findElement(By.xpath("//a[@id='demo-tab-grid']")).click();

		// working with Grid sortable
		
		Thread.sleep(3000);

		WebElement mover_Grid = driver
				.findElement(By.xpath("//div[text()='Six' and ./ancestor::div[@id='demo-tabpane-grid']]"));

		WebElement target_Grid = driver
				.findElement(By.xpath("//div[text()='One' and ./ancestor::div[@id='demo-tabpane-grid']]"));

		act.clickAndHold(mover_Grid).moveToElement(target_Grid).release().perform();
		
		Thread.sleep(3000);

		Thread.sleep(3000);

		driver.quit();

	}

}
