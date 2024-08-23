package StepDefinitions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.ArrayUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import CommonUtil.ElementUtil;
import dataProviders.ConfigFileReader;
import driverManager.WebDriverManager;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.opentelemetry.internal.StringUtils;
import pagefactory.Advertiser_PF;
import pagefactory.HomePage_PF;
import pagefactory.LoginPage_PF;
import pagefactory.SchedulePage_PF;


public class AdvertiserValidation extends WebDriverManager{
	LoginPage_PF login;
	HomePage_PF home;
	SoftAssert mySoftAssert=new SoftAssert();
	SchedulePage_PF schedule;
	Advertiser_PF advertiser;
	WebDriverManager webDriverManager;
	ElementUtil elementUtil;
	ConfigFileReader configFileReader;
	public String newMatchID=null;
	public static Scenario scenario;
 	@Before()
	public void before(Scenario scenario) {
		this.scenario = scenario;
	}
 //value = "@smoke2"
 	 @After
     public void afterScenario(Scenario scenario) throws Exception {
         mySoftAssert.assertAll();
     }

 	 @And ("Click on Advertiser page and Navigate")
 	public void click_on_adv() throws InterruptedException
 	 {
 		home = new HomePage_PF(driver);
 		home.ClickAdvertiser();
 	 }
 	 @And ("Click on Ad Creative page and Navigate")
  	public void click_on_adcreative() throws InterruptedException
  	 {
  		home = new HomePage_PF(driver);
  		home.ClickAdCreative();
  	 }
 	@When ("Add Advertiser")
 	public void add_advertiser() throws InterruptedException
 	{
 		Thread.sleep(100);
 		advertiser = new Advertiser_PF(driver);
 		advertiser.AddAdvWithInvalidData();
 		advertiser.AddAdv();
		Thread.sleep(2000);
 	}
 	
 	@When ("Add New Ad Creative {string} {string} {string}")
 	public void add_new_ad_creative(String CreativeMode,String creativeType ,String Url) throws Exception
 	{
 		Thread.sleep(100);
 		advertiser = new Advertiser_PF(driver);
 		advertiser.AddAdCreative(CreativeMode,creativeType,Url);
		Thread.sleep(2000);
 	}
 	
	@When ("Add New Ad Creative Error Validation")
 	public void add_new_ad_creative_error_validation() throws Exception
 	{
 		Thread.sleep(100);
 		advertiser = new Advertiser_PF(driver);
 		advertiser.AddAdCreativeErrorValidation();
		Thread.sleep(2000);
 	}
 	@And ("^Validate Add Advertiser \"(.*)\"$")
 	public void validate_add_advertiser(String name) throws InterruptedException
 	{
 		Thread.sleep(100);
 		advertiser = new Advertiser_PF(driver);
 	}
 	
 	@And ("Validate All Advertiser Listing ")
 	public void validate_all_adv_list() throws Exception
 	{
 		Thread.sleep(100);
 		advertiser = new Advertiser_PF(driver);
 	}
 	@And ("Validate Active Advertiser")
 	public void validate_active_adv() throws Exception
 	{
 		Thread.sleep(100);
 		advertiser = new Advertiser_PF(driver);
 	}
 	
 	@And ("Validate InActive Advertiser")
 	public void validate_inactive_adv() throws Exception
 	{
 		Thread.sleep(100);
 		advertiser = new Advertiser_PF(driver);
 	}

 
	@And ("Validate All Ad Creative Listing")
 	public void validate_all_ad_creative_list() throws Exception
 	{
 		Thread.sleep(100);
 		advertiser = new Advertiser_PF(driver);
 		advertiser.AllButtonValidation();
 	}
 	@And ("Validate Active Ad Creative Listing")
 	public void validate_active_ad_creative() throws Exception
 	{
 		Thread.sleep(100);
 		advertiser = new Advertiser_PF(driver);
 		advertiser.ActiveButtonValidation();
 	}
 	
 	@And ("Validate InActive Advertiser Listing")
 	public void validate_inactive_ad_creative() throws Exception
 	{
 		Thread.sleep(100);
 		advertiser = new Advertiser_PF(driver);
 		advertiser.InActiveButtonValidation();
 	}
 	@And ("Verfiy format of phone number field")
 	public void verify_phone_no() throws InterruptedException
 	{
 		Thread.sleep(100);
 		advertiser = new Advertiser_PF(driver);
 	}
 	@And ("Verify field length for advertiser name and description fields")
 	public void verify_nameAndDesc() throws InterruptedException
 	{
 		Thread.sleep(100);
 		advertiser = new Advertiser_PF(driver);
 	}
 	
 	@And ("Verify validation message for email field")
 	public void verify_email() throws InterruptedException
 	{
 		Thread.sleep(100);
 		advertiser = new Advertiser_PF(driver);
 	}
 	
 	@And ("Close the Chrome driver")
 	public void close_driver() throws InterruptedException
 	{
 		Thread.sleep(100);
 		advertiser = new Advertiser_PF(driver);
 	}
 	


}