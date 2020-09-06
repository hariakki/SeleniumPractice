package handlingWebelements;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Cust_dynamicDD_Runner {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");

		driver.findElement(By.xpath("//button")).click();

	//	List<WebElement> li = driver.findElements(By.xpath("//button/following-sibling::ul/li/a/label"));
		


//		Cust_dynamicDD.selectOptionInDropDownUsingIteration(li, "HTML");
//		Thread.sleep(2000);
//
//		Cust_dynamicDD.selectOptionInDropDownUsingIteration(li, "CSS");
//		Thread.sleep(2000);
//		Cust_dynamicDD.selectOptionInDropDownUsingIteration(li, "HTML");
//		Thread.sleep(2000);
//		
//		Cust_dynamicDD.selectOptionInDropDownUsingIteration(li, "cle");
//		
//		Thread.sleep(2000);
		
		Cust_dynamicDD.selectOptionInDropDownUsingCustomXpath(driver,"HTML");
		Thread.sleep(2000);
		Cust_dynamicDD.selectOptionInDropDownUsingCustomXpath(driver,"CSS");
		Thread.sleep(2000);
		Cust_dynamicDD.selectOptionInDropDownUsingCustomXpath(driver,"HTML");
		Thread.sleep(2000);
		Cust_dynamicDD.selectOptionInDropDownUsingCustomXpath(driver,"C#");
		Thread.sleep(2000);
		

		driver.quit();

	}

}
