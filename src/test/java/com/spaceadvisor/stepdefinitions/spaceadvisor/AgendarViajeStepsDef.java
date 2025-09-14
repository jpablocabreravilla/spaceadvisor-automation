package com.spaceadvisor.stepdefinitions.spaceadvisor;

import com.spaceadvisor.screenplay.tasks.general.OpenApplication;
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
    }

    @When("define pasajeros adultos {string} y ninos {string}")
    public void definePasajeros(String adults, String children) {
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
