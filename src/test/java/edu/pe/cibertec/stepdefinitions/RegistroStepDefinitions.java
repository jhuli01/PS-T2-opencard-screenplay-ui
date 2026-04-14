package edu.pe.cibertec.stepdefinitions;

import edu.pe.cibertec.tasks.RegistrarseComo;
import edu.pe.cibertec.ui.RegistroPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.questions.Text;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.*;

public class RegistroStepDefinitions {

    @Managed
    private WebDriver browser;

    private Actor user;

    @Before
    public void setUp(){
        user = Actor.named("User").whoCan(BrowseTheWeb.with(browser));
    }

    @Given("the user navigates to the register page")
    public void the_user_navigates_to_the_register_page() {
        user.attemptsTo(Open.url(RegistroPage.URL));
    }

    @When("the user fills the form with first name {string}, last name {string}, email {string}, phone {string} and password {string}")
    public void the_user_fills_the_form(String firstName, String lastName, String email, String phone, String password) {
        user.attemptsTo(RegistrarseComo.withCredentials(firstName,lastName,email,phone,password));
    }

    @And("accepts the privacy policy")
    public void accepts_the_privacy_policy() {
        user.attemptsTo(Click.on(RegistroPage.AGREE_CHECKBOX));
    }

    @And("clicks on continue")
    public void clicks_on_continue() {
        user.attemptsTo(Click.on(RegistroPage.CONTINUE_BUTTON));
    }

}
