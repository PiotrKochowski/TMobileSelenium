package com.tmobile.web.steps;

import io.cucumber.java.en.When;
import pages.ProductPage;

public class ProductSteps {

    private ProductPage productPage = new ProductPage();

    @When("Add product to basket")
    public void addProductToBasket() {
        productPage.setStartPrice();
        productPage.setMonthPrice();
        productPage.clickBtnAddToBasket();
    }
}
