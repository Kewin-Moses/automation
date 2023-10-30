Feature: To signin demoBlaze e-commerce website

  Background: 
    Given: I am on the demoBlaze site page


  Scenario: Sucessfully creating a new account on demoBlaze site by entering un-used credentials
    Given I open the signup popup
    And I have entered an un-used username and password
    When I click the Signup button
    Then I should be Signup sucessfully

  Scenario: Unsucessfull signup with already used credentials
    Given I have entered already used username and password
    When I click on the signup button
    Then I should see a alert

  Scenario: Unsucessfull signup by click the close button in signup popup
    Given I have entered username and password
    When I click on the close button
    Then I should see the signup popup closed without creating a account
