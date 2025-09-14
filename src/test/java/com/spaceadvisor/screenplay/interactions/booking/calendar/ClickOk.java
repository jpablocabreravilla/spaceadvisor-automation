package com.spaceadvisor.screenplay.interactions.booking.calendar;

import com.spaceadvisor.screenplay.ui.booking.CalendarUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

public class ClickOk implements Interaction {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(CalendarUI.OK_BUTTON, isClickable()).forNoMoreThan(8).seconds(),
                Click.on(CalendarUI.OK_BUTTON)
        );
    }

    public static ClickOk button() {
        return instrumented(ClickOk.class);
    }
}
