package robot;

import java.awt.AWTException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUploadSendKeys {

	public static void main(String[] args) throws AWTException, InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		driver.get("https://www.monsterindia.com/seeker/registration");
		
		Thread.sleep(3000);
		
		//Scrolling to keep upload process in view
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		WebElement random= driver.findElement(By.xpath("//h3[text()='Preferred Industry']"));
		
		js.executeScript("arguments[0].scrollIntoView(true)",random);
		
		//uploading the file using sendKeys()
		
		WebElement upload_btn = driver.findElement(By.id("file-upload"));

		upload_btn.sendKeys("C:\\Users\\Ankush420\\Desktop\\AbhishekBhardwaj_QA.docx");
		
		Thread.sleep(2500);
		
		//verifying the upload is correct or not
		
		if (upload_btn.getAttribute("title").equalsIgnoreCase("AbhishekBhardwaj_QA.docx")) {
			
		System.out.println("UPLOAD SUCCESSFUL >>>>>");	
			
			
			
		}
		
		else {
			
			System.out.println("UPLOAD FAILED >>>>>");
		}
		
		Thread.sleep(5000);

		driver.quit();

	}

}
