Feature: T-Mobile test

  @test1
  Scenario: Choose smartwatch from product list
    Given Open home page

    When  Choose devices from menu
    Then  Check if submenu is visible

    When  Choose smartwatches from without subscription from submenu
    Then  Check if I moved to page with products list

    When  Select first product form list
    Then  Check if product page opened

    When  Add product to basket
    Then  Check details on basket page

    When  Open home page
    Then  Check if there is 1 product in basket