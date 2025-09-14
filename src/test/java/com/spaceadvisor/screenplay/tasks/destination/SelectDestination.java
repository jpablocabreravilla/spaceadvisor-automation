package com.spaceadvisor.screenplay.tasks.destination;

import com.spaceadvisor.screenplay.interactions.destination.ClickLaunch;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SelectDestination implements Task {

    private final String destination;

    public SelectDestination(String destination) {
        this.destination = destination;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                ClickLaunch.on(destination)
        );
    }

    public static SelectDestination called(String destination) {
        return instrumented(SelectDestination.class, destination);
    }
}

