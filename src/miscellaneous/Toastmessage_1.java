package miscellaneous;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Toastmessage_1 {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		driver.get("https://codeseven.github.io/toastr/demo.html");

		Thread.sleep(3000);

		driver.findElement(By.xpath("//input[@id='title']")).sendKeys("Hola Seneora!");
		driver.findElement(By.xpath("//textarea[@id='message']")).sendKeys("My name is Abhishek");
		driver.findElement(By.xpath("//button[text()='Show Toast']")).click();

		System.out.println("Title is : " + driver.findElement(By.xpath("//div[@class='toast-title']")).getText());

		System.out.println("Title is : " + driver.findElement(By.xpath("//div[@class='toast-message']")).getText());
		driver.quit();

	}

}
