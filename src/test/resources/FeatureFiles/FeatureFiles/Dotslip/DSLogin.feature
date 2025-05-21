@Dotslip

  @Regression
  Feature: Login to Dotslip as an Administrator
   Scenario Outline: : : Login to Dotslip as an Admin user
      Given User is on Login page
      When User enters <username> and <password>
      Then Validate user is on login page using text from "PropertyFile"

     Examples:
       | username            | password   |
       | Haulhub99@gmail.com | Test@12345 |
