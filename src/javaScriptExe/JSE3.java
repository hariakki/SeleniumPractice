package javaScriptExe;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JSE3 {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		driver.get("http://omayo.blogspot.com/");

		JavascriptExecutor js = (JavascriptExecutor) driver;

	    //Scrolling page by page
		
		//Height of one page
		
		long i = (long) js.executeScript("return window.innerHeight;");
		
		System.out.println("each page height is : "+i);
		
		//total scrollable height
		
		long k = (long) js.executeScript("return document.body.scrollHeight");
		
		System.out.println("total scrollable height is : "+k);
		
		//total pages 
		
		int totalPage = (int) (k/i)+1;
		
		System.out.println("Total no of pages are: "+totalPage);
		
		
		//Itertaing through total no. ofpages
		
	   for (int j=0;j<totalPage;j++) {
		   
		   
		   js.executeScript("window.scrollBy(0,"+i+")");
		   
		   Thread.sleep(2700);
		   	   
		   
	   }


		driver.quit();
	}

}
