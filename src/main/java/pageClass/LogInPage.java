package pageClass;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogInPage {

	// Webdriver
	private WebDriver driver;

	// Alert
	//private Alert alert;

	private boolean foundAlert;
	//
	private WebDriverWait wait;

	// Constructor
	public LogInPage(WebDriver driver) {
		this.driver = driver;
	}

	private By loginLinkLocator = By.linkText("Log in");
	private By usernameLocator = By.id("loginusername");
	private By passwordLocator = By.id("loginpassword");
	private By loginButtonLocator = By.xpath("//button[.='Log in']");
	private By verifyloginLocator = By.id("nameofuser");

	public void clickLogInLink() {
		WebElement LoginLink = driver.findElement(loginLinkLocator);
		LoginLink.click();
	}

	public void enterUsername(String username) {
		WebElement UserNameEnter = driver.findElement(usernameLocator);
		UserNameEnter.sendKeys(username);
	}

	public void enterPassword(int password) {
		String pword = Integer.toString(password);
		WebElement PasswordEnter = driver.findElement(passwordLocator);
		PasswordEnter.sendKeys(pword);
	}

	public void clickLoginButton() {
		WebElement loginButtonClick = driver.findElement(loginButtonLocator);
		loginButtonClick.click();
	}

	public void LogIn(String username, int password) throws InterruptedException {

		Thread.sleep(2000);
		enterUsername(username);
		enterPassword(password);

	}

	public boolean isAlertPresent() {
		foundAlert = false;
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		try {
			wait.until(ExpectedConditions.alertIsPresent());
			foundAlert = true;
		} catch (TimeoutException eTO) {
			foundAlert = false;
		}
		return foundAlert;
	}

	public void closeAlert() {
		if (isAlertPresent() == true) {
			String text = driver.switchTo().alert().getText();
			System.out.println("The text in alert is : " + text);
			System.out.println("Alert is present" + isAlertPresent());
		} else {
			String welcometext = driver.findElement(verifyloginLocator).getText();
			System.out.println(welcometext);
				if(welcometext == "Welcome kewinmoses") {
					System.out.println("Log in sucess full: "+ welcometext);
				}else {
					System.out.println("Log in Unsucessfull");
				}
			
		}
	}

}
