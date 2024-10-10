Feature: AERQ Advertiser UI Automation
Background:
    Given scenario data


@smoke
Scenario Outline: Advertiser Validation - "<Scenario>"

Given Open the chrome
And Navigate to the AERQ homepage
Then Validate AERQ home page for "<Scenario>" with "<message>"
And Click on Advertiser page and Navigate
And Add Advertiser
And Verfiy format of phone number field
And Verify validation message for email field
And Verify field length for advertiser name and description fields
And Validate Add Advertiser "<name>"
And Validate Active Advertiser
And Validate InActive Advertiser

    Examples:
		 		  | Testcase_NO | Scenario | message | name |
	##@externaldata@./src/test/resources/data/TestData_Advertiser.xlsx@Advertiser
|TC_001|UI|success|Automation Advertiser|
  
