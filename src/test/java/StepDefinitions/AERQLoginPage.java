package StepDefinitions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import CommonUtil.ElementUtil;
import dataProviders.ConfigFileReader;
import driverManager.WebDriverManager;
import driverManager.FileReaderManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pagefactory.Advertiser_PF;
import pagefactory.HomePage_PF;
import pagefactory.LoginPage_PF;

public class AERQLoginPage {				
	WebDriver driver;
	LoginPage_PF login;
	HomePage_PF home;
	Advertiser_PF advertiser;
	ElementUtil elementUtil;
	WebDriverManager webDriverManager;
	ConfigFileReader configFileReader;
	SoftAssert mySoftAssert=new SoftAssert();

	private Scenario scenario;
 	@Before()
	public void before(Scenario scenario) {
		this.scenario = scenario;
	}
 //value = "@smoke2"
 	 @After
     public void afterScenario(Scenario scenario) throws Exception {
         mySoftAssert.assertAll();
     }

	    @Given("Open the chrome")				
	    public void Open_the_chrome_browser() throws Throwable							
	    {		
	    	webDriverManager = new WebDriverManager();
			driver = webDriverManager.getDriver();
		   }
	     
	    @And("Navigate to the AERQ homepage")  
	      public void Navigate_to_the_advertiser_site() throws Throwable 
	      {
	    	configFileReader =new ConfigFileReader();
	    	driver.get(configFileReader.getApplicationUrl(configFileReader.getEnvironment().toString().toLowerCase())+"");
	        Thread.sleep(3000);
	    	//elementUtil = new ElementUtil();
	    	//elementUtil.pageLoad(driver);

	    }	
	    
	    @And("Navigate to the Ad Creative page")  
	      public void Navigate_to_the_adcreative_site() throws Throwable 
	      {
	    	configFileReader =new ConfigFileReader();
	    	driver.get(configFileReader.getApplicationUrl(configFileReader.getEnvironment().toString().toLowerCase())+"");
	        Thread.sleep(3000);
	    	//elementUtil = new ElementUtil();
	    	//elementUtil.pageLoad(driver);

	    }	
	    @And("Click login link")					
	    public void Click_login_link() throws Throwable 							
	    {    
	    	login = new LoginPage_PF(driver);
	        System.out.println("Click login button.");	
	        login.clickLogin();
	    }
	    
	    @And("Click login link if link available")					
	    public void Click_login_link_if() throws Throwable 							
	    {    
	    	try
	    	{
	    	configFileReader =new ConfigFileReader();
		    String url = configFileReader.getApplicationUrl(configFileReader.getEnvironment().toString().toLowerCase());
		     
	    	login = new LoginPage_PF(driver);
	        System.out.println("Click login button.");	
	        login.clickLoginifavailable(url);
	    
	    	}
	    	catch(Exception ex)
	    	{
	    	scenario.log(ex.getMessage());
	    	}
	    	}
	    
	   
	    @When("User enter {string} and {string} for login validation")					
	    public void user_enter_the_username_and_password(String username,String password) throws Throwable 							
	    {
	    	login = new LoginPage_PF(driver);
	       System.out.println("This step enter the Username and Password on the login page.");
			login.enterUsername(username);
			login.enterPassword(password);
			login.clickOnSubmit();
			// System.out.println("Alert :"+login.getAlertMsg());
			Thread.sleep(2000);
	     //  driver.findElement(By.name("username")).sendKeys("1681@email.com"); 
//	       driver.findElement(By.name("password")).sendKeys("Test@1234");
	    }
	    
	    @When("^User enter \"([^\"]*)\" and \"([^\"]*)\"$")					
	    public void enter_the_username_and_password(String username,String password) throws Throwable 							
	    {
	    	login = new LoginPage_PF(driver);
	       System.out.println("This step enter the Username and Password on the login page.");
			login.enterUsername(username);
			login.enterPassword(password);
			login.clickOnSubmit();
			Thread.sleep(5000);
	     //  driver.findElement(By.name("username")).sendKeys("1681@email.com"); 
//	       driver.findElement(By.name("password")).sendKeys("Test@1234");
	    }		


