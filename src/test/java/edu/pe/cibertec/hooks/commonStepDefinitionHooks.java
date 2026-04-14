package edu.pe.cibertec.hooks;

import edu.pe.cibertec.ui.BusquedaPage;
import edu.pe.cibertec.ui.LoginPage;
import edu.pe.cibertec.ui.RegistroPage;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Then;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.questions.Text;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class commonStepDefinitionHooks {

    @Managed
    private WebDriver browser;

    private Actor user;

    private Scenario scenario;

    @Before
    public void beforeScenario(Scenario scenario) {
        this.scenario = scenario;
        user = Actor.named("User").whoCan(BrowseTheWeb.with(browser));
    }

    @Then("the user should see the message {string}")
    public void the_user_should_see_the_message(String message) {
        String featureName = scenario.getUri().toString();

        if (featureName.contains("registro")) {
            user.should(seeThat(Text.of(RegistroPage.SUCCESS_MESSAGE), containsString(message)));
        } else if (featureName.contains("login")) {
            user.should(seeThat(Text.of(LoginPage.WARNING_MESSAGE), containsString(message)));
        } else if (featureName.contains("search")) {
            user.should(seeThat(Text.of(BusquedaPage.MESSAGE), containsString(message)));
        }
    }

}
