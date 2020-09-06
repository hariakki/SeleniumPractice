package miscellaneous;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetLocation_WebElement {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		driver.get("http://omayo.blogspot.com/");

		Thread.sleep(3000);

		WebElement btn = driver.findElement(By.xpath("//input[@id='hbutton']"));

		// Getting coordinates using getLocation()

		Point poi = btn.getLocation();

		System.out.println("X-coordinate" + poi.getX());

		System.out.println("Y-coordinate" + poi.getY());

		// getting height and width of WebElements

		Dimension dim = btn.getSize();

		System.out.println("Height is : " + dim.getHeight());

		System.out.println("Width is : " + dim.getWidth());

		driver.quit();

	}

}
