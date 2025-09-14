package com.spaceadvisor.stepdefinitions.spaceadvisor;

import com.spaceadvisor.screenplay.interactions.checkout.AcceptTerms;
import com.spaceadvisor.screenplay.interactions.checkout.ClickPayNow;
import com.spaceadvisor.screenplay.interactions.destination.ClickBookButton;
import com.spaceadvisor.screenplay.interactions.destination.ClickDestination;
import com.spaceadvisor.screenplay.interactions.destination.ClickLoadMore;
import com.spaceadvisor.screenplay.questions.checkout.ConfirmationMessage;
import com.spaceadvisor.screenplay.tasks.booking.SelectAdults;
import com.spaceadvisor.screenplay.tasks.booking.SelectChildren;
import com.spaceadvisor.screenplay.tasks.booking.SelectDate;
import com.spaceadvisor.screenplay.tasks.checkout.ApplyPromoCode;
import com.spaceadvisor.screenplay.tasks.checkout.FillOutBasicForm;
import com.spaceadvisor.screenplay.tasks.checkout.UploadFile;
import com.spaceadvisor.screenplay.tasks.destination.FilterByPrice;
import com.spaceadvisor.screenplay.tasks.destination.FilterDestination;
import com.spaceadvisor.screenplay.tasks.general.OpenApplication;
import com.spaceadvisor.screenplay.ui.booking.SearchOptionsUI;
import com.spaceadvisor.utilities.DateFormatter;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.google.common.base.Predicates.equalTo;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class AgendarViajeStepsDef {

    @Given("el usuario ingresa a la web de reservas")
    public void elUsuarioIngresaALaWebDeReservas() {
        theActorInTheSpotlight().attemptsTo(
                OpenApplication.inTheBrowser()
        );
    }

    @When("selecciona fechas de partida {string} y regreso {string}")
    public void seleccionaFechas(String departure, String returning) {
        var departureDate = DateFormatter.convert(departure);   // dd/MM/yyyy
        var returnDate = DateFormatter.convert(returning);

        //theActorInTheSpotlight().remember("DEPARTURE", departureDate);
        //theActorInTheSpotlight().remember("RETURN",    returnDate);

        // ------ Departure ------
        theActorInTheSpotlight().attemptsTo(
                SelectDate.on(
                        SearchOptionsUI.DEPARTING_FIELD,
                        DateFormatter.getDay(departureDate),
                        DateFormatter.getMonthName(departureDate),
                        DateFormatter.getYear(departureDate)
                )
        );

        // ------ Return ------
        theActorInTheSpotlight().attemptsTo(
                SelectDate.on(
                        SearchOptionsUI.RETURNING_FIELD,
                        DateFormatter.getDay(returnDate),
                        DateFormatter.getMonthName(returnDate),
                        DateFormatter.getYear(returnDate)
                )
        );
    }

    @When("define pasajeros adultos {string} y ninos {string}")
    public void definePasajeros(String adults, String children) {
        theActorInTheSpotlight().attemptsTo(
                SelectAdults.withAmount(adults),
                SelectChildren.withAmount(children)
        );
    }

    @And("pulsa el boton Select Destination y luego el boton Load More")
    public void pulsaElBotonSelectDestinationYLuegoElBotonLoadMore() {
        theActorInTheSpotlight().attemptsTo(
                ClickDestination.button(),
                ClickLoadMore.button()
        );
    }

    @When("filtra por precio minimo {string} y maximo {string}")
    public void filtraPorPrecio(String minPrice, String maxPrice) {
        theActorInTheSpotlight().attemptsTo(
                FilterByPrice.withRange(minPrice, maxPrice)
        );
    }

    @When("elige el destino {string}")
    public void eligeElDestino(String destination) {
        theActorInTheSpotlight().attemptsTo(
                FilterDestination.by(destination),
                ClickBookButton.click()
        );
    }

    @When("completa el formulario con nombre {string}, email {string}, ssn {string}, telefono {string}")
    public void completaElFormulario(String name, String email, String ssn, String phone) {
        theActorInTheSpotlight().attemptsTo(
                FillOutBasicForm.with(name, email, ssn, phone)
        );
    }

    @When("adjunta archivo al formulario {string}")
    public void adjuntaArchivoAlFormulario(String filePath) {
        theActorInTheSpotlight().attemptsTo(
                UploadFile.withPath(filePath)
        );
    }

    @When("aplica el cupon {string}")
    public void aplicaElCupon(String coupon) {
        theActorInTheSpotlight().attemptsTo(
                ApplyPromoCode.with(coupon)
        );
    }

    @When("acepta los terminos y condiciones y pagar")
    public void aceptaLosTerminosYCondicionesYPagar() {
        theActorInTheSpotlight().attemptsTo(
                AcceptTerms.now(),
                ClickPayNow.button()
        );
    }

    @Then("deberia ver el mensaje {string}")
    public void deberiaVerElMensaje(String expectedMessage) {
        theActorInTheSpotlight().should(
                seeThat("confirmation message", ConfirmationMessage.value(), equalTo(expectedMessage))
        );
    }

    @Then("Pause")
    public void pause() throws InterruptedException {
        Thread.sleep(5000);
    }
}
