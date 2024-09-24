package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FinishPage {

    private AppiumDriver<MobileElement> driver;
    private WebDriverWait wait;

    public FinishPage(AppiumDriver<MobileElement> driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void ingresarNumTarjeta(String numTarj) {
        MobileElement cardNum = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.EditText[@text='Card Number' and @resource-id='com.booking:id/new_credit_card_number_edit']")));
        cardNum.click();
        cardNum.sendKeys(numTarj);
    }

    public void ingresarFechaVenci(String fechaVenc) {
        MobileElement expirDate = driver.findElement(By.xpath("//android.widget.EditText[@text='Expiration Date' and @resource-id='com.booking:id/new_credit_card_expiry_date_edit']"));
        expirDate.click();
        expirDate.sendKeys(fechaVenc);
    }

    public void clicReservar(){
        MobileElement bookNow = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.Button[@text='Book now' and @resource-id='com.booking:id/action_button']")));
        bookNow.click();
    }

    public void validarCamposFin(){
        //Validacion de campo tarjeta
        MobileElement errorMessage = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Card length is incorrect' and @resource-id='com.booking:id/textinput_error']")));
        String msj = errorMessage.getText();
        assert msj.equals("Card length is incorrect") : "No se está mostrando el mensaje de error esperado: " + msj;
        System.out.println("Mensaje de error mostrado: " + msj);
    }

}
