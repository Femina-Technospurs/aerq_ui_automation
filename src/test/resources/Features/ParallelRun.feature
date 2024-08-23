Feature: LiveScoring in Parallem browser

  Background:
    Given scenario data

@admin
Scenario Outline: Add date to ground permit and create new match
	Given Open the chrome
	And Navigate to the cricbay url
	#And Click login link
	When Login as Admin Team
	#Then Add date to Ground Permitted date "<Match_Date>" "<Match_Time>" "<PermitTime>" "<Ground>" 
	And Click on Admin
	And Click on Schedule
	And Click on Add new match
	And Select Match Date as "<Match_Date>"
	And Select Match Time as "<Match_Time>"
	And Select Home Team as "<Home_Team>"
	And Select Away Team as "<Away_Team>"
	And Select Umpire Team1 as "<Umpire1_Team>"
	And Select Umpire Team2 as "<Umpire2_Team>"
	And Select Ground as "<Ground>"
	And Select Permit Time as "<PermitTime>"
	And Select Game Stage as "<Stage>"
	And Select Toggle liveScore "<Live_Score>"
	And Click on Create Match Button
	Then Verify the Match Creation "<Validation_Message>"
	And Get MatchID Created from Schedule page "<Validation_Message>" on "<Sunday>" 
	And Navigate to the cricbay url
	Then Wait for the "Umpire assigned by Team 2" Status of Match "<Match_ID>"
	And Edit the Match date to current date for "<Match_ID>"
	And Click on Logout
		Examples:
      | Testcase_NO | Scenario | Match_Date | Match_Time | PermitTime | Ground | Home_Team | Away_Team | Umpire1_Team | Umpire2_Team | Stage | Live_Score | Validation_Message | Match_ID | 
	##@externaldata@./src/test/resources/data/TestData_LiveScore_Parallel.xlsx@Admin
|Testcase_001|Add a New Match for Success creation|02/04/2023|08:30AM|8:30-12:00|Alviso Park|Absolute|Alpha Lions|Warriors|007|Round-Robin|Yes|Match Scheduled Successfully|26673|
									  
@home
Scenario Outline: Send iEmail ,Update home Team players before match start
Given Open the chrome
And Navigate to the cricbay url
#And Click login link
When Login as Home Team
Then iEmail initiate from Team lead Logins "<Match_ID>"
And Select the Match "<Match_ID>" And Expand it
And Verify the "IEmail Initiated" Status of Match "<Match_ID>"
Then Wait for the "IEmail Acknowledged by Opponent" Status of Match "<Match_ID>"
And Select the Match "<Match_ID>" And Expand it
And Update Home Team Members "<Match_ID>"
And Select the Match "<Match_ID>" And Expand it
And Verify the "Playing XI Entered" Status of Match "<Match_ID>"
Then Wait for the "Toss Conducted" Status of Match "<Match_ID>"
And Select the Match "<Match_ID>" And Verify the date
And Select live match from home "<Match_ID>"
And Start Innnings by Toss Winning Team "<Skriker>" "<NonStriker>" "<Bowler>" "<WicketKeeper>"
And Navigate to the cricbay url
And Select live match from home "<Match_ID>"
And Validation after Start Innings "<Skriker>" "<NonStriker>" "<Bowler>"
And Navigate to the cricbay url
#And Select the Match "<Match_ID>" And Expand it
#And Verify the "Innings Started" Status of Match "<Match_ID>"
And Select live match from home "<Match_ID>"
And Add run to the live match "6"
And Select the next player "Anil Kaneriya" and Wicket by "Rajesh Borkar" "Bowled"
And Select live match from home "<Match_ID>"
And Add run to the live match "6"
And Select the next player "Ankit Solanki" and Wicket by "Rajesh Borkar" "Caught"
And Select live match from home "<Match_ID>"
And Add run to the live match "6"
And Select the next player "Dhruvil Parikh" and Wicket by "Rajesh Borkar" "Caught Behind"
And Select live match from home "<Match_ID>"
And Add run to the live match "6"
And Select the next player "Gitesh Patel" and Wicket by "Rajesh Borkar" "Caught by Substitute"
And Select live match from home "<Match_ID>"
And Add run to the live match "6"
And Select the next player "Haard Shah" and Wicket by "Rajesh Borkar" "Handled the ball"
And Select live match from home "<Match_ID>"
And Add run to the live match "6"
And Select the next player "Hiten Sonani" and Wicket by "Rajesh Borkar" "Hit the ball twice"
And Select live match from home "<Match_ID>"
And Add run to the live match "6"
And Select the next player "Jait Purohit" and Wicket by "Rajesh Borkar" "Obstructing the field"
And Select live match from home "<Match_ID>"
And Add run to the live match "6"
And Select the next player "Jenil Mehta" and Wicket by "Rajesh Borkar" "Retired Out"
And Select live match from home "<Match_ID>"
And Add run to the live match "6"
And Select the next pl ayer "Jainish Mistry" and Wicket by "Rajesh Borkar" "Obstructing the field"
And Select live match from home "<Match_ID>"
And Add run to the live match "6"
And Select the Final player and Wicket by "Rajesh Borkar" "Retired Out"
And Select live match from home "<Match_ID>"
And End Innings by Home Team
And Navigate to the cricbay url
#And Select the Match "<Match_ID>" And Expand it
#And Verify the "Innings Completed" Status of Match "<Match_ID>"
And Click on Logout

