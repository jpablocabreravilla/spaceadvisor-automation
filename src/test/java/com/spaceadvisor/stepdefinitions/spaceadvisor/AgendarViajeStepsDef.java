package com.spaceadvisor.stepdefinitions.spaceadvisor;

import com.spaceadvisor.models.OrderSummary;
import com.spaceadvisor.screenplay.interactions.checkout.AcceptTerms;
import com.spaceadvisor.screenplay.interactions.checkout.ClickPayNow;
import com.spaceadvisor.screenplay.interactions.destination.ClickBookButton;
import com.spaceadvisor.screenplay.interactions.destination.ClickDestination;
import com.spaceadvisor.screenplay.interactions.destination.ClickLoadMore;
import com.spaceadvisor.screenplay.questions.checkout.ConfirmationMessage;
import com.spaceadvisor.screenplay.questions.checkout.TermsAndConditionsMessage;
import com.spaceadvisor.screenplay.questions.checkout.TheOrderSummary;
import com.spaceadvisor.screenplay.tasks.booking.SelectAdults;
import com.spaceadvisor.screenplay.tasks.booking.SelectChildren;
import com.spaceadvisor.screenplay.tasks.booking.SelectDate;
import com.spaceadvisor.screenplay.tasks.checkout.ApplyPromoCode;
import com.spaceadvisor.screenplay.tasks.checkout.FillOutBasicForm;
import com.spaceadvisor.screenplay.tasks.checkout.UploadFile;
import com.spaceadvisor.screenplay.tasks.destination.FilterByColor;
import com.spaceadvisor.screenplay.tasks.destination.FilterByPrice;
import com.spaceadvisor.screenplay.tasks.destination.FilterDestination;
import com.spaceadvisor.screenplay.tasks.general.OpenApplication;
import com.spaceadvisor.screenplay.ui.booking.SearchOptionsUI;
import com.spaceadvisor.utilities.DateFormatter;

import static com.spaceadvisor.utilities.ParseMoney.formatUSD;
import static com.spaceadvisor.utilities.ParseMoney.parseUnitPrice;
import static org.hamcrest.MatcherAssert.assertThat;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.time.LocalDate;
import java.time.temporal.TemporalAccessor;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;

public class AgendarViajeStepsDef {

    @Given("el usuario ingresa a la web de reservas")
    public void elUsuarioIngresaALaWebDeReservas() {
        theActorInTheSpotlight().attemptsTo(
                OpenApplication.inTheBrowser()
        );
    }

    @When("selecciona fechas de partida {string} y regreso {string}")
    public void seleccionaFechas(String departure, String returning) {
        var departureDate = DateFormatter.convert(departure);
        var returnDate = DateFormatter.convert(returning);

        theActorInTheSpotlight().attemptsTo(
                SelectDate.on(
                        SearchOptionsUI.DEPARTING_FIELD,
                        DateFormatter.getDay(departureDate),
                        DateFormatter.getMonthName(departureDate),
                        DateFormatter.getYear(departureDate)
                )
        );

        theActorInTheSpotlight().attemptsTo(
                SelectDate.on(
                        SearchOptionsUI.RETURNING_FIELD,
                        DateFormatter.getDay(returnDate),
                        DateFormatter.getMonthName(returnDate),
                        DateFormatter.getYear(returnDate)
                )
        );

        theActorInTheSpotlight().remember("DEPARTURE", departureDate);
        theActorInTheSpotlight().remember("RETURNING", returnDate);
    }

    @When("define pasajeros adultos {string} y ninos {string}")
    public void definePasajeros(String adults, String children) {
        theActorInTheSpotlight().attemptsTo(
                SelectAdults.withAmount(adults),
                SelectChildren.withAmount(children)
        );

        theActorInTheSpotlight().remember("ADULTS", adults);
        theActorInTheSpotlight().remember("CHILDRENS", children);
    }

    @When("pulsa el boton Select Destination y luego el boton Load More")
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

    @And("filtra por el destino {string}")
    public void filtraPorElDestino(String destination) {
        theActorInTheSpotlight().attemptsTo(
                FilterDestination.by(destination)
        );

        theActorInTheSpotlight().remember("DESTINATION", destination);
    }

    @When("elige el color del planeta  {string}")
    public void eligeElColorDelPlaneta(String color) throws InterruptedException {
        theActorInTheSpotlight().attemptsTo(
                FilterByColor.with(color)
        );
    }


    @And("selecciona la tarjeta filtrada")
    public void seleccionaLaTarjetaFiltrada() {
        theActorInTheSpotlight().attemptsTo(
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

    @When("acepta los terminos y condiciones")
    public void aceptaLosTerminosYCondiciones() {
        theActorInTheSpotlight().attemptsTo(
                AcceptTerms.now()
        );
    }

    @When("finalizar el pago")
    public void finalizarElPago() {
        theActorInTheSpotlight().attemptsTo(
                ClickPayNow.button()
        );
    }

    @Then("deberia ver el mensaje {string}")
    public void deberiaVerElMensaje(String expectedMessage) {
        theActorInTheSpotlight().should(
                seeThat("confirmation message", ConfirmationMessage.value(), equalTo(expectedMessage))
        );
    }

    @Then("los datos de la orden de compra deben ser correctos")
    public void losDatosDeLaOrdenDeCompraDebenSerCorrectos() {
        var departure = (TemporalAccessor) theActorInTheSpotlight().recall("DEPARTURE");
        var returning = (TemporalAccessor) theActorInTheSpotlight().recall("RETURNING");
        var adults = Integer.parseInt(theActorInTheSpotlight().recall("ADULTS"));
        var childrens = Integer.parseInt(theActorInTheSpotlight().recall("CHILDRENS"));

        OrderSummary summaryFront = theActorInTheSpotlight().asksFor(TheOrderSummary.displayed());

        double expectedUnitPrice = parseUnitPrice(summaryFront.getUnitPrice());

        int travelersCount = adults + childrens;
        String expectedTravelers = travelersCount + (travelersCount == 1 ? " traveler" : " travelers");

        String expectedDateRange = DateFormatter.formatRange(LocalDate.from(departure), LocalDate.from(returning));

        assertThat(summaryFront.getDates(), equalTo(expectedDateRange));
        assertThat(summaryFront.getTravelers(), equalTo(expectedTravelers));
        assertThat(summaryFront.getUnitPrice(), equalTo(formatUSD(expectedUnitPrice)));
    }

    @Then("se debe desplegar una alerta con el mensaje {string}")
    public void seDebeDesplegarUnaAlertaConElMensaje(String expectedMessage) {
        theActorInTheSpotlight().should(seeThat(TermsAndConditionsMessage.text(), equalTo(expectedMessage)));
    }

}
