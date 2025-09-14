package com.spaceadvisor.screenplay.tasks.booking;

import com.spaceadvisor.screenplay.ui.booking.SearchOptionsUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SelectAdults implements Task {

    private final String amount;

    public SelectAdults(String amount) {
        int value = Integer.parseInt(amount);
        if (value < 1 || value > 4) {
            throw new IllegalArgumentException("The number of adults must be between 1 and 4. Received: " + amount);
        }
        this.amount = amount;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(SearchOptionsUI.ADULTS_DROPDOWN),
                Click.on(SearchOptionsUI.ADULTS_OPTION(amount))
        );
    }

    public static SelectAdults withAmount(String amount) {
        return instrumented(SelectAdults.class, amount);
    }
}
