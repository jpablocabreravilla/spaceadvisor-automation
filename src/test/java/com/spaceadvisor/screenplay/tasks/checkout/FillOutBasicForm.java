package com.spaceadvisor.screenplay.tasks.checkout;

import com.spaceadvisor.screenplay.ui.checkout.CheckoutUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;

public class FillOutBasicForm implements Task {

    private final String name;
    private final String email;
    private final String ssn;
    private final String phone;

    public FillOutBasicForm(String name, String email, String ssn, String phone) {
        this.name = name;
        this.email = email;
        this.ssn = ssn;
        this.phone = phone;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(name).into(CheckoutUI.NAME_FIELD),
                Enter.theValue(email).into(CheckoutUI.EMAIL_FIELD),
                Enter.theValue(ssn).into(CheckoutUI.SOCIAL_SECURITY_FIELD),
                Enter.theValue(phone).into(CheckoutUI.PHONE_FIELD)
        );
    }

    public static FillOutBasicForm with(String name, String email, String ssn, String phone) {
        return Tasks.instrumented(FillOutBasicForm.class, name, email, ssn, phone);
    }
}
