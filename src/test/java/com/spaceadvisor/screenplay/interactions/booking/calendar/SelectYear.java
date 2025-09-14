package com.spaceadvisor.screenplay.interactions.booking.calendar;

import com.spaceadvisor.screenplay.ui.booking.CalendarUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

public class SelectYear implements Interaction {

    private final String year;

    public SelectYear(String year) {
        this.year = year;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(CalendarUI.YEAR_SELECTOR),
                WaitUntil.the(CalendarUI.YEAR_ITEM(year), isClickable()).forNoMoreThan(8).seconds(),
                Click.on(CalendarUI.YEAR_ITEM(year))
        );
    }

    public static SelectYear of(String year) {
        return instrumented(SelectYear.class, year);
    }
}
