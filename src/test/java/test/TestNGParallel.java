package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import CommonUtil.ElementUtil;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;


public class TestNGParallel {
    @Test    
    public void executSessionOne()
    {	ElementUtil element;
            //First session of WebDriver
        System.setProperty("webdriver.chrome.driver","src//test//resources//drivers//chromedriver.exe");
        
      //  WebDriver driver = new ChromeDriver();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        //Goto guru99 site
        driver.get("http://ec2-52-66-252-73.ap-south-1.compute.amazonaws.com/");
        element = new ElementUtil();
        element.pageLoad(driver);

        //find user name text box and fill it
        driver.findElement(By.name("username")).sendKeys("21424@email.com");    
        driver.findElement(By.name("password")).sendKeys("Test@1234");   
        
        driver.findElement(By.name("submit")).click();    
        }
        
    @Test    
        public void executeSessionTwo(){
    	ElementUtil element;
            //Second session of WebDriver
        System.setProperty("webdriver.chrome.driver","src//test//resources//drivers//chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        //Goto guru99 site
            //Goto guru99 site
        driver.get("http://ec2-52-66-252-73.ap-south-1.compute.amazonaws.com/");
        //find user name text box and fill it
        element = new ElementUtil();
        element.pageLoad(driver);

        driver.findElement(By.name("username")).sendKeys("21424@email.com");  
        driver.findElement(By.name("password")).sendKeys("Test@1234");    
        driver.findElement(By.name("submit")).click();    
        }
}