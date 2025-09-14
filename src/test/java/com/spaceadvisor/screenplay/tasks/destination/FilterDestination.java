package com.spaceadvisor.screenplay.tasks.destination;

import com.spaceadvisor.screenplay.interactions.destination.ClickDestination;
import com.spaceadvisor.screenplay.interactions.destination.ClickLaunch;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class FilterDestination implements Task {

    private final String destination;

    public FilterDestination(String destination) {
        this.destination = destination;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                ClickLaunch.on(destination),
                ClickDestination.button()
        );
    }

    public static FilterDestination by(String destination) {
        return instrumented(FilterDestination.class, destination);
    }
}

