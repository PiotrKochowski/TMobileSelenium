package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.AbstractPage;

import java.util.List;

public class BasketPage extends AbstractPage {

    @FindBy(xpath = "//h1[contains(text(), 'Twój koszyk')]")
    private WebElement pageHeader;

    @FindBy(xpath = "//h1[contains(text(), 'Twój koszyk')]")
    private List<WebElement> pageHeaderList;

    @FindBy(xpath = "//span[@data-qa='BKT_TotalupFront']")
    private WebElement valueStartingPayment;

    @FindBy(xpath = "//span[@data-qa='BKT_TotalMonthly']")
    private WebElement valueMonthlyPayment;

    @FindBy(xpath = "//a[@href='https://www.t-mobile.pl/']")
    private WebElement imgTLogo;

    public BasketPage() {
        super();
    }

    public String getBasketPageHeader() {
        waitFor(7).until(d -> pageHeaderList.size() > 0);
        return pageHeader.getText();
    }

    public String getValueStartingPayment() {
        return valueStartingPayment.getText();
    }

    public String getValueMonthlyPayment() {
        return valueMonthlyPayment.getText();
    }

    public void clickOnTLogo() {
        imgTLogo.click();
    }
}
