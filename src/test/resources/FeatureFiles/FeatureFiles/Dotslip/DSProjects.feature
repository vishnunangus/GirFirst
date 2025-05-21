@Dotslip
Feature: Create projects

  @Regression  @Smoke
  Scenario Outline: Create a new project
    Given User is on Login page
    When User enters <username> and <password>
    Then Validate user is on login page using text from "PropertyFile"
    Then I click on create project button
    Then I enter Project Title as a unique value
    Then I enter State Project number as unique value
    Then I enter Project description as "This is newly created project"
    Then I enter Federal Project number as "This is FD Number"
    Then I enter motorist notification as "This is Dot project level Description"
    Then I click on create project button inside
    And I validate the success message is shown after project creation



    Examples:
      | username            | password   |
      | Haulhub99@gmail.com | Test@12345 |

