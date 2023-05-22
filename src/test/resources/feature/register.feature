#Author: Srikanth Pula
#date: 21/05/2023
#Description: Test sample
Feature: Register feature
  As a user
  I want to create a account in the  application
  so that I can access my account

  @First
  Scenario: Successful registration
    Given I am on the home page
    When I enter my user details
    And I click the register button
   Then I should be logged in with my username
