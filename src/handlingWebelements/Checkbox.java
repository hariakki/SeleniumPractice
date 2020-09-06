package handlingWebelements;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Checkbox {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("http://omayo.blogspot.com/");
		
		int on =0;

		List<WebElement> opa = driver.findElements(By.xpath("//input[@type='checkbox']"));

		for (WebElement ts : opa) {

			if (ts.isSelected()) {

				System.out.println(ts.getAttribute("value") + "--is selected");
				on++;
			}

			else {

				System.out.println(ts.getAttribute("value") + "--is NOT selected");

			}
		}
		
		System.out.println("Total checkboxes checked are : "+on+" and non checked are: "+(opa.size()-on));

		driver.quit();

	}

}
