package com.spaceadvisor.screenplay.interactions.booking.calendar;

import com.spaceadvisor.screenplay.ui.booking.CalendarUI;
import com.spaceadvisor.utilities.DateFormatter;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.questions.Text;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SelectMonth implements Interaction {

    private final String targetMonth;

    public SelectMonth(String month) {
        this.targetMonth = month;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        selectMonth(actor);
    }

    private void selectMonth(Actor actor) {
        String currentMonthYear = Text.of(CalendarUI.MONTH_TITLE).answeredBy(actor).trim();
        String currentMonth = currentMonthYear.split("\\s+")[0];

        int currentMonthNum = Integer.parseInt(DateFormatter.getMonthNumber(currentMonth));
        int targetMonthNum = Integer.parseInt(DateFormatter.getMonthNumber(targetMonth));

        int difference = targetMonthNum - currentMonthNum;

        if (difference > 0) {
            for (int i = 0; i < difference; i++) {
                actor.attemptsTo(Click.on(CalendarUI.NEXT_MONTH_BUTTON));
            }
        } else if (difference < 0) {
            for (int i = 0; i < Math.abs(difference); i++) {
                actor.attemptsTo(Click.on(CalendarUI.PREVIOUS_MONTH_BUTTON));
            }
        }
    }

    public static SelectMonth of(String month) {
        return instrumented(SelectMonth.class, month);
    }
}