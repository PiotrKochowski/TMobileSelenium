package steps;

import io.cucumber.java.en.When;
import org.junit.Assert;
import io.cucumber.java.en.Then;
import pages.BasketPage;
import pages.ProductPage;
import utils.Base;

public class BasketSteps {

    private BasketPage basketPage = new BasketPage();

    @Then("Check details on basket page")
    public void checkDetailsOnBasketPage() {
        Assert.assertEquals("Page header is not correct. Actual: " + basketPage.getBasketPageHeader() + " expected: Twój koszyk", "Twój koszyk", basketPage.getBasketPageHeader());
        Assert.assertEquals("Start price is not correct. Actual: " + basketPage.getValueStartingPayment() + " expected: " + ProductPage.startPrice, basketPage.getValueStartingPayment(), ProductPage.startPrice);
        Assert.assertEquals("Month price is not correct. Actual: " + basketPage.getValueMonthlyPayment() + " expected: " + ProductPage.monthPrice, basketPage.getValueMonthlyPayment(), ProductPage.monthPrice);
        Base.logger.info("Details on basket page are correct");
    }

    @When("Click logo on menu to move to home page")
    public void clickLogoOnMenu() {
        basketPage.clickOnTLogo();
    }
}
