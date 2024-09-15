Feature: T-Mobile test

  @test1
  Scenario: Choose smartwatch from product list
    Given Open home page
    When  Choose devices from menu
    When  Choose smartwatches from without subscription from submenu
    When  Select first product form list
    When  Add product to basket
    Then  Check details on basket page
    Given Open home page
    Then  Check if there is 1 product in basket