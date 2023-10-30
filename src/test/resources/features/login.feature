Feature: Log into demoBlaze e-commerce website
	
	
Background: 
     Given I am on the demoBlaze site page


  Scenario: Log into demoBlaze website with valid credentials
     
    Given I click on the Login link
    And I enter the valid Username and Password
    When I click on the Login button
    Then I should be login sucessfully

 
  Scenario Outline: Unsucessfull login with Invalid credentials
  
    Given I click on the Login link
    And I enter the Invalid  "<username>" and <password>
    When I click on the Log in button
    Then I should not be able to log in sucessfully

    Examples: 
      | username   | password |
      | Kewinmose  |     1532 |
      | Kewinmoses |     1533 |
