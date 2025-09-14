package com.spaceadvisor.screenplay.interactions.checkout;

import com.spaceadvisor.screenplay.ui.checkout.CheckoutUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

public class AcceptTerms implements Interaction {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(CheckoutUI.TERMS_CHECKBOX)
        );
    }

    public static AcceptTerms now() {
        return Tasks.instrumented(AcceptTerms.class);
    }
}
