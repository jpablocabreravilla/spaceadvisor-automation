package com.spaceadvisor.screenplay.ui.destination;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class CardUI {

    public static final Target BOOK_BUTTON = Target.the("Book button")
            .located(By.xpath("//button[contains(@class,'BookButton__accent')]"));


}
