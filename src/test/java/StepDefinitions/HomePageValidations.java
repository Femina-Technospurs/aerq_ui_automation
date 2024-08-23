package StepDefinitions;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import CommonUtil.ElementUtil;
import dataProviders.ConfigFileReader;
import driverManager.WebDriverManager;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.opentelemetry.internal.StringUtils;
import pagefactory.HomePage_PF;
import pagefactory.Advertiser_PF;
import pagefactory.LoginPage_PF;
import pagefactory.SchedulePage_PF;

public class HomePageValidations extends WebDriverManager{
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

 	@When("Login as Home Team Again")
	  public void login_as_home_team() throws Throwable
	  	{
    	login = new LoginPage_PF(driver);

 		configFileReader =new ConfigFileReader();
		Thread.sleep(5000);
		login.enterUsername(configFileReader.getHomeTeamUserName(configFileReader.getEnvironment().toString().toLowerCase()));
		login.enterPassword(configFileReader.getHomeTeamPassword(configFileReader.getEnvironment().toString().toLowerCase()));
		//login.enterUsername("16229@email.com");
		//login.enterPassword("Test@1234");
		login.clickOnSubmit();
		Thread.sleep(5000);
	  	}
 	
 	@When("^User login enter \"([^\"]*)\" and \"([^\"]*)\"$")					
    public void enter_the_username_and_password(String username,String password) throws Throwable 							
    {
    	login = new LoginPage_PF(driver);
       System.out.println("This step enter the Username and Password on the login page.");
		login.enterUsername(username);
		login.enterPassword(password);
		login.clickOnSubmit();
		Thread.sleep(5000);
     //  driver.findElement(By.name("username")).sendKeys("1681@email.com"); 
//       driver.findElement(By.name("password")).sendKeys("Test@1234");
    }		
	  
 	
 	@And("^Click on the link \"(.*)\"$")
	public void Clicl_on_Link_in_Home_Page(String linkValue) throws Exception
	{
		home = new HomePage_PF(driver);
		login = new LoginPage_PF(driver);
		home.clickAnyLink(linkValue);
	}
 	
  	@And("^Click on the Button \"(.*)\"$")
 	public void Clicl_on_Button(String linkValue) throws Exception
 	{
 		home = new HomePage_PF(driver);
 		login = new LoginPage_PF(driver);
 		home.clickAnyButton(linkValue);
 	}
  	
  	@And("^Verify on the Link availablity \"(.*)\"$")
 	public void verify_on_Link_notavailable(String linkValue) throws Exception
 	{
 		home = new HomePage_PF(driver);
 		login = new LoginPage_PF(driver);
 		Boolean isButtonPresernt =home.VerifyButton(linkValue);
 		mySoftAssert.assertEquals(isButtonPresernt,false);
	    scenario.log("Actual Element Availability :" + isButtonPresernt+ ", Expected element availability : False");	  

 	}
	@And("^Verify on the Button availablity \"(.*)\"$")
 	public void verify_on_Button_notavailable(String linkValue) throws Exception
 	{
 		home = new HomePage_PF(driver);
 		login = new LoginPage_PF(driver);
 		Boolean isButtonPresernt =home.VerifyButton(linkValue);
 		mySoftAssert.assertEquals(isButtonPresernt,false);
	    scenario.log("Actual Element Availability :" + isButtonPresernt+ ", Expected element availability : False");	  

 	}
	
	@And("^Verify on the Button availablity for false \"(.*)\"$")
 	public void verify_on_UpdateButton_notavailable(String linkValue) throws Exception
 	{
 		home = new HomePage_PF(driver);
 		login = new LoginPage_PF(driver);
 		Boolean isButtonPresernt =home.VerifyUpdateButton(linkValue);
 		mySoftAssert.assertEquals(isButtonPresernt,false);
	    scenario.log("Actual Element Availability :" + isButtonPresernt+ ", Expected element availability : False");	  

 	}
	
	
 	
	@And("^Verify on the Button availablity for true \"(.*)\"$")
 	public void verify_on_Button_available(String linkValue) throws Exception
 	{
 		home = new HomePage_PF(driver);
 		login = new LoginPage_PF(driver);
 		Boolean isButtonPresernt =home.VerifyUpdateButton(linkValue);
 		mySoftAssert.assertEquals(isButtonPresernt,true);
	    scenario.log("Actual Element Availability :" + isButtonPresernt+ ", Expected element availability : True");	  

 	}
	@And("Click on the links {string} and {string}")
	public void Clicl_on_Links_in_Home_Page(String linkValue,String linkValue2) throws Exception
	{
		home = new HomePage_PF(driver);
		login = new LoginPage_PF(driver);
		home.clickAnyLink(linkValue,linkValue2);
	}
	
	  @And("Select {string} Tabs")
	  public void select_tabs(String tabName) throws InterruptedException
	  {
		  try {
			  
			  advertiser = new Advertiser_PF(driver);

	  advertiser.switchTab(tabName);
		  }
	  catch(Exception ex)
	  {
		  scenario.log(ex.getMessage());
		  throw ex;
	  }
		  }
	  @And("Validation of Tabs in {string} page")
	  public void validation_of_tabs(String tabName) throws InterruptedException
	  {
		  try {
			  advertiser = new Advertiser_PF(driver);
			  scenario.log("Validation of Tab values : "+tabName);
			  Thread.sleep(4000);
			  if(tabName.equalsIgnoreCase("live"))
			  {
				  scenario.log("Batter Bowler Table avaialble : ");
				 			  }
			  else if(tabName.equalsIgnoreCase("scoreentry"))
			  {
				  scenario.log("Current Run: ");
						  
			  }
			  else if(tabName.equalsIgnoreCase("scorecard"))
			  {
				advertiser.validateBatterTable2();
				String[] value=advertiser.validateBatterTable("R", "0");
				scenario.log("Batter table value for R :"+value[0]+","+value[1]);
				mySoftAssert.assertEquals(value[0],"0") ;
						 }
			  else if(tabName.equalsIgnoreCase("commentary"))
			  {
				  Boolean flag= advertiser.verifyCommentsinCommetaryTab();
				  scenario.log("Commentary Table isDisplayed :"+flag);	
				  mySoftAssert.assertEquals(flag,true);
			  }
			  else if(tabName.equalsIgnoreCase("overs"))
			  {
				  Boolean flag= advertiser.VerifyOverTable();
				  scenario.log("Over table isDisplayed :"+ flag);	
				  mySoftAssert.assertEquals(flag,true);
			  }
			  
			  /*advertiser.switchTab("ScoreEntry");
			  Thread.sleep(1000);
			  advertiser.switchTab("Scorecard");
			  Thread.sleep(1000);
			  advertiser.switchTab("Commentary");
			  Thread.sleep(1000);
			  advertiser.switchTab("Overs");
		  */
			  }
		  catch(Exception ex)
		  {
			  scenario.log(ex.getMessage());
			  throw ex;
		  }
	  }
	  }