package com.spaceadvisor.screenplay.ui.checkout;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CheckoutUI {

    public static final Target NAME_FIELD = Target.the("Full name field")
            .located(By.xpath("//span[normalize-space(.)='Name']/preceding-sibling::input"));

    public static final Target EMAIL_FIELD = Target.the("Email address field")
            .located(By.xpath("//span[normalize-space(.)='Email Address']/preceding-sibling::input"));

    public static final Target SOCIAL_SECURITY_FIELD = Target.the("Social security number field")
            .located(By.xpath("//span[normalize-space(.)='Social Security Number']/preceding-sibling::input"));

    public static final Target PHONE_FIELD = Target.the("Phone number field")
            .located(By.xpath("//span[normalize-space(.)='Phone Number']/preceding-sibling::input"));

    public static final Target PROMO_CODE_FIELD = Target.the("Promo code field")
            .located(By.xpath("//input[@name='promo']"));

    public static final Target APPLY_PROMO_BUTTON = Target.the("Apply promo button")
            .located(By.xpath("//button[contains(@class,'OrderSummary__apply-button')]"));

    public static final Target PAY_NOW_BUTTON = Target.the("Pay now button")
            .located(By.xpath("//button[contains(@class,'OrderSummary__pay-button')]"));

    public static final Target TERMS_CHECKBOX = Target.the("Terms and conditions checkbox")
            .located(By.xpath("//div[@data-react-toolbox='check']"));

    public static final Target BOOKING_CONFIRMATION_MESSAGE = Target.the("Booking confirmation message")
            .located(By.xpath("//*[contains(text(),'Destination Booked')]"));

    public static final Target FILE_INPUT = Target.the("file upload input")
            .locatedBy("//div[contains(@class,'CustomerInfo__dropzone')]/input[@type='file']");

    public static final Target ORDER_DATES = Target.the("Dates value")
            .located(By.xpath("//div[contains(@class,'OrderSummary__order-summary')]//div[contains(text(),'Dates')]/following-sibling::div"));

    public static final Target ORDER_TRAVELERS = Target.the("order summary travelers label")
            .located(By.xpath("//div[contains(@class,'OrderSummary__order-summary')]//div[contains(normalize-space(text()),'traveler')]"));

    public static final Target ORDER_TRAVELERS_PRICE_UNITARY = Target.the("order summary travelers price")
            .located(By.xpath("//div[contains(@class,'OrderSummary__order-summary')]//div[contains(normalize-space(text()),'traveler')]/following-sibling::div"));

    public static final Target ORDER_TOTAL_PRICE = Target.the("order summary total price")
            .located(By.xpath("//div[contains(@class,'OrderSummary__order-summary')]//div[contains(@class,'OrderSummary__price')]//strong"));

    public static final Target TERMS_AND_CONDITIONS_MESSAGE = Target.the("Terms and Conditions message")
            .locatedBy("//*[text()='Terms and Conditions']/following-sibling::p");

}