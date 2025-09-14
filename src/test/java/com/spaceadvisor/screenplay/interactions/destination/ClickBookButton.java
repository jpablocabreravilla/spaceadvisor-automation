package com.spaceadvisor.screenplay.interactions.destination;

import com.spaceadvisor.screenplay.ui.destination.CardUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

public class ClickBookButton implements Interaction {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(CardUI.BOOK_BUTTON)
        );
    }

    public static ClickBookButton click() {
        return Tasks.instrumented(ClickBookButton.class);
    }
}
