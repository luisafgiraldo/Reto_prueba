Feature: Search and add products to cart
  Scenario: Search for products and add to cart
    Given I am on the AliExpress homepage
    When I search for products from Excel
    Then I validate the price in the cart