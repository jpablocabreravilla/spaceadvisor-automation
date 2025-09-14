package com.spaceadvisor.screenplay.tasks.checkout;

import com.spaceadvisor.screenplay.ui.checkout.CheckoutUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Upload;

import java.nio.file.Path;

public class UploadFile implements Task {

    private final String filePath;

    public UploadFile(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Upload.theFile(Path.of(filePath)).to(CheckoutUI.FILE_INPUT)
        );
    }

    public static UploadFile withPath(String filePath) {
        return Tasks.instrumented(UploadFile.class, filePath);
    }
}
