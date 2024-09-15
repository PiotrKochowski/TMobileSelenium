package com.tmobile.web;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.Base;

import java.io.File;
import java.io.IOException;

public class Hook extends Base {


    @Before
    public void before(Scenario scenario) throws IOException {
        deleteFile();
        logger.info("log w hook2");
        super.starTest(scenario);
    }

    @After
    public void afterTest(Scenario scenario) {
        super.afterTest(scenario);
    }

    public void deleteFile() {
        File logFile = new File("target/logs/selenium.log");
        if (logFile.exists()) {
            if (!logFile.delete()) {
                logger.error("Nie udało się usunąć pliku logów: " + logFile.getAbsolutePath());
            }
        }
    }
}
