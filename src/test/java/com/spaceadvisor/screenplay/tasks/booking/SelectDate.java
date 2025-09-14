package com.spaceadvisor.screenplay.tasks.booking;


import com.spaceadvisor.screenplay.interactions.booking.calendar.ClickOk;
import com.spaceadvisor.screenplay.interactions.booking.calendar.SelectDay;
import com.spaceadvisor.screenplay.interactions.booking.calendar.SelectMonth;
import com.spaceadvisor.screenplay.interactions.booking.calendar.SelectYear;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SelectDate implements Task {

    private final Target dateField;
    private final String day;
    private final String month;
    private final String year;

    public SelectDate(Target dateField, String day, String month, String year) {
        this.dateField = dateField;
        this.day = day;
        this.month = month;
        this.year = year;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(dateField),
                SelectYear.of(year),
                SelectMonth.of(month),
                SelectDay.of(day),
                ClickOk.button()
        );
    }

    public static SelectDate on(Target dateField, String day, String month, String year) {
        return instrumented(SelectDate.class, dateField, day, month, year);
    }
}