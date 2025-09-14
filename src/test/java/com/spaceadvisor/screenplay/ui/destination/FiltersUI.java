package com.spaceadvisor.screenplay.ui.destination;

import net.serenitybdd.screenplay.targets.Target;

public class FiltersUI {

    public static final Target MIN_PRICE_FIELD = Target.the("Minimum price input field")
            .locatedBy("//div[contains(@class,'Gallery__price-filter___')]//input[@role='input' and @name='name']");

    public static final Target MAX_PRICE_FIELD = Target.the("Maximum price input field")
            .locatedBy("//div[contains(@class,'Gallery__price-filter___')]//div[contains(@class,'PurpleSlider__input')]//input[@role='input' and not(@name)]");

    public static final Target LAUNCH_DROPDOWN = Target.the("Launch dropdown")
            .locatedBy("//div[contains(@class,'Gallery__filters-box')]//div[contains(@class,'Gallery__dropdown')]//input[@value='Launch']");

    public static Target LAUNCH_OPTION(String option) {
        return Target.the("Launch option '" + option + "'")
                .locatedBy("//ul[contains(@class,'theme__values')]//li[normalize-space(.)='{0}']")
                .of(option);
    }

}
