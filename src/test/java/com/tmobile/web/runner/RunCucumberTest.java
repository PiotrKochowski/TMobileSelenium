package com.tmobile.web.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com.tmobile.web",
        plugin = {"pretty", "html:target/cucumber-report/cucumber.html"},
        tags = "@test1"
)
public class RunCucumberTest {
}