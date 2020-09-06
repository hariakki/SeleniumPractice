package basicdemo1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromProflng {

	public static void main(String[] args) throws InterruptedException {

		ChromeOptions cr = new ChromeOptions();
	    cr.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
	    cr.addArguments("--start-maximized");
	  //  cr.addArguments("incognito");
	  //  cr.addArguments("--proxy-server=http://83.209.94.87:8123");
	    
	    //profiling in chrome
	    
	 //   cr.addArguments("user-data-dir=C:\\Users\\Ankush420\\AppData\\Local\\Google\\Chrome\\User Data\\");
	    
	  //Turn off logs
	 
	    System.setProperty("webdriver.chrome.logfile", "E://abc.log");
	  // System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
	   System.setProperty(ChromeDriverService.CHROME_DRIVER_VERBOSE_LOG_PROPERTY, "true");
	    
	    
       

		WebDriver driver = new ChromeDriver(cr);
		driver.get("https://google.com");
		Thread.sleep(9000);
		driver.quit();

	}
	
	

}
