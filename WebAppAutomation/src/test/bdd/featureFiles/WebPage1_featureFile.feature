Feature: To check WebPage1 Fucntionality
  Description: Checking the basic web elemnets functionality in App2Automate application.

  Scenario: Positive functionality check for WebPage1
    Given user navigates to AppAutomate
    When user clicks on HtmlPageTag card
    When username and Password Validates
    Then check Radiobutton value
    And check Checkbox value
    And Select an item from dropdown
    And Select an file to upload
    And Select an item from dropup
    Then Click on link to navigate to next Webpage Successfully
