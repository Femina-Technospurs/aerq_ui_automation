package test;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.testng.annotations.DataProvider;
import io.cucumber.testng.AbstractTestNGCucumberTests;

import driverManager.WebDriverManager;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Features/Parallel/AddRun.feature", 
glue= {"StepDefinitions"},
monochrome= true,
plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
		"timeline:test-output-thread/"}
)
public class TestRunnerAdvertiser extends AbstractTestNGCucumberTests 
{
	 
	public static WebDriverManager webDriverManager;
	  @DataProvider(parallel = false) public Object[][] scenarios() { return
	  super.scenarios(); }
	  
	@AfterClass
	   public static void afterAll() {
		webDriverManager.closeDriver();
	}
}
