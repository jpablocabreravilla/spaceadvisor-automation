package com.spaceadvisor.stepdefinitions.spaceadvisor;

import com.spaceadvisor.screenplay.tasks.booking.SelectAdults;
import com.spaceadvisor.screenplay.tasks.booking.SelectChildren;
import com.spaceadvisor.screenplay.tasks.booking.SelectDate;
import com.spaceadvisor.screenplay.tasks.general.OpenApplication;
import com.spaceadvisor.screenplay.ui.booking.SearchOptionsUI;
import com.spaceadvisor.utilities.DateFormatter;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

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
        var returnDate    = DateFormatter.convert(returning);

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

    @When("pulsa en SELECT DESTINATION y luego LOAD MORE")
    public void pulsaEnSelectDestinationYLuegoLoadMore() {
    }

    @When("filtra por precio minimo {string} y maximo {string}")
    public void filtraPorPrecio(String minPrice, String maxPrice) {
    }

    @When("elige el destino {string}")
    public void eligeElDestino(String destination) {
    }

    @When("completa el formulario con nombre {string}, email {string}, ssn {string}, telefono {string}")
    public void completaElFormulario(String name, String email, String ssn, String phone) {
    }

    @When("adjunta archivo al formulario {string}")
    public void adjuntaArchivoAlFormulario(String filePath) {
    }

    @When("aplica el cupon {string}")
    public void aplicaElCupon(String coupon) {
    }

    @When("acepta los terminos y condiciones y pagar")
    public void aceptaLosTerminosYCondicionesYPagar() {
    }

    @Then("deberia ver el mensaje {string}")
    public void deberiaVerElMensaje(String expectedMessage) {
    }
}
