package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class DateSelectionPage {

    private AppiumDriver<MobileElement> driver;
    private WebDriverWait wait;

    public DateSelectionPage(AppiumDriver<MobileElement> driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void selectDate(String startDate, String endDate) throws InterruptedException {
        MobileElement calendario = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(By.id("com.booking:id/calendar_month_list")));
        scroll(driver, calendario, 4, 500, 1300, 540, 600, 1000);
        MobileElement fechaIni = driver.findElement(By.xpath("//android.view.View[@content-desc='" + startDate + "']"));
        fechaIni.click();
        MobileElement fechaFin = driver.findElement(By.xpath("//android.view.View[@content-desc='" + endDate + "']"));
        fechaFin.click();
        MobileElement fechaElegida = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(By.id("com.booking:id/facet_date_picker_selection_summary")));
        String fechas = fechaElegida.getText();
        assert fechas.equals("Feb 14 - Feb 28 (14 nights)") : "Las fechas no se pudieron seleccionar: " + fechas;
        MobileElement confirmButton = driver.findElement(By.id("com.booking:id/facet_date_picker_confirm"));
        confirmButton.click();
    }

    public void selectDateIncorrec(String startDate, String endDate) {
        try {
            MobileElement fechaIni = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.View[@content-desc='" + startDate + "']")));
            fechaIni.click();
        } catch (NoSuchElementException e) {
            System.out.println("Fecha de inicio no encontrada: " + startDate);
        }
        try {
            MobileElement fechaFin = driver.findElement(By.xpath("//android.view.View[@content-desc='" + endDate + "']"));
            fechaFin.click();
        } catch (NoSuchElementException e) {
            System.out.println("Fecha de fin no encontrada: " + endDate);
        }
        // Verificar si las fechas fueron seleccionadas correctamente
        MobileElement fechaElegida = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(By.id("com.booking:id/facet_date_picker_selection_summary")));
        String fechas = fechaElegida.getText();
        if (fechas.equals("Sep 12 - Sep 15 (3 nights)")) {
            MobileElement confirmButton = driver.findElement(By.id("com.booking:id/facet_date_picker_confirm"));
            confirmButton.click();
        } else {
            System.out.println("Las fechas no se pudieron seleccionar, fuera de rango");
        }
    }

    private void scroll(AppiumDriver<MobileElement> driver, MobileElement element, int scrollCount, int startX, int startY, int endX, int endY, int duration) throws InterruptedException {
        if (element != null) {
            for (int i = 0; i < scrollCount; i++) {
                new TouchAction<>(driver)
                        .press(PointOption.point(startX, startY))
                        .waitAction(WaitOptions.waitOptions(Duration.ofMillis(duration)))
                        .moveTo(PointOption.point(endX, endY))
                        .release()
                        .perform();
                Thread.sleep(1000);
            }
        } else {
            System.out.println("El elemento es null. No se puede realizar el scroll.");
        }
    }
}
