package sikuliX;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class SikuliX1 {

	public static void main(String[] args) throws InterruptedException, FindFailed {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		driver.get("http://tutorialsninja.com/demo/");

		Thread.sleep(3000);

		// Creating a Screen class object

		Screen screen = new Screen();

		// creating all pattern objects (image elements stored)

		Pattern myAccount = new Pattern("E:\\SikuliImages\\MyAccount.PNG");
		Pattern login_Pg1 = new Pattern("E:\\SikuliImages\\Login.PNG");
		Pattern email = new Pattern("E:\\SikuliImages\\Email Address.PNG");
		Pattern password = new Pattern("E:\\SikuliImages\\password.PNG");
		Pattern login_btn = new Pattern("E:\\SikuliImages\\Login_btn.PNG");
		Pattern doubleClick_Omayo = new Pattern("E:\\SikuliImages\\doubleClick_btn_Omayo.PNG");
		Pattern report_link = new Pattern("E:\\SikuliImages\\reports_Link.PNG");
		Pattern about_RightClicker = new Pattern("E:\\SikuliImages\\about_RightClick.PNG");

		// writing script

		screen.wait(myAccount, 5);
		screen.click(myAccount);
		screen.click(login_Pg1);
		screen.type(email, "ankush.bhardwaj@boku.com");
		screen.type(password, "gundaaraj");
		screen.click(login_btn);

		driver.navigate().to("http://omayo.blogspot.com");

		// if an element is not viewable on screen, the sikuli script will fail.
		// scrolling till the doubleClick button on Omayo page using JS

		WebElement webElement_doubleClick_Omayo = driver
				.findElement(By.xpath("//button[text()=' Double click Here   ']"));

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView(true)", webElement_doubleClick_Omayo);

		screen.doubleClick(doubleClick_Omayo.similar(0.5f));

		Thread.sleep(4000);

		driver.switchTo().alert().accept();

		driver.navigate().to("http://automationtesting.in/");

		screen.wait(report_link);

		screen.hover(report_link);
		screen.rightClick(about_RightClicker);

		Thread.sleep(4000);

		driver.quit();

	}

}
