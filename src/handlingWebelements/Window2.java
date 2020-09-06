package handlingWebelements;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Window2 {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://www.naukri.com/");

		// getting parent window handle

		String parentwindowhandle = driver.getWindowHandle();

		System.out.println("Parent window id is: " + parentwindowhandle);

		Thread.sleep(3000);

		// getting window handles of all pop up advertisement windows opened

		Set<String> allwindows = driver.getWindowHandles();

		// getting size of all pop up advertisement windows + parent window opened

		System.out.println("Total windows opened by this seesion is : " + allwindows.size());

		System.out.println("Total child/pop up windows opened by this seesion is : " + (allwindows.size() - 1));

		// printing window handles of all pop up advertisement windows opened

		int count = 0;

		for (String s : allwindows) {

			if (!s.equals(parentwindowhandle)) {

				count++;

				System.out.println("window handle of child/pop up window " + count + " is :" + s);

			}

		}

		// Operate on each child winodw, fetch title and close it

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

		driver.switchTo().window(parentwindowhandle);

		System.out.println("Lastly on page : " + driver.getTitle());

		driver.quit();

	}

}
