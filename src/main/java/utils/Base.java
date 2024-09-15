package utils;

import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static utils.DriverFactory.closeDriver;

public class Base {

    protected static WebDriver driver;
    public static final Logger logger = LogManager.getLogger(Base.class);

    public void starTest(Scenario scenario) {
        logger.info("==========================================================================================");
        logger.info("scenario name: " + scenario.getName());
        logger.info("==========================================================================================");
        this.driver = DriverFactory.getDriver();
    }

    public void afterTest(Scenario scenario) {
        logger.info("==========================================================================================");
        logger.info("scenario name: " + scenario.getName() + " finished with result: " + scenario.getStatus());
        logger.info("==========================================================================================");
        closeDriver();
    }
}
