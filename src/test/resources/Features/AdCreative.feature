Feature: AERQ Ad Creative UI Automation
Background:
    Given scenario data


@smoke
Scenario Outline: Ad Creative Validation - "<Scenario>"

Given Open the chrome
And Navigate to the AERQ homepage
Then Validate AERQ home page for "<Scenario>" with "<message>"
And Click on Ad Creative page and Navigate
And Add New Ad Creative "<CreativeMode>" "<CreativeType>" "<Url>"
And Verfiy format of phone number field
And Verify validation message for email field
And Verify field length for advertiser name and description fields
And Validate Add Advertiser "<name>"

    Examples:
      | Testcase_NO | Scenario | username |password | message | name | CreativeMode | CreativeType | Url |
|TC_001| UI |1568@email.com|Test@1234|success| Automation Advertiser | AdSource | Edge Ad Source |  |
|TC_002| UI |1568@email.com|Test@1234|success| Automation Advertiser | Upload | Image | C:\\Users\\Admin\\eclipse-workspace\\AREQ_UI_PROJECT\\src\\test\\resources\\Data\\1Image.jpg |
|TC_003| UI |1568@email.com|Test@1234|success| Automation Advertiser | Upload | Video | C:\\Users\\Admin\\eclipse-workspace\\AREQ_UI_PROJECT\\src\\test\\resources\\Data\\2Video.mp4 |
|TC_004| UI |1568@email.com|Test@1234|success| Automation Advertiser | Upload | HTML5 | C:\\Users\\Admin\\eclipse-workspace\\AREQ_UI_PROJECT\\src\\test\\resources\\Data\\300x250Banner.jpg |
|TC_005| UI |1568@email.com|Test@1234|success| Automation Advertiser | Upload | Zip | C:\\Users\\Admin\\eclipse-workspace\\AREQ_UI_PROJECT\\src\\test\\resources\\Data\\Ogx.zip|
|TC_006| UI |1568@email.com|Test@1234|success| Automation Advertiser | CreativeURL | Image | https://picsum.photos/200/300 |
|TC_007| UI |1568@email.com|Test@1234|success| Automation Advertiser | CreativeURL | Video | http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4 |
|TC_008| UI |1568@email.com|Test@1234|success| Automation Advertiser | CreativeURL | Vast | https://technospurs.com/services.html |

   
@smoke
Scenario Outline: Error Validation On Add Creative

Given Open the chrome
And Navigate to the AERQ homepage
Then Validate AERQ home page for "<Scenario>" with "<message>"
And Click on Ad Creative page and Navigate
And Validate All Ad Creative Listing
And Validate Active Ad Creative Listing
And Validate InActive Advertiser Listing
And Click on Ad Creative page and Navigate
And Add New Ad Creative Error Validation
And Close the Chrome driver
  
