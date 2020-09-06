package download;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

public class Download_FF {

	public static void main(String[] args) throws InterruptedException {

		FirefoxOptions options = new FirefoxOptions();

		FirefoxProfile myProfile = new FirefoxProfile();

		String downloadPath = System.getProperty("user.dir") + "\\Downloads";

		// setting preferences

		myProfile.setPreference("browser.download.folderList", 2);

		myProfile.setPreference("browser.download.dir", downloadPath);

		myProfile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/zip");

		options.setProfile(myProfile);

		WebDriver driver = new FirefoxDriver(options);

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
