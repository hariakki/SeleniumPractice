package robot;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Robot1 {

	public static void main(String[] args) throws AWTException, InterruptedException, IOException {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		driver.get("http://tutorialsninja.com/demo/");

		// Initializing Robot class object

		Robot rob = new Robot();

		WebElement searchBox = driver.findElement(By.xpath("//input[@name='search']"));

		// Enter text in serach box

		searchBox.sendKeys("zamana chor denge hum");

		// 1. Click TAB to go to search icon and then click Enter to serach

		rob.keyPress(KeyEvent.VK_TAB);
		rob.keyRelease(KeyEvent.VK_TAB);

		// delay the robot execution for 4 seconds

		rob.delay(4000);

		rob.keyPress(KeyEvent.VK_ENTER);
		rob.keyRelease(KeyEvent.VK_ENTER);

		Thread.sleep(3000);

		// 2. move the mouse/ Mouse Hover to "Desktops" menu

		rob.mouseMove(146, 270);

		Thread.sleep(4000);

		// 3. scrolling - mouse scoll using mouse wheel

		rob.mouseWheel(80);

		rob.delay(2000);

		rob.mouseWheel(-80);

		rob.delay(2000);

		// 4.mouse press and mouse release- left and right click

		// a. left click on items button after moving mouse on that

		rob.mouseMove(1116, 180);

		rob.mousePress(InputEvent.BUTTON1_MASK);

		rob.mouseRelease(InputEvent.BUTTON1_MASK);

		// b. moving mouse to 'serach link' and right clicking on it and opening it in
		// new
		// window

		rob.delay(6000);

		rob.mouseMove(200, 330);

		rob.mousePress(InputEvent.BUTTON3_MASK);
		rob.mouseRelease(InputEvent.BUTTON3_MASK);

		// pressing ARROW DOWN and then hitting ENTER

		rob.delay(2000);

		rob.keyPress(KeyEvent.VK_DOWN);
		rob.keyPress(KeyEvent.VK_DOWN);
		rob.keyRelease(KeyEvent.VK_DOWN);
		rob.keyRelease(KeyEvent.VK_DOWN);

		rob.delay(2000);

		rob.keyPress(KeyEvent.VK_ENTER);
		rob.keyRelease(KeyEvent.VK_ENTER);

		String parentWindowHandle = driver.getWindowHandle();

		Thread.sleep(4000);

		// 5. capturing screenshot

		Rectangle area = new Rectangle(0, 0, 100, 800);

		BufferedImage bufferedImage = rob.createScreenCapture(area);

		File imageFile = new File(".\\screenshots\\Repo_screenshot\\jcb.png");

		Thread.sleep(5000);

		ImageIO.write(bufferedImage, "png", imageFile);

		System.out.println("NON Full desktop screenshot saved");

		// capturing fullscreen screenshot

		Rectangle area1 = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());

		BufferedImage bufferedImage1 = rob.createScreenCapture(area1);

		File imageCaptured = new File(".\\screenshots\\Repo_screenshot\\jcb_full.png");

		ImageIO.write(bufferedImage1, "png", imageCaptured);

		System.out.println("Full desktop screenshot saved");

		// close the child window

		Set<String> allOpenedWindow = driver.getWindowHandles();

		for (String s : allOpenedWindow) {

			if (!s.equalsIgnoreCase(parentWindowHandle)) {

				driver.switchTo().window(s);

				driver.close();

				break;
			}

		}

		driver.switchTo().window(parentWindowHandle);

		Thread.sleep(4000);
		driver.quit();

	}

}
