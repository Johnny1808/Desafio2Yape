package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;
import java.util.List;

import static utils.utilitarios.*;

public class DataFormPage {

    private AppiumDriver<MobileElement> driver;
    private WebDriverWait wait;

    public DataFormPage(AppiumDriver<MobileElement> driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void nomYape(String nombre, String apellido) {
        MobileElement firstName = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(By.xpath(FIRST_NAME_FIELD)));
        firstName.click();
        firstName.sendKeys(nombre);
        MobileElement lastName = driver.findElement(By.xpath(LAST_NAME_FIELD));
        lastName.click();
        lastName.sendKeys(apellido);
    }

    public void correoYregion(String correo, String region) {
        MobileElement email = driver.findElement(By.xpath(EMAIL_FIELD));
        email.click();
        email.sendKeys(correo);
        MobileElement reg = driver.findElement(By.xpath("//android.widget.TextView[@text='Country/Region *']/following-sibling::android.widget.AutoCompleteTextView"));
        reg.click();
        reg.clear();
        reg.sendKeys(region);
    }

    public void numYopc(String numero, String opcion) {
        MobileElement mobile = driver.findElement(By.xpath("//android.widget.TextView[@text='Mobile Phone *']/following-sibling::android.widget.EditText"));
        mobile.click();
        mobile.sendKeys(numero);
        driver.hideKeyboard();
        MobileElement opc = driver.findElement(By.xpath("//android.widget.RadioButton[@text='" + opcion + "']"));
        opc.click();
    }

    public void clickNextStep() {
        try {
            MobileElement next = driver.findElement(By.xpath("//android.widget.Button[@text='Next step']"));
            next.click();
        } catch (Exception e) {
            MobileElement next = driver.findElement(By.xpath("//android.widget.Button[@text='Add missing details']"));
            next.click();
        }
    }

    public void validarCamposRequeridos() {
        List<String> mensajesEsperados = Arrays.asList(
                "Please enter your first name.",
                "Please enter your last name.",
                "Please enter your email address.",
                "Please enter your country.",
                "Please enter your phone number."
        );
        for (String mensaje : mensajesEsperados) {
            try {
                MobileElement errorMessage = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='" + mensaje + "' and @resource-id='com.booking:id/bui_input_container_helper_label']")));
                String msj = errorMessage.getText();
                assert msj.equals(mensaje) : "No se está mostrando el mensaje de error esperado: " + mensaje;
            } catch (Exception e) {
                System.out.println("Campo completado correctamente, no se encontró el mensaje de error: " + mensaje);
            }
        }
    }

}
