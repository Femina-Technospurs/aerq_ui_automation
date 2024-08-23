package test.runner;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.testng.annotations.DataProvider;
import driverManager.WebDriverManager;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@CucumberOptions(plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
"timeline:test-output-thread/"},features="src/test/resources/Features/AdCreative.feature",
		// "Advertiser.feature", 

//LiveScoreWithoutUmp.feature
//LiveScoreDataDriven.feature
//SuperOver.feature

glue= {"StepDefinitions"},tags = "@smoke",
monochrome = true, snippets = SnippetType.CAMELCASE)



@RunWith(CustomCucumberRunner.class)
public class TestRunnerAdvertiser extends AbstractTestNGCucumberTests 
{
    @BeforeSuite
    public static void test() throws InvalidFormatException, IOException 
    {
        FeatureOverright.overrideFeatureFiles(System.getProperty("user.dir")+"/src/test/resources/features");
    }
    
	public static WebDriverManager webDriverManager;
	  @DataProvider(parallel = true) public Object[][] scenarios() 
	  { 
		  return super.scenarios(); 
	  }
	  
    @AfterClass
	   public static void afterAll() 
    {
		webDriverManager.closeDriver();
	}
}	