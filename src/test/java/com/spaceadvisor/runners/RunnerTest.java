package com.spaceadvisor.runners;


import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/",
        tags = "@tag",
        glue = {"stepDefinitions", "net.serenitybdd.cucumber.actors"},
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class RunnerTest {
}