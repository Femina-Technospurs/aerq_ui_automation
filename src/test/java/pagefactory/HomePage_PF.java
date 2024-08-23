package pagefactory;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
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

import com.google.common.base.Verify;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class HomePage_PF {
	
	String a =null;
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
	@FindBy(name="advertiser")
	WebElement lnk_Adv;
	
	@FindBy(xpath="//span[text()='ADVERTISERS']")
	WebElement lnk_Advertiserlist;
	
	@FindBy(xpath="//span[text()='AD CREATIVES']")
	WebElement lnk_AdCreativelist;
	//@FindBy(xpath = "//span[contains(.,'Ground Permits')]")
	@FindBy(xpath="//a[contains(@href, '/groundpermits')]")
	WebElement lnkGroundPermit;
	
	@FindBy(id="recordPermit")
	WebElement addGroundPermit;
	
	@FindBy(id="groundId")
	WebElement drpGround;
	
	@FindBy(id="permitTime")
	WebElement drpPermitTime;
	
	@FindBy(id="permitDates")
	WebElement txtPermitDates;
	
	@FindBy(xpath="//button[text()='Save and Done']")
	WebElement btnSave;
	
	@FindBy(xpath="//a[text()='Game Deadlines']")
	WebElement btnGameDeadline;
	@FindBy(xpath="//a[text()='CoRA Contacts']")
	WebElement btnCora;
	@FindBy(xpath="//a[text()='CoLA Contacts']")
	WebElement btnCola;
	@FindBy(xpath="//a[text()='DLS Calculator']")
	WebElement btnDLS;
	@FindBy(xpath="//button[text()='Close']")
	WebElement btnClose;

	@FindBy(xpath="//div[@class='alert alert-success p-1 mx-2']")
	WebElement txtSuccess;

	//List<WebElement>() 123 = 
	@FindBy(xpath="//div[@class='alert alert-danger p-1 mx-2 text-center']")
	WebElement txtFailure;
	
	@FindBy(xpath="//a[contains(text(),'Cancel')]")
	WebElement btnCancel;
	
	@FindBy(xpath="//div[@id='root']/nav/a/img")
	WebElement lnk_Home;
	
	@FindBy(xpath="//a[contains(text(),'Docs')]")
	WebElement lnk_Docs;
	
	@FindBy(className="accordion")
	List<WebElement> MatchListing;
	
	@FindBy(xpath="//a[contains(@href, '/scorecard/')]")
	List<WebElement> matchIDS;
	
	@FindBy(linkText="Go Live")
	WebElement lnk_GoLive;
	
	@FindBy(xpath="//a[contains(text(),'Committees')]")
	WebElement lnk_Committees;
	
	@FindBy(xpath="//span[contains(text(),'Forum')]")
	WebElement lnk_Forum;
	
	@FindBy(xpath="//summary[text(),'Logout')]")
	WebElement lnk_Logout;
	
	@FindBy(className="text-info")
	WebElement expandMatch;

	WebDriver driver;
	
	public HomePage_PF(WebDriver driver) 
	{
		this.driver = driver;
		//PageFactory.initElements(driver, LoginPage_PF.class);
		//PageFactory.initElements(driver, this);
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
		
	}
	
	public SchedulePage_PF ClickHomePage()
	{
		lnk_Home.click();
return new SchedulePage_PF(driver);		
	}
	
	public void ClickAdvertiser() throws InterruptedException
	{
		lnk_Adv.click();
		Thread.sleep(3000);
		lnk_Advertiserlist.click();		
	}
	
	public void ClickAdCreative() throws InterruptedException
	{
		lnk_Adv.click();
		Thread.sleep(3000);
		lnk_AdCreativelist.click();		
	}
	
	public void ClickAdvertiserlist() throws InterruptedException
	{
		//Thread.sleep(3000);
		lnk_Advertiserlist.click();
	}
	
	public void ClickDoc()
	{
		lnk_Docs.click();
	}
	public void ClickCommittees()
	{
		lnk_Committees.click();
	}
	public void ClickForum()
	{
		lnk_Forum.click();
	}
	public void Logout()
	{
		lnk_Logout.click();
	}
	
	public void ClickClose()
	{
		btnClose.click();
	}
	
	public void ClickExpandMatch(WebElement match)
	{
		WebElement element = match.findElement(By.className("text-info"));
		Actions actions = new Actions(driver); actions.moveToElement(element).click().build().perform();
				//match.findElement(By.className("text-primary")).click();
	}
	
	public void ClickExpandCompletedMatch(WebElement match)
	{
		System.out.println(match.getText());
		WebElement element = match.findElement(By.xpath(".//span[@class='text-info ml-1']"));
		System.out.println(element.getText());
		
		Actions actions = new Actions(driver); actions.moveToElement(element).click().build().perform();
		
		//match.findElement(By.className("text-primary")).click();
	}
	
	
	public boolean verifyGoLive(WebElement match)
	{
		boolean flag=null != null;
		if(match.findElements(By.linkText("Go Live")).size()>0)
		{
			System.out.println("no of golive *******************"+match.findElements(By.linkText("Go Live")).size());
			flag=true;
		}
		else flag=false;
		return flag;
	}
	
public void clickAnyLink(String linkValue) throws Exception
	{
	
		driver.findElement(By.xpath("//a[contains(text(),'"+linkValue+"')]")).click();
		Thread.sleep(2000);

	}
	
	public void clickAnyButton(String linkValue) throws Exception
	{
	
		driver.findElement(By.xpath("//a[contains(text(),'"+linkValue+"')]")).click();
		Thread.sleep(2000);

	}
	public Boolean VerifyButton(String linkValue) throws Exception
	{
		Thread.sleep(1000);

		 List elements = driver.findElements(By.xpath("//a[contains(text(),'"+linkValue+"')]"));
		
		 //driver.findElement(By.xpath("//a[contains(text(),'"+linkValue+"')]")).click();
		 if(elements.size()>0)
			 return true;
		 else
			 return  false;
	}
	public Boolean VerifyUpdateButton(String linkValue) throws Exception
	{
		Thread.sleep(1000);

		 List elements = driver.findElements(By.xpath("//span[contains(text(),'"+linkValue+"')]"));
		
		 //driver.findElement(By.xpath("//a[contains(text(),'"+linkValue+"')]")).click();
		 if(elements.size()>0)
			 return true;
		 else
			 return  false;
	}
	public void clickLinksFromHomepage() throws Exception
	{
	
	btnGameDeadline.click();
	Thread.sleep(1000);

	ClickClose();
	btnCora.click();
	Thread.sleep(1000);

	ClickClose();
	btnCola.click();
	Thread.sleep(1000);

	ClickClose();
	btnDLS.click();
	Thread.sleep(1000);

	ClickClose();

	}
	public void clickAnyLink(String linkValue,String linkValue2) throws Exception
	{
		driver.findElement(By.xpath("//a[contains(text(),'"+linkValue+"')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[contains(text(),'"+linkValue2+"')]")).click();
		Thread.sleep(2000);
	}
	public void clickGroundPermit()
	{
		lnkGroundPermit.click();
	}
	
	public void clickAddPermit()
	{
		addGroundPermit.click();
	}
	
	public void enterGroundPermit(String Match_Date,String Match_Time,String PermitTime,String Ground ) throws InterruptedException
	{
		Select dropdownGround=new Select(drpGround);	
		List<WebElement> DrpDwnList=dropdownGround.getOptions();
		dropdownGround.selectByVisibleText(Ground);
		Select dropdownPermitTime=new Select(drpPermitTime);	
		List<WebElement> DrpDwnListPT=dropdownPermitTime.getOptions();
		dropdownPermitTime.selectByVisibleText(PermitTime);
		txtPermitDates.sendKeys(Match_Date);
		Thread.sleep(1000);		
		btnSave.click();
		
		
	}
	public String validateAddGroundPermit()
	{
		try {
		String msg = null;
			WebDriverWait wait = new WebDriverWait(driver,10);
		// wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='alert alert-success p-1 mx-2']")));
		
		    Assert.assertEquals(true, txtSuccess.isDisplayed());
		    Verify.verify(true, "Error", txtSuccess.isDisplayed(), true);
			 msg = txtSuccess.getText();	
		// wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='alert alert-danger p-1 mx-2 text-center']")));
		 return msg;
		}
		catch(Exception e)
		{
			String msg = txtFailure.getText();
			return msg;
		}
		 
		//WebElement success = WebDriverWait(driver, 20).until(EC.element_to_be_clickable((By.xpath("//div[@class='alert alert-success p-1 mx-2']")));
		//		elem2 = WebDriverWait(driver, 20).until(EC.visibility_of_element_located((By.ID, "finish"))) #Find element by text
		//		print(elem2.text) #Display text
	}
	
	public void clickGoLive()
	{
		lnk_GoLive.click();
	}
	public WebElement getMatch(String MatchID)
	{
		return driver.findElement(By.linkText("["+MatchID+"]"));
	}
	public List<WebElement> getallMatch()
	{
		return driver.findElements(By.className("accordion-item"));
	}
	public List<WebElement> getMatchIDs()
	{
		return matchIDS;
	}
	
	public List<WebElement> getallMatchTable()
	{
		return driver.findElements(By.className("card"));
	}
	public void checkLogoutIsDisplayed() 
	{
		lnk_Logout.isDisplayed();
	}
	
}
