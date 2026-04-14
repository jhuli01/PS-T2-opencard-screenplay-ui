package edu.pe.cibertec.questions;

import edu.pe.cibertec.ui.BusquedaPage;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.Actor;

import java.util.List;
import java.util.stream.Collectors;

public class ResultadosDeBusqueda {

    public static Question<List<String>> obtenerNombres() {
        return actor -> BusquedaPage.PRODUCT_NAMES.resolveAllFor(actor)
                .stream()
                .map(e -> e.getText())
                .collect(Collectors.toList());
    }

}
