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
    }

    public void stopLogging() {
        LoggerContext context = (LoggerContext) LogManager.getContext(false);
        context.stop();
    }

    public void startLogging() {
        LoggerContext context = (LoggerContext) LogManager.getContext(false);
        context.start();
        context.reconfigure();
        logger = LogManager.getLogger(Base.class);
    }

    public void deleteFile(String fileName) {
        stopLogging();
        File logFile = new File("target/logs/" + fileName);
        if (logFile.exists()) {
            if (!logFile.delete()) {
                logger.error("Nie udało się usunąć pliku logów: " + logFile.getAbsolutePath());
            }
        }
    }

    public static void setupExceptionHandler() {
        Thread.setDefaultUncaughtExceptionHandler((thread, throwable) -> {
            System.out.println("UncaughtExceptionHandler invoked"); // Debugging
            if (logger != null) {
                logger.error("Uncaught exception in thread {}: ", thread.getName(), throwable);
            } else {
                System.err.println("Uncaught exception in thread " + thread.getName() + ": ");
                throwable.printStackTrace();
            }
        });
    }
}
