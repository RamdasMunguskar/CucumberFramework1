@loginPage

Feature: To validate login page from zoom application
 
    Background:
    Given:
    And To launch the browser "chrome"
    And To zoom login page "https://zoom.us/signin#/login"
    
    

    @ValidData
    Scenario: To validate zoom meetng page once user will enter valid username and password
    And To locate on email textbox & enter email "ramdasmunguskar@gmail.com"
    And To locate on password textbox & enter password "Ramdas@2000"
    When To locate on signin button & click on it
    Then To validate user should be on zoom meeting page "Sign In | Zoom"
    And To close the browser
    
    @inValidData
    Scenario Outline:To validate user should be on login page after enter invalid credentials 
    And To locate on email textbox & enter email "<userName>"
    And To locate on password textbox & enter password "<userPassword>"
    When To locate on signin button & click on it
    Then To validate user should be on zoom signin page "Sign In | Zoom"
    
    Examples: 
    
       |testName           |userName            |userPassword  |
       |both are empty     |                    |              |
       |email is empty     |                    | 123456       |
       |password is empty  |queuecodes@gmail.com|              |
       |both are invalid   | ccjorj             | 15955        |
       |email is invalid   | nnvijji            | 123456       |
       |passowrd is invalid|queuecodes@gmail.com|              |
       