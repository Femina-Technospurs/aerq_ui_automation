package test;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="C:/Users/admin/Downloads/SeleniumCucumberBDD-master/CucumberJava/src/test/resources/FeatureWithTags", glue= "StepDefinitions",
//tags = {"@Smoke"}) //deprecated
// tags = {"@smoke or @regression"}
tags = "@smoke and @regression",
monochrome= true,
plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:","timeline:test-output-thread/"})
// tags = {"(@smoke or @regression) and @important"}
// tags = {"@regression and not @smoke"}
//tags = {"(@smoke or @regression) and not @important"}
		
public class TestRunner_RunWithSingleTag {

}
