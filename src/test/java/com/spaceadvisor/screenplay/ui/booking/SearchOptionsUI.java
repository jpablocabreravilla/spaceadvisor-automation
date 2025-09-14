package com.spaceadvisor.screenplay.ui.booking;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class SearchOptionsUI {

    // -------- Date fields --------
    public static final Target DEPARTING_FIELD = Target.the("Departing date field")
            .locatedBy("//label[normalize-space(.)='Departing']/ancestor::*[self::div or self::label][1]//input");

    public static final Target RETURNING_FIELD = Target.the("Returning date field")
            .locatedBy("//label[normalize-space(.)='Returning']/ancestor::*[self::div or self::label][1]//input");

    // -------- Adults dropdown --------
    public static final Target ADULTS_DROPDOWN = Target.the("Adults (18+) dropdown")
            .locatedBy("//div[@data-react-toolbox='dropdown'][.//*[contains(normalize-space(.),'Adults (18+)')]]");

    /**
     * Opción para cantidad de adultos (acepta número o texto)
     */
    public static Target ADULTS_OPTION(String amount) {
        return Target.the("Adults option '" + amount + "'")
                .locatedBy("//li[contains(normalize-space(.),'Adults')]/following-sibling::li[normalize-space(.)='{0}']")
                .of(amount);
    }

    // -------- Children dropdown --------
    public static final Target CHILDREN_DROPDOWN = Target.the("Children (0-7) dropdown")
            .locatedBy("//div[@data-react-toolbox='dropdown'][.//*[contains(normalize-space(.),'Children')]]");

    public static Target CHILDREN_OPTION(String amount) {
        return Target.the("Children option '" + amount + "'")
                .locatedBy("//li[contains(normalize-space(.),'Children')]/following-sibling::li[normalize-space(.)='{0}']")
                .of(amount);
    }

    // -------- Destination button --------
    public static final Target SELECT_DESTINATION_BUTTON = Target.the("Select Destination button")
            .located(By.xpath("//button[normalize-space(.)='Select Destination']"));

}
