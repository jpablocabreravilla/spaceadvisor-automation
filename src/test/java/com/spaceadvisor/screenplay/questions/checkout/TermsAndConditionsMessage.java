package com.spaceadvisor.screenplay.questions.checkout;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static com.spaceadvisor.screenplay.ui.checkout.CheckoutUI.TERMS_AND_CONDITIONS_MESSAGE;

public class TermsAndConditionsMessage implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        return TERMS_AND_CONDITIONS_MESSAGE.resolveFor(actor).getText();
    }

    public static TermsAndConditionsMessage text() {
        return new TermsAndConditionsMessage();
    }
}