Examples:
      | Testcase_NO | Scenario | Match_ID |Skriker |	NonStriker	| Bowler	| Player	| Fielder	| Dismissal | WicketKeeper |
	##@externaldata@./src/test/resources/data/TestData_LiveScore_Parallel.xlsx@Home
|Testcase_005|Ack|26673|Abhishek Dhanuka|Jainish Mistry|Rajesh Borkar|Anil Kaneriya|Akash Devgun|Bowled|Akash Devgun|

@away
Scenario Outline: Iemail Acknowledge ,Update away Team players before match start  
Given Open the chrome
And Navigate to the cricbay url
#And Click login link
When Login as Away Team
Then Wait for the "IEmail Initiated" Status of Match "<Match_ID>"
And Select the Match "<Match_ID>" And Expand it
And Acknowledge Game by Away Team "<Match_ID>"
And Select the Match "<Match_ID>" And Expand it
And Verify the "IEmail Acknowledged by Opponent" Status of Match "<Match_ID>"
And Select the Match "<Match_ID>" And Expand it
And Update Away Team Members "<Match_ID>"
And Select the Match "<Match_ID>" And Expand it
And Verify the "Playing XI Entered" Status of Match "<Match_ID>"
Then Wait for the "Innings Completed" Status of Match "<Match_ID>"
And Select live match from home "<Match_ID>"
And Start Innnings by Ops Team "<Skriker>" "<NonStriker>" "<Bowler>" "<WicketKeeper>"
And Navigate to the cricbay url
And Select live match from home "<Match_ID>"
And Validation after Start Innings "<Skriker>" "<NonStriker>" "<Bowler>"
And Navigate to the cricbay url
And Select the Match "<Match_ID>" And Expand it
And Verify the "Innings Started" Status of Match "<Match_ID>"
And Select live match from home "<Match_ID>"
And Add run to the live match "4"
And Select the next player "Akash Devgun" and Wicket by "Jainish Mistry" "Timed Out"
And Select live match from home "<Match_ID>"
And Add run to the live match "4"
And Select the next player "Amaresh Bingumalla" and Wicket by "Jainish Mistry" "Run-out"
And Select live match from home "<Match_ID>"
And Add run to the live match "4"
And Select the next player "Anand Katailiha" and Wicket by "Jainish Mistry" "Run-out by Substitute"
And Select live match from home "<Match_ID>"
And Add run to the live match "4"
And Select the next player "Ashpujit (appu) Jogow" and Wicket by "Jainish Mistry" "Stumped"
And Select live match from home "<Match_ID>"
And Add run to the live match "4"
And Select the next player "Mohit Goenka" and Wicket by "Jainish Mistry" "Stumped"
And Select live match from home "<Match_ID>"
And Add run to the live match "4"
And Select the next player "Navpreet Singh" and Wicket by "Jainish Mistry" "Caught"
And Select live match from home "<Match_ID>"
And Add run to the live match "4"
And Select the next player "Piyush Yadav" and Wicket by "Jainish Mistry" "Timed Out"
And Select live match from home "<Match_ID>"
And Add run to the live match "4"
And Select the next player "Sameer Ks" and Wicket by "Jainish Mistry" "Timed Out"
And Select live match from home "<Match_ID>"
And Add run to the live match "4"
And Select the next player "Sandip Umrotkar" and Wicket by "Jainish Mistry" "Timed Out"
And Select live match from home "<Match_ID>"
And Add run to the live match "4"
And Select the Final player and Wicket by "Jainish Mistry" "Retired Out"
And Select live match from home "<Match_ID>"
And End Innings by Ops Team
And Navigate to the cricbay url
#And Select the Match "<Match_ID>" And Expand it
#And Verify the "Innings Completed" Status of Match "<Match_ID>"
And Click on Logout

