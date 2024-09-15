package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.AbstractPage;

import java.util.List;


public class DevicesWithoutSubscriptionPage extends AbstractPage {

    @FindBy(xpath = "//h1[contains(text(), 'Urządzenia bez abonamentu')]")
    private WebElement pageHeader;

    @FindBy(xpath = "//div[@data-qa='LST_ProductCard0']")
    private List<WebElement> productsList;

    public DevicesWithoutSubscriptionPage( ) {
        super();
    }

    public void clickFirstProduct(){
        waitFor(2).until(d -> ExpectedConditions.visibilityOf(pageHeader));
        productsList.get(0).click();
    }
}
