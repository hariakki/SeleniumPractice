package autoIT;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowAuth {

	public static void main(String[] args) throws IOException, InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		
		

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		driver.get("https://the-internet.herokuapp.com/basic_auth");

		// getting path of AutoIt .exe file

		String autoItScriptPath = "E:\\Authenticator.exe";

		String username = "admin";

		String password = "admin";

		Thread.sleep(2000);

		// creating string array to pass path to AutoIt .exe file and arguments

		String[] cmd = { autoItScriptPath, username, password };

		// running the autoIt.exe file

		Runtime.getRuntime().exec(cmd);

		Thread.sleep(2000);

		driver.quit();

	}

}
