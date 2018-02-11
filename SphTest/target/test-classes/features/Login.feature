Feature: Login
  As a user
  I want to Login to website
  and click on article

  Scenario Outline: Login with valid credential and validate article
    Given I open 'straites'
    Then click on login button
    When I enter "<username>" and "<password>"
    Then Verify the user has been logged in
    Then Verify that the main article has a picture/video
    And User  Click on the main article
    Then Verify page has been navigated to the main article, and the picture/video is present in the article
    Examples:
      |username |password |
      |jaga4work@gmail.com |Anujag0308 |