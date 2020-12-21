@jobactivity1_1
Feature: Login Test

Scenario: Visit the site’s backend and create a new user
    Given User is on login page
    When User Enters "root" and "pa$$w0rd"
    Then Locate Add Button and Click
    And Close theBrowser