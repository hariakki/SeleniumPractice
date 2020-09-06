package handlingWebelements;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectMulti {

	public static void main(String[] args) throws InterruptedException {
		
		
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://learn.letskodeit.com/p/practice");
		
	WebElement wb = 	driver.findElement(By.cssSelector("select#multiple-select-example"));
	
	Select sel = new Select(wb);
	
	sel.selectByVisibleText("Orange");
	
	Thread.sleep(2000);
	
sel.selectByValue("peach");;
	
	Thread.sleep(2000);
	
sel.selectByIndex(0);;
	
	Thread.sleep(2000);
	
	System.out.println(sel.getFirstSelectedOption().getText());
	
	System.out.println("kya ye multiple hai?? "+sel.isMultiple());
	
	sel.deselectByIndex(2);
	
	List <WebElement> lopa = sel.getOptions();
	
	for (WebElement ts : lopa) {
		
		System.out.println(ts.getText());
		
	}
	
	Thread.sleep(2000);



driver.quit();		
		

	}

}
