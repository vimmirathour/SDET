@Activity1_4
Feature: Posting a job using parameterization
Scenario Outline: Post a job using details passed from Example table

    Given Browser is open with Alchemy jobs and User is navigated to Post a job page  and signing in
    When User enters"<Designation>"and"<City>"and"<Message>"
    And Click submit
    Then Go to jobs page and confirm the job listing
    And Closing browser
Examples:
    | Designation    | City      |Message     |
    |System Engineer | Hyderabad |Job Applied |