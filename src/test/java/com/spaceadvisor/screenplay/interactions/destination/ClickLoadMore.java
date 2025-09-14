package com.spaceadvisor.screenplay.interactions.destination;

import com.spaceadvisor.screenplay.ui.destination.DestinationUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

public class ClickLoadMore implements Interaction {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(DestinationUI.LOAD_MORE_BUTTON, isClickable())
                        .forNoMoreThan(8).seconds(),
                Click.on(DestinationUI.LOAD_MORE_BUTTON)
        );
    }

    public static ClickLoadMore button() {
        return instrumented(ClickLoadMore.class);
    }
}
