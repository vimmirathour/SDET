@Activity1_2
Feature: Searching for jobs
Scenario: Searching for jobs and applying to them 

    Given Browser is open with Alchemy jobs site 
    When User is navigated to jobs page and find the keyword for search input field
    And Search for Jobs
    And Set the filter job type to show only fulltime job
    And Find a job listing and check the job details and print the title to the console
    Then Click on Apply for Job button
    And Close browser