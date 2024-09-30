Feature: Navigate to the AERQ homepageFeature: AERQ Advertiser UI Automation
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
      | Testcase_NO | Scenario | username |password | message | name |
|TC_001| UI |1568@email.com|Test@1234|success| Automation Advertiser |

   
@admin3
Scenario Outline: Error Validation On AddAdvetiser

Given Open the chrome
And Navigate to the AERQ homepage
#And Click login link
And Verfiy format of phone number field
And Verify validation message for email field
And Verify field length for advertiser name and description fields
And Validate Add Advertiser "<name>"
And Validate Active Advertiser
And Validate InActive Advertiser
And Click on Logout
  
