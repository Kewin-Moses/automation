package runner;



import io.cucumber.testng.AbstractTestNGCucumberTests;

@io.cucumber.testng.CucumberOptions(features = "src/test/resources/features", glue = {"stepDefinition" },
plugin = {"pretty", "html:target/cucumber-reports", "json:target/cucumber.json"}, 
monochrome = true,
publish = true)
public class TestRunner extends AbstractTestNGCucumberTests {
	  
}
