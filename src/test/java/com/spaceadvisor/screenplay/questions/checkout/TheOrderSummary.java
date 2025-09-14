package com.spaceadvisor.screenplay.questions.checkout;

import com.spaceadvisor.models.OrderSummary;
import com.spaceadvisor.screenplay.ui.checkout.CheckoutUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class TheOrderSummary implements Question<OrderSummary> {

    @Override
    public OrderSummary answeredBy(Actor actor) {
        String dates = CheckoutUI.ORDER_DATES.resolveFor(actor).getText();
        String travelers = CheckoutUI.ORDER_TRAVELERS.resolveFor(actor).getText();
        String unitPrice = CheckoutUI.ORDER_TRAVELERS_PRICE_UNITARY.resolveFor(actor).getText();
        String totalPrice = CheckoutUI.ORDER_TOTAL_PRICE.resolveFor(actor).getText();

        return new OrderSummary(dates, travelers, unitPrice, totalPrice);
    }

    public static TheOrderSummary displayed() {
        return new TheOrderSummary();
    }
}