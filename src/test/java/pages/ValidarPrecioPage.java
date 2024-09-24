package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ValidarPrecioPage {

    private AppiumDriver<MobileElement> driver;
    private WebDriverWait wait;
    private String precioHabitacion; // Variable para almacenar el precio de la habitación


    public ValidarPrecioPage(AppiumDriver<MobileElement> driver, WebDriverWait wait, String precioHabitacion) {
        this.driver = driver;
        this.wait = wait;
        this.precioHabitacion = precioHabitacion;
    }

    public void validarPrecioFinal(String preciohab) {
        // Capturar el precio en la parte inferior
        MobileElement precioF = driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.booking:id/title' and @text='" + preciohab + "']"));
        String precioAbajo = precioF.getText();
        // Validar que el precio de la habitación sea igual al precio en la parte inferior
        if (preciohab.equals(precioAbajo)) {
            System.out.println("Los precios coinciden: " + precioAbajo);
        } else {
            throw new AssertionError("Los precios no coinciden. Precio de la habitación: " + preciohab + ", Precio en la parte inferior: " + precioAbajo);
        }
    }

}
