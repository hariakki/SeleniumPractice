package basicdemo1;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Window_manupulation {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		Point p;

	//	driver.manage().window().maximize();
		
		//Printing coordinates before setting window to (0,0)

		p = driver.manage().window().getPosition();

		System.out.println("The positions BEFORE SET  are :" + p.getX() + "  " + p.getY());

		Thread.sleep(3000);

		driver.get("http://automationtesting.in/");
		
		//Printing coordinates before setting window to (0,0)

		Point poi = new Point(0, -200);

		driver.manage().window().setPosition(poi);

		p = driver.manage().window().getPosition();

		System.out.println("The positions AFTER SET  are :" + p.getX() + "  " + p.getY());

		Thread.sleep(9000);

	driver.quit();

	}

}
