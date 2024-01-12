Feature: Saucedemo page
  @Run
  Scenario Outline: add a product to the shopping cart
    Given User enters saucedemo site
    And User login with "<email>" and "<password>"
    When user add the product to the shopping cart
    And user verifies that the product of the shopping cart is the same one that was selected
    And Complete the purchase form with information "<name>", "<lastName>" and "<codePostal>"
    Then Verify that the purchase was successful by viewing the message "<message>"
    Examples:
      | email         | password     | message                   | name    | lastName | codePostal |
      | standard_user | secret_sauce | Thank you for your order! | Mariana | Uribe    | 05555      |

 # @Run
  Scenario Outline: add multiples products to the shopping cart
    Given User enters saucedemo site
    And User login with "<email>" and "<password>"
    When user add "<quantity>" products to the shopping cart
    And user verifies that products of the shopping cart is the same one that was selected
    And Complete the purchase form with information "<name>", "<lastName>" and "<codePostal>"
    Then Verify that the purchase was successful by viewing the message "<message>"
    Examples:
      | email         | password     | message                  | name    | lastName | codePostal | quantity |
      | standard_user | secret_sauce | THANK YOU FOR YOUR ORDER | Mariana | Uribe    | 05555      | 3        |

