package basicdemo1;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Remote1 {

	public static void main(String[] args) {
		
		RemoteWebDriver rm = new ChromeDriver();
		
		rm.get("https://google.com");
		
		System.out.println(rm.getTitle());
		
		
		
		rm.quit();


	}

}
