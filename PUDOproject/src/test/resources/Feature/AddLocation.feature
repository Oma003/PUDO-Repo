Feature: Add Location Functionality

  Scenario: Successfully add a new location
    Given I open the PUDO login page
    When I enter valid email "oma.devi@outlook.com"
    And I enter valid password '6~4;6InG5"rk'
    And I click on the login button
    Given I open the PUDO add location page
    When I enter "PUDO124" in the "PUDO Code" field    
    And I enter "Test Location" in the "Name" field
    And I enter "657 Main St" in the "Address Line 1" field
    And I enter "Suite 100" in the "Address Line 2" field
    And I enter "New York" in the "City/Town" field    
    And I enter "Denmark" in the "County" field
    And I enter "10001" in the "Post Code" field
    And I enter "70.7128" in the "Latitude" field
    And I enter "-84.0060" in the "Longitude" field
    And I select "Ireland" from the "Country" dropdown
    And I select "LOCKER" from the "PUDO Type" dropdown
    And I select "ACTIVE" from the "Location Status" dropdown
    And I select "Desktop" from the "Hardware Type" dropdown
    And I select "UTC" from the "Time Zone" dropdown
    When I check the following checkboxes:
      | Open 24x7        |
      | Always Open      |
      | Active          |
    And I click on the submit button
    

  Scenario: Attempt to add a location with missing mandatory fields
    Given I open the PUDO login page
    When I enter valid email "oma.devi@outlook.com"
    And I enter valid password '6~4;6InG5"rk'
    And I click on the login button
    Given I open the PUDO add location page
    When I enter "PUDO123" in the "PUDO Code" field
    And I click on the submit button
    
    
    
  Scenario: Verify that a duplicate PUDO Code cannot be added.
    Given I open the PUDO login page
    When I enter valid email "oma.devi@outlook.com"
    And I enter valid password '6~4;6InG5"rk'
    And I click on the login button
    Given I open the PUDO add location page
    When I enter "PUDO124" in the "PUDO Code" field    
    And I enter "Test Location" in the "Name" field
    And I enter "657 Main St" in the "Address Line 1" field
    And I enter "Suite 100" in the "Address Line 2" field
    And I enter "New York" in the "City/Town" field    
    And I enter "Denmark" in the "County" field
    And I enter "10001" in the "Post Code" field
    And I enter "70.7128" in the "Latitude" field
    And I enter "-84.0060" in the "Longitude" field
    And I select "Ireland" from the "Country" dropdown
    And I select "LOCKER" from the "PUDO Type" dropdown
    And I select "ACTIVE" from the "Location Status" dropdown
    And I select "Desktop" from the "Hardware Type" dropdown
    And I select "UTC" from the "Time Zone" dropdown
    When I check the following checkboxes:
      | Open 24x7        |
      | Always Open      |
      | Active          |
    And I click on the submit button