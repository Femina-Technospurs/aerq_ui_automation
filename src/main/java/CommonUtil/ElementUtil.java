package CommonUtil;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import dataProviders.ConfigFileReader;

public class ElementUtil {
	ConfigFileReader configFileReader;
	
	public void pageLoad(WebDriver driver)
	{
	JavascriptExecutor j = (JavascriptExecutor) driver;
    j.executeScript("return document.readyState").toString().equals("complete");
    
	}
	public void driverWait(WebDriver driver)
	{
		configFileReader =new ConfigFileReader();	
		
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public void driverWait3Sec(WebDriver driver)
	{
		configFileReader =new ConfigFileReader();	
		
	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}
	
	public List readTableData(WebDriver driver,String Day) 
	{
		int ScheduleDay;
		List<LinkedHashMap<String, String>> allTableData = new ArrayList<LinkedHashMap<String, String>>();
		if(Day.toLowerCase().equals("saturday"))
				ScheduleDay=1;
		else
				ScheduleDay= 2;
	
		try
		{
		List<WebElement> allHeadersEle = driver.findElements(By.xpath("(//*[@id=\"Table3\"])["+ScheduleDay+"]/thead/tr/th"));
		List<String> allHeaderNames = new ArrayList<String>();
		for (WebElement header : allHeadersEle) 
		{
			String headerName = header.getText();
			if(!allHeaderNames.contains(headerName))
			allHeaderNames.add(headerName);	
			//System.out.println("\nHeader name"+headerName );
		}
		
		System.out.println(allHeaderNames);
		String rowLoc = "(//*[@id=\"Table3\"])["+ScheduleDay+"]/tbody/tr";
		List<WebElement> allRowsEle = driver.findElements(By.xpath(rowLoc));
		System.out.println("Row Size "+allRowsEle.size());
		for (int i = 0; i <= allRowsEle.size(); i++) 
		{
			/*List<WebElement> header=driver.findElements(By.xpath("//*[@id=\"Table3\"]/thead/tr[" + i + "]/th/h4"));
			//if(header.size()>=1)
			//*[@id="Table3"]/tbody/tr[1]/td/h4
			System.out.println("\nif :" +header.size());
			if(header.size()!=0 &&  header.get(0).getText().equals("Sunday Games"))
				
				{
				i=allRowsEle.size();
				break;	
				}
				//*[@id="Table3"]/tbody/tr[1]/td/h4
			*/
			//*[@id="Table3"]/tbody/tr[1]/td[3]
			String specificRowLoc = "//*[@id=\"Table3\"])[1]/tbody/tr[" + i + "]";
			List<WebElement> allColumnsEle = driver.findElements(By.xpath("(//*[@id=\"Table3\"])["+ScheduleDay+"]/tbody/tr[" + i + "]/td"));
			if(allColumnsEle.size()!=0)
			{
			System.out.println("\n td column size " +allColumnsEle.size());
			System.out.println("\n Header Size"+allHeaderNames.size());
			LinkedHashMap<String, String> eachRowData = new LinkedHashMap<>();
			for (int j = 0; j < allColumnsEle.size(); j++) 
			{
				String cellValue = allColumnsEle.get(j).getText();
				eachRowData.put(allHeaderNames.get(j), cellValue);
			//	System.out.println("Header" +allHeaderNames.get(j) +"\nValue"+ cellValue);
			}
			allTableData.add(eachRowData);
			System.out.println("\n Row Data"+eachRowData);
			}
			}
 		//System.out.println("\nFinal"+allTableData); 
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		return allTableData;
	}
	
	public List readTableDataInListOfMap(WebDriver driver,String headerLoc) {
		
		try
		{
		// Browser initialization
		
		// Let's get header first
		//String headerLoc = "//table[@class='tg']//tr//th";
		
		List<WebElement> allHeadersEle = driver.findElements(By.xpath(headerLoc));
		List<String> allHeaderNames = new ArrayList<String>();
		for (WebElement header : allHeadersEle) {
			String headerName = header.getText();
			allHeaderNames.add(headerName);	
		}
		System.out.println(allHeaderNames);
		// Each row will be a key value pair. So we will use LinkedHashMap so that order
		// can be retained.
		// All map will be added to a list.
		List<LinkedHashMap<String, String>> allTableData = new ArrayList<LinkedHashMap<String, String>>();
 
		// Get total rows count
		String rowLoc = "//*[@id='matchEventsTab']//tbody//tr";
		List<WebElement> allRowsEle = driver.findElements(By.xpath(rowLoc));
		// Starting from 2 as first row is header. Remember xpath index starts from 1
		for (int i = 1; i <= allRowsEle.size(); i++) 
		{
			// Getting specific row with each iteration//
			String specificRowLoc = "//*[@id='matchEventsTab']//tbody//tr[" + i + "]";
			// Locating only cells of specific row.
			List<WebElement> allColumnsEle = driver.findElements(By.xpath("//*[@id='matchEventsTab']//tbody//tr[" + i + "]//td"));
					
			// Creating a map to store key-value pair data. It will be created for each
			// iteration of row
			LinkedHashMap<String, String> eachRowData = new LinkedHashMap<>();
			// Iterating each cell
			for (int j = 0; j < allColumnsEle.size(); j++) 
			{
				// Getting cell value
				String cellValue = allColumnsEle.get(j).getText();
				// We will put in to map with header name and value with iteration
		 		// Get jth index value from allHeaderNames and jth cell value of row		
					for(int i1=0;i1<allTableData.size();i1++)
					{
					if(allTableData.get(i1).get("Event Name").equals("Innings Started") && cellValue.equals("Innings Started") )
					{
						cellValue = cellValue+ " Opp";
						break;
					}
					else if(allTableData.get(i1).get("Event Name").equals("Innings Completed") && cellValue.equals("Innings Completed"))
						{
							cellValue = cellValue+ " Opp";
							break;
						}
					else if(allTableData.get(i1).get("Event Name").equals("Playing XI Entered") && cellValue.equals("Playing XI Entered"))
					{
						cellValue = cellValue+ " Opp";
						break;
					}
					}
					eachRowData.put(allHeaderNames.get(j), cellValue);
				//	System.out.println("Row Data : "+eachRowData);
					
			}
			// After iterating row completely, add in to list.
			allTableData.add(eachRowData);
		}
 		//System.out.println(allTableData); 
 		return allTableData;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return null;
		}
	}
	
public List readEventTableDataInListOfMap(WebDriver driver,String headerLoc) {
		
		try
		{
		// Browser initialization
		
		// Let's get header first
		//String headerLoc = "//table[@class='tg']//tr//th";
		
		List<WebElement> allHeadersEle = driver.findElements(By.xpath(headerLoc));
		List<String> allHeaderNames = new ArrayList<String>();
		for (WebElement header : allHeadersEle) {
			String headerName = header.getText();
			allHeaderNames.add(headerName);	
		}
		System.out.println(allHeaderNames);
		// Each row will be a key value pair. So we will use LinkedHashMap so that order
		// can be retained.
		// All map will be added to a list.
		List<LinkedHashMap<String, String>> allTableData = new ArrayList<LinkedHashMap<String, String>>();
 
		// Get total rows count
		
		String rowLoc = "//table[@class='table table-striped w-75']//tbody//tr";
		List<WebElement> allRowsEle = driver.findElements(By.xpath(rowLoc));
		// Starting from 2 as first row is header. Remember xpath index starts from 1
		for (int i = 1; i <= allRowsEle.size(); i++) 
		{
			// Getting specific row with each iteration//
			String specificRowLoc = "//table[@class='table table-striped w-75']//tbody//tr[" + i + "]";
			// Locating only cells of specific row.
			List<WebElement> allColumnsEle = driver.findElements(By.xpath("//table[@class='table table-striped w-75']//tbody//tr[" + i + "]//td"));
					
			// Creating a map to store key-value pair data. It will be created for each
			// iteration of row
			LinkedHashMap<String, String> eachRowData = new LinkedHashMap<>();
			// Iterating each cell
			for (int j = 0; j < allColumnsEle.size(); j++) 
			{
				// Getting cell value
				String cellValue = allColumnsEle.get(j).getText();
				// We will put in to map with header name and value with iteration
		 		// Get jth index value from allHeaderNames and jth cell value of row		
					for(int i1=0;i1<allTableData.size();i1++)
					{
					if(allTableData.get(i1).get("Event Name").equals("Innings Started") && cellValue.equals("Innings Started") )
					{
						cellValue = cellValue+ " Opp";
						break;
					}
					else if(allTableData.get(i1).get("Event Name").equals("Innings Completed") && cellValue.equals("Innings Completed"))
						{
							cellValue = cellValue+ " Opp";
							break;
						}
					else if(allTableData.get(i1).get("Event Name").equals("Playing XI Entered") && cellValue.equals("Playing XI Entered"))
					{
						cellValue = cellValue+ " Opp";
						break;
					}
					}
					eachRowData.put(allHeaderNames.get(j), cellValue);
				//	System.out.println("Row Data : "+eachRowData);
					
			}
			// After iterating row completely, add in to list.
			allTableData.add(eachRowData);
		}
 		//System.out.println(allTableData); 
 		return allTableData;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return null;
		}
	}
	
	public void validateDropdown()
	{
	}
}
