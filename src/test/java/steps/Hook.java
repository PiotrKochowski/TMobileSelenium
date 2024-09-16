package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.Base;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class Hook extends Base {

    private static PrintStream originalOut;
    private static PrintStream originalErr;


    @Before
    public void before(Scenario scenario) throws Exception {
        setupExceptionHandler();
        deleteFile("console.log");
        deleteFile("selenium.log");
        redirectSystemStreams();
        super.testStart();
        logger.info("==========================================================================================");
        logger.info("Scenario name: " + scenario.getName());
        logger.info("==========================================================================================");
    }

    @After
    public void afterTest(Scenario scenario) {
        logger.info("==========================================================================================");
        if (scenario.isFailed()) {
            logger.error("Scenario name: " + scenario.getName() + " finished with result: " + scenario.getStatus());
        } else {
            logger.info("Scenario name: " + scenario.getName() + " finished with result: " + scenario.getStatus());
        }
        logger.info("==========================================================================================");
        restoreSystemStreams();
        super.afterTest();
    }

    public static void redirectSystemStreams() throws Exception {
        File logFile = new File("target/logs/console.log");
        FileOutputStream fos = new FileOutputStream(logFile, true);
        PrintStream ps = new PrintStream(fos);

        originalOut = System.out;
        originalErr = System.err;

        System.setOut(ps);
        System.setErr(ps);
    }

    public static void restoreSystemStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }
}
