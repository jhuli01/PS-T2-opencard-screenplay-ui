package edu.pe.cibertec.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginPage {
    public static final String URL ="https://naveenautomationlabs.com/opencart/index.php?route=account/login";

    // public static final String EDIT_URL = "https://naveenautomationlabs.com/opencart/index.php?route=account/edit";

    // public static final Target ACCOUNT_NAME = Target.the("account first name").located(By.id("input-firstname"));

    public static final Target EMAIL_FIELD = Target.the("email field").located(By.id("input-email"));

    public static final Target PASSWORD_FIELD = Target.the("password field").located(By.id("input-password"));

    public static final Target LOGIN_BUTTON = Target.the("login button").located(By.xpath("//input[@value='Login']"));

    public static final Target WARNING_MESSAGE = Target.the("warning message").located(By.xpath("//*[@id='account-login']/div[1]"));

    public static final Target ACCOUNT_NAME =
            Target.the("account name in header")
                    .located(By.cssSelector("#content h2:first-of-type"));
}