Examples:
      | Testcase_NO | Scenario | Match_ID | Skriker |	NonStriker | Bowler | Player	| Fielder	 | Dismissal | WicketKeeper |
	##@externaldata@./src/test/resources/data/TestData_LiveScore_Parallel.xlsx@Away
|Testcase_005|Ack|26673|Abhishek Misra|Nikhil Jain|Jainish Mistry|Akash Devgun|Akshya QA |Retired Out|Akash Devgun|


@umpirehome
Scenario Outline: Umpire home Team Acknowledge the iEmail,Assign Umpire Team and Conduct Toss 
Given Open the chrome
And Navigate to the cricbay url
#And Click login link
When Login as Umpaire home team
And Acknowledge Game by umpire home team "<Match_ID>"
And Select the Match "<Match_ID>" And Expand it
And Verify the "IEmail Acknowledged by Ump Team #1" Status of Match "<Match_ID>"
And Select the Match "<Match_ID>" And Expand it
And Assign umpire for home team "<Match_ID>"
And Select the Match "<Match_ID>" And Expand it
And Click on Logout
When Login as Assigned Umpaire home team
And Select the Match "<Match_ID>" And Verify the date
Then Wait for the "Umpire assigned by Team 2" Status of Match "<Match_ID>"
And Select live match from home "<Match_ID>"
And Verify Toss Status of Match "<Match_ID>"
And Select live match from home "<Match_ID>"
And Conduct toss by umpire team "<Match_ID>"
And Navigate to the cricbay url
#And Select the Match "<Match_ID>" And Expand it
#And Verify the "Toss Conducted" Status of Match "<Match_ID>"
And Click on Logout

Examples:
      | Testcase_NO | Scenario | Match_ID |
	##@externaldata@./src/test/resources/data/TestData_LiveScore_Parallel.xlsx@HomeUmpire
|Testcase_008|Update Umpire|26673|

@umpireaway
Scenario Outline: Umpire away Team Acknowledge the iEmail,Assign Umpire Team 
Given Open the chrome
And Navigate to the cricbay url
#And Click login link
When Login as Umpaire away team
And Acknowledge Game by umpire away team "<Match_ID>"
And Select the Match "<Match_ID>" And Expand it
And Verify the "IEmail Acknowledged by Ump Team #2" Status of Match "<Match_ID>"
And Select the Match "<Match_ID>" And Expand it
And Assign umpire for away team "<Match_ID>"
And Select the Match "<Match_ID>" And Expand it
And Verify the "Umpire assigned by Team 2" Status of Match "<Match_ID>"
And Click on Logout
When Login as Assigned Umpaire away team
Then Wait for the "Innings Completed" Status of Match "<Match_ID>"
And Select live match from home "<Match_ID>"
And Close the Match "<Win>" "<POM>"
And Click on Logout

Examples:
      | Testcase_NO | Scenario | Match_ID | Win	| POM | 
	##@externaldata@./src/test/resources/data/TestData_LiveScore_Parallel.xlsx@AwayUmpire
|Testcase_007|Umpire Ack,Assign,Close Match|26673|Alp Won|Abhishek Dhanuka (Absol)|
