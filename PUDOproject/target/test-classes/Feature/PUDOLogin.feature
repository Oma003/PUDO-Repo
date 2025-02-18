Feature: Login Functionality

  Scenario: Successful login with valid credentials
    Given I open the PUDO login page
    When I enter valid email "oma.devi@outlook.com"
    And I enter valid password '6~4;6InG5"rk'
    And I click on the login button
    Then I should see a success message

  Scenario: Login fails with invalid password
    Given I open the PUDO login page
    When I enter valid email "oma.devi@outlook.com"
    And I enter invalid password "wrongPassword"
    And I click on the login button
    Then I should see an error message "Login not allowed. Incorrect password."
    
  Scenario: Verify website name after login
    Given I open the PUDO login page
    When I enter valid email "oma.devi@outlook.com"
    And I enter valid password "Kyu003??"
    And I click on the login button
    Then I should see the website title as "PUDO Locator"
    