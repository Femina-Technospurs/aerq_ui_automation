package pagefactory;

import static org.junit.Assert.assertThrows;
import org.openqa.selenium.JavascriptExecutor;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Random;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import CommonUtil.ElementUtil;
import StepDefinitions.AdvertiserValidation;
import dataProviders.ConfigFileReader;
import com.google.common.base.Verify;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import net.bytebuddy.implementation.bytecode.Throw;

public class Advertiser_PF {

	ElementUtil elementUtil;
	WebDriver driver;
	ConfigFileReader configFileReader;
	HomePage_PF home;
	Advertiser_PF Adv;
	SoftAssert mySoftAssert=new SoftAssert();
	private Scenario scenario;
 	
	@FindBy(id="freeHitNo")
	WebElement chkfreeHitNo;
	
	@FindBy(xpath="//button[contains(.,'New Advertiser')]")
	WebElement btnNewAdv;
	
	@FindBy(xpath="//button[contains(.,'New Ad Creative')]")
	WebElement btnNewAdCreative;
	
	@FindBy(id="Advertiser Name")
	WebElement txtAdvName;
		
	@FindBy(id="name")
	WebElement txtAdCreativeName;

	@FindBy(id="trackerName")
	WebElement txtTrackerName;

	@FindBy(id="Phone Number")
	WebElement txtPhn;
	
	@FindBy(id="Email ID")
	WebElement txtEmail;
	
	@FindBy(id="demo-simple-select-label font-Gilroy-Medium text-base")
	List<WebElement> dropdownAdSource2;
	
	//@FindBy(id=":rh:")
	@FindBy(xpath="//input[@class='MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputAdornedEnd MuiAutocomplete-input MuiAutocomplete-inputFocused css-1uvydh2']")
	WebElement dropdownAdList;
	
	
	
	@FindBy(xpath="//span[contains(.,'Select Advertiser')]")
	WebElement dropdownAdList1;

	@FindBy(xpath="(//label[@id='demo-simple-select-label font-Gilroy-Medium text-base'])[1]")
	WebElement dropdownTrackers1;

	
	@FindBy(id=":rk:")
	WebElement dropdownTrackers;
		
	@FindBy(name="adSourceId")
	WebElement dropdownAdSource;
	
	@FindBy(id="Description")
	WebElement txtDesc;
	
	@FindBy(name="description")
	WebElement txtDescAdCreative;
	
	@FindBy(id="long-button")
	WebElement dotButton;
	
	@FindBy(xpath="//span[contains(.,'Select Ad Source')]")
	WebElement selectAdSource;
	
	@FindBy(xpath="//label[contains(.,'Select Tracker Type')]")
	WebElement selectTrackerType;
	
	@FindBy(xpath="(//div[@class='MuiSelect-select MuiSelect-outlined MuiInputBase-input MuiOutlinedInput-input css-qiwgdb'])[2]")
	WebElement txtTrackerType;

	@FindBy(xpath="(//div[@class='MuiSelect-select MuiSelect-outlined MuiInputBase-input MuiOutlinedInput-input css-qiwgdb'])[1]")
	WebElement txtAdSourceType;
	
	@FindBy(xpath="//button[contains(.,'Add')]")
	WebElement btnAdd;
	
	@FindBy(id="imgAltText")
	WebElement btnImageText;
	
	@FindBy(id="creative Url")
	WebElement txtCreativeURL;
	
	@FindBy(id="creativeUrl")
	WebElement txtCreativeURL2;
	
	@FindBy(name="displayUrl")
	WebElement btnDisplayUrl;
	
	@FindBy(id="width")
	WebElement txtWidth;
	
	@FindBy(id="height")
	WebElement txtHeight;
	
	@FindBy(id="html5")
	WebElement txtHtml5;
	
	@FindBy(xpath="//button[text()='Add']")
	WebElement btnAdCreative;

	@FindBy(id="search")
	WebElement btnSearch;
	
	@FindBy(id="fileInput")
	WebElement btnFileInput;
	
	@FindBy(xpath="//u[contains(.,'Choose files')]")
	WebElement btnChoose;
	
	@FindBy(xpath="//button[@class='rounded w-[80px] h-[40px] bg-gradient-bg-primary font-gilroy text-base text-white font-semibold hover:shadow-neutral-400 shadow-md']")
	WebElement btnAddMedia;
	
	
	@FindBy(xpath="//button[contains(.,'Add Ad Media')]")
	WebElement btnAdMedia;
	
