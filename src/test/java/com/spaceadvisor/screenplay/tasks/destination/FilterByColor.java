package com.spaceadvisor.screenplay.tasks.destination;

import com.spaceadvisor.screenplay.interactions.destination.ClickColor;
import com.spaceadvisor.screenplay.interactions.destination.ClickPlanetColor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class FilterByColor implements Task {


    private final String color;

    public FilterByColor(String color) {
        this.color = color;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                ClickColor.button(),
                ClickPlanetColor.of(color)
                );
    }

    public static FilterByColor with(String color) {
        return instrumented(FilterByColor.class, color);
    }
}

