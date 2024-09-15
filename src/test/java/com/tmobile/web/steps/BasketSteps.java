package com.tmobile.web.steps;

import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import io.cucumber.java.en.Then;
import pages.BasketPage;
import pages.ProductPage;

public class BasketSteps {

    private BasketPage basketPage = new BasketPage();

    @Then("Check details on basket page")
    public void checkDetailsOnBasketPage() {
        Assertions.assertEquals(basketPage.getBasketPageHeader(), "Twój koszyk", "Page header is not correct. Actual: " + basketPage.getBasketPageHeader() + " expected: Twój koszyk");
        Assertions.assertEquals(basketPage.getValueStartingPayment(), ProductPage.startPrice, "Start price is not correct. Actual: " + basketPage.getValueStartingPayment() + " expected: " + ProductPage.startPrice);
        Assertions.assertEquals(basketPage.getValueMonthlyPayment(), ProductPage.monthPrice, "Month price is not correct. Actual: " + basketPage.getValueMonthlyPayment() + " expected: " + ProductPage.monthPrice);
    }

    @When("Click logo on menu to move to home page")
    public void clickLogoOnMenu() {
        basketPage.clickOnTLogo();
    }
}
