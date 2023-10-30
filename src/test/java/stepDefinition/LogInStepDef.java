package stepDefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageClass.LogInPage;
import pageClass.SignInPage;

public class LogInStepDef {

	private LogInPage loginpage;
	private WebDriver driver;

	@Before
	public void setup() {
		WebDriverManager.edgedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.demoblaze.com/");
		loginpage = new LogInPage(driver);
	}

	@After
	public void tearDown() {
		if (driver != null) {
		//	driver.quit();
			;
		}
	}

	@Given("I click on the Login link")
	public void i_click_on_the_login_link() {
		loginpage.clickLogInLink();
		System.out.println("Signup Popup opnened");
	}

	@Given("I enter the valid Username and Password")
	public void i_enter_the_valid_username_and_password() throws InterruptedException {
		loginpage.LogIn("kewinmoses", 1532);
	}

	@When("I click on the Login button")
	public void i_click_on_the_login_button() {
		loginpage.clickLoginButton();
	}

	@Then("I should be login sucessfully")
	public void i_should_be_login_sucessfully() throws InterruptedException {
		Thread.sleep(5000);
		loginpage.closeAlert();
	}

	@Given("I enter the Invalid  {string} and {int}")
	public void i_enter_the_invalid_and(String string, Integer int1) throws InterruptedException {
		loginpage.LogIn(string, int1);
	}

	@When("I click on the Log in button")
	public void i_click_on_the_log_in_button() {
		loginpage.clickLoginButton();
	}

	@Then("I should not be able to log in sucessfully")
	public void i_should_not_be_able_to_log_in_sucessfully() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
//		Thread.sleep(5000);
		loginpage.closeAlert();
	}

}
