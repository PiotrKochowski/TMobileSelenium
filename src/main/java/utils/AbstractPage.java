package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class AbstractPage extends Base {

    public AbstractPage() {
        PageFactory.initElements(driver, this);
    }

    public WebDriverWait waitFor(int seconds) {
        return (WebDriverWait) new WebDriverWait(driver, Duration.ofSeconds(seconds));
    }

    public boolean checkVisibilityOfElement(WebElement element, int seconds) {
        WebDriverWait customWait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        try {
            customWait.until(driver -> element.isDisplayed());
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public void waitForElementDisplayed(WebElement element, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(driver -> {
            return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete")
                    && element.isDisplayed();
        });
    }
}
