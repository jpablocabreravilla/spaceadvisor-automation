package com.spaceadvisor.screenplay.ui.booking;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CalendarUI{

    // --- Static elements ---
    public static final Target YEAR_SELECTOR = Target.the("year selector")
            .located(By.id("years"));

    public static final Target MONTH_TITLE = Target.the("month and year title")
            .locatedBy("//div[@data-react-toolbox='month']//span[contains(@class,'title')]");

    public static final Target NEXT_MONTH_BUTTON = Target.the("next month button")
            .located(By.id("right"));

    public static final Target PREVIOUS_MONTH_BUTTON = Target.the("previous month button")
            .located(By.id("left"));

    public static final Target OK_BUTTON = Target.the("calendar OK button")
            .located(By.xpath("//button[@data-react-toolbox='button' and normalize-space()='Ok']"));

    // --- Dynamic elements ---
    public static Target YEAR_ITEM(String year) {
        return Target.the("year option '" + year + "'")
                .locatedBy("//ul[@data-react-toolbox='years']//li[@id='{0}']").of(year);
    }

    public static Target MONTH_ITEM(String month) {
        return Target.the("month option '" + month + "'")
                .locatedBy("//ul[@data-react-toolbox='months']//li[@id='{0}']").of(month);
    }

    public static Target DAY_ITEM(String day) {
        return Target.the("day option '" + day + "'")
                .locatedBy("//div[@data-react-toolbox='day' and not(contains(@class,'disabled'))]//span[normalize-space()='{0}']")
                .of(day);
    }
}