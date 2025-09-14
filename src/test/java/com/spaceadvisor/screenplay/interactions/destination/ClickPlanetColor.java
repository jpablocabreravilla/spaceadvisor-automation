package com.spaceadvisor.screenplay.interactions.destination;

import com.spaceadvisor.screenplay.ui.destination.DestinationUI;
import com.spaceadvisor.screenplay.ui.destination.FiltersUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

public class ClickPlanetColor implements Interaction {

    private final String color;

    public ClickPlanetColor(String color) {
        this.color = color;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(FiltersUI.COLOR_OPTION(color))
        );
    }

    public static ClickPlanetColor of(String color) {
        return Tasks.instrumented(ClickPlanetColor.class, color);
    }
}
