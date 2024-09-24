package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReservaDetailsPage {

    private AppiumDriver<MobileElement> driver;
    private WebDriverWait wait;

    public ReservaDetailsPage(AppiumDriver<MobileElement> driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void validarReservaDetalles(String noches, String hab, String adultos, String ninos) {
        // Validar la información de la reserva
        MobileElement vald1 = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[contains(@text, '" + noches + " nights, " + hab + " rooms for " + adultos + " adults, " + ninos + " child')]")));
        String reserva1 = vald1.getText();
        if (reserva1.equals(noches + " nights, " + hab + " rooms for " + adultos + " adults, " + ninos + " child")) {
            assert reserva1.equals(noches + " nights, " + hab + " rooms for " + adultos + " adults, " + ninos + " child") : "La información de la reserva es incorrecta. Texto obtenido: " + reserva1;
            System.out.println("La reserva fue: " + reserva1);
        } else {
            assert reserva1.equals(noches + " nights, " + hab + " rooms for " + adultos + " adults, " + ninos + " children") : "La información de la reserva es incorrecta. Texto obtenido: " + reserva1;
            System.out.println("La reserva fue: " + reserva1);
        }
        // Validar el check-in
        MobileElement vald2 = driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.booking:id/checkin_date']"));
        String checkin = vald2.getText();
        assert checkin.equals("Fri Feb 14 2025") : "La información de la reserva es incorrecta. Texto obtenido: " + checkin;
        System.out.println("Checkin es: " + checkin);
        // Validar el check-out
        MobileElement vald3 = driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.booking:id/checkout_date']"));
        String checkout = vald3.getText();
        assert checkout.equals("Fri Feb 28 2025") : "La información de la reserva es incorrecta. Texto obtenido: " + checkout;
        System.out.println("Checkout es: " + checkout);
    }

    public void clicSiguienteReserva() {
        MobileElement bFinalStep = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.Button[@resource-id='com.booking:id/action_button' and @text='Final step']")));
        bFinalStep.click();
    }

}
