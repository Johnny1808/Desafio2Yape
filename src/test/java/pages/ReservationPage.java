package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ReservationPage {

    private AppiumDriver<MobileElement> driver;
    private WebDriverWait wait;


    public ReservationPage(AppiumDriver<MobileElement> driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }

    public void seleccionarHotel() {
        try {
            MobileElement info = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(By.id("com.booking:id/bui_banner_close_button")));
            info.click();
            MobileElement opc2 = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]")));
            opc2.click();
        } catch (Exception e) {
            try {
                MobileElement actu = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.booking:id/bui_banner_button_flow")));

                MobileElement opc3 = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[3]/android.view.ViewGroup/android.view.ViewGroup[2]")));
                opc3.click();
            } catch (Exception e2) {
            }
            try {
                MobileElement opc2 = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]")));
                opc2.click();
            } catch (Exception e3) {
            }
        }
    }

    public String selectHabitacion() {
        String precioHabitacion = capturarPrecioHabitacion();
        MobileElement selectHab = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.FrameLayout[@resource-id='com.booking:id/property_availability_cta_facetframe']/android.view.ViewGroup")));
        selectHab.click();
        MobileElement reserveOpc = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(By.id("com.booking:id/recommended_block_reserve_button")));
        reserveOpc.click();
        return precioHabitacion;
    }

    // Método para capturar el precio de la habitación
    public String capturarPrecioHabitacion() {
        MobileElement precioHab = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(By.id("com.booking:id/price_view_price")));
        String precioHabitacion = precioHab.getText();
        System.out.println("Precio de la habitación: " + precioHabitacion);
        return precioHabitacion;
    }


}
