package handlingWebelements;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Window4_wrongway {

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

		int totcount = allwindows.size();

		System.out.println("Total windows opened by this seesion is : " + totcount);

		System.out.println("Total child/pop up windows opened by this seesion is : " + (allwindows.size() - 1));

		// converting SET to LIST

		List<String> liallwindows = new ArrayList<String>(allwindows);

		// printing window handles of all tabs opened using LIST

		int count = 0;
		for (String str : liallwindows) {

			if (!str.equals(parentwindowhandle)) {

				count++;

				System.out.println("window handle of child/pop up window " + count + " is :" + str);

			}
		}

		// switching to each tab using index, printing title and closing it.

		for (int i = 0; i < liallwindows.size(); i++) {

			driver.switchTo().window(liallwindows.get(i));

			System.out.println(driver.getTitle());

			driver.close();
			Thread.sleep(3000);

		}
		
		driver.quit();

	}

}
