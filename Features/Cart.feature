Feature: Cart functionality of Application
  Verify that user is able to use cart functionality.

  Scenario: User should be able to add product to cart

    When Add product with id 8 to cart

    Then Product with id 8 is in cart

  Scenario: User should be able to remove product from cart

    When Add product with id 8 to cart

    When Delete product from cart

    Then Cart is empty