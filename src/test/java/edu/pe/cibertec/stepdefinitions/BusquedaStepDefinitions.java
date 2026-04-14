package edu.pe.cibertec.stepdefinitions;

import edu.pe.cibertec.questions.ResultadosDeBusqueda;
import edu.pe.cibertec.tasks.BuscarProducto;
import edu.pe.cibertec.ui.BusquedaPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.questions.Text;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.*;

public class BusquedaStepDefinitions {

    @Managed
    private WebDriver browser;

    private Actor user;

    @Before
    public void setUp() {
        user = Actor.named("User").whoCan(BrowseTheWeb.with(browser));
    }

    @Given("the user is on the OpenCart home page")
    public void the_user_is_on_the_OpenCart_home_page() {
        user.attemptsTo(Open.url(BusquedaPage.URL));
    }

    @When("the user searches for the product {string}")
    public void the_user_searches_for_the_product(String product) {
        user.attemptsTo(BuscarProducto.withSearch(product));
    }

    @Then("the user should see at least one result with the name {string}")
    public void the_user_should_see_at_least_one_result_with_name(String product) {
        user.should(seeThat(ResultadosDeBusqueda.obtenerNombres(), hasItem(containsString(product))));
    }


}
