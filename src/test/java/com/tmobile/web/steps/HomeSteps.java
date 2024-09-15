package com.tmobile.web.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import pages.HomePage;

import java.io.IOException;

public class HomeSteps {

    private HomePage homePage = new HomePage();

    @Given("Open home page$")
    public void openHomePage() throws IOException {
        homePage.openHomePage();
    }

    @When("Choose devices from menu")
    public void chooseDevicesFromMenu() {
        homePage.clickDevicesTab();
    }

    @When("Choose smartwatches from without subscription from submenu")
    public void chooseSmartwatchesWithoutSubscription() {
        homePage.clickSmartwatchesWithoutSubscription();
    }


    @Then("Check if there is (.*?) product in basket$")
    public void checkNumberOfProductsInBasket(String numberOfProducts) {
        Assertions.assertEquals(homePage.getNumberOfProductsFromBasket(), numberOfProducts, "Number of products in basket is not correct, actuat: " + homePage.getNumberOfProductsFromBasket() + ", expected: " + numberOfProducts);
    }
}
