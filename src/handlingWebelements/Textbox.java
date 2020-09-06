package handlingWebelements;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Textbox {

	public static void main(String[] args) throws InterruptedException {

WebDriver driver = new ChromeDriver();

driver.manage().window().maximize();

driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

driver.get("http://automationtesting.in/");

driver.findElement(By.xpath("//a[text()='Demo Site']")).click();


driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys("abhisheka");;

Thread.sleep(2500);

driver.findElement(By.xpath("//input[@placeholder='First Name']")).clear();

driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys("adder");;
Thread.sleep(2000);


driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys("bhardwaj");;


Thread.sleep(2000);


System.out.println(driver.findElement(By.xpath("//input[@placeholder='Last Name']")).getAttribute("value"));

driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.DELETE)); ;

System.out.println(driver.findElement(By.xpath("//input[@placeholder='Last Name']")).getAttribute("value").length());

driver.findElement(By.xpath("//textarea")).sendKeys("katai gandu \t abhishek hi to hai na gandu\n mohan bhi hai gandu baaaai...");;

Thread.sleep(3000);

driver.quit();


		

	}

}
