package miscellaneous;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Broken_links {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		driver.get("https://www.facebook.com/");

		List<WebElement> validLinks = new ArrayList<WebElement>();

		// getting all links and images, then adding it to a list

		List<WebElement> allLinks = driver.findElements(By.tagName("a"));

		allLinks.addAll(driver.findElements(By.tagName("img")));

		// getting links having proper href values (excluding javascript calls)

		for (WebElement ele : allLinks) {

			if (ele.getAttribute("href") != null && !(ele.getAttribute("href").startsWith("javascript"))) {

				validLinks.add(ele);

			}

			// printing Invalid links

			else {

				System.out.println(ele.getAttribute("href") + "   ->HAVING JS CALL OR NO href");

			}

		}

		System.out.println("Total no. of links and images are : " + allLinks.size());
		System.out.println("Total no. of VALID links and images are : " + validLinks.size());
		System.out.println("Total no. of INVALID links and images are : " + (allLinks.size() - validLinks.size()));

		// method call to check the status of links

		for (WebElement ele : validLinks) {

			Broken_links.doCheckLink(ele.getAttribute("href"));

		}

		driver.quit();

	}

	//cutsom method to check the status of links

	public static void doCheckLink(String linkUrl) {
		
		HttpURLConnection httpURLConnect = null;

		try {
		
			URL url = new URL(linkUrl);

			 httpURLConnect = (HttpURLConnection) url.openConnection();

			httpURLConnect.setConnectTimeout(5000);

			httpURLConnect.connect();

			String responseMessage = httpURLConnect.getResponseMessage();

			int responseCode = httpURLConnect.getResponseCode();

			if (responseCode == 200) {

				System.out.println("VALID LINK :: " + linkUrl + "  :: " + responseMessage + " :: " + responseCode);

			}

			else if (responseCode < 200 || responseCode > 299) {

				System.out.println("INVALID LINK : " + linkUrl + "  ->" + responseMessage + "----" + responseCode);

			}

		} catch (Exception e) {

			e.printStackTrace();
		}
		
		finally {
			
			httpURLConnect.disconnect();
		}

	}

}
