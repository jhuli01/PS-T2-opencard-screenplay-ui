package edu.pe.cibertec.questions;

import edu.pe.cibertec.ui.CarritoPage;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

import java.util.List;
import java.util.stream.Collectors;

public class ContadorDelCarrito {

    public static Question<String> totalText() {
        return actor -> Text.of(CarritoPage.CART_TOTAL).answeredBy(actor);
    }

    public static Question<List<String>> productosEnCarrito() {
        return actor -> CarritoPage.CART_PRODUCT_NAMES.resolveAllFor(actor)
                .stream()
                .map(e -> e.getText())
                .collect(Collectors.toList());
    }
}
