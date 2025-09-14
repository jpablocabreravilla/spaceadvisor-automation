package com.spaceadvisor.screenplay.interactions.destination;

import com.spaceadvisor.screenplay.ui.booking.SearchOptionsUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

public class SelectDestination implements Interaction {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(SearchOptionsUI.SELECT_DESTINATION_BUTTON, isClickable())
                        .forNoMoreThan(8).seconds(),
                Click.on(SearchOptionsUI.SELECT_DESTINATION_BUTTON)
        );
    }

    public static SelectDestination click() {
        return instrumented(SelectDestination.class);
    }
}