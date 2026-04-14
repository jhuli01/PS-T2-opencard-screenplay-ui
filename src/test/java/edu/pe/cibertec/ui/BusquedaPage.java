package edu.pe.cibertec.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class BusquedaPage {

    public static final String URL = "https://naveenautomationlabs.com/opencart/index.php?route=common/home";

    public static final Target SEARCH_FIELD = Target.the("search field").located(By.xpath("//*[@id='search']/input"));

    public static final Target SEARCH_BUTTON = Target.the("search button").located(By.xpath("//*[@id='search']/span/button"));

    public static final Target PRODUCT_NAMES = Target.the("product names").located(By.cssSelector(".product-layout .caption h4 a"));

    public static final Target MESSAGE = Target.the("message").located(By.xpath("//*[@id='content']/p[2]"));

}
