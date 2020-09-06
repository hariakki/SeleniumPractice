package sikuliX;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class FileUpload {

	public static void main(String[] args) throws FindFailed, InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_input_multiple ");

		// Creating a Screen class object

		Screen screen = new Screen();

		// creating all pattern objects (image elements stored)

		Pattern choose_btn = new Pattern("E:\\SikuliImages\\FileUpload\\choose_btn.PNG");
		Pattern Filebox = new Pattern("E:\\SikuliImages\\FileUpload\\fileUploadbox.PNG");
		Pattern open = new Pattern("E:\\SikuliImages\\FileUpload\\Open_btn.PNG");

		screen.wait(choose_btn, 5);
		screen.click(choose_btn);

		// getting exact match for File box element visually

		screen.type(Filebox.similar(1f), "\"E:\\SikuliImages\\reports_Link.PNG\" \"E:\\SikuliImages\\password.PNG\"");
		screen.click(open);

		Thread.sleep(3000);

		driver.quit();

	}

}
