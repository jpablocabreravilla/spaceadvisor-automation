package com.spaceadvisor.screenplay.questions.checkout;

import com.spaceadvisor.screenplay.ui.checkout.CheckoutUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.TextContent;

public class ConfirmationMessage implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        return TextContent.of(CheckoutUI.BOOKING_CONFIRMATION_MESSAGE)
                .answeredBy(actor)
                .trim();
    }

    public static ConfirmationMessage value() {
        return new ConfirmationMessage();
    }
}
