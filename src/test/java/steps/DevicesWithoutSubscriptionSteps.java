package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.DevicesWithoutSubscriptionPage;
import utils.Base;

public class DevicesWithoutSubscriptionSteps {

    private DevicesWithoutSubscriptionPage devicesWithoutSubscriptionPage = new DevicesWithoutSubscriptionPage();

    @Then("Check if I moved to page with products list")
    public void checkIfMovedToDevicesWithoutSubscriptionPage() {
        Assert.assertTrue("Devices Without Subscription Page is not opened", devicesWithoutSubscriptionPage.isPageHeaderVisible());
        Base.logger.info("Devices without subscriptions page opened");
    }

    @When("Select first product form list")
    public void chooseDevicesFromMenu() {
        devicesWithoutSubscriptionPage.clickFirstProduct();
    }
}
