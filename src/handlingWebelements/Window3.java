package handlingWebelements;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Window3 {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("http://seleniumpractise.blogspot.com/2017/07/multiple-window-examples.html");

		// getting parent window handle

		String parentwindowhandle = driver.getWindowHandle();

		System.out.println("Parent window id is: " + parentwindowhandle);

		Thread.sleep(3000);

		// Clicking on links that opens new tabs of Yahoo,Google and Facebook

		driver.findElement(By.xpath("//a[@href='http://www.google.com']")).click();

		driver.findElement(By.xpath("//a[text()[contains(.,'Tab')] and @href='http://www.facebook.com']")).click();

		driver.findElement(By.xpath("//a[ @href='http://www.yahoo.com']")).click();

		// getting window handles of all tabs opened

		Set<String> allwindows = driver.getWindowHandles();

		// getting size of all tabs opened

		System.out.println("Total windows opened by this seesion is : " + allwindows.size());

		System.out.println("Total child/pop up windows opened by this seesion is : " + (allwindows.size() - 1));

		// printing window handles of all tabs opened

		int count = 0;

		for (String s : allwindows) {

			if (!s.equals(parentwindowhandle)) {

				count++;

				System.out.println("window handle of child/pop up window " + count + " is :" + s);

			}

		}

		// Operate on each child window

		Iterator<String> windowitr = allwindows.iterator();

		while (windowitr.hasNext()) {

			String someid = windowitr.next();

			if (!someid.equals(parentwindowhandle)) {

				driver.switchTo().window(someid);

				// separte code for Yahoo tab

				if (driver.getTitle().contains("Yahoo")) {

					System.out.println("Doing action on : " + driver.getTitle());
					driver.findElement(By.xpath("//input[@id='header-search-input']")).sendKeys("Trump");
					driver.findElement(By.xpath("//BUTTON[@ID='header-desktop-search-button']")).click();

					Thread.sleep(3000);

				}

				else {

					System.out.println(driver.getTitle() + " no action performed...");

				}

				driver.close();
			}

		}

		driver.switchTo().window(parentwindowhandle);

		System.out.println("Lastly on page : " + driver.getTitle());

		driver.quit();

	}

}
