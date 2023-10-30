package pageClass;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignInPage {
	
	//Webdriver
	private WebDriver driver;
	
	//Alert
	private Alert alert ;
	
	private boolean foundAlert;
	//
	private WebDriverWait wait;
	
	//Locators
	private By signInLocator = By.linkText("Sign up");
    private By userNameLocator = By.id("sign-username");
    private By passWordLocator = By.id("sign-password");
    private By SignInSubmitLocator = By.xpath("//button[.='Sign up']");
    private By SignInCloseLocator = By.xpath("(//button[.='Close'])[2]");
    
    //Constructor
    public SignInPage(WebDriver driver) {
    	this.driver=driver;
	}
    
    //Methods
    public void clickSignIn(){
        WebElement SignInButton = driver.findElement(signInLocator);
        SignInButton.click();
    }
    public void enterUserName(String email){
        WebElement emailInput = driver.findElement(userNameLocator);
        emailInput.sendKeys(email);
    }
    public void enterPassword(String password){
        WebElement emailInput = driver.findElement(passWordLocator);
        emailInput.sendKeys(password);
    }
    public void clickSubmitButton(){
        WebElement submitClick = driver.findElement(SignInSubmitLocator);
        submitClick.click();
    }
    public void clickCloseButton(){
        WebElement closeClick = driver.findElement(SignInCloseLocator);
        closeClick.click();
    }
    public boolean isAlertPresent(){
         foundAlert = false;
         wait = new WebDriverWait(driver, Duration.ofSeconds(5) );
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            foundAlert = true;
        } catch (TimeoutException eTO) {
            foundAlert = false;
        }
        return foundAlert;
    }
    public void closeAlert() {
    	if(isAlertPresent()==true) {  	
    		 String text = driver.switchTo().alert().getText();
    		 System.out.println("The text in alert is :"+ text  );
    	System.out.println("Alert is present" + isAlertPresent());
    	}else {
    		System.out.println("No alert is present");
    	}
    }

    
    public void SignIn(String username, String password) throws InterruptedException {
        clickSignIn();
        Thread.sleep(2000);
        enterUserName(username);
        enterPassword(password);
    }
    
    

}
