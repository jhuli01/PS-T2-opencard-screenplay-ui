package edu.pe.cibertec.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CarritoPage {

    public static final String CART_URL = "https://naveenautomationlabs.com/opencart/index.php?route=checkout/cart";

    public static final Target CART_TOTAL = Target.the("cart total").located(By.id("cart-total"));

    public static Target ADD_CART_BUTTON(String productName) {
        return Target.the("add to cart button for " + productName).located(By.xpath("//a[normalize-space()='" + productName + "']/ancestor::div[contains(@class,'product-thumb')]//button[1]"));
    }
    public static final Target CART_PRODUCT_NAMES = Target.the("cart product names").located(By.xpath("//td[contains(@class,'text-left')]/a[not(@class)]"));

}
