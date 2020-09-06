package basicdemo1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Navigator {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.get("http://omayo.blogspot.com/");
		
		Thread.sleep(2000);

	driver.manage().window().maximize();
//
//		//String strp = "//a";
//		
     	By by = By.xpath("//a[./text()='Blogger']");

		WebElement wb =

		driver.findElement(by);
//
//		System.out.println("value is : "+wb.getAttribute("innerHTML"));
//		
//		System.out.println(wb.getAttribute("innerHTML").length());
		
		wb.click();
		
		Thread.sleep(2000);

		driver.quit();
		

	}

}
