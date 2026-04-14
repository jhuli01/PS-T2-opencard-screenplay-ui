package edu.pe.cibertec.stepdefinitions;

import edu.pe.cibertec.questions.ContadorDelCarrito;
import edu.pe.cibertec.tasks.AgregarAlCarrito;
import edu.pe.cibertec.ui.CarritoPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.*;

public class CarritoStepDefinitions {
    @Managed
    private WebDriver browser;

    private Actor user;

    @Before
    public void setUp() {
        user = Actor.named("User").whoCan(BrowseTheWeb.with(browser));
    }


    @When("the user adds the product {string} to the cart")
    public void the_user_adds_the_product_to_the_cart(String product) {
        user.attemptsTo(AgregarAlCarrito.withProduct(product));
    }

    @Then("the cart should show {string}")
    public void the_cart_should_show(String expectedText) {
        user.should(seeThat(ContadorDelCarrito.totalText(), containsString(expectedText)));
    }

    @And("navigates to the cart")
    public void navigates_to_the_cart() {
        user.attemptsTo(Open.url(CarritoPage.CART_URL));
    }

    @Then("the user should see the product {string} in the cart list")
    public void the_user_should_see_the_product_in_the_cart_list(String product) {
        user.should(seeThat(ContadorDelCarrito.productosEnCarrito(), hasItem(containsString(product))));
    }
}
