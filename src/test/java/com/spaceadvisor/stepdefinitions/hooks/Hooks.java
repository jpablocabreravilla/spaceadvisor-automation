package com.spaceadvisor.stepdefinitions.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.actors.OnStage.drawTheCurtain;
import static net.serenitybdd.screenplay.actors.OnStage.setTheStage;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;

public class Hooks {

    @Managed
    WebDriver driver;

    @Before(order = 0)
    public void setUpStage() {
        setTheStage(new OnlineCast());
    }

    @Before(order = 1)
    public void prepareActor() {
        theActorCalled("Usuario").can(BrowseTheWeb.with(driver));
    }

    @After
    public void tearDown() {
        drawTheCurtain();
    }
}
