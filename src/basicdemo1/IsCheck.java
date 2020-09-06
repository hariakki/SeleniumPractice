package basicdemo1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IsCheck {

	public static void main(String[] args) throws InterruptedException {
		
		
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://google.co.in");
		
		WebElement wb = driver.findElement(By.xpath("//input[@name='q']"));
		
		//Entering runtime value

		wb.sendKeys("chaman kobra");

		Thread.sleep(2000);
		
		//Fetching runtime value

		String str = wb.getAttribute("value");

		System.out.println(str);

		driver.quit();

	}

}
