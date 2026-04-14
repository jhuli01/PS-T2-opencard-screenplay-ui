package edu.pe.cibertec.tasks;

import edu.pe.cibertec.ui.BusquedaPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;

public class BuscarProducto implements Task {

    private final String product;

    public BuscarProducto(String product) {
        this.product = product;
    }

    public static Performable withSearch(String product) {
        return Task.where("{0} searches for product '"+product+"'", new BuscarProducto(product));
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.url(BusquedaPage.URL),
                Enter.theValue(product).into(BusquedaPage.SEARCH_FIELD),
                Click.on(BusquedaPage.SEARCH_BUTTON)
        );
    }
}
