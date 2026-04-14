package edu.pe.cibertec.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class RegistroPage {

    public static final String URL = "https://naveenautomationlabs.com/opencart/index.php?route=account/register";

    public static final Target FIRSTNAME_FIELD = Target.the("firstname field").located(By.id("input-firstname"));

    public static final Target LASTNAME_FIELD = Target.the("lastname field").located(By.id("input-lastname"));

    public static final Target EMAIL_FIELD = Target.the("email field").located(By.id("input-email"));

    public static final Target TELEPHONE_FIELD = Target.the("telephone field").located(By.id("input-telephone"));

    public static final Target PASSWORD_FIELD = Target.the("password field").located(By.id("input-password"));

    public static final Target CONFIRM_FIELD = Target.the("confirm field").located(By.id("input-confirm"));

    public static final Target AGREE_CHECKBOX = Target.the("agree checkbox").located(By.xpath("//input[@name='agree']"));

    public static final Target CONTINUE_BUTTON = Target.the("continue button").located(By.xpath("//input[@value='Continue']"));

    public static final Target SUCCESS_MESSAGE = Target.the("info message").located(By.xpath("//div[@id='content']/h1"));

}
