package handlingWebelemnts2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Calendar2 {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://phptravels.net/");

		// month and year to be detected

		String day = "30";

		String month = "December";

		String year = "2020";

		// clicking checkin box

		driver.findElement(By.xpath("//input[@id='checkin']")).click();

		Thread.sleep(4000);

		// 1. Setting month and year

		WebElement label = driver.findElement(By.xpath("//div[1]//nav[1]//div[2]"));

		while (!(label.getAttribute("innerHTML").contains(month) && label.getAttribute("innerHTML").contains(year))) {

			System.out.println(label.getText());

			WebElement nextIcon = driver.findElement(By.xpath("//div[1]//nav[1]//div[3]//*[local-name()='svg']"));

			nextIcon.click();

			Thread.sleep(750);

			// to resolve stale element exception

			label = driver.findElement(By.xpath("//div[1]//nav[1]//div[2]"));

		}
		
		//setting date using customized xpath

	
		for (int i = 1; i <= 35; i++) {

			String xpath = "//div[@id='datepickers-container']//div[1]//div[1]//div[1]//div[2]//div[" + i + "]";

			String tofind = driver.findElement(By.xpath(xpath)).getAttribute("class");
			
			//if block to restrict the clicking on unactive previous/next month buttons

			if (tofind.equalsIgnoreCase("datepicker--cell datepicker--cell-day")
					|| tofind.equalsIgnoreCase("datepicker--cell datepicker--cell-day -weekend-")) {

				
				if (driver.findElement(By.xpath(xpath)).getText().equals(day)) {

					driver.findElement(By.xpath(xpath)).click();

					break;

				}

			}

		}

		
		Thread.sleep(4000);

		driver.quit();

	}

}
