package com.spaceadvisor.screenplay.interactions.destination;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.Keys;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class EnterPrice implements Interaction {

    private final Target field;
    private final String value;

    public EnterPrice(Target field, String value) {
        this.field = field;
        this.value = value;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Clear.field(field),
                Enter.theValue(value).into(field),
                Enter.keyValues(Keys.ENTER).into(field)
        );
    }

    public static EnterPrice into(Target field, String value) {
        return instrumented(EnterPrice.class, field, value);
    }
}

