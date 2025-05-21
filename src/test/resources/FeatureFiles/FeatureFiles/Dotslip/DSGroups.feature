@Dotslip  @Groups
Feature: Groups Module Validation


  @Regression  @Smoke
  Scenario Outline: Create a new group and verify created group is in the group list
    Given User is on Login page
    When User enters <username> and <password>
    Then Validate user is on login page using text from "PropertyFile"
    Then I click on Groups icon and navigate to groups page
    And I validate I landed on Groups Page
    Then I click on create Group button
    Then enter group title and group description
    Then I click on save button
    Then I validate success message is shown after group creation
    Then I click on back button from groups page
    Then I validate the created group is there in the list



    Examples:
      | username            | password   |
      | Haulhub99@gmail.com | Test@12345 |


  @Regression  @Smoke
  Scenario Outline: Delete a group and validate it is in the deleted list
    Given User is on Login page
    When User enters <username> and <password>
    Then Validate user is on login page using text from "PropertyFile"
    Then I click on Groups icon and navigate to groups page
    And I validate I landed on Groups Page
    Then I click on create Group button
    Then enter group title and group description
    Then I click on save button
    Then I validate success message is shown after group creation
    Then I click on back button from groups page
    Then I click on delete button for the created group and click on delete
    And I validate success message is shown after group deletion
    Then I go to view recently deleted groups tab and I check for the deleted group



    Examples:
      | username            | password   |
      | Haulhub99@gmail.com | Test@12345 |



  @Regression  @Smoke
  Scenario Outline: Restore a group and validate it is in the Active group list
    Given User is on Login page
    When User enters <username> and <password>
    Then Validate user is on login page using text from "PropertyFile"
    Then I click on Groups icon and navigate to groups page
    And I validate I landed on Groups Page
    Then I click on create Group button
    Then enter group title and group description
    Then I click on save button
    Then I click on back button from groups page
    Then I click on delete button for the created group and click on delete
    Then I go to view recently deleted groups tab and I check for the deleted group
    Then I click on Restore group from the list
    And I validate the success message on group restoration
    Then I click on View active groups button
    And Validate restored group is present in the active group list



    Examples:
      | username            | password   |
      | Haulhub99@gmail.com | Test@12345 |


  @Regression  @Smoke
  Scenario Outline: Adding staff to a created group and validating the count
    Given User is on Login page
    When User enters <username> and <password>
    Then Validate user is on login page using text from "PropertyFile"
    Then I click on Groups icon and navigate to groups page
    And I validate I landed on Groups Page
    Then I click on create Group button
    Then enter group title and group description
    Then I click on save button
    Then I click on Staffing button
    Then I fetch the count before adding an employee
    Then I click on Add employee button
    Then I validate the success message on adding an employee
    Then I Validate the count of employees after adding


    Examples:
      | username            | password   |
      | Haulhub99@gmail.com | Test@12345 |