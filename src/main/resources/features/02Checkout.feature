Feature: Checkout Process

  Scenario Outline: Successful checkout process
    Given I am logged in to the website with username "<username>" and password "<password>"
    And I am on the item page
    When I add a items to the cart
    And I clicked on the cart to view the item and tried to checkout
    And I enter firstname "<firstName>", lastname "<lastName>", postalcode "<postalCode>"
    And I click the button continue
    And I click the button finish
    Then I see the complete page

    Examples:
    | username      | password      | firstName   | lastName  | postalCode  |
    | standard_user | secret_sauce  | fadly       | steven    | 000         |

  Scenario Outline: Failed checkout process with empty information
    Given I am logged in to the website with username "<username>" and password "<password>"
    And I am on the item page
    When I add a items to the cart
    And I clicked on the cart to view the item and tried to checkout
    And I don't fill in firstname "<firstName>", lastname "<lastName>", postalcode "<postalCode>"
    And I click the continue button
    Then Alert with message "<error_message>" will appear


    Examples:
    | username      | password        | firstName | lastName  | postalCode | error_message            |
    | standard_user | secret_sauce    |           |           |            | First Name is required   |