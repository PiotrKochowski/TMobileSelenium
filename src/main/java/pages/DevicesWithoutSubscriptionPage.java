package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.AbstractPage;

import java.util.List;

public class DevicesWithoutSubscriptionPage extends AbstractPage {

    @FindBy(xpath = "//h1[contains(text(), 'Urządzenia bez abonamentu')]")
    private WebElement pageHeader;

    @FindBy(xpath = "//div[@data-qa='LST_ProductCard0']")
    private List<WebElement> productsList;

    public DevicesWithoutSubscriptionPage() {
        super();
    }

    public boolean isPageHeaderVisible() {
        return checkVisibilityOfElement(pageHeader, 2);
    }

    public void clickFirstProduct() {
        productsList.get(0).click();
    }
}
