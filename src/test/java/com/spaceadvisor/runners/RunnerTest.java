package com.spaceadvisor.runners;

import net.serenitybdd.cucumber.CucumberWithSerenity;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {
                "com.spaceadvisor.stepdefinitions",
                "com.spaceadvisor.stepdefinitions.hooks",
                "net.serenitybdd.cucumber.actors"
        },
        tags = "@AgendarViaje",
        plugin = {"pretty"},
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class RunnerTest {
}
