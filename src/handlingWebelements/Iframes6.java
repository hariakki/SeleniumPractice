package handlingWebelements;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Iframes6 {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");

		// Getting size of iframes on 1st level

		int size = driver.findElements(By.tagName("iframe")).size();

		System.out.println("The size of the 1st level iframes are: " + size);

		// Iterating first level iframes

		outer:

		for (int i = 0; i < size; i++) {

			driver.switchTo().frame(i);
			
			System.out.println("Executing-> Main Frame no: "+(i+1));

			List<WebElement> tobefound = driver.findElements(By.xpath("//select[@id='animals']"));

			if (tobefound.size() == 1) {

				//write logic for action

				Select sel = new Select(driver.findElement(By.xpath("//select[@id='animals']")));

				sel.selectByValue("big baby cat");	
				
				Thread.sleep(4000);
				
				System.out.println("The element was found in Main Frame no: "+(i+1) );

				break outer;

			}

			else {

				// check for any nested iframe are prsent inside each first level iframe and iterate it

				int insize = driver.findElements(By.tagName("iframe")).size();

				if (insize >= 1) {

					inner:

					for (int k = 0; k < insize; k++) {

						driver.switchTo().frame(i);
						
						System.out.println("Executing-> Main Frame no: "+(i+1)+" 's inner frame no."+(k+1));

						tobefound = driver.findElements(By.xpath("//select[@id='animals']"));

						if (tobefound.size() == 1) {
							
							//write logic for action

							Select sel = new Select(driver.findElement(By.xpath("//select[@id='animals']")));

							sel.selectByValue("big baby cat");		
							
							Thread.sleep(4000);
							
							System.out.println("The Element was found in Main Frame no: "+(i+1)+" 's inner frame no."+(k+1) );

							break inner;

						}

						driver.switchTo().parentFrame();

					}

				}
				driver.switchTo().defaultContent();
			}

			
			
		}
		driver.quit();
	}

}
