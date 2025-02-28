 Feature: Edit location functionality
 
 Scenario: User edits a location successfully
    Given I open the PUDO login page
    When I enter valid email "oma.devi@outlook.com"
    And I enter valid password '6~4;6InG5"rk'
    And I click on the login button
    And I am on the View Locations page
    When I click the edit icon for a specific location
    When I enter "PUDO124" in the "PUDO Code" field    
    And I enter "Test Location" in the "Name" field
    And I click on the submit button
    
    

  Scenario: User tries to edit a location with invalid details
    Given I open the PUDO login page
    When I enter valid email "oma.devi@outlook.com"
    And I enter valid password '6~4;6InG5"rk'
    And I click on the login button
    And I am on the View Locations page
    When I click the edit icon for a specific location
    And I enter "125" in the "Latitude" field     
    And I click on the submit button
    

  Scenario: User cancels editing a location
    Given I open the PUDO login page
    When I enter valid email "oma.devi@outlook.com"
    And I enter valid password '6~4;6InG5"rk'
    And I click on the login button
    And I am on the View Locations page
    When I click the edit icon for a specific location
    When I enter "PUDO124" in the "PUDO Code" field    
    And I enter "Test Location" in the "Name" field
    And I click on the Cancel button
    