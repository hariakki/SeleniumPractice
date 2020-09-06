package cookies;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.chrome.ChromeDriver;

public class CookiesAll {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		driver.get("https://edition.cnn.com/");

		// print all the cookies

		Options opt = driver.manage();

		// getting all the cookies

		Set<Cookie> allCookies = opt.getCookies();

		for (Cookie ck : allCookies) {

			// printing all cookies when "Countrycode = IND" as a cookie is present

			System.out.println(ck.getName() + " : " + ck.getValue());

			// delete cookie named "countryCode"

			driver.manage().deleteCookieNamed("countryCode");

			// add cookie named "countryCode" with value = UK

			Cookie countrycode = new Cookie("countryCode", "UK");

			driver.manage().addCookie(countrycode);

		}

		System.out.println("---------------------------------------------");

		allCookies = opt.getCookies();

		for (Cookie ck : allCookies) {

			// Printing all the cookies when cookie "countryCode" with value = UK is already
			// added

			System.out.println(ck.getName() + " : " + ck.getValue());

			// In the above code, any property of cookie can be accessed- path ,domain etc.

		}

		driver.quit();

	}

}
