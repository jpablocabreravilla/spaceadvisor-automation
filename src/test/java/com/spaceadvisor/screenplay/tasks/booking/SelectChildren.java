package com.spaceadvisor.screenplay.tasks.booking;

import com.spaceadvisor.screenplay.ui.booking.SearchOptionsUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SelectChildren implements Task {

    private final String amount;

    public SelectChildren(String amount) {
        int value = Integer.parseInt(amount);
        if (value < 0 || value > 7) {
            throw new IllegalArgumentException("The number of children must be between 0 and 7. Received: " + amount);
        }
        this.amount = amount;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(SearchOptionsUI.CHILDREN_DROPDOWN),
                Click.on(SearchOptionsUI.CHILDREN_OPTION(amount))
        );
    }

    public static SelectChildren withAmount(String amount) {
        return instrumented(SelectChildren.class, amount);
    }
}
