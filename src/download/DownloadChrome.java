package download;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DownloadChrome {

	public static void main(String[] args) throws InterruptedException {

		ChromeOptions options = new ChromeOptions();

		String downloadPath = System.getProperty("user.dir") + "\\Downloads";

		Map<String, Object> preferences = new HashMap<String, Object>();

		// setting preferences using Map

		preferences.put("profile.default_content_settings.popups", 0);

		preferences.put("download.default_directory", downloadPath);

		options.setExperimentalOption("prefs", preferences);

		WebDriver driver = new ChromeDriver(options);

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		driver.get("http://omayo.blogspot.com/p/page7.html");

		// clicking the download link

		driver.findElement(By.xpath("//a[text()='ZIP file']")).click();

		Thread.sleep(4000);

		// to check if the file got downloaded successfully or not

		File myfile = new File(".//Downloads//DownloadDemo-master.zip");

		if (myfile.exists()) {

			System.out.println("File got downloaded: <<SUCCESS>>");
		}

		else {

			System.out.println("File got downloaded: <<FAILED>>");

		}
		driver.quit();

	}

}
