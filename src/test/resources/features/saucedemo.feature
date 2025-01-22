Feature: Saucedemo Website Automation Task

  @task
  Scenario: Select the highest price item and add to cart
    Given the user goes to saucedemo website
    When the user logs in with "standard_user" credentials
    And finds the highest price item
    And adds the most expensive item to the cart
    When the user goes to the cart
    Then the item should be seen in the cart
    And the user removes the item from the cart
    And the user logs out from the website


