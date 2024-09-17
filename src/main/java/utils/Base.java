package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.LoggerContext;
import org.openqa.selenium.WebDriver;
import org.apache.logging.log4j.Logger;

import java.io.File;

import static utils.DriverFactory.closeDriver;

public class Base {

    protected static WebDriver driver;
    public static Logger logger;

    public void testStart() {
        startLogging();
        this.driver = DriverFactory.getDriver();
    }

    public void afterTest() {
        closeDriver();
        stopLogging();
    }

    public void stopLogging() {
        LoggerContext context = (LoggerContext) LogManager.getContext(false);
        context.stop();
    }

    public void startLogging() {
        deleteLog();
        LoggerContext context = (LoggerContext) LogManager.getContext(false);
        context.start();
        context.reconfigure();
        logger = LogManager.getLogger(Base.class);
    }

    public void deleteLog() {
        File logFile = new File("target/logs/log4j.log");
        if (logFile.exists()) {
            if (!logFile.delete()) {
                logger.error("Failed to delete log file: " + logFile.getAbsolutePath());
            }
        }
    }
}
