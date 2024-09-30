package dataProviders;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import enums.DriverType;
import enums.EnvironmentType;

public class ConfigFileReader {	
	private Properties properties;
	private final String propertyFilePath= "src//test//resources//config//Configuration.properties";

	public ConfigFileReader(){
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}		
	}

	public String getChromeDriverPath(){
		String projectPath = System.getProperty("user.dir");
		
		String driverPath = projectPath + properties.getProperty("chrome_driverPath");
		if(driverPath!= null) return driverPath;
		else throw new RuntimeException("Driver Path not specified in the Configuration.properties file for the Key:chrome_driverPath");		
	}

	public String getFirefoxDriverPath(){
		String projectPath = System.getProperty("user.dir");
		
		String driverPath = projectPath + properties.getProperty("firefox_driverPath");
		if(driverPath!= null) return driverPath;
		else throw new RuntimeException("Driver Path not specified in the Configuration.properties file for the Key:driverPath");		
	}
	public String getFileUploadPath(){
		String projectPath = System.getProperty("user.dir");
		
		String filePath = projectPath + properties.getProperty("file_upload");
		if(filePath!= null) return filePath;
		else throw new RuntimeException("File Path not specified in the Configuration.properties file for the Key:file_upload");		
	}
	public long getImplicitlyWait() {		
		String implicitlyWait = properties.getProperty("implicitlyWait");
		if(implicitlyWait != null) {
			try{
				return Long.parseLong(implicitlyWait);
			}catch(NumberFormatException e) {
				throw new RuntimeException("Not able to parse value : " + implicitlyWait + " in to Long");
			}
		}
		return 30;		
	}

	public String getApplicationUrl(String env) {
		String url = null;
		if(env.equalsIgnoreCase("qa"))
		url = properties.getProperty("qa_url");
		else if(env.equalsIgnoreCase("int"))
		url = properties.getProperty("int_url");	
		if(url != null) return url;
		else throw new RuntimeException("Application Url not specified in the Configuration.properties file for the Key:url");	
	}

	public DriverType getBrowser() {
		String browserName = properties.getProperty("browser");
		if(browserName == null || browserName.equals("chrome")) return DriverType.CHROME;
		else if(browserName.equalsIgnoreCase("firefox")) return DriverType.FIREFOX;
		else if(browserName.equals("iexplorer")) return DriverType.INTERNETEXPLORER;
		else throw new RuntimeException("Browser Name Key value in Configuration.properties is not matched : " + browserName);
	}

	public EnvironmentType getEnvironment() {
		String environmentName = properties.getProperty("environment");
		if(environmentName == null || environmentName.equalsIgnoreCase("local")) return EnvironmentType.LOCAL;
		else if(environmentName.equals("remote")) return EnvironmentType.REMOTE;
		else if(environmentName.equals("qa")) return EnvironmentType.QA;
		else if(environmentName.equals("rack")) return EnvironmentType.RACK;
		else throw new RuntimeException("Environment Type Key value in Configuration.properties is not matched : " + environmentName);
	}

	public Boolean getBrowserWindowSize() {
		String windowSize = properties.getProperty("windowMaximize");
		if(windowSize != null) return Boolean.valueOf(windowSize);
		return true;
	}
	
	public String getHomeTeamUserName(String env)
	{
		String homeUserName = properties.getProperty(env+"_home_username");
		if(homeUserName != null) return homeUserName;
		else throw new RuntimeException("Home Team username not specified in the Configuration.properties file for the Key:qa_home_username");

	}
	
	public String getAwayTeamUserName(String env)
	{
		String awayUserName = properties.getProperty(env+"_away_username");
		if(awayUserName != null) return awayUserName;
		else throw new RuntimeException("Away Team username not specified in the Configuration.properties file for the Key:qa_away_username");

	}
	
	public String getUmpire1TeamUserName(String env)
	{
		String umpire1UserName = properties.getProperty(env+"_umpire1_username");
		if(umpire1UserName != null) return umpire1UserName;
		else throw new RuntimeException("Umpire Team 1 username not specified in the Configuration.properties file for the Key:qa_umpire1_username");

	}
	
	public String getUmpire2TeamUserName(String env)
	{
		String umpire2UserName = properties.getProperty(env+"_umpire2_username");
		if(umpire2UserName != null) return umpire2UserName;
		else throw new RuntimeException("Umpire Team 2 username not specified in the Configuration.properties file for the Key:qa_umpire2_username");

	}
	
	public String getAdminUserName(String env)
	{
		String adminUserName = properties.getProperty(env+"_admin_username");
		if(adminUserName != null) return adminUserName;
		else throw new RuntimeException("Admin Team username not specified in the Configuration.properties file for the Key:qa_admin_username");

	}
	

	public String getHomeTeamPassword(String env)
	{
		String homePassword = properties.getProperty(env+"_home_password");
		if(homePassword != null) return homePassword;
		else throw new RuntimeException("Home Team Password not specified in the Configuration.properties file for the Key:qa_home_password");

	}
	
	public String getAwayTeamPassword(String env)
	{
		String awayPassword = properties.getProperty(env+"_away_password");
		if(awayPassword != null) return awayPassword;
		else throw new RuntimeException("Away Team Password not specified in the Configuration.properties file for the Key:qa_away_password");

	}
	
	public String getUmpire1TeamPassword(String env)
	{
		String umpire1Password = properties.getProperty(env+"_umpire1_password");
		if(umpire1Password != null) return umpire1Password;
		else throw new RuntimeException("Umpire Team 1 Password not specified in the Configuration.properties file for the Key:qa_umpire1_password");

	}
	
	public String getUmpire2TeamPassword(String env)
	{
		String umpire2Password = properties.getProperty(env+"_umpire2_password");
		if(umpire2Password != null) return umpire2Password;
		else throw new RuntimeException("Umpire Team 2 Password not specified in the Configuration.properties file for the Key:qa_umpire2_password");

	}

	public String getAssignedUmpire1TeamUserName(String env)
	{
		String umpire1UserName = properties.getProperty(env+"_assign_ump1_username");
		if(umpire1UserName != null) return umpire1UserName;
		else throw new RuntimeException("Assigned Umpire Team 1 username not specified in the Configuration.properties file for the Key:qa_umpire1_username");

	}
	
	public String getAssignedUmpire2TeamUserName(String env)
	{
		String umpire2UserName = properties.getProperty(env+"_assign_ump2_username");
		if(umpire2UserName != null) return umpire2UserName;
		else throw new RuntimeException("Assigned Umpire Team 2 username not specified in the Configuration.properties file for the Key:qa_umpire2_username");

	}

	public String getAssignedUmpire1TeamPassword(String env)
	{
		String umpire1Password = properties.getProperty(env+"_assign_ump1_password");
		if(umpire1Password != null) return umpire1Password;
		else throw new RuntimeException("Assigned Umpire Team 1 Password not specified in the Configuration.properties file for the Key:qa_umpire1_password");

	}
	
	public String getAssignedUmpire2TeamPassword(String env)
	{
		String umpire2Password = properties.getProperty(env+"_assign_ump2_password");
		if(umpire2Password != null) return umpire2Password;
		else throw new RuntimeException("Assigned Umpire Team 2 Password not specified in the Configuration.properties file for the Key:qa_umpire2_password");

	}

	
	public String getAdminPassword(String env)
	{
		String adminPassword = properties.getProperty(env+"_admin_password");
		if(adminPassword!= null) return adminPassword;
		else throw new RuntimeException("Admin Team Password not specified in the Configuration.properties file for the Key:qa_admin_password");

	}
	public String getRackPassword()
	{
		String rackPassword = properties.getProperty("rack_user_password");
		if(rackPassword!= null) return rackPassword;
		else throw new RuntimeException("Rack user password not specified in the Configuration.properties file for the Key:qa_admin_password");

	}
	
	public String getUserName_webadmin()
	{
		String rackPassword = properties.getProperty("webadmin");
		if(rackPassword!= null) return rackPassword;
		else throw new RuntimeException("Rack user password not specified in the Configuration.properties file for the Key:qa_admin_password");

	}

	public String getUserName_admin()
	{
		String rackPassword = properties.getProperty("admin");
		if(rackPassword!= null) return rackPassword;
		else throw new RuntimeException("Rack user password not specified in the Configuration.properties file for the Key:qa_admin_password");

	}
	public String getUserName_cora()
	{
		String rackPassword = properties.getProperty("cora");
		if(rackPassword!= null) return rackPassword;
		else throw new RuntimeException("Rack user password not specified in the Configuration.properties file for the Key:qa_admin_password");

	}
	public String getUserName_cofa()
	{
		String rackPassword = properties.getProperty("cofa");
		if(rackPassword!= null) return rackPassword;
		else throw new RuntimeException("Rack user password not specified in the Configuration.properties file for the Key:qa_admin_password");

	}
	public String getUserName_copa()
	{
		String rackPassword = properties.getProperty("copa");
		if(rackPassword!= null) return rackPassword;
		else throw new RuntimeException("Rack user password not specified in the Configuration.properties file for the Key:qa_admin_password");

	}
	public String getUserName_cola()
	{
		String rackPassword = properties.getProperty("cola");
		if(rackPassword!= null) return rackPassword;
		else throw new RuntimeException("Rack user password not specified in the Configuration.properties file for the Key:qa_admin_password");

	}
	public String getUserName_colax()
	{
		String rackPassword = properties.getProperty("colax");
		if(rackPassword!= null) return rackPassword;
		else throw new RuntimeException("Rack user password not specified in the Configuration.properties file for the Key:qa_admin_password");

	}
	
	public String getUserName_team_Leader()
	{
		String rackPassword = properties.getProperty("team_Leader");
		if(rackPassword!= null) return rackPassword;
		else throw new RuntimeException("Rack user password not specified in the Configuration.properties file for the Key:qa_admin_password");

	}
	public String getUserName_team_Player()
	{
		String rackPassword = properties.getProperty("team_Player");
		if(rackPassword!= null) return rackPassword;
		else throw new RuntimeException("Rack user password not specified in the Configuration.properties file for the Key:qa_admin_password");

	}
	public String getUserName_free_Agent()
	{
		String rackPassword = properties.getProperty("free_Agent");
		if(rackPassword!= null) return rackPassword;
		else throw new RuntimeException("Rack user password not specified in the Configuration.properties file for the Key:qa_admin_password");

	}


}