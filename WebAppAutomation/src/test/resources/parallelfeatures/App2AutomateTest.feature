Feature: App2AutomateTest

Business Need: To verify App2Automate Home Page Test cases

Scenario: User open first page
Given user open the App2Automate page
When user clicks on "HTML" tab 
Then user should redirects to "HTML page"

Scenario: User open canvas page
Given user open the App2Automate page
When user clicks on "Canvas" tab
Then user should redirects to "Canvas"

Scenario: User open reports page
Given user open the App2Automate page
When user clicks on "Reports" tab 
Then user should redirects to "Reports"

@RegressionTest
Scenario: User opens all tab in Home page
Given user open the App2Automate page
When user clicks on "HTML" tab 
Then user should redirects to "HTML" page
And user clicks on home page from html page
Then user should redirects to Home page
When user clicks on "Canvas" tab
Then user should redirects to "Canvas" page
And user clicks on home page from canvas page
Then user should redirects to Home page
When user clicks on "Reports" tab 
Then user should redirects to "Reports" page
And user clicks on home page from reports page
Then user should redirects to Home page

@ReportTest
Scenario: report test
Given user open the App2Automate page


