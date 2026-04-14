package edu.pe.cibertec.tasks;

import edu.pe.cibertec.ui.RegistroPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;

public class RegistrarseComo implements Task {


    private final String firstname;
    private final String lastname;
    private final String email;
    private final String telephone;
    private final String password;

    public RegistrarseComo(String  firstname, String lastname, String email, String telephone, String password) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.telephone = telephone;
        this.password = password;
    }

    public static Performable withCredentials(String firstname, String lastname, String email, String telephone, String password) {
        return Task.where("{0} registers in with lastname '"+firstname+"'", new RegistrarseComo(firstname, lastname, email, telephone, password));
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.url(RegistroPage.URL),
                Enter.theValue(firstname).into(RegistroPage.FIRSTNAME_FIELD),
                Enter.theValue(lastname).into(RegistroPage.LASTNAME_FIELD),
                Enter.theValue(email).into(RegistroPage.EMAIL_FIELD),
                Enter.theValue(telephone).into(RegistroPage.TELEPHONE_FIELD),
                Enter.theValue(password).into(RegistroPage.PASSWORD_FIELD),
                Enter.theValue(password).into(RegistroPage.CONFIRM_FIELD)
        );
    }


}
