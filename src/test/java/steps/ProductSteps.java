package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.ProductPage;

public class ProductSteps {

    private ProductPage productPage = new ProductPage();

    @Then("Check if product page opened")
    public void checkIfProductPageOpened() {
        Assert.assertTrue("Product page is not opened" , productPage.isProductPageOpened());
    }

    @When("Add product to basket")
    public void addProductToBasket() {
        productPage.setStartPrice();
        productPage.setMonthPrice();
        productPage.clickBtnAddToBasket();
    }
}
