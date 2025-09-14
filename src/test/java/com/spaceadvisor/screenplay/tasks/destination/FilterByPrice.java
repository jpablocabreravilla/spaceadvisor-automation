package com.spaceadvisor.screenplay.tasks.destination;

import com.spaceadvisor.screenplay.interactions.destination.EnterPrice;
import com.spaceadvisor.screenplay.ui.destination.DestinationUI;
import com.spaceadvisor.screenplay.ui.destination.FiltersUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;


import static net.serenitybdd.screenplay.Tasks.instrumented;

public class FilterByPrice implements Task {

    private final String min;
    private final String max;

    public FilterByPrice(String min, String max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                // EnterPrice.into(FiltersUI.Min_PRICE_FIELD, min), --> BUG: missing min input
                EnterPrice.into(FiltersUI.MAX_PRICE_FIELD, max)
        );
    }

    public static FilterByPrice withRange(String min, String max) {
        return instrumented(FilterByPrice.class, min, max);
    }
}
