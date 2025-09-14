package com.spaceadvisor.screenplay.interactions.destination;

import com.spaceadvisor.screenplay.ui.destination.FiltersUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ClickLaunch implements Interaction {

    private final String option;

    public ClickLaunch(String option) {
        this.option = option;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(FiltersUI.LAUNCH_DROPDOWN),
                Click.on(FiltersUI.LAUNCH_OPTION(option))
        );
    }

    public static ClickLaunch on(String option) {
        return instrumented(ClickLaunch.class, option);
    }
}