	@FindBy(name="trackerUrl")
	WebElement txtTrackerUrl;
	
	@FindBy(xpath="//button[contains(.,'+ Add Tracker')]")
	WebElement btnAddTracket;
	
	@FindBy(xpath="//button[contains(.,'Update')]")
	WebElement btnUpdate;
	
	@FindBy(xpath="//button[contains(.,'Cancel')]")
	WebElement btnCancel;
	
	@FindBy(xpath="//button[contains(.,'Delete')]")
	WebElement btnDeleteConfirm;
	
	@FindBy(xpath="//span[contains(.,'INACTIVE')]")
	WebElement btnInActive;
	
	@FindBy(xpath="//span[contains(.,'ACTIVE')]")
	WebElement btnActive;
	
	@FindBy(xpath="//span[contains(.,'EDIT ADVERTISER')]")
	WebElement btnEdit;
	
	@FindBy(xpath="//span[contains(.,'EDIT AD CREATIVE')]")
	WebElement btnEditAdCreative;
	
	@FindBy(xpath="//span[contains(.,'DELETE')]")
	WebElement btnDelete;
	
	@FindBy(xpath="//span[contains(.,'Ad Source')]")
	WebElement btnAdSource;
	
	@FindBy(xpath="//span[contains(.,'Upload')]")
	WebElement btnUploadRadio;
	
	@FindBy(xpath="//span[contains(.,'Creative URL')]")
	WebElement btnCreativeURLRadio;
	
	

	@FindBy(xpath="(//span[@class='font-Gilroy-SemiBold text-base'])[1]")
	WebElement buttonAll;
	
	@FindBy(xpath="(//span[@class='font-Gilroy-SemiBold text-base'])[2]")
	WebElement buttonActive;
	
	@FindBy(xpath="(//span[@class='font-Gilroy-SemiBold text-base'])[3]")
	WebElement buttonInActive;
	
	
	@FindBy(xpath="(//p[@class='font-Gilroy-SemiBold text-base text-sub-text-color flex'])[1]")
	WebElement txtName;
	
	@FindBy(xpath="(//p[@class='font-Gilroy-SemiBold text-base text-sub-text-color flex'])[2]")
	WebElement txtDate;
	
	@FindBy(xpath="(//p[@class='font-Gilroy-SemiBold text-base text-sub-text-color flex'])[3]")
	WebElement txtStatus;
	
	
	@FindBy(xpath="//span[contains(.,'Edge Ad Source')]")
	WebElement listAdSource;
	
	@FindBy(xpath="//span[contains(.,'IMAGE')]")
	WebElement listAdTypeImage;
	
	@FindBy(xpath="//span[contains(.,'VIDEO')]")
	WebElement listAdTypeVideo;
	
	@FindBy(xpath="//span[contains(.,'HTML5')]")
	WebElement listAdTypeHtml5;
	
	@FindBy(xpath="//span[contains(.,'ZIP')]")
	WebElement listAdTypeZip;
	

	@FindBy(xpath="//span[contains(.,'VAST')]")
	WebElement listAdTypeVast;
	
	@FindBy(xpath="//span[contains(.,'0%')]")
	WebElement listTracketType0;

	@FindBy(xpath="//span[contains(.,'25%')]")
	WebElement listTracketType25;
	
	@FindBy(xpath="//span[contains(.,'50%')]")
	WebElement listTracketType50;
	
	@FindBy(xpath="//span[contains(.,'75%')]")
	WebElement listTracketType75;
	
	@FindBy(xpath="//span[contains(.,'100%')]")
	WebElement listTracketType100;
	
	@FindBy(xpath="//span[contains(.,'Click')]")
	WebElement listTracketTypeClick;
	
	@FindBy(xpath="//span[contains(.,'Upload')]")
	WebElement btnUpload;
	
	
	@FindBy(xpath="//span[contains(.,'Creative URL')]")
	WebElement btnCreativeURL;
	
	@FindBy(xpath="//button[text()='Send IEmail for your game']")
	WebElement btnSendIemailforGame;

	@FindBy(id="new_batter_id")
	WebElement drpNewBatter;	
	
	@FindBy(xpath="//button[text()='Record Player-of-the-Match & Close Match']")
	WebElement btnCloseMatch;

	@FindBy(id="dismissal")
	WebElement drpResult;

	
	@FindBy(xpath="//a[text()='PoM Candidate Suggestions ']")
	WebElement POMExpand;

	@FindBy(xpath="//div[@class='p-1 modal-body']")
	WebElement undoPopUp;

