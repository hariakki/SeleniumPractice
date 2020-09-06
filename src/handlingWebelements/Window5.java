package handlingWebelements;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Window5 {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("http://seleniumpractise.blogspot.com/2017/07/multiple-window-examples.html");

		String parentwindowhandle = driver.getWindowHandle();

		driver.findElement(By.xpath("//a[@href='http://www.google.com']")).click();

		Set<String> allwindows = driver.getWindowHandles();

		Iterator<String> windowitr = allwindows.iterator();

		while (windowitr.hasNext()) {

			String someid = windowitr.next();

			if (!someid.equals(parentwindowhandle)) {

				driver.switchTo().window(someid);

				System.out.println(driver.getTitle());

				driver.close();

				Thread.sleep(3000);

			}

		}

		// after closing the child tab,donot switch to main page
		// then try to click on some link on main page

		driver.findElement(By.xpath("//a[ @href='http://www.yahoo.com']")).click();

		driver.close();

	}

}
