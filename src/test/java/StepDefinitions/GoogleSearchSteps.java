package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import driverManager.WebDriverManager;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import dataProviders.ConfigFileReader;
import driverManager.WebDriverManager;
import driverManager.FileReaderManager;
import CommonUtil.ExtentReportsClass;

public class GoogleSearchSteps {

	WebDriver driver = null;
	WebDriverManager webDriverManager;
	ConfigFileReader configFileReader;
	ExtentReportsClass extentReport;
	String projectPath = System.getProperty("user.dir");

	private Scenario scenario;
 	@Before()
	public void before(Scenario scenario) {
		this.scenario = scenario;
	}
	@Given("browser window is open")
	public void browser_is_open() throws Exception {
		
		System.out.println("Inside Step - browser is open");
		
		System.out.println("Project path is : "+projectPath);
		
		webDriverManager = new WebDriverManager();
		driver = webDriverManager.getDriver();
	
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		scenario.log("<a href="+ extentReport.getScreenshot(driver, projectPath)+ "> Link to Image </a>");
		//driver.manage().window().maximize();
		
	}

	@And("user is on google search page")
	public void user_is_on_google_search_page() throws Exception {
		
		System.out.println("Inside Step - user is on goolge search page");
		
		driver.navigate().to("https://google.com");
		scenario.log("<a href="+ extentReport.getScreenshot(driver, projectPath)+ "> Link to Image </a>");
			
	}

	@When("user enters a text in search box")
	public void user_enters_a_text_in_search_box() throws Exception {
		
		System.out.println("Inside Step - user enters a text in search box");
		
		driver.findElement(By.name("q")).sendKeys("Automation Step by Step");
		scenario.log("<a href="+ extentReport.getScreenshot(driver, projectPath)+ "> Link to Image </a>");
		
		Thread.sleep(2000);
	}

	@And("hits enter")
	public void hits_enter() throws InterruptedException {
		
		System.out.println("Inside Step - hits enter");
		
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
	}

	@Then("user is navigated to search results")
	public void user_is_navigated_to_search_results() {
		
		System.out.println("Inside Step - user is navigated to search results");
		
		driver.getPageSource().contains("Online Courses");
		
		driver.close();
		driver.quit();
	}




}
