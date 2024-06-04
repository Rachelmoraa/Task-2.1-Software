package sit707_week2;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

/**
 * This class demonstrates Selenium locator APIs to identify HTML elements.
 * 
 * Details in Selenium documentation https://www.selenium.dev/documentation/webdriver/elements/locators/
 * 
 * @author Ahsan Habib
 */
public class SeleniumOperations {

	public static void sleep(int sec) {
		try {
			Thread.sleep(sec*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void officeworks_registration_page(String url) {
		// Step 1: Locate chrome driver folder in the local drive.
		System.setProperty("webdriver.chrome.driver", "/home/mahabib/java_lib/chromedriver-linux64/chromedriver");

		// Step 2: Use above chrome driver to open up a chromium browser.
		System.out.println("Fire up chrome browser.");
		WebDriver driver = new ChromeDriver();
		
		System.out.println("Driver info: " + driver);
		
		sleep(2);
	
		// Load a webpage in chromium browser.
		driver.get(url);
		
		/*
		 * How to identify a HTML input field -
		 * Step 1: Inspect the webpage, 
		 * Step 2: locate the input field, 
		 * Step 3: Find out how to identify it, by id/name/...
		 */

		sleep(12);
		
		// Find first input field which is firstname
		WebElement element = driver.findElement(By.id("firstname"));
		System.out.println("Found element: " + element);
		// Send first name
		element.sendKeys("Ahsan");

		/*
		 * Find following input fields and populate with values
		 */
		// Write code
		WebElement lastNameElement = driver.findElement(By.id("lastname"));
		System.out.println("Found element: " + lastNameElement);
		WebElement phoneNumberElement = driver.findElement(By.id("phoneNumber"));
		System.out.println("Found element: " + phoneNumberElement);
		WebElement emailElement = driver.findElement(By.id("email"));
		System.out.println("Found element: " + emailElement);
		WebElement passwordElement = driver.findElement(By.id("password"));
		System.out.println("Found element: " + passwordElement);
		WebElement confirmPasswordElement = driver.findElement(By.id("confirmPassword"));
		System.out.println("Found element: " + confirmPasswordElement);

		lastNameElement.sendKeys("Stone");
		phoneNumberElement.sendKeys("0787123465");
		emailElement.sendKeys("ahsan@stone.example.com");
		passwordElement.sendKeys("password");
		confirmPasswordElement.sendKeys("password");
		
		/*
		 * Identify button 'Create account' and click to submit using Selenium API.
		 */
		// Write code
		WebElement createAccountBtn = driver.findElement(By.xpath("//button[contains(text(),'Create account')]"));
		createAccountBtn.click();
		
		/*
		 * Take screenshot using selenium API.
		 */
		// Write code
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			screenshotFile.renameTo(new File("/home/makechi/Pictures/Screenshots/officeworks_screenshot.png"));
			System.out.println("Screenshot saved successfully");
		} catch (Exception e) {
			System.out.println("Failed to save screenshot: " + e.getMessage());
		}
		
		
		// Sleep a while
		sleep(2);

		// close chrome driver
		driver.close();
	}

	public static void alternative_registration_page(String url) {
// Step 1: Locate chrome driver folder in the local drive.
		System.setProperty("webdriver.chrome.driver", "/home/mahabib/java_lib/chromedriver-linux64/chromedriver");

		// Step 2: Use above chrome driver to open up a chromium browser.
		System.out.println("Fire up chrome browser.");
		WebDriver driver = new ChromeDriver();

		System.out.println("Driver info: " + driver);

		sleep(2);

		// Load a webpage in chromium browser.
		driver.get(url);

		sleep(12);

		// Locate input fields
		WebElement customerNameElement = driver.findElement(By.id("ap_customer_name"));
		System.out.println("Found element: " + customerNameElement);
		WebElement emailElement = driver.findElement(By.id("ap_email"));
		System.out.println("Found element: " + emailElement);
		WebElement passwordElement = driver.findElement(By.id("ap_password"));
		System.out.println("Found element: " + passwordElement);
		WebElement confirmPasswordElement = driver.findElement(By.id("ap_password_check"));
		System.out.println("Found element: " + confirmPasswordElement);

		// Send values
		customerNameElement.sendKeys("Ahsan Stone");
		emailElement.sendKeys("ahsan@stone.example.com");
		passwordElement.sendKeys("1234");
		confirmPasswordElement.sendKeys("1234");

		/*
		 * Identify element 'Continue' and click to submit using Selenium API.
		 */
		WebElement continueButton = driver.findElement(By.id("continue"));
		continueButton.click();

		/*
		 * Take screenshot using selenium API.
		 */
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			screenshotFile.renameTo(new File("/home/makechi/Pictures/Screenshots/alternative_screenshot.png"));
			System.out.println("Screenshot saved successfully");
		} catch (Exception e) {
			System.out.println("Failed to save screenshot: " + e.getMessage());
		}

		// Sleep a while
		sleep(10);

		// close chrome driver
		driver.close();
	}
	
}
