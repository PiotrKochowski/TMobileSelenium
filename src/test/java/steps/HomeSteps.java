package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.HomePage;
import utils.Base;

import java.io.IOException;

public class HomeSteps {

    private HomePage homePage = new HomePage();

    @Given("Open home page$")
    public void openHomePage() throws IOException {
        homePage.openHomePage();
        Base.logger.info("Home page opened");
    }

    @When("Choose devices from menu")
    public void chooseDevicesFromMenu() {
        homePage.clickDevicesTab();
    }

    @Then("Check if submenu is visible")
    public void checkVisibilityOfSubmenu() {
        Assert.assertTrue("Submenu is not visible", homePage.isSubmenuVisible());
    }

    @When("Choose smartwatches from without subscription from submenu")
    public void chooseSmartwatchesWithoutSubscription() {
        homePage.clickSmartwatchesWithoutSubscription();
    }


    @Then("Check if there is (.*?) product in basket$")
    public void checkNumberOfProductsInBasket(String numberOfProducts) {
        Assert.assertEquals("Number of products in basket are not correct, actuat: " + homePage.getNumberOfProductsFromBasket() + ", expected: " + numberOfProducts, homePage.getNumberOfProductsFromBasket(), numberOfProducts);
        Base.logger.info("Number of products in basket are correct");
    }
}
