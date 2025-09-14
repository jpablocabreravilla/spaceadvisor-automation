package com.spaceadvisor.screenplay.interactions.destination;

import com.spaceadvisor.screenplay.ui.destination.FiltersUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

public class ClickColor implements Interaction {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(FiltersUI.COLOR_DROPDOWN)
        );
    }

    public static ClickColor button() {
        return Tasks.instrumented(ClickColor.class);
    }
}
