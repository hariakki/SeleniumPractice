package handlingWebelements;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectDrop1 {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("http://demo.automationtesting.in/Register.html");
		
		WebElement wb = driver.findElement(By.xpath("//select[@id='yearbox']"));
		
	
		
		Select sel = new Select(wb);
		
		System.out.println("Is this a multiselect?? "+ sel.isMultiple() );
		
		sel.selectByVisibleText("1927");
		
		Thread.sleep(3000);
		
		sel.selectByValue("1986");
		
		Thread.sleep(3000);


		
//		List<WebElement> lopa = driver.findElements(By.xpath("//select[@id='yearbox']/option"));
//		
//		for (int i=0;i<lopa.size();i++) {
//			
//			System.out.println(lopa.get(i).getAttribute("value")+"------- "+i );
//			
//			
//		}
		
		sel.selectByIndex(85);
		
		System.out.println(sel.getFirstSelectedOption().getText());
		
		Thread.sleep(3000);
		
		driver.quit();
		
	}

}
