Feature: Saucedemo page

  Scenario Outline: add a product to the shopping cart
    Given User enters saucedemo site
    And User login with "<email>" and "<password>"
    When user add the product to the shopping cart
    Then user verifies that the product of the shopping cart is the same one that was selected
    Examples:
      | email                   | password     |
      | standard_user           | secret_sauce |
      | locked_out_user         | secret_sauce |
      | problem_user            | secret_sauce |
      | performance_glitch_user | secret_sauce |