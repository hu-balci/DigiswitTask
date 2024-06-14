package com.digiswit.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com/digiswit/stepdefinitions/",
        dryRun = false,
        tags = "@addItem"
)
public class CukesRunner {
}
