package test;


import org.junit.AfterClass;
import org.junit.runner.RunWith;

import driverManager.WebDriverManager;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;


@RunWith(Cucumber.class)

@CucumberOptions(features="src/test/resources/Features/parallel", 
glue= {"StepDefinitions"},
monochrome= true,
plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
		"timeline:test-output-thread/"})

public class TestRunner extends WebDriverManager{
	@AfterClass
	   public static void afterAll() {
		//closeDriver();
	}

}
