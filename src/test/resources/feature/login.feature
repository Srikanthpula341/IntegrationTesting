#Author: Srikanth Pula
#date: 21/05/2023
#Description: Test sample
Feature: Login feature
  As a user
  I want to log in with valid credentials
  So that I can check security here

  @First
  Scenario: Failed login
    Given I am on the login page
    When I enter random username and password
    When I click the login button
    Then I should be taken to the home page and say error
