package com.spaceadvisor.screenplay.interactions.checkout;

import com.spaceadvisor.screenplay.ui.checkout.CheckoutUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

public class ClickPayNow implements Interaction {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(CheckoutUI.PAY_NOW_BUTTON)
        );
    }

    public static ClickPayNow button() {
        return Tasks.instrumented(ClickPayNow.class);
    }
}