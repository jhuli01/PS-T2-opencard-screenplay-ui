package edu.pe.cibertec.tasks;

import edu.pe.cibertec.ui.CarritoPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.JavaScriptClick;


public class AgregarAlCarrito implements Task {

    private final String product;

    public AgregarAlCarrito(String product) {
        this.product = product;
    }

    public static Performable withProduct(String product) {
        return Task.where("{0} adds '" + product + "' to cart",
                new AgregarAlCarrito(product));
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                JavaScriptClick.on(CarritoPage.ADD_CART_BUTTON(product))
        );
       try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

}
