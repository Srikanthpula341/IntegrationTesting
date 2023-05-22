#Author: Srikanth Pula
#date: 21/05/2023
#Description: Testing the Cart feature
Feature: Cart feature
  As a customer
  I want to add the items to cart

  @First
  Scenario: Adding item to Cart
    Given I am on the initial page
    When I select the item for details
    When I click the add to cart
    Then I should be go to cart to check item

