package pagefactory;

import static org.junit.Assert.assertEquals;
import org.testng.asserts.SoftAssert;

import CommonUtil.ElementUtil;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.TimeZone;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.Scenario;
import StepDefinitions.AdvertiserValidation;
import dataProviders.ConfigFileReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class SchedulePage_PF {
	
	WebDriver driver;
	ElementUtil elementUtil;
	ConfigFileReader configFileReader;

	@FindBy(xpath="//a[contains(text(),'Schedule')]")
	WebElement lnk_Schedule;
	
	@FindBy(xpath="//a[contains(text(),'Tournaments')]")
	WebElement lnk_Tournaments;
	
	@FindBy(id="tournament_46")
	WebElement TournamentSeason;
	
	@FindBy(xpath="//a[contains(text(),'Update Settings')]")
	WebElement btnUpdateTournamentSeason;
	
	@FindBy(id="tournament_event_id")
	WebElement dropdownTournament;
	
	@FindBy(id="weekend_date")
	WebElement dropdownWeekEnd;
	
	@FindBy(xpath="//a[contains(text(),'Add New Match')]")
	WebElement addNewMatch;		
	
	@FindBy(xpath="//button[contains(text(),'View Free Grounds')]")
	WebElement viewFreeGround;		
	
	@FindBy(id="reason")
	WebElement txtReason;

	@FindBy(xpath="//input[@value='Abandon All the games']")
	WebElement abondanAllTheGame;
	
	@FindBy(xpath="//div[contains(@id,'showGround')]/following-sibling::h4")
	WebElement freeGroundList;
		
	@FindBy(xpath="//a[contains(text(),'Abandon all Matches')]")
	WebElement abandonAllMatch;		
	
	@FindBy(id="match_date")
	WebElement matchDate;
	
	@FindBy(id="game_time")
	WebElement matchTime;
	
	@FindBy(id="ground")
	WebElement dropdownGround;
	
	@FindBy(id="home_team")
	WebElement dropdownHomeTeam;
		
	@FindBy(id="umpire1_team")
	WebElement dropdownUmpire1;
	
	@FindBy(id="away_team")
	WebElement dropdownAwayTeam;
	
	@FindBy(id="umpire2_team")
	WebElement dropdownUmpire2;
	
	@FindBy(id="permit_time")
	WebElement dropdownPermitTime;

	@FindBy(id="game_stage")
	WebElement dropdownGameStage;
	
	@FindBy(id="updateBtn")
	WebElement btnUpdate;
	
	@FindBy(css = ".col-md-4 .switch-off")
	WebElement toggleLiveScore;
	
	@FindBy(css = ".col-md-4 .switch-on")
	WebElement toggleLiveScoreOff;
	
	@FindBy(css = ".col-md-3 .switch-off")
	WebElement toggleSplit;
	
	@FindBy(css = ".col-md-3 .switch-on")
	WebElement toggleSplitOff;
	
	@FindBy(xpath="//span[@class='switch btn on btn-light']")
	WebElement onSplit;
	
	@FindBy(xpath="//div[@class='col-md-3 font-weight-bold p-1']")
	WebElement tournamentValue;
	
	@FindBy(id="isTrophyGame")
	WebElement matchLeadtoTrophy;	
	
	
	
	@FindBy(xpath="//span[@class='switch btn off btn-light']")
	WebElement offSplit;
	
	@FindBy(xpath="//div[@class='switch-group']")
	WebElement splitInningValue;	
	
	@FindBy(css = ".off .switch-off")
	WebElement toggleYesSplitInTournament;
	
	@FindBy(css = ".form-inline .switch-on")
	WebElement toggleNoSplitInTournament;
	 
	@FindBy(id="addBtn")
	WebElement btnUpdateTournamentEvent;	
		
	@FindBy(name="split_inning_over")
	WebElement dropdownSplitInningOver;
	
	@FindBy(name="max_overs_played")
	WebElement dropdownMaxOver;
	
	@FindBy(name="number_of_pp_overs")
	WebElement dropdownppOver;
	
	@FindBy(name="notify_team")
	WebElement radioNotifyTeam;
	
	@FindBy(name="max_overs_per_bowler")
	WebElement dropdownMaxOverPerBowler;
	
	@FindBy(name="ground_charge")
	WebElement dropdownGroundCharge;
	
	
	@FindBy(css=".fade")
	WebElement Message;
		
	@FindBy(xpath="//h4[@class='border-0 m-0 p-0']")
	List<WebElement> tableGames;
	
	

	@FindBy(xpath="//*[@id=\"root\"]/div/div/div/div/div[6]/div[1]/h5")
	WebElement SaturdayFreeGround;
	
	@FindBy(xpath="//*[@id=\"root\"]/div/div/div/div/div[6]/div[1]/h5")
	WebElement SundayFreeGround;
	
	@FindBy(xpath="//div[@class='alert alert-success p-1']")
	WebElement icons;
	
	@FindBy(xpath="//span[@class='text-danger']")
	List<WebElement> errorTxt;
	@FindBy(xpath="//div[@class='bi bi-bag-x-fill text-danger']")
	WebElement iconsMissingPermit;
	
	@FindBy(xpath="//div[@class='bi bi-briefcase-fill text-primary']")
	WebElement iconsValidPermit;
	
	@FindBy(xpath="//div[@class='bi bi-check text-success']")
	WebElement iconsIemailInit;
	
	@FindBy(xpath="//div[@class='bi bi-calendar2-plus-fill text-danger']")
	WebElement iconsAbandonedGame;
	
	//private Scenario scenario;
	SoftAssert mySoftAssert=new SoftAssert();
	
 	@Before()
	public void before(Scenario scenario) 
 	{
		AdvertiserValidation.scenario = scenario;
	}
 	 
 	@After
    public void afterScenario(Scenario scenario) throws Exception {
        mySoftAssert.assertAll();
    }
	
	
	public SchedulePage_PF(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);	
		
	}
	public void clickSchedule()
	{
		lnk_Schedule.click();	
	}
	
	
	public void clickTournaments(String split) throws InterruptedException
	{
		lnk_Tournaments.click();
		Thread.sleep(1000);
		TournamentSeason.click();
		Thread.sleep(1000);
		btnUpdateTournamentSeason.click();
		Thread.sleep(1000);
		if(split.equalsIgnoreCase("yes"))
		{
			toggleYesSplitInTournament.click();
			dropdownSplitInningOver.click();
			Select dropdownSplit=new Select(dropdownSplitInningOver);
			dropdownSplit.selectByVisibleText("3 Overs");
			Thread.sleep(1000);
			dropdownSplitInningOver.click();
		}
		else 
		{
			toggleNoSplitInTournament.click();
		}
		btnUpdateTournamentEvent.click();
		}

	public void clickAddNewMatch() throws Exception
	{
		try {
			
		addNewMatch.click();
		}
		catch (Exception e)
		{
            throw e;
		}
	}
	public String errValidation_AddNewMatch() throws Exception
	{
		try {
			
		addNewMatch.click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		//WebElement element = wait.until(
		 //       ExpectedConditions.visibilityOfElementLocated(By.id("match_date")));
		Thread.sleep(5000);
		System.out.println(tournamentValue.getText());
		 mySoftAssert.assertEquals(tournamentValue.getText(),"2023 Regular Season Regular Season - Round Robin","Tournament Value pre selected as lastest");
		 btnUpdate.click();
		 List<WebElement> errors= errorTxt;
		 String txt="";
		 	
		 for (WebElement error : errors) 
		 { 
			 System.out.println(error.getText());
			 if(error.getText().equals("Match date is required"))
			 {
				 mySoftAssert.assertEquals(error.getText().equals("Match date is required"), true," * Match date is required text found");
				txt=txt+" * Match date is required text found <br>";
			 }
			 else if(error.getText().equals("Permit time is required."))
			 {
				 mySoftAssert.assertEquals(error.getText().equals("Permit time is required."), true," * Permit time is required. text found");
					txt=txt+" * Permit time is required. text found <br>";
			
			 }
		     else if(error.getText().equals("Ground is required."))
			 {
		    	 mySoftAssert.assertEquals(error.getText().equals("Ground is required."), true," * Ground is required. text found");
					txt=txt+" * Ground is required. text found  <br>";
			
			 } 
		     else if(error.getText().equals("Home team is required."))					
			 {
		    	 mySoftAssert.assertEquals(error.getText().equals("Home team is required."), true," * Home team is required. text found");
					txt=txt+" * Home team is required. text found  <br>";
			
			 }
			 else if(error.getText().equals("Away team is required."))
			 {
				 mySoftAssert.assertEquals(error.getText().equals("Away team is required."), true," * Away team is required. text found");
					txt=txt+" * Away team is required. text found  <br>";
			
			 }
			 else if(error.getText().equals("Game stage is required."))
			 {
				 mySoftAssert.assertEquals(error.getText().equals("Game stage is required."), true," * Game stage is required. text found");
					txt=txt+" * Game stage is required. text found  <br>";
			
			 }
		
		 }
		 
		 mySoftAssert.assertEquals(matchLeadtoTrophy.isEnabled(),true);
		 mySoftAssert.assertEquals(dropdownMaxOver.getText(),"20","Validate default Value of Stipulated Overs per Team*");
		 mySoftAssert.assertEquals(dropdownppOver.getText(),"6","Validate dafault value of Number of PP Overs*");
		 mySoftAssert.assertEquals(dropdownMaxOverPerBowler.getText(),"4","VAlidate dafault value of Maximum Overs Per Bowler *");
		 mySoftAssert.assertEquals(dropdownGroundCharge.getText(),"50% of Ground Cost - Per Team","Validate default value of Ground Charge Split *");
		 validateDropdown1(dropdownMaxOver,"StimulateOver","20");
		 validateDropdown1(dropdownppOver,"PPOver","6");
		 validateDropdown1(dropdownMaxOverPerBowler,"MaxOverPerBowler","4");
		 validateDropdown1(dropdownGroundCharge,"Ground Change Split","50% of Ground Cost - Per Team");
		 System.out.println("Notify Team enabled : "+ radioNotifyTeam.getAttribute("value"));
		 radioNotifyTeam.click();
		 radioNotifyTeam.click();
		 return txt;
		}
		catch (Exception e)
		{
            throw e;
		}
	}
	
	public String validateDropdown1(WebElement drp,String name,String defaultValue) throws InterruptedException
	{
		String log  = null;
		Select select = new Select(drp);  
		List<WebElement> options = select.getOptions();  
		Boolean flagitem=false;  
		AdvertiserValidation.scenario.log(name + " default value dropdown value is :" +defaultValue);
		mySoftAssert.assertEquals(defaultValue,select.getFirstSelectedOption());
		 
		//Validation of the dropdown selection
		for(int i=0;i<options.size();i++)
		{
        		select.selectByVisibleText(options.get(i).getText());
        		WebElement selectedItem = select.getFirstSelectedOption();	
        		String strSelectedValue = selectedItem.getText();
        		Thread.sleep(1000);
        		if(strSelectedValue.equalsIgnoreCase(options.get(i).getText()))
        		{
        			 mySoftAssert.assertEquals(options.get(i).getText(),strSelectedValue);
        			System.out.println("Desired Value is selected in the dropdwon "+drp.getAttribute("name")+ "Value : " + strSelectedValue);
        			AdvertiserValidation.scenario.log("Desired Value is selected in the dropdwon "+drp.getAttribute("name")+ "\nValue : " + strSelectedValue);
        			flagitem=true;
        		}     	 
		}
		if(flagitem==false)
        {
        	System.out.println("Required Value not found in the dropdown");
        	AdvertiserValidation.scenario.log("Required Value not found in the dropdown");
        }
		Thread.sleep(500);
		select.selectByVisibleText(defaultValue);
		return log;
	}
	public void freeGroundValidation() throws Exception
	{
		try 
		{
			elementUtil = new ElementUtil();
			elementUtil.pageLoad(driver);
			Thread.sleep(4000);
			viewFreeGround.click();
		//	getFreeGround();
			//WebElement followingSibling = freeGroundList.findElement(By.xpath("following-sibling::*[1]"));
			//System.out.println(driver.findElement(By.xpath("//div[contains(@id,'showGround')]/following-sibling::h4")).getText());
			mySoftAssert.assertEquals(freeGroundList.getText().contains("Free List - Grounds Available"),true,"Validation of Free Ground and Text");
			AdvertiserValidation.scenario.log("Free Ground Text found "+freeGroundList.getText().contains("Free List - Grounds Available"));
driver.findElement(By.cssSelector("tr:nth-child(1) > .text-center .text-primary")).click();
driver.findElement(By.xpath("//button[contains(.,'Cancel')]")).click();
		}
		catch (Exception e)
		{
            throw e;
		}
	}
	public void AbandonAllMatchValidation() throws Exception
	{
		try 
		{				
			elementUtil = new ElementUtil();
			elementUtil.pageLoad(driver);
			Thread.sleep(7000);
			abandonAllMatch.click();
			txtReason.sendKeys("All match Abdandon");
			Thread.sleep(500);
			abondanAllTheGame.click();
			mySoftAssert.assertEquals(Message.getText().contains("Abandoned Games removed successfully"),true,"Success Message Found");
			AdvertiserValidation.scenario.log("Success Alert Message : "+Message.getText());
			System.out.println(Message.getText());
			
			Thread.sleep(2000);
			List<LinkedHashMap<String, String>> allTableData = elementUtil.readTableData(driver, "Saturday");
			List<LinkedHashMap<String, String>> allTableData1 = elementUtil.readTableData(driver, "Sunday");
			for(int i=0;i<allTableData.size() ;i++)
			{
				if(!allTableData.get(i).containsValue("No Matches found"))
				System.out.println("Table ["+ i +"] :" +allTableData.get(i).get("Match#"));
				System.out.println(allTableData.get(i));
				}
			for(int i=0;i<allTableData1.size() ;i++)
			{
				if(!allTableData1.get(i).containsValue("No Matches found"))
				{
				System.out.println("Table ["+ i +"] :" +allTableData1.get(i).get("Match#"));
				System.out.println(allTableData1.get(i));
				configFileReader =new ConfigFileReader();
				driver.navigate().to(configFileReader.getApplicationUrl(configFileReader.getEnvironment().toString().toLowerCase())+"/reschedulematch/"+allTableData1.get(i).get("Match#"));
				 elementUtil.pageLoad(driver);		
				
				
				btnUpdate.click();
				}
			}
		}
catch (Exception e)
{
    throw e;
}
}
	public void validateEditableField() throws Exception
	{
		try 
		
		{	
			String attribute  = matchDate.getAttribute("disabled"); 
			if(attribute==null)
				System.out.println("matchDate Element is editable");
			else 
				System.out.println("matchDate Element is Not Editable"+attribute);
			mySoftAssert.assertEquals(attribute,null,"matchDate is editable");
			AdvertiserValidation.scenario.log("matchDate is Disabled : "+attribute);
		
			attribute  = matchTime.getAttribute("disabled"); 
			if(attribute==null)
				System.out.println("MatchTime Element is editable");
			else 
				System.out.println("MatchTime Element is Not Editable"+attribute);
			mySoftAssert.assertEquals(attribute,null,"MatchTime is editable");
			AdvertiserValidation.scenario.log("MatchTime is Disabled : "+attribute);
			
			attribute  = dropdownGround.getAttribute("disabled"); 
			if(attribute==null)
				System.out.println("dropdownGround Element is editable"+attribute);
			else 
				System.out.println("dropdownGround Element is Not Editable"+attribute);

			mySoftAssert.assertEquals(attribute,null,"dropdownGround is editable");
			AdvertiserValidation.scenario.log("dropdownGround is Disabled : "+attribute);
			
			attribute  = dropdownHomeTeam.getAttribute("disabled"); 
			if(attribute==null)
				System.out.println("dropdownHomeTeam Element is editable");
			else 
				System.out.println("dropdownHomeTeam Element is Not Editable"+attribute);			
			mySoftAssert.assertEquals(attribute,true,"dropdownHomeTeam is editable");
			AdvertiserValidation.scenario.log("dropdownHomeTeam is Disabled : "+attribute);
			
			attribute  = dropdownAwayTeam.getAttribute("disabled"); 
			if(attribute==null)
				System.out.println("dropdownAwayTeam Element is editable");
			else 
				System.out.println("dropdownAwayTeam Element is Not Editable"+attribute);
			mySoftAssert.assertEquals(attribute,true,"dropdownAwayTeam is editable");
			AdvertiserValidation.scenario.log("dropdownAwayTeam is Disabled : "+attribute);
			
			attribute  = dropdownMaxOver.getAttribute("disabled"); 
			if(attribute==null)
				System.out.println("dropdownMaxOver Element is editable");
			else 
				System.out.println("dropdownMaxOver Element is Not Editable"+attribute);
			mySoftAssert.assertEquals(attribute,null,"dropdownMaxOver is editable");
			AdvertiserValidation.scenario.log("dropdownMaxOver is Disabled : "+attribute);
			
			attribute  = dropdownUmpire1.getAttribute("disabled"); 
			if(attribute==null)
				System.out.println("dropdownUmpire1 Element is editable");
			else 
				System.out.println("dropdownUmpire1 Element is Not Editable"+attribute);
			attribute  = dropdownUmpire2.getAttribute("disabled"); 
			mySoftAssert.assertEquals(attribute,null,"dropdownUmpire1 is editable");
			AdvertiserValidation.scenario.log("dropdownUmpire1 is Disabled : "+attribute);
			
			if(attribute==null)
				System.out.println("dropdownUmpire2 Element is editable");
			else 
				System.out.println("dropdownUmpire2 Element is Not Editable"+attribute);
			mySoftAssert.assertEquals(attribute,null,"dropdownUmpire2 is editable");
			AdvertiserValidation.scenario.log("dropdownUmpire2 is Disabled : "+attribute);
			
			attribute  = dropdownPermitTime.getAttribute("disabled"); 
			if(attribute==null)
				System.out.println("dropdownPermitTime Element is editable");
			else 
				System.out.println("dropdownPermitTime Element is Not Editable"+attribute);
			mySoftAssert.assertEquals(attribute,null,"dropdownPermitTime is editable");
			AdvertiserValidation.scenario.log("dropdownPermitTime is Disabled : "+attribute);
			
			attribute  = dropdownGameStage.getAttribute("disabled"); 
			if(attribute==null)
				System.out.println("dropdownGameStage Element is editable");
			else 
				System.out.println("dropdownGameStage Element is Not Editable"+attribute);
			mySoftAssert.assertEquals(attribute,null,"dropdownGameStage is editable");
			AdvertiserValidation.scenario.log("dropdownGameStage is Disabled : "+attribute);
				
		}
		catch (Exception e)
		{
            throw e;
		}
	}
	public void enterMatchDate(String date) throws Exception
	{
		try 
		{
			matchDate.click();
			matchDate.clear();
			matchDate.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		//	Thread.sleep(1000);
			//for(int k=0;k<20 ;k++)
			/*{	matchDate.sendKeys(Keys.chord(Keys.CONTROL, "a"));
				Thread.sleep(1000);
			matchDate.sendKeys(Keys.BACK_SPACE);
			}*/
			//Thread.sleep(4000);
			matchDate.sendKeys(date);
			Thread.sleep(1000);
			matchDate.sendKeys(Keys.ENTER);
			//matchDate.click();

			//matchDate.sendKeys(Keys.ENTER);
			//Thread.sleep(4000);

			
		}
		catch (Exception e)
		{
            throw e;
		}
	}
	
	public void enterMatchTime(String time) throws Exception
	{
		try 
		{
			matchTime.sendKeys(time);
		//	matchTime.sendKeys("08:30AM");
			matchTime.sendKeys(Keys.ENTER);
		}
		catch (Exception e)
		{
            throw e;
		}
	}
	
	public String getTournament()
	{
		String tournament=null;
		try
		{
			Select drpTournament=new Select(dropdownTournament);
			WebElement e=drpTournament.getFirstSelectedOption();
			tournament=e.getText();
		}
		catch(Exception e) 
		{
            throw e;
		}
		return tournament;
	}
	
	public String getWeekend()
	{
		String weekendValue=null;
		try
		{
			Select drpWeekend=new Select(dropdownWeekEnd);
			WebElement e=drpWeekend.getFirstSelectedOption();
			weekendValue=e.getText();
			//weekendValue=dropdownWeekEnd.getText();
			
		}
		catch(Exception e) 
		{
            throw e;
		}
		return weekendValue;
	}
	public void selectGround(String ground) throws Exception
	{
		try {
			Select drpGround=new Select(dropdownGround);
			drpGround.selectByVisibleText(ground);
			
			//drpGround.selectByVisibleText("Alviso Park"); 
			}
		catch (Exception e)
		{
            throw e;
		}
	}
	
	public void selectHomeTeam(String homeTeam) throws Exception
	{
		try {
			dropdownHomeTeam.click();
			Select drpHomeTeam=new Select(dropdownHomeTeam);
			drpHomeTeam.selectByVisibleText(homeTeam);
			
			//drpHomeTeam.selectByVisibleText("Absol");
			}
		catch (Exception e)
		{
            throw e;
		}
	}
	
	public void selectAwayTeam(String awayTeam) throws Exception
	{
		try {
			 Thread.sleep(1000); 
			 Select drpAwayTeam=new Select(dropdownAwayTeam);
			 drpAwayTeam.selectByVisibleText(awayTeam);
			 //drpAwayTeam.selectByVisibleText("Alp");
			}
		catch (Exception e)
		{
            throw e;
		}
	}
	public void selectOver(String Over) throws Exception
	{
		try {
			 Thread.sleep(1000); 
			 Select drpOver=new Select(dropdownMaxOver);
			 drpOver.selectByVisibleText(Over);
			 //drpAwayTeam.selectByVisibleText("Alp");
			}
		catch (Exception e)
		{
            throw e;
		}
	}
	
	
	public void selectUmpire1(String ump1) throws Exception
	{
		try 
		{
			if(!ump1.isEmpty())
			{
			 Thread.sleep(1000); 
			 Select drpUmpire1=new Select(dropdownUmpire1);
			 drpUmpire1.selectByVisibleText(ump1);
			}
			//drpUmpire1.selectByVisibleText("Aryans");
		}
		catch (Exception e)
		{
            throw e;
		}
	}
	
	public void selectUmpire2(String ump2) throws Exception
	{
		try {
			if(!ump2.isEmpty())
			{
			 Thread.sleep(1000); 
			 Select drpUmpire2=new Select(dropdownUmpire2);
			 drpUmpire2.selectByVisibleText(ump2);
			//drpUmpire2.selectByVisibleText("007");
			}
			}
		catch (Exception e)
		{
            throw e;
		}
	}
	
	
	public void selectPermitTime(String premitTime) throws Exception
	{
		try {
			 Select drpPermitTime=new Select(dropdownPermitTime);
			 drpPermitTime.selectByVisibleText(premitTime);
			 // drpPermitTime.selectByVisibleText("8:30-12:00");
			 }
		catch (Exception e)
		{
            throw e;
		}
	}
	
	public void selectGameStage(String stage) throws Exception
	{
		try {
			 
			 Select drpGameStage=new Select(dropdownGameStage);
			 drpGameStage.selectByVisibleText(stage);
			 // drpGameStage.selectByVisibleText("Ranking");
		
		}
		catch (Exception e)
		{
            throw e;
		}
	}
	
	public void selectMaxOver() throws Exception
	{
		try {
			 
			 Select drpMaxOver=new Select(dropdownMaxOver);
			 drpMaxOver.selectByVisibleText("10");
			 drpMaxOver.selectByVisibleText("20");
		}
		catch (Exception e)
		{
            throw e;
		}
	}
	
	public void selectppOver() throws Exception
	{
		try {
			 
			 Select drpppOver=new Select(dropdownppOver);
			 drpppOver.selectByVisibleText("4");
			 drpppOver.selectByVisibleText("6");
		}
		catch (Exception e)
		{
            throw e;
		}
	}

	public void selectMaxOverBowler() throws Exception
	{
		try {
			 
			 Select drpMaxOverBowler=new Select(dropdownMaxOverPerBowler);
			 drpMaxOverBowler.selectByVisibleText("4");
		}
		catch (Exception e)
		{
            throw e;
		}
	}
	
	public void selectGroundCharge() throws Exception
	{
		try {
			 Select drpGroundCharge=new Select(dropdownGroundCharge);
			 drpGroundCharge.selectByVisibleText("50% of Ground Cost - Per Team");
			 // drpGameStage.selectByVisibleText("Ranking");
		
		}
		catch (Exception e)
		{
            throw e;
		}
	}
	
	
	public void enableLiveScore(String live_score) throws Exception
	{
		try {
			if(live_score.equalsIgnoreCase("yes"))
			 toggleLiveScore.click();
		}
		catch (Exception e)
		{
            throw e;
		}
	}
	
	public void enableSplitInnings(String split,String overs) throws Exception
	{
		try {
			List<WebElement> on= driver.findElements(By.cssSelector(".col-md-3 .switch-off"));
			List<WebElement> off= driver.findElements(By.cssSelector(".col-md-3 .switch-on"));
			System.out.println( "Size" + on.size() +"Split Inning Value on"+toggleSplit.isSelected() +" Enabled"+toggleSplit.isEnabled() +" Displayed" +toggleSplit.isDisplayed());
			System.out.println( "Size" +off.size()+"Split Inning Value off "+toggleSplitOff.isSelected()+" Enabled"+toggleSplitOff.isEnabled() +" Displayed" +toggleSplitOff.isDisplayed());
			
			//List<WebElement> on= driver.findElements(By.cssSelector(".col-md-3 .switch-off"));
			//List<WebElement> off= driver.findElements(By.cssSelector(".on .switch-on"));
			//driver.findElement(By.cssSelector("span.switch-on.btn.btn-primary")).click();
			//driver.findElement(By.cssSelector("span.switch-off.btn.btn-primary")).click();
			
			//System.out.println( "Size" + on.size() +"Split Inning Value on"+toggleSplit.isSelected() +" Enabled"+toggleSplit.isEnabled() +" Displayed" +toggleSplit.isDisplayed());
			//System.out.println( "Size" +off.size()+"Split Inning Value off "+toggleSplitOff.isSelected()+" Enabled"+toggleSplitOff.isEnabled() +" Displayed" +toggleSplitOff.isDisplayed());
			if(split.equalsIgnoreCase("yes"))
			{

				toggleSplit.click();
				Thread.sleep(1000);
				dropdownSplitInningOver.click();
				Select dropdownSplit=new Select(dropdownSplitInningOver);
				dropdownSplit.selectByVisibleText("1 Over");				
				dropdownSplit.selectByVisibleText(overs);
			}
			System.out.println("Split Inning Value"+toggleSplitOff.isSelected());
			
		}
		catch (Exception e)
		{
            throw e;
		}
	}
	
	public void enableSplitInningsTournamentLevel(String split,String overs) throws Exception
	{
		try {
			List<WebElement> on= driver.findElements(By.cssSelector(".col-md-3 .switch-off"));
			List<WebElement> off= driver.findElements(By.cssSelector(".col-md-3 .switch-on"));
			System.out.println( "Size" + on.size() +"Split Inning Value on"+toggleSplit.isSelected() +" Enabled"+toggleSplit.isEnabled() +" Displayed" +toggleSplit.isDisplayed());
			System.out.println( "Size" +off.size()+"Split Inning Value off "+toggleSplitOff.isSelected()+" Enabled"+toggleSplitOff.isEnabled() +" Displayed" +toggleSplitOff.isDisplayed());
			
			//List<WebElement> on= driver.findElements(By.cssSelector(".col-md-3 .switch-off"));
			//List<WebElement> off= driver.findElements(By.cssSelector(".on .switch-on"));
			//driver.findElement(By.cssSelector("span.switch-on.btn.btn-primary")).click();
			//driver.findElement(By.cssSelector("span.switch-off.btn.btn-primary")).click();
			
			//System.out.println( "Size" + on.size() +"Split Inning Value on"+toggleSplit.isSelected() +" Enabled"+toggleSplit.isEnabled() +" Displayed" +toggleSplit.isDisplayed());
			//System.out.println( "Size" +off.size()+"Split Inning Value off "+toggleSplitOff.isSelected()+" Enabled"+toggleSplitOff.isEnabled() +" Displayed" +toggleSplitOff.isDisplayed());
			if(split.equalsIgnoreCase("yes"))
			{
				dropdownSplitInningOver.click();
				Select dropdownSplit=new Select(dropdownSplitInningOver);
				dropdownSplit.selectByVisibleText("1 Over");
				
				dropdownSplit.selectByVisibleText(overs);
				Thread.sleep(500);
			}
			else if(split.equalsIgnoreCase("no"))
			{
					toggleSplitOff.click();
			}
			System.out.println("Split Inning Value"+toggleSplitOff.isSelected());
			
		}
		catch (Exception e)
		{
            throw e;
		}
	}
	public void clickUpdate() throws Exception
	{
		try {
			 btnUpdate.click();
			 Thread.sleep(2000);
		}
		catch (Exception e)
		{
            throw e;
		}
	}
	
	public String addNewMach() throws Exception
	{
		try
		{
		addNewMatch.click();
		 String date=DateFunction(2);
		matchDate.sendKeys(date);
		matchDate.sendKeys(Keys.ENTER);
		
		matchTime.sendKeys("08:30AM");
		matchTime.sendKeys(Keys.ENTER);
		Select drpGround=new Select(dropdownGround);
		drpGround.selectByVisibleText("Alviso Park"); 
		//drpGround.selectByIndex(4);
		Thread.sleep(1000); 
		Select drpHomeTeam=new Select(dropdownHomeTeam);
		drpHomeTeam.selectByVisibleText("Absol");
		Thread.sleep(1000); 
		 Select drpUmpire1=new Select(dropdownUmpire1);
		 drpUmpire1.selectByVisibleText("Aryans");
		 Thread.sleep(1000); 
		 Select drpAwayTeam=new Select(dropdownAwayTeam);
		 drpAwayTeam.selectByVisibleText("Alp");
		
		 Thread.sleep(1000); 
		 Select drpUmpire2=new Select(dropdownUmpire2);
		 drpUmpire2.selectByVisibleText("007");
		
		 Select drpPermitTime=new Select(dropdownPermitTime);
		 drpPermitTime.selectByVisibleText("8:30-12:00");;
		 
		 
		 Select drpGameStage=new Select(dropdownGameStage);
		 drpGameStage.selectByVisibleText("Ranking");
	
		 toggleLiveScore.click();
		 btnUpdate.click();
		 Thread.sleep(2000);
		// assert Message.getText().contains("Match");
		 System.out.println("Message " +Message.getText());
		 return Message.getText();	
		}
		catch (Exception e)
		{
            throw e;
		}
		
		
	}	
	public String verifyMatchSave(String msg)
	
	{
		//assertEquals(Message.getText(),msg);
		//System.out.println(Message.getText());
		if(Message.getText().contains(msg))
		{
			System.out.println(Message.getText() + "Same Validation Appear");
		}
		else
		{
			
			System.out.println(Message.getText() + "Invalid Validation Message");
		}
		return Message.getText();
	}
	public String DateFunction(int addDays)
				{
				    final DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
					Date currentDate = new Date();
//			        System.out.println(dateFormat.format(currentDate));

			      //  ZoneId leavingZone = ZoneId.of("America/Los_Angeles"); 
			      //  ZonedDateTime departure = ZonedDateTime.of(currentDate, leavingZone);

			        // convert date to calendar
			        Calendar c = Calendar.getInstance();
			        c.setTime(currentDate);

			        // manipulate date
			        //c.add(Calendar.YEAR, 1);
			        //c.add(Calendar.MONTH, 1);
			        c.add(Calendar.DATE, addDays); //same with c.add(Calendar.DAY_OF_MONTH, 1);
			        //c.add(Calendar.HOUR, 1);
			        //c.add(Calendar.MINUTE, 1);
			        //c.add(Calendar.SECOND, 1);

			        // convert calendar to date
			        Date currentDatePlusOne = c.getTime();
			      //  System.out.println(dateFormat.format(currentDatePlusOne));
					return dateFormat.format(currentDatePlusOne);
				}
	
	public String getNextSaturday()
	{
	    try {
	    	 final DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
	        Calendar c = Calendar.getInstance();
	        c.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
	        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
	        Date weekendDate = sdf.parse(sdf.format(c.getTime()));
	        return dateFormat.format(weekendDate);
	    } catch (ParseException e) {
	        e.printStackTrace();
	        return null;
	    }
	}
	public String getCurrentDate()
	{
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");

		// Use Madrid's time zone to format the date in
		df.setTimeZone(TimeZone.getTimeZone("America/Los_Angeles"));

		System.out.println("Date and time in LA: " + df.format(date));
		
		/*TimeZone.getTimeZone("America/Los_Angeles");
		Date currentDate1 = Calendar.getInstance(TimeZone.getDefault()).getTime();
	    final DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date currentDate = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(currentDate1);
     //   c.add(Calendar.DATE, addDays); //same with c.add(Calendar.DAY_OF_MONTH, 1);
        Date currentDatePlusOne = c.getTime();
       System.out.println(dateFormat.format(currentDate1));
		*/
		return df.format(date);
	}
	public String getWeekEndGame()
	{
		String txtGames = null;
		  for(WebElement tableGame : tableGames)
		  {
			System.out.println("Game List found :" + tableGame.getText()); 
			txtGames=txtGames+tableGame.getText();
		  }
		  
		  return txtGames;
	}
	
	public String getFreeGround()
	{
		String txtGround =null;
		  System.out.println("Free ground found :" + SaturdayFreeGround.getText()); 
		  txtGround=txtGround+SaturdayFreeGround.getText();
		  System.out.println("Free ground found :" + SundayFreeGround.getText()); 
		  txtGround=txtGround+SundayFreeGround.getText();
		
		  
		  return txtGround;
	}
	
	public String getThisWeekEndDate()
	{
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("MM-dd-yyyy");
		df.setTimeZone(TimeZone.getTimeZone("America/Los_Angeles"));
		System.out.println("Date This Weekend" + df.format(date));
		return df.format(date);
	}
	public void selectTournament()
	{
		Select drpTournament=new Select(dropdownTournament);
		drpTournament.selectByVisibleText("2022 test tournament new Regular Season - Round Robin 1"); 
	
	}
	
	public void selectWeekend()
	{
		Select drpWeekEnd=new Select(dropdownWeekEnd);
		drpWeekEnd.selectByVisibleText("05/21/2022"); 
	}
	
	public boolean verifyIconRepresentation()
	{
		try {
boolean status = false;
			List<WebElement> list= icons.findElements(By.tagName("svg"));
			System.out.println("list value" +list.size() +list );
			if(list.size()==4)
			{
				if(list.get(0).getAttribute("class").equals("bi bi-bag-x-fill text-danger")) 
					{status = true;
					System.out.println("Missing Permit icon found");
					}
				else 
					System.out.println(list.get(0).getText().trim()+"Missing Permit Not Found");
				if(list.get(1).getAttribute("class").equals("bi bi-briefcase-fill text-primary")) 
					{
					status = true;
					System.out.println("Valid Permit icon found");
					}
				else 
					System.out.println(list.get(1).getText().trim() +"bi bi-check text-success");
				if(list.get(2).getAttribute("class").equals("bi bi-calendar2-plus-fill text-danger")) 
					{
					status = true;
					System.out.println("Iemail Initiate icon found");
					}
				else 
					System.out.println(list.get(2).getText().trim() +"Iemail Initiate not found");
				if(list.get(3).getAttribute("class").equals("Indicates Abandoned Game that can be rescheduled")) 
					{
					System.out.println("Abandoned Game icon found");
					status = true;
					}
				else 
				System.out.println(list.get(3).getText().trim()+"Abandoned Game Not Found");
			}
			else
				status= false;
			/*
			if(icons.findElement(By.xpath("//svg[@class='bi bi-bag-x-fill text-danger']")).isDisplayed())
				System.out.prin tln("Missing Permit");
			else 
				System.out.println("Missing Permit Not Fount");
			if(icons.findElement(By.xpath("//svg[@class='bi bi-briefcase-fill text-primary']")).isDisplayed())
				System.out.println("Valid Permit");
			else 
				System.out.println("Valid Permit Not Fount");
			if(icons.findElement(By.xpath("//svg[@class='bi bi-check text-success']")).isDisplayed())
				System.out.println("Iemail Initiate");
			else 
				System.out.println("Iemail Initiate Not Fount");
			if(icons.findElement(By.xpath("//svg[@class='bi bi-calendar2-plus-fill text-danger']")).isDisplayed())
				System.out.println("Abandoned Game");
			else 
			System.out.println("Abandoned Game Not Fount");*/
		return status;
		}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return false;
		}
		
	}
}
