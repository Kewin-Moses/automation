import io.cucumber.java.Scenario;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

	@CucumberOptions(features = "src/test/resources/features", glue = {"stepDefinition" }, 
	plugin = {"pretty", "html:target/cucumber-reports", "json:target/cucumber.json"},
	monochrome = true,
	publish = true)

public class TestRunner extends AbstractTestNGCucumberTests {
	
		  @Override
		  @DataProvider(parallel = true)
		    public Object[][] scenarios() {
		        return super.scenarios();
		    }
	
	

}

