package basicdemo1;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;

public class Ffprofiling {

	public static void main(String[] args) throws InterruptedException {

		// profiling in Firefox

		// Setting off the logs or logging a log file at a particular loaction.

		// System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,
		// "E://abc.log");
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "null");

		// Setting the binary firefox.exe file

		FirefoxOptions options = new FirefoxOptions();
		options.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe");

		// Setting page load strategy

		options.setPageLoadStrategy(PageLoadStrategy.NORMAL);

		// Setting a profile

		ProfilesIni pf = new ProfilesIni();
		FirefoxProfile fpf = pf.getProfile("MOD11");

		// disbale web pop up notifications

		fpf.setPreference("dom.webnotifications.enabled", false);
		
		//Handling certificate error
		
//		fpf.setAcceptUntrustedCertificates(true);
//		fpf.setAssumeUntrustedCertificateIssuer(false);

		options.setProfile(fpf);
		
	
		
		

		// Firefox driving code
		WebDriver driver = new FirefoxDriver(options);
		driver.get("https://untrusted-root.badssl.com/");
//		WebElement wb = driver.findElement(By.xpath("//input[@id='srchquery_tbox']"));
//		wb.sendKeys("mrunal hot pics");
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//form[@name='newsrchform']//input[@class='newsrchbtn']")).click();
		Thread.sleep(5000);
		driver.quit();

	}

}
