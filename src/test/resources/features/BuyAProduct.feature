Feature: Flow buying a product

  Scenario: Validate that a register user can buy a product
    Given I access to Flow bo
    When I do login with my account
    And  I search a product
    And I select a product
    And I click on the Comprar Ahora button
    Then I should be redirected to the checkout page