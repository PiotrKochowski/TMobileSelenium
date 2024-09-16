package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.AbstractPage;

public class ProductPage extends AbstractPage {

    public static String startPrice;
    public static String monthPrice;

    @FindBy(xpath = "//div[contains(@class, 'Enabled')]//button[@data-qa='PRD_AddToBasket']")
    private WebElement btnAddToBasket;

    @FindBy(xpath = "(//div[@data-qa='PRD_TotalUpfront'])[2]/div/div")
    private WebElement valueStartPrice;

    @FindBy(xpath = "(//div[@class='dt_price_change'])[4]/div")
    private WebElement valueMonthPrice;

    public ProductPage() {
        super();
    }

    public void clickBtnAddToBasket() {
        btnAddToBasket.click();
    }

    public boolean isProductPageOpened() {
        return checkVisibilityOfElement(btnAddToBasket, 5);
    }

    public void setStartPrice() {

        this.startPrice = valueStartPrice.getText().replaceAll("\\D+", "");
    }

    public void setMonthPrice() {
        this.monthPrice = valueMonthPrice.getText().replaceAll("\\D+", "");
    }
}
