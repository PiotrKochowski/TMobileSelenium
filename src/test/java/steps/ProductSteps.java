package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.ProductPage;
import utils.Base;

public class ProductSteps {

    private ProductPage productPage = new ProductPage();

    @Then("Check if product page opened")
    public void checkIfProductPageOpened() {
        Assert.assertTrue("Product page is not opened", productPage.isProductPageOpened());
        Base.logger.info("Product page opened");
    }

    @When("Add product to basket")
    public void addProductToBasket() {
        productPage.setStartPrice();
        productPage.setMonthPrice();
        productPage.clickBtnAddToBasket();
    }
}
