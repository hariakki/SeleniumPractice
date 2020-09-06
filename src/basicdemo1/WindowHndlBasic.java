package basicdemo1;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class WindowHndlBasic {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.get("https://cosmocode.io/automation-practice/");
		
	

		// System.out.println(driver.getTitle());

		String parent = driver.getWindowHandle();

		System.out.println("Parent handle is :" + parent);

		Thread.sleep(3000);

		driver.findElement(By.xpath("//a[text()='Click Me to open New Window']")).click();

		Set<String> se = driver.getWindowHandles();

		for (String temp : se) {

			System.out.println(temp);

		}

		driver.quit();

	}

}
