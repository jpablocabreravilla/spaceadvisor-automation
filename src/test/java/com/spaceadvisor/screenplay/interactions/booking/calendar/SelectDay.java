package com.spaceadvisor.screenplay.interactions.booking.calendar;

import com.spaceadvisor.screenplay.ui.booking.CalendarUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

public class SelectDay implements Interaction {

    private final String day;

    public SelectDay(String day) {
        this.day = day;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(CalendarUI.DAY_ITEM(day), isClickable()).forNoMoreThan(8).seconds(),
                Click.on(CalendarUI.DAY_ITEM(day))
        );
    }

    public static SelectDay of(String day) {
        return instrumented(SelectDay.class, day);
    }
}
