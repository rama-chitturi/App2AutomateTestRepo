Feature: Basic HTML Elements Page
Business Need: To automate basic html elements actions


  @RegressionTest
  Scenario Outline: Verify User credentials only
   Given user open the App2Automate page
		When user clicks on "HTML" tab 
		When user enters username as "<username>" and emailId as "<emailId>"
		And user clicks on submit button
		Then user should see a alert of status "<status>"
		When user clicks on OK for confirmation alert
		Then user should see the basic elements in page

    Examples: 
      | username  | emailId | status  |
      | Test |     test@test.com | Success |
		

  @SmokeTest
  Scenario Outline: Verify User credentials only
   Given user open the App2Automate page
		When user clicks on "HTML" tab 
		When user enters username as <username> and emailId as <emailId>
		And user clicks on submit button
		Then user should see a alert of status <status>

    Examples: 
      | username  | emailId | status  |
      | Test |     test@test.com | Success |
      | Test1 |     test | Failed    |
