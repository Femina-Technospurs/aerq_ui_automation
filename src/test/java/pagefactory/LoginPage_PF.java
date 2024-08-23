package pagefactory;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class LoginPage_PF {
	
	
	@FindBy(xpath="//a[contains(text(),'Log In')]")
	WebElement link_login;
	
	@FindBy(name = "username")
	@CacheLookup
	WebElement txt_username;
	
	@FindBy(name = "password")
	WebElement txt_password;

	@FindBy(id = "submit")
	WebElement btn_submit;
	
	@FindBy(xpath="//div[@class='alert alert-warning p-1']")
	WebElement txtAlertMsg;
	
	@FindBy(xpath="//summary[text()='Logout']")
	WebElement lnk_Logout;
	
	@FindBy(xpath="//span[@class='text-danger']")
	WebElement txtError;
	
	
	@FindBy(how = How.ID, using = "name")
	WebElement abc;
	
	WebDriver driver;
	
	public LoginPage_PF(WebDriver driver) {
		this.driver = driver;
		//AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 30);
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
		
	}
	
	public void clickLogin()
	{
		link_login.click(); 
			
	}
	
	public String getError()
	{
		
		return txtError.getText();
			
	}
	
	public String getPasswordError()
	{
		
		return txtAlertMsg.getText();
			
	}
	public void clickLoginifavailable(String url)
	{
		if(driver.getCurrentUrl().equals(url))
		link_login.click(); 
			
	}
	public void enterUsername(String username) {
		
		txt_username.sendKeys(username);
	}
	
	public void enterPassword(String password) {
		txt_password.sendKeys(password);
	}
	
	public void clickOnSubmit() {
		btn_submit.click();
	}
	public void clickOnLogout() throws Exception
	{
		try 
		{
		Thread.sleep(2000);		
		//Actions action =new Actions(driver);
		//action.moveToElement(lnk_Logout);
		//action.click().build().perform();
		lnk_Logout.click();
		}
		catch(Exception ex)
		{
		throw(ex);	
		}
		}
	
	public String getAlertMsg()
	{
	return txtAlertMsg.getText();	
	}
}
