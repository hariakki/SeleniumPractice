package miscellaneous;

import java.util.Base64;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PasswordEncryptDecrypt {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("http://tutorialsninja.com/demo/index.php?route=account/login");

		// ---------------------------------------------------------------------------------

		// code to encrypt a password

		// In real time this String will be fetched from any data source -Excel
		// file/properties file /Db etc.

		String passwordInString = "KKKkiran";

		// changing the password in string to byte []

		byte[] passwordInBytes = passwordInString.getBytes();

		// logic for Encrypting the password

		byte[] encryptedPasswordInBytes = Base64.getEncoder().encode(passwordInBytes);

		// the encode (<password in bytes>) will return byte []; so, change to String

		String encryptedPasswordInString = new String(encryptedPasswordInBytes);

		// printing the encrypted password

		System.out.println("The encrypted password is : " + encryptedPasswordInString);

		// ---------------------------------------------------------------------------------

		// code to decrypt the password

		byte[] decryptedPasswordInBytes = Base64.getDecoder().decode(encryptedPasswordInString);

		// the decode (<password in string>) will return byte []; so, change to String

		String decryptedPasswordInString = new String(decryptedPasswordInBytes);

		System.out.println("The decrypted password is : " + decryptedPasswordInString);

		// ---------------------------------------------------------------------------------

		// filling the login form

		driver.findElement(By.cssSelector("#input-email")).sendKeys("ankush.kumar@gmail.com");

		driver.findElement(By.cssSelector("#input-password")).sendKeys(decryptedPasswordInString);

		driver.findElement(By.xpath("//input[@type='submit']")).click();

		Thread.sleep(4000);

		driver.quit();

	}

}
