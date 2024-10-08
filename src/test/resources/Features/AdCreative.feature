Feature: AERQ Ad Creative API Automation
Background:
    Given scenario data
    
    
@smoke1
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


#|TC_001| UI |success| Automation Advertiser | AdSource | Edge Ad Source |  |
#|TC_002| UI |success| Automation Advertiser | Upload | Image | C:\\Users\\Admin\\eclipse-workspace\\AREQ_UI_PROJECT\\src\\test\\resources\\Data\\1Image.jpg |
#|TC_003| UI |success| Automation Advertiser | Upload | Video | C:\\Users\\Admin\\eclipse-workspace\\AREQ_UI_PROJECT\\src\\test\\resources\\Data\\2Video.mp4 |
#|TC_004| UI |success| Automation Advertiser | Upload | HTML5 | C:\\Users\\Admin\\eclipse-workspace\\AREQ_UI_PROJECT\\src\\test\\resources\\Data\\300x250Banner.jpg |
#|TC_005| UI |success| Automation Advertiser | Upload | Zip | C:\\Users\\Admin\\eclipse-workspace\\AREQ_UI_PROJECT\\src\\test\\resources\\Data\\Ogx.zip|
#|TC_006| UI |success| Automation Advertiser | CreativeURL | Image | https://picsum.photos/200/300 |
#|TC_007| UI |success| Automation Advertiser | CreativeURL | Video | http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4 |
#|TC_008| UI |success| Automation Advertiser | CreativeURL | Vast | https://technospurs.com/services.html |

@smoke
Scenario Outline: Ad Creative Validation on - "<Scenario>" - "<CreativeMode>" - "<CreativeType>"

Given Open the chrome
And Navigate to the AERQ homepage
Then Validate AERQ home page for "<Scenario>" with "<message>"
And Click on Ad Creative page and Navigate
And Add New Ad Creative "<CreativeMode>" "<CreativeType>" "<Url>"


    Examples:
    	    | Testcase_NO | Scenario | message | name | CreativeMode | CreativeType | Url |
     			##@externaldata@./src/test/resources/data/TestData_Advertiser.xlsx@Creative
|TC_001|UI|success|Automation Creative|AdSource|Edge Ad Source||
|TC_002|UI|success|Automation Creative|Upload|Image|1Image.jpg|
|TC_003|UI|success|Automation Creative|Upload|Video|2Video.mp4|
|TC_004|UI|success|Automation Creative|Upload|HTML5|300x250Banner.jpg|
|TC_005|UI|success|Automation Creative|Upload|Zip|Ogx.zip|
|TC_006|UI|success|Automation Creative|CreativeURL|Image|https://dummyimage.com/400x300/00ff00/000|
|TC_007|UI|success|Automation Creative|CreativeURL|Video|http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerJoyrides.mp4|
|TC_008|UI|success|Automation Creative|CreativeURL|Vast|https://ytvastqa.appspot.com/static/sampletag/vast.xml|


   
