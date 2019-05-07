@vehicle_check

Feature: Drive away insurance check

Scenario Outline: Check for vehicle where insurance is covered
    Given User navigates to cover check page
    Then User checks for page title as "Drive Away Insurance"
    Then User checks for page subtitle as "Please enter the vehicle registration"
    When User enters the vehicle registration number as "<RegNumber>"
    And User clicks on Find Vehicle button
    Then User checks for CoverStartDate as "<CoverStartDate>" and CoverEndDate as "<CoverEndDate>" in search result

    Examples:
        | RegNumber | CoverStartDate        | CoverEndDate          |
        | OV12UYY   | 09 FEB 2022 : 16 : 26 | 18 FEB 2022 : 23 : 59 |

Scenario Outline: Check for vehicle where insurance is not covered
    Given User navigates to cover check page
    Then User validates page title as "Drive Away Insurance"
    Then User validates page subtitle as "Please enter the vehicle registration"
    When User enters the vehicle registration number as "<RegNumber>"
    And User clicks on "Find Vehicle" button
    Then User checks for search result message as "<SearchResult>"

    Examples:
        | RegNumber | SearchResult           |
        | XV12UYY   | Sorry record not found |

Scenario Outline: Check for search result where invalid registration number entered
    Given User navigates to cover check page
    Then User validates page title as "Drive Away Insurance"
    Then User validates page subtitle as "Please enter the vehicle registration"
    When User enters the vehicle registration number as "<RegNumber>"
    And User clicks on "Find Vehicle" button
    Then User checks the search result message for invalid registation as "<SearchResult>"

    Examples:
        | RegNumber | SearchResult                          |
        | %V*2UYY   | Please enter a valid car registration |