Feature: View Locations Page

  Scenario: Verify the View Locations page loads successfully
    Given I open the PUDO login page
    When I enter valid email "oma.devi@outlook.com"
    And I enter valid password '6~4;6InG5"rk'
    And I click on the login button
    And I am on the View Locations page
    Then I should see the Pudo Locations table

  Scenario: Verify table headers in the View Locations page
    Given I open the PUDO login page
    When I enter valid email "oma.devi@outlook.com"
    And I enter valid password '6~4;6InG5"rk'
    And I click on the login button
    And I am on the View Locations page
    Then the table should have the following headers:
      | Actions           |
      | PudoCode          |
      | PudoType          |
      | Name              |
      | Address1          |
      | CityTown          |
      | PostCode          |
      | County            |
      | Country           |
      | Latitude          |
      | Longitude         |
      | TimeZone          |
      | Location Status   |
      | Hardware Type     |
      | what3Words        |
      | LocationLink      |
      | IsActive          |
      | AlwaysOpen        |
      | OversizedAllowed  |
      | Open24X7          |

  Scenario: Verify at least one location entry is displayed
    Given I open the PUDO login page
    When I enter valid email "oma.devi@outlook.com"
    And I enter valid password '6~4;6InG5"rk'
    And I click on the login button
    And I am on the View Locations page
    When I check the locations table
    Then I should see at least one location entry
    
 