	@FindBy(xpath="//p[@class='text-[#DF3F41] font-Gilroy-Medium text-[14px] mt-[2px]']")
	List<WebElement> alertText;
			
	@FindBy(xpath="//div[@class='p-1 overflow-auto modal-body']")
	WebElement ChangeBowlerErrorValidation;
	
	@FindBy(xpath="//div[@class='card-header bg-lightblue display-9 p-1']")
	WebElement commentsCommentaryTab;
	
	
	
	@FindBy(xpath="//label[@id='demo-simple-select-label font-Gilroy-Medium text-base']")
	WebElement dropdownadSource1;
	
	
	@FindBy(xpath="//table[@class='table oversTab']")
	WebElement OverTabTable;
	
	@FindBy(xpath="//p[@class='mt-[-3px]']")
	WebElement alertMsg;
	
	
	@FindBy(xpath="//div[@class='modal-body']")
	WebElement popupSendIemail;
	
	
 	@Before()
	public void before(Scenario scenario) 
 	{
		AdvertiserValidation.scenario = scenario;
	}

 	 @After
     public void afterScenario(Scenario scenario) throws Exception {
         mySoftAssert.assertAll();
     }
	
 	 
	public Advertiser_PF(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);	
	}
	
	
	public Boolean validateEventDirectly(String MatchID,String Event) throws Exception
	{	
		home = new HomePage_PF(driver);
		elementUtil = new ElementUtil();
		configFileReader =new ConfigFileReader();
	
		Boolean flag=false;
		try 
		{
	Thread.sleep(5000);
	List<LinkedHashMap<String, String>> allTableData = elementUtil.readEventTableDataInListOfMap(driver, "//table[@class='table table-striped w-75']//thead//tr//th");
    mySoftAssert.assertNotEquals(allTableData.size(),0,"No Status is initiated for this match"); 		
	if(allTableData!=null && allTableData.size()!=0 && allTableData.toString().contains(Event))
		{
		for(int i=0;i<allTableData.size() ;i++)
			{
			if(allTableData.get(i).get("Event Name").equals(Event))
			{
				System.out.println(Event + " from user " +allTableData.get(i).get("Who"));
				System.out.println(" At : "+allTableData.get(i).get("When")+"\n");
				flag=true;
				break;
			}
			}
        Thread.sleep(3000);		
		}
	System.out.println(driver.findElement(By.className("tab-content")).getText());	
		return flag;

		}
		catch(Exception ex)
		{				
			System.out.println(ex.getLocalizedMessage());
			throw(ex);
		}
	}
	public Boolean validateEvent(String MatchID,String Event) throws Exception
	{Boolean flag=false;
		try 
		{
			home = new HomePage_PF(driver);
			elementUtil = new ElementUtil();
			configFileReader =new ConfigFileReader();
	  		List<WebElement> Matchs  =  home.getallMatch();
	  			String beforeWindow=driver.getWindowHandle();
	  			WebElement Match= home.getMatch(MatchID);
	  			if(Match.isDisplayed())
	  			{
	  			System.out.println("Match "+MatchID+" Found in the List ");
	  			Actions action =new Actions(driver);
	  			action.moveToElement(Match);
	  			action.click().build().perform();
	  			Set<String> windows = driver.getWindowHandles();
	  			for (String windowHandle : driver.getWindowHandles()) 
	  			{
	  			    if(!windowHandle.contentEquals(beforeWindow)) 
	  			    {
	  			        driver.switchTo().window(windowHandle);
	  			        break;
	  			    }
	  			}
	  			Thread.sleep(5000);
		    	List<LinkedHashMap<String, String>> allTableData = elementUtil.readEventTableDataInListOfMap(driver, "//table[@class='table table-striped w-75']//thead//tr//th");
		        mySoftAssert.assertNotEquals(allTableData.size(),0,"No Status is initiated for this match"); 		
				if(allTableData!=null && allTableData.size()!=0 && allTableData.toString().contains(Event))
					{
					for(int i=0;i<allTableData.size() ;i++)
						{
						if(allTableData.get(i).get("Event Name").equals(Event))
						{
							System.out.println(Event + " from user " +allTableData.get(i).get("Who"));
							driver.close();
							driver.switchTo().window(beforeWindow);
							System.out.println(" At : "+allTableData.get(i).get("When")+"\n");
							flag=true;
							break;
						}
						}
			        Thread.sleep(3000);		
					}
				System.out.println(driver.findElement(By.className("tab-content")).getText());	
			
	  			if(driver.getWindowHandles().size()>1)
	  			{
	  				driver.close();
	  				driver.switchTo().window(beforeWindow);
	  			}
	  			}
	  			return flag;
	  		
		//	String value=configFileReader.getApplicationUrl(configFileReader.getEnvironment().toString().toLowerCase())+"/scorecard/"+MatchID;
	    //	driver.get(value);

	    //	driver.findElement(By.xpath("//button[text()='Events']")).click();
	    	}
		catch(Exception ex)
		{				
			System.out.println(ex.getLocalizedMessage());
			throw(ex);
		}
	}

	public Boolean verifyCommentsinCommetaryTab() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public Boolean VerifyOverTable() {
		// TODO Auto-generated method stub
		return null;
	}

	public void validateBatterTable2() {
		// TODO Auto-generated method stub
		
	}

	public String[] validateBatterTable(String string, String string2) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	public void switchTab(String tabName) 
	{
		// TODO Auto-generated method stub
		
	}

	public void AddAdCreative(String CreativeMode,String creativeType,String Url) throws Exception 
	{
		try {
			Thread.sleep(5000);

		btnNewAdCreative.click();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");  
		   LocalDateTime now = LocalDateTime.now();  
		   System.out.println(dtf.format(now));
		   String name="Automation Ad Creative "+dtf.format(now);
		   txtAdCreativeName.sendKeys("Automation Ad Creative "+dtf.format(now));
		   txtDescAdCreative.sendKeys("Ad Creative");
		   dropdownAdList.sendKeys("Automation Advertiser20240712152547 Updated");
		   dropdownAdList.sendKeys(Keys.ARROW_DOWN);
		   dropdownAdList.sendKeys(Keys.ENTER);
		  
			Thread.sleep(3000);
		//	Actions action =new Actions(driver);
  		//	action.moveToElement(selectAdSource);
			//	action.click().build().perform();
		if(CreativeMode.toLowerCase().equals("adsource"))
		{
			btnAdSource.click();
			txtTrackerName.sendKeys(Keys.DOWN);
			txtAdSourceType.click();
			listAdSource.click();
			driver.findElement(By.xpath("//span[contains(.,'"+ creativeType +"')]")).click();
			Thread.sleep(3000);
		}
		else if (CreativeMode.toLowerCase().equals("upload"))
		{
			btnUploadRadio.click();
			txtTrackerName.sendKeys(Keys.DOWN);
			txtAdSourceType.click();
			switch(creativeType.toString().toLowerCase())
			{
			case "image" :
				ImageUpload(Url);
		        break;

			case "video" :
				VideoUpload(Url);
				break;

			case "html5" : 
				Html5Upload(Url);
		        break;

			case "zip" :
				ZipUpload(Url);
				break;
			}
		}
		else if (CreativeMode.toLowerCase().equals("creativeurl"))
		{
			btnCreativeURLRadio.click();
			txtTrackerName.sendKeys(Keys.DOWN);
			txtAdSourceType.click();
			switch(creativeType.toString().toLowerCase())
			{
			case "image" :
				ImageUploadinCreativeURL(Url);
		        break;

			case "video" :
				VideoUploadinCreativeURL(Url);
				break;

			case "vast" : 
			{
				listAdTypeVast.click();
				txtCreativeURL.sendKeys(Url);
		        break;
			}
			}
		}
				AddTracker("0%");
				Thread.sleep(5000);

				AddTracker("25%");
				Thread.sleep(5000);

				AddTracker("50%");
				Thread.sleep(5000);

				AddTracker("75%");
				Thread.sleep(5000);

				AddTrackerClick("100%");
				Thread.sleep(5000);

				AddTrackerClick("Click");
				Thread.sleep(5000);

				Actions action =new Actions(driver);
	  			action.moveToElement(btnAdCreative);
				action.click().build().perform();
	
			//btnAdCreative.sendKeys(Keys.DOWN);
			//btnAdCreative.click();
			@SuppressWarnings("deprecation")
			WebDriverWait wait = new WebDriverWait(driver,30);
			wait.until(ExpectedConditions.visibilityOf(alertMsg));
		System.out.println("alertMsg "+alertMsg.getText());
		AdvertiserValidation.scenario.log("Alert Text Found : "+alertMsg.getText());
//		AdvertiserValidation.scenario.log("Search of Advertiser");
	//	btnSearch.sendKeys(name);
	//	Thread.sleep(3000);

	//	driver.findElement(By.xpath("//p[contains(.,'"+name+"')]")).click();
		
	//	AdvertiserValidation.scenario.log("Edit of Advertiser");
	//	Thread.sleep(3000);

	//	dotButton.click();
	//	btnEditAdCreative.click();
		
		}
		catch(Exception ex)
		{
			throw ex;
		}
	}
	public void ImageUploadinCreativeURL(String Url) throws InterruptedException, IOException
	{
		try {
			listAdTypeImage.click();
			Thread.sleep(5000);   
			btnAdMedia.click();
			txtCreativeURL2.sendKeys(Url);
			btnImageText.sendKeys("Image Upload");
			btnDisplayUrl.sendKeys("Testing Image");
			Thread.sleep(5000);			
			btnAddMedia.click();
		}
			catch(Exception ex)
			{
				throw ex;
			}
		}
	public void VideoUploadinCreativeURL(String Url) throws InterruptedException, IOException
	{
		try {
			listAdTypeVideo.click();
			Thread.sleep(5000);   
			btnAdMedia.click();
			Thread.sleep(5000);
			txtCreativeURL2.sendKeys(Url);
			btnDisplayUrl.sendKeys("Testing Video");
			System.out.println("File Uploaded Successfully");   
			btnAddMedia.click();
		}
			catch(Exception ex)
			{
				throw ex;
			}
		}
	public void ImageUpload(String Url) throws InterruptedException, IOException
	{
		try {
		listAdTypeImage.click();
		Thread.sleep(5000);   
		String beforeWindow=driver.getWindowHandle();
		btnAdMedia.click();
		btnChoose.click();
		JavascriptExecutor executor = (JavascriptExecutor)driver;    
		Thread.sleep(3000);   
		Runtime.getRuntime().exec("C:\\Users\\Admin\\Desktop\\1.exe"+" "+ Url);
		System.out.println("File Uploaded...");
		Thread.sleep(15000);
		Set<String> windows = driver.getWindowHandles();
		for (String windowHandle : driver.getWindowHandles()) 
		{
		    if(!windowHandle.contentEquals(beforeWindow)) 
		    {
		        driver.switchTo().window(windowHandle);
		        break;
		    }
		}
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", btnImageText);
		
	
		btnImageText.sendKeys("Image Upload");
		
		btnDisplayUrl.sendKeys("Testing Image");
		Thread.sleep(5000);
		//btnDisplayUrl.sendKeys(Keys.ENTER);
		if(driver.getWindowHandles().size()>1)
		{
			driver.close();
			driver.switchTo().window(beforeWindow);
		}

		System.out.println("File Uploaded Successfully");   
		btnAddMedia.click();

		}
		catch(Exception ex)
		{
			throw ex;
		}
		
	}
	
	public void VideoUpload(String Url) throws InterruptedException, IOException
	{
		try 
		{
		listAdTypeVideo.click();
		Thread.sleep(5000);   
		String beforeWindow=driver.getWindowHandle();
		btnAdMedia.click();
		btnChoose.click();
		Thread.sleep(3000);   
		Runtime.getRuntime().exec("C:\\Users\\Admin\\Desktop\\1.exe"+" "+ Url);
		System.out.println("File Uploaded...");
		Thread.sleep(30000);
		Set<String> windows = driver.getWindowHandles();
		for (String windowHandle : driver.getWindowHandles()) 
		{
		    if(!windowHandle.contentEquals(beforeWindow)) 
		    {
		        driver.switchTo().window(windowHandle);
		        break;
		    }
		}
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", btnDisplayUrl);
		
		btnDisplayUrl.sendKeys("Testing Video");
		Thread.sleep(5000);

		if(driver.getWindowHandles().size()>1)
		{
			driver.close();
			driver.switchTo().window(beforeWindow);
		}

		System.out.println("File Uploaded Successfully");   
		btnAddMedia.click();
		}
		catch(Exception ex)
		{
			throw ex;
		}
		
	}
	
	public void Html5Upload(String Url) throws InterruptedException, IOException
	{
		try {
			
		listAdTypeHtml5.click();
		Thread.sleep(5000);   
		String beforeWindow=driver.getWindowHandle();

		btnAdMedia.click();
		txtHtml5.sendKeys("<html><\\html>");
		txtHeight.sendKeys("10");
		txtWidth.sendKeys("10");
		
	

		System.out.println("File Uploaded Successfully");   
		btnAddMedia.click();

		}
		catch(Exception ex)
		{
			throw ex;
		}	
	}
	
	public void ZipUpload(String Url) throws InterruptedException, IOException
	{
		
		try
		{
		listAdTypeZip.click();
		Thread.sleep(5000);   
		String beforeWindow=driver.getWindowHandle();

		btnAdMedia.click();
		btnChoose.click();
		JavascriptExecutor executor = (JavascriptExecutor)driver;    
		Thread.sleep(3000);   
		Runtime.getRuntime().exec("C:\\Users\\Admin\\Desktop\\1.exe"+" "+ Url);
		System.out.println("File Uploaded...");
		Thread.sleep(15000);
		Set<String> windows = driver.getWindowHandles();
		for (String windowHandle : driver.getWindowHandles()) 
		{
		    if(!windowHandle.contentEquals(beforeWindow)) 
		    {
		        driver.switchTo().window(windowHandle);
		        break;
		    }
		}
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", txtWidth);
		
		txtHeight.sendKeys("10");
		txtWidth.sendKeys("10");
		
		if(driver.getWindowHandles().size()>1)
		{
			driver.close();
			driver.switchTo().window(beforeWindow);
		}

		System.out.println("File Uploaded Successfully");   
		btnAddMedia.click();

		}
		catch(Exception ex)
		{
			throw ex;
		}
	}
	
	public void AllButtonValidation() throws Exception 
	{
		try 
		
		{
			Thread.sleep(2000);

			buttonAll.click();
			
			
			Thread.sleep(10000);
			
			AdvertiserValidation.scenario.log("Verify Name, Date Added and Status table is listed for all");
			 mySoftAssert.assertEquals("Ad Creative",txtName.getText());
			 AdvertiserValidation.scenario.log("Actual value : " +txtName.getText()+ ", Expected Value : " + "Ad Creative");
			 mySoftAssert.assertEquals("Date Added",txtDate.getText());
			 AdvertiserValidation.scenario.log("Actual value : " +txtDate.getText()+ ", Expected Value : " + "Date Added");
			 mySoftAssert.assertEquals("Status",txtStatus.getText());
			 AdvertiserValidation.scenario.log("Actual value : " +txtStatus.getText()+ ", Expected Value : " + "Status");
	
		}
		catch(Exception ex)
		{
			throw ex;
		}
	}
	public void ActiveButtonValidation() throws Exception 
	{
		try {

	buttonActive.click();
	Thread.sleep(5000);
	
	AdvertiserValidation.scenario.log("Verify Name, Date Added and Status table is listed for Active");
	 mySoftAssert.assertEquals("Ad Creative",txtName.getText());
	 AdvertiserValidation.scenario.log("Actual value : " +txtName.getText()+ ", Expected Value : " + "Ad Creative");
	 mySoftAssert.assertEquals("Date Added",txtDate.getText());
	 AdvertiserValidation.scenario.log("Actual value : " +txtDate.getText()+ ", Expected Value : " + "Date Added");
	 mySoftAssert.assertEquals("Status",txtStatus.getText());
	 AdvertiserValidation.scenario.log("Actual value : " +txtStatus.getText()+ ", Expected Value : " + "Status");
		}
		catch(Exception ex)
		{
			throw ex;
		}
	}
	
	public void InActiveButtonValidation() throws Exception 
	{
		try {

	Thread.sleep(5000);

	buttonInActive.click();
	AdvertiserValidation.scenario.log("Verify Name, Date Added and Status table is listed for Active");
	 mySoftAssert.assertEquals("Ad Creative",txtName.getText());
	 AdvertiserValidation.scenario.log("Actual value : " +txtName.getText()+ ", Expected Value : " + "Ad Creative");
	 mySoftAssert.assertEquals("Date Added",txtDate.getText());
	 AdvertiserValidation.scenario.log("Actual value : " +txtDate.getText()+ ", Expected Value : " + "Date Added");
	 mySoftAssert.assertEquals("Status",txtStatus.getText());
	 AdvertiserValidation.scenario.log("Actual value : " +txtStatus.getText()+ ", Expected Value : " + "Status");

		}
		catch(Exception ex)
		{
			throw ex;
		}
	}
	public void AddAdCreativeErrorValidation() throws Exception 
	{
		try {
			Thread.sleep(5000);
			

			btnNewAdCreative.click();
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");  
		   LocalDateTime now = LocalDateTime.now();  
		   System.out.println(dtf.format(now));
		
		   String name="Automation Ad Creative "+dtf.format(now);
		   dropdownAdList.sendKeys("Automation Advertiser20240712152547 Updated");
		   dropdownAdList.sendKeys(Keys.ARROW_DOWN);
		   dropdownAdList.sendKeys(Keys.ENTER);
		  
			Thread.sleep(3000);
		
		   txtAdCreativeName.sendKeys("1");
		   txtAdCreativeName.clear();
		   txtDescAdCreative.sendKeys("Ad Creative");
		   for(int i=0;i<alertText.size();i++)
			{
				if(!alertText.get(i).getText().toString().equals(""))
				{
				System.out.println(alertText.get(i).getText().toString());
				AdvertiserValidation.scenario.log("Error Validation found on Ad Creative Name : " +alertText.get(i).getText().toString());
				}
			}
		   AdvertiserValidation.scenario.log("Verify on Cancel Button in Add Ad Creative ..." );
			
		   btnCancel.click();
		   btnNewAdCreative.click();
		   
		   txtAdCreativeName.sendKeys("Automation Ad Creative "+dtf.format(now));
		   txtDescAdCreative.sendKeys("Ad Creative");
			AdvertiserValidation.scenario.log("Verify Add button is disabled before adding Advertiser and Creative Types");
			 mySoftAssert.assertEquals(Boolean.FALSE,driver.findElement(By.xpath("//button[text()='Add']")).isEnabled());
			 AdvertiserValidation.scenario.log("Actual value" +driver.findElement(By.xpath("//button[text()='Add']")).isEnabled()+ ", Expected Value " + Boolean.FALSE );
			  
			btnAdSource.click();
			txtTrackerName.sendKeys(Keys.DOWN);
			txtAdSourceType.click();
			listAdSource.click();
			Thread.sleep(3000);
	
			AdvertiserValidation.scenario.log("Verify Add button is Enabled After adding Advertiser and Creative Types");
			mySoftAssert.assertEquals(Boolean.TRUE,driver.findElement(By.xpath("//button[text()='Add']")).isEnabled());
			AdvertiserValidation.scenario.log("Actual value" +driver.findElement(By.xpath("//button[text()='Add']")).isEnabled()+ ", Expected Value " + Boolean.TRUE );
			
				AddTracker("0%");
				Thread.sleep(3000);

				AddTracker("25%");
				Thread.sleep(3000);

				AddTracker("50%");
				Thread.sleep(3000);

				AddTracker("75%");
				Thread.sleep(3000);

				AddTrackerClick("100%");
				Thread.sleep(5000);

				AddTrackerClick("Click");
				Thread.sleep(5000);

					Actions action =new Actions(driver);
		  			action.moveToElement(btnAdCreative);
					action.click().build().perform();
			//btnAdCreative.sendKeys(Keys.DOWN);
			//btnAdCreative.click();
					@SuppressWarnings("deprecation")
					WebDriverWait wait = new WebDriverWait(driver,30);
					wait.until(ExpectedConditions.visibilityOf(alertMsg));		System.out.println("alertMsg "+alertMsg.getText());
		AdvertiserValidation.scenario.log("Alert Text Found : "+alertMsg.getText());
		AdvertiserValidation.scenario.log("Search of Advertiser");
		btnSearch.sendKeys(name);
		Thread.sleep(3000);

		driver.findElement(By.xpath("//p[contains(.,'"+name+"')]")).click();
		
		AdvertiserValidation.scenario.log("Edit of Ad Creatives");
		dotButton.click();
		btnEditAdCreative.click();
		txtAdCreativeName.sendKeys(" Updated");
		btnCancel.click();
		Thread.sleep(3000);

		dotButton.click();
		btnEditAdCreative.click();
		txtAdCreativeName.sendKeys(" Updated");
		
		btnUpdate.click();
		AdvertiserValidation.scenario.log("Alert Text Found for Update: "+alertMsg.getText());

		Thread.sleep(10000);
		AdvertiserValidation.scenario.log("Delete of Ad Creatives");
		
		dotButton.click();
		btnDelete.click();
		btnDeleteConfirm.click();
		Thread.sleep(3000);

		AdvertiserValidation.scenario.log("Alert Text Found for Delete: "+alertMsg.getText());

		}
		catch(Exception ex)
		{
			throw ex;
		}
	}
	public void AddTracker(String trackerType) throws InterruptedException
	{
		try {
			Thread.sleep(3000);
			WebDriverWait wait = new WebDriverWait(driver,30);
			wait.until(ExpectedConditions.visibilityOf(txtTrackerName));
	
		txtTrackerName.sendKeys(trackerType +" Tracker ");
		txtTrackerName.sendKeys(Keys.TAB,Keys.ENTER,trackerType,Keys.ENTER);
		Thread.sleep(3000);

		//txtTrackerType.click();
		//txtTrackerType.sendKeys(trackerType,Keys.ENTER);
		/*	List<WebElement> options = driver.findElements(By.tagName("li"));
			for (WebElement option : options)
			{
			    if (option.getText().equals(trackerType))
			    {
			        option.click(); // click the desired option
			        break;
			    }
			}
			*/
		
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", txtTrackerUrl);
			
		txtTrackerUrl.sendKeys("http://123.com");
		btnAddTracket.click();
		}
		catch(Exception ex)
		{
			throw ex;
		}
	}
	public void AddTrackerClick(String trackerType) throws InterruptedException
	{
		try {
			WebDriverWait wait = new WebDriverWait(driver,30);
			wait.until(ExpectedConditions.visibilityOf(txtTrackerName));
			
		txtTrackerName.sendKeys("Tracker");
		txtTrackerName.sendKeys(Keys.TAB,Keys.ENTER,trackerType,Keys.ENTER);
		
		//txtTrackerType.click();
		/*	List<WebElement> options = dropdownTrackers.findElements(By.tagName("li"));
			for (WebElement option : options)
			{
			    if (option.getText().equals(trackerType))
			    {
			        option.click(); // click the desired option
			        break;
			    }
			}*/
		txtTrackerUrl.sendKeys("123.com");
		btnAddTracket.click();
		}
		catch(Exception ex)
		{
			throw ex;
		}
	}
	public void AddAdv() throws InterruptedException 
	{
		btnNewAdv.click();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");  
		   LocalDateTime now = LocalDateTime.now();  
		   System.out.println(dtf.format(now));
		   String name="Automation Advertiser"+dtf.format(now);
		txtAdvName.sendKeys("Automation Advertiser"+dtf.format(now));
		txtPhn.sendKeys("1234567890");
		txtEmail.sendKeys("abc@mail.com");;
		txtDesc.sendKeys("Automation Testing-Selenium Cucumber");
		Thread.sleep(3000);
		
		btnAdd.click();
		System.out.println("alertMsg "+alertMsg.getText());
		AdvertiserValidation.scenario.log("Alert Text Found : "+alertMsg.getText());
		AdvertiserValidation.scenario.log("Search of Advertiser");
		
		driver.findElement(By.xpath("//p[contains(.,'"+name+"')]")).click();
		
		AdvertiserValidation.scenario.log("Edit of Advertiser");
		dotButton.click();
		btnEdit.click();
		Thread.sleep(3000);

		txtAdvName.sendKeys(" Updated");
		//txtDesc.sendKeys("Updated");
		btnUpdate.click();
		AdvertiserValidation.scenario.log("Alert Text Found : "+alertMsg.getText());
		AdvertiserValidation.scenario.log("Delete of Advertiser");
		
		dotButton.click();
		btnDelete.click();
		btnDeleteConfirm.click();
		Thread.sleep(3000);
		AdvertiserValidation.scenario.log("Delete Alert Text Found : "+alertMsg.getText());
		
	}
	
	public void AddAdvWithInvalidData() throws InterruptedException 
	{
		btnNewAdv.click();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");  
		   LocalDateTime now = LocalDateTime.now();  
		   System.out.println(dtf.format(now));
		   String name="Automation Advertiser"+dtf.format(now);
		Thread.sleep(5000);
		txtAdvName.sendKeys("Automation Advertiser"+dtf.format(now));
		txtPhn.sendKeys("123456");
		for(int i=0;i<alertText.size();i++)
		{
			if(!alertText.get(i).getText().toString().equals(""))
			{
			System.out.println(alertText.get(i).getText().toString());
			AdvertiserValidation.scenario.log("Error Validation found" +alertText.get(i).getText().toString());
			}
			}
		txtPhn.sendKeys("7890");
		
		txtEmail.sendKeys("abc@mail");
		for(int i=0;i<alertText.size();i++)
		{
			if(!alertText.get(i).getText().toString().equals(""))
			{
			System.out.println(alertText.get(i).getText().toString());
			AdvertiserValidation.scenario.log("Error Validation found"+alertText.get(i).getText().toString());
			}
			}
		txtEmail.sendKeys(".com");
		txtDesc.sendKeys("Automation Testing-Selenium Cucumber");
		AdvertiserValidation.scenario.log("Desc Value added : " +txtDesc.getText());
		Thread.sleep(3000);
		btnCancel.click();
	}
	
}	