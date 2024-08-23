package test;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(features= "C:/Users/admin/Downloads/SeleniumCucumberBDD-master/CucumberJava/src/test/resources/FeatureWithTags", 
glue= {"StepDefinitions"},
tags = "@smoke",
monochrome= true,
plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:","timeline:test-output-thread/"})

public class TestRunner_RunWithMultipleTags {

	public String projectPath = System.getProperty("user.dir");

}
