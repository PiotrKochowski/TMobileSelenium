package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.AbstractPage;
import utils.DriverFactory;
import utils.PropertiesLoader;

import java.io.IOException;

public class HomePage extends AbstractPage {

    @FindBy(xpath = "//button[@id='didomi-notice-agree-button']")
    private WebElement btnAcceptCookies;

    @FindBy(id = "main-menu")
    private WebElement mainMenu;

    @FindBy(xpath = "//div[contains(@class, 'hidden menu-dropdown-submenu')]")
    private WebElement submenu;

    @FindBy(xpath = "//button[contains(text(), 'Urządzenia')]")
    private WebElement devicesTab;

    @FindBy(xpath = "//a[@data-ga-ea='nav-links - Urządzenia/Bez abonamentu/Smartwatche']")
    private WebElement smartwatchesWithoutSubscription;

    @FindBy(xpath = "//span[contains(text(), 'Przejdź do strony koszyka')]/following-sibling::div")
    private WebElement numberOfProductsInBasket;

    public HomePage() {
        super();
    }

    public void openHomePage() throws IOException {
        driver = DriverFactory.getDriver();
        driver.get(PropertiesLoader.loadProperty("homePageUrl"));
        driver.manage().window().maximize();
        if (checkVisibilityOfElement(btnAcceptCookies, 2))
            btnAcceptCookies.click();
        waitFor(2).until(d -> ExpectedConditions.visibilityOf(mainMenu));
    }

    public void clickDevicesTab() {
        devicesTab.click();
        waitFor(5).until(d -> ExpectedConditions.visibilityOf(submenu));
    }

    public void clickSmartwatchesWithoutSubscription() {
        smartwatchesWithoutSubscription.click();
    }

    public String getNumberOfProductsFromBasket() {
        return numberOfProductsInBasket.getText().trim();
    }

}
