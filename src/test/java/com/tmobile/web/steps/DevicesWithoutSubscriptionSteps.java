package com.tmobile.web.steps;

import io.cucumber.java.en.When;
import pages.DevicesWithoutSubscriptionPage;

public class DevicesWithoutSubscriptionSteps  {

    private DevicesWithoutSubscriptionPage devicesWithoutSubscriptionPage = new DevicesWithoutSubscriptionPage();

    @When("Select first product form list")
    public void chooseDevicesFromMenu() {
        devicesWithoutSubscriptionPage.clickFirstProduct();
    }

}
