package com.spaceadvisor.screenplay.ui.destination;

import net.serenitybdd.screenplay.targets.Target;

public class DestinationUI {
    public static final Target LOAD_MORE_BUTTON = Target.the("Load more button")
            .locatedBy("//button[@data-react-toolbox='button' and normalize-space(.)='Load more']");

}
