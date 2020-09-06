package handlingWebelements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Cust_dynamicDD {

	public static void selectOptionInDropDownUsingIteration(List<WebElement> li, String text) {

		boolean present = false;

		for (WebElement option : li) {

			if (option.getText().contains(text)) {

				present = true;

				option.click();
				break;

			}

		}

		if (!present) {

			System.out.println("WebElement not found...or Not in List");

		}

	}
	
	public static void selectOptionInDropDownUsingCustomXpath(WebDriver driver, String text) {

		String cust = "//button/following-sibling::ul/li/a/label[text()=' "+text+"']";
		
		
		if (	driver.findElement(By.xpath(cust)).isDisplayed()) {
			
			System.out.println("Element "+text+" is present.");
			driver.findElement(By.xpath(cust)).click();
		}
		else {
			
			System.out.println("Element "+text+" is NOT present.");
		}
		
	

	}

}
