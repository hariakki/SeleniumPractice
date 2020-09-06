package miscellaneous;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Bootstrap_Goibibo {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		driver.get("https://www.goibibo.com/");

		// to handle notification Iframe. If no notification pane found now...comment
		// this code

		List<WebElement> checker = driver.findElements(By.xpath("//iframe[@title[contains(.,'notification-frame')]]"));

		int counter = 0;

		while (checker.size() == 0) {

			System.out.println(counter);

			checker = driver.findElements(By.xpath("//iframe[@title[contains(.,'notification-frame')]]"));

			counter++;
		}

		driver.switchTo().frame("webklipper-publisher-widget-container-notification-frame");

		WebElement closebtn_info = driver.findElement(By.xpath("//div[@class=' prime']/div/div/a"));

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].click();", closebtn_info);

		driver.switchTo().defaultContent();

		WebElement link = driver.findElement(By.xpath("//a[text()='Sign up']"));

		link.click();

		Thread.sleep(2000);

		// to handle Sign up bootstrap form Iframe.

		List<WebElement> checker1 = driver.findElements(By.xpath("//iframe[@id='authiframe']"));

		counter = 0;

		while (checker1.size() == 0) {

			System.out.println(counter);

			checker = driver.findElements(By.xpath("//iframe[@title[contains(.,'notification-frame')]]"));

			counter++;
		}

		driver.switchTo().frame("authiframe");

		driver.findElement(By.xpath("//input[@id='authMobile']")).sendKeys("0000076543");

		Thread.sleep(3000);

		driver.findElement(By.xpath("//button[@id='authFBSignInBtn']")).click();

		driver.switchTo().defaultContent();

		String str = driver.getWindowHandle();

		Set<String> all = driver.getWindowHandles();
		
		System.out.println("total windows opened are"+all.size());

		for (String s : all) {

			if (!s.equalsIgnoreCase(str)) {

				driver.switchTo().window(s);
				
				Thread.sleep(3000);

				driver.close();
			}

		}

		Thread.sleep(3000);

		driver.quit();

	}

}
