package driverManager;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Platform;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import enums.DriverType;
import enums.EnvironmentType;

public class WebDriverManager {

		public static WebDriver driver;
		private static DriverType driverType;
		protected static EnvironmentType environmentType;
		private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";
		private static final String FIREFOX_DRIVER_PROPERTY = "webdriver.gecko.driver";

		
		public WebDriverManager() {
			driverType = FileReaderManager.getInstance().getConfigReader().getBrowser();
			environmentType = FileReaderManager.getInstance().getConfigReader().getEnvironment();
		}

		public WebDriver getDriver() throws MalformedURLException {
			if(driver == null) driver = createDriver();
			return driver;
		}

		private WebDriver createDriver() throws MalformedURLException {
			   switch (environmentType) {	    
		        case LOCAL : driver = createLocalDriver();
		        	break;
		        case REMOTE : driver = createRemoteDriver();
		        	break;
		        case QA : driver = createLocalDriver();
	        	    break;
		        case RACK : driver = createLocalDriver();
		        	break;
			   }
			   return driver;
		}

		private WebDriver createRemoteDriver() {
			throw new RuntimeException("RemoteWebDriver is not yet implemented");
		}

		private WebDriver createLocalDriver() throws MalformedURLException {
	        switch (driverType) {	    
	        case FIREFOX : 
	        	//System.setProperty("webdriver.firefox.marionette",FileReaderManager.getInstance().getConfigReader().getFirefoxDriverPath());
	        	// DesiredCapabilities capabilities = DesiredCapabilities.firefox();  
	            // capabilities.setCapability("marionette",true);  
	            // WebDriver driver= new FirefoxDriver(capabilities); 
	        	//FirefoxOptions options = new FirefoxOptions();
	        	//options.setLegacy(true);

	        	//driver = new FirefoxDriver();	
	        	//driver.get("http://google.com");
	        	 driver = new SafariDriver();
	        	break;
		    	/*
	        	driver = WebDriver.Firefox();
	        	FirefoxProfile firefoxProfile = new FirefoxProfile();
	        	File extension = new File("extension.xpi");
	        	firefoxProfile.addExtension(extension);

	        	DesiredCapabilities capabilities = DesiredCapabilities.firefox();
	        	//capabilities=DesiredCapabilities.firefox();
	        	 capabilities.setBrowserName("firefox");
	        	driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
	        */
	        	case CHROME : 
	        	//System.setProperty(CHROME_DRIVER_PROPERTY,
	            //         "C:\\Users\\Administrator\\Desktop\\CucumberJava\\src\\test\\resources\\drivers\\chrome_driverPath.exe");    
	        	System.setProperty(CHROME_DRIVER_PROPERTY, FileReaderManager.getInstance().getConfigReader().getChromeDriverPath());
	        	System.setProperty("webdriver.http.factory", "jdk-http-client");
	    		ChromeOptions options = new ChromeOptions();
 
	        	//ChromeOptions chromeOptions = new ChromeOptions();
	        	ChromeOptions handlingSSL = new ChromeOptions();

	    		//Using the accept insecure cert method with true as parameter to accept the untrusted certificate
	        //	options.setAcceptInsecureCerts(true);
	    				
	    		//Creating instance of Chrome driver by passing reference of ChromeOptions object
	    		//WebDriver driver = new ChromeDriver(handlingSSL);
	    	
	        	options.addArguments("--remote-allow-origins=*");
	        	 //ChromeDriver driver = new ChromeDriver(chromeOptions);
	    		//options.addArguments("force-device-scale-factor=0.75");
	    		//options.addArguments("high-dpi-support=0.75");
	    		//WebDriver driver = new ChromeDriver(options);

	        	//driver = new ChromeDriver(handlingSSL);
	        	driver = new ChromeDriver(options);
	        	Dimension size = driver.manage().window().getSize();
		    	int height = size.getHeight();
		    	int width = size.getWidth();
		    	System.out.println("Height : "+height+ "Width : "+ width);
		    	//driver.manage().window().setSize(new Dimension(1000,800));
		    	driver.manage().window().setPosition(new Point(0,0));
		    	driver.manage().window().maximize();
		    	break;
	        case INTERNETEXPLORER : driver = new InternetExplorerDriver();
	    		break;
	        case BRAVE : 
	        	 System.setProperty("webdriver.chrome.driver",  FileReaderManager.getInstance().getConfigReader().getChromeDriverPath());
	        	 
	        	    //Initializing ChromeOptions Object
	        	    ChromeOptions options2 = new ChromeOptions();
	        	 
	        	    //Setting Binary Path of Brave Browser in options object.
	        	    options2.setBinary("C:\\Program Files\\BraveSoftware\\Brave-Browser\\Application\\brave.exe");
	        	 
	        	    //Initializing Chrome Browser Instance
	        	    WebDriver driver2 = new ChromeDriver(options2);
	        	 break;
	        }

	        if(FileReaderManager.getInstance().getConfigReader().getBrowserWindowSize()) 
	        	//driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(FileReaderManager.getInstance().getConfigReader().getImplicitlyWait(), TimeUnit.SECONDS);
			return driver;
		}	

		public static void closeDriver() {
			driver.close();
			driver.quit();
		}

	
}
