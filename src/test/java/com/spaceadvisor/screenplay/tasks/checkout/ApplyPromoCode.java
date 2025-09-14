package com.spaceadvisor.screenplay.tasks.checkout;


import com.spaceadvisor.screenplay.ui.checkout.CheckoutUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;

public class ApplyPromoCode implements Task {

    private final String promoCode;

    public ApplyPromoCode(String promoCode) {
        this.promoCode = promoCode;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(promoCode).into(CheckoutUI.PROMO_CODE_FIELD),
                WaitUntil.the(CheckoutUI.PROMO_CODE_FIELD, isEnabled()).forNoMoreThan(5).seconds(),
                Click.on(CheckoutUI.APPLY_PROMO_BUTTON)
        );
    }

    public static ApplyPromoCode with(String promoCode) {
        return Tasks.instrumented(ApplyPromoCode.class, promoCode);
    }
}
