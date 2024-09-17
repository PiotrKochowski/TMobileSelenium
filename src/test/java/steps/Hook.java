package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.Base;

public class Hook extends Base {

    @Before
    public void before(Scenario scenario) {
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
        super.afterTest();
    }
}
