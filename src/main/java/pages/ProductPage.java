package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.AbstractPage;

public class ProductPage extends AbstractPage {

    public static String startPrice;
    public static String monthPrice;

    @FindBy(xpath = "PRD_ProductName")
    private WebElement productName;

    @FindBy(xpath = "//div[contains(@class, 'Enabled')]//button[@data-qa='PRD_AddToBasket']")
    private WebElement btnAddToBasket;

    @FindBy(xpath = "(//div[@data-qa='PRD_TotalUpfront'])[2]/div/div")
    private WebElement valueStartPrice;

    @FindBy(xpath = "(//div[@class='dt_price_change'])[4]/div")
    private WebElement valueMonthPrice;

    public ProductPage( ) {
        super();
    }

    public void clickBtnAddToBasket(){
        btnAddToBasket.click();
    }

    public void setStartPrice() {
        waitForElementDisplayed(valueStartPrice, 5);
        this.startPrice = valueStartPrice.getText().replaceAll("\\D+", "");
    }

    public void setMonthPrice() {
        this.monthPrice = valueMonthPrice.getText().replaceAll("\\D+", "");
    }
}
