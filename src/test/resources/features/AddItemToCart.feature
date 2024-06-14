@addItem @ui
Feature: Amazon Shopping Cart

  Scenario: Add hats for men to the cart
    Given I am on the Amazon homepage
    And  I search for "hats for men"
    When I select the first hat
    And  I add to the cart with quantity "2"
    Then I open the cart
    And  I assert the total price and quantity "2" are correct
    When I search for "hats for women"
    And  I select the first hat
    And  I add to the cart with quantity "1"
    Then I open the cart
    And  I assert the total price and quantity "3" are correct
    When I change the quantity for second item as 1 on Cart
    Then I should see total price and quantity "2" are changed correctly
    Then I should see total price and quantity "2" are changed correctly