		  @When("Login as Admin Team")
		  public void login_as_admin_team() throws Throwable
		  	{
			configFileReader =new ConfigFileReader();
			login = new LoginPage_PF(driver);    
			Thread.sleep(2000);

			login.enterUsername(configFileReader.getAdminUserName(configFileReader.getEnvironment().toString().toLowerCase()));
			login.enterPassword(configFileReader.getAdminPassword(configFileReader.getEnvironment().toString().toLowerCase()));
			login.clickOnSubmit();
		//	WebDriverWait wait = new WebDriverWait(driver, 10); 
		//	WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("responsive-navbar-nav")));
			
			Thread.sleep(5000);
			//Boolean isPresent = driver.findElements(By.id("responsive-navbar-nav")).size() > 0;
			//if(isPresent==true)
			//{
			//	WebDriverWait wait = new WebDriverWait(driver, 10); 
			//	WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("responsive-navbar-nav")));
			//}
			//else
			//{
			//	driver.navigate().refresh();
			
			//}
		  	}
		  
	    @And("Click submit button")					
	    public void Click_submit_button() throws Throwable 							
	    	{    
	        System.out.println("Click login button.");	
	        login.clickOnSubmit();
	    	}
	    
	    @And("Navigate to the cricbay home page")
	    public void Navigate_to_home_page() throws Throwable 
	    	{
	    	//driver.manage().window().maximize();
	    	String Home= configFileReader.getApplicationUrl(configFileReader.getEnvironment().toString().toLowerCase())+"/home";
	    	System.out.println("Home page URL is" +Home);
	    	driver.navigate().to(Home);
	    	Thread.sleep(1000);
	    	}
	    
	    @And("Validate AERQ home page for {string} with {string}")
	    public void validate_home_page(String cases,String message) throws Throwable 
	    	{
	    	login = new LoginPage_PF(driver);
	    	Thread.sleep(1000);
	    	//driver.manage().window().maximize();
	    	String Home= configFileReader.getApplicationUrl(configFileReader.getEnvironment().toString().toLowerCase())+"/overview";
	    	System.out.println("Home page URL is" +Home);
	    	if(cases.equalsIgnoreCase("login"))
	    	{
	    	scenario.log("Home page Validation , Actual URL" +driver.getCurrentUrl() +"Expected URL" +Home);
	    	mySoftAssert.assertEquals(driver.getCurrentUrl(),Home,"Home page landing URL Validation");  
	    	}
	    	else if(cases.equalsIgnoreCase("wronguser"))
	    	{
	    		System.out.println(login.getError());
	    		scenario.log("Validation Error, Actual Msg" +login.getError() +"Expected Msg :" +message);
		    	mySoftAssert.assertEquals(login.getError(),message,"Error Message Validation");  
		    	
	    	}
	    	else if(cases.equalsIgnoreCase("wrongpassword"))
	    	{
	    		System.out.println(login.getPasswordError());
	    		scenario.log("Validation Error , Actual Msg : " + login.getPasswordError() +"Expected Msg : " +message);
		    	mySoftAssert.assertEquals(login.getPasswordError(),message,"Error Message Validation");  
		    	
	    	}
	    	Thread.sleep(1000);
	    	}
	    
	    @Then("Click on Logout")
	    public void Click_on_logout()
	    	{
	    	login = new LoginPage_PF(driver);
	    	try {
				login.clickOnLogout();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	}	  
	    
	    @Then("Click on Logout on {string}")
	    public void Click_on_logout(String status)
	    	{
	    	if(status.equalsIgnoreCase("login"))
	    	{
	    	login = new LoginPage_PF(driver);
	    	try {
				login.clickOnLogout();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	
	    	}
	    	}	 
	    
	    
	    
}

