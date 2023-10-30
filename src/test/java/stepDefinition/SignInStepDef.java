package stepDefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageClass.SignInPage;

public class SignInStepDef {

	private String username = "Kewinmo";
	private String password = "1532";
	private SignInPage signinpage;
	private WebDriver driver;

	@Before
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();

	}

	@After
	public void tearDown() {
		if (driver != null) {
			driver.quit();
			;
		}
	}

	@Given("Currently I am on the demoBlaze site page")
	public void currently_i_am_on_the_demo_blaze_site_page() {
		driver.get("https://www.demoblaze.com/");
		signinpage = new SignInPage(driver);
	}

	@Given("I open the signup popup")
	public void i_open_the_signup_popup() {
		System.out.println("Signup Popup opnened");
	}

	@And("I have entered an un-used username and password")
	public void i_have_entered_an_un_used_username_and_password() throws InterruptedException {
		Thread.sleep(3000);
		signinpage.SignIn(username, password);
	}

	@When("I click the Signup button")
	public void i_click_the_signup_button() {
		signinpage.clickSubmitButton();
	}

	@Then("I should be Signup sucessfully")
	public void i_should_be_signup_sucessfully() throws InterruptedException {
		signinpage.closeAlert();
		System.out.println("You have signed in sucessfully");
	}

	@Given("I have entered already used username and password")
	public void i_have_entered_already_used_username_and_password() throws InterruptedException {
		signinpage.SignIn(username, password);
	}

	@When("I click on the signup button")
	public void i_click_on_the_signup_button() {
		signinpage.clickSubmitButton();
	}

	@Then("I should see a alert")
	public void i_should_see_a_alert() {
		System.out.println("Alert is present");

		signinpage.closeAlert();
	}

	@Given("I have entered username and password")
	public void i_have_entered_username_and_password() throws InterruptedException {
		signinpage.SignIn(username, password);
	}

	@When("I click on the close button")
	public void i_click_on_the_close_button() {
		signinpage.clickCloseButton();
	}

	@Then("I should see the signup popup closed without creating a account")
	public void i_should_see_the_signup_popup_closed_without_creating_a_account() {
		System.out.println("Popup closed sucessfully");
		signinpage.closeAlert();
	}

}
