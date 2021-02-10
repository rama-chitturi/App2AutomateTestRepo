Feature: To check entire App2Automate functionality

  Background:
  Given user navigates to AppAutomate
  
  @functionalCheck @webPage1
  Scenario: To check both positive and negative functionality of WebPage1
  When user clicks on HtmlPageTag card
  When username "TestUser" and useremail "test@test.com" validates
  Then check Radiobutton value
  And check Checkbox value
  And Select an item from dropdown
  And Select an file to upload
  And Select an item from dropup
  Then Click on link to navigate to next Webpage Successfully
  
  @functionalCheck @canvasPage
  Scenario Outline: To check Canvas Fucntionality
  	When user clicks on Canvas card
    Given pick "<color_name>" to draw
    Then Draw a "<shape>" shape
    Then clear canvas by cliking on clear canvas
    Then click on back to home page

    Examples: 
      | color_name | shape    |
      | brown      | square   |
      | slateGrey | rhombus  |
      | blue       | alphabet |
  

  @functionalCheck @webPage2
  Scenario: To check both positive and negative functionality of WebPage2
  When user clicks on HtmlPageTag card
  When username and user emailID validates
  |username|testUser|
  |useremail|test@test.com|
  Then click on link to navigate to next Webpage Successfully
  And select all items in side menu
  And drag and drop blue card to grey
  And click on modal
  And click on alert message
  And click on snackbar
  And flip the card
  And click on Thumb icon
  And click on slider switch
  Given search keyword in search bar
  Then verify filtered data in Table
  
  