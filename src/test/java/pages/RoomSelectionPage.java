package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;

import java.time.Duration;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class RoomSelectionPage {

    private AppiumDriver<MobileElement> driver;
    private WebDriverWait wait;

    public RoomSelectionPage(AppiumDriver<MobileElement> driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;

    }

    public void selectRoomOptions() throws InterruptedException {
        MobileElement habitacion = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@resource-id='com.booking:id/facet_search_box_basic_field_label' and @text='1 room · 2 adults · 0 children']")));
        habitacion.click();
        MobileElement hijos = driver.findElement(By.xpath("(//android.widget.Button[@resource-id='com.booking:id/bui_input_stepper_add_button'])[3]"));
        hijos.click();
        MobileElement edadHijo = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(By.id("com.booking:id/age_picker_view")));
        scroll(driver, edadHijo, 6, 540, 1200, 540, 1050, 500);
        MobileElement okEdad = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(By.id("android:id/button1")));
        okEdad.click();
        MobileElement aplicHabitacion = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(By.id("com.booking:id/group_config_apply_button")));
        aplicHabitacion.click();
        MobileElement Search = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(By.id("com.booking:id/facet_search_box_cta")));
        Search.click();
    }

    public void selectRoomOptions2() throws InterruptedException {
        MobileElement habitacion = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@resource-id='com.booking:id/facet_search_box_basic_field_label' and @text='1 room · 2 adults · 0 children']")));
        habitacion.click();
        MobileElement rooms = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//android.widget.Button[@resource-id='com.booking:id/bui_input_stepper_add_button'])[1]")));
        rooms.click();
        MobileElement adults = driver.findElement(By.xpath("(//android.widget.Button[@resource-id='com.booking:id/bui_input_stepper_add_button'])[2]"));
        adults.click();
        MobileElement hijos = driver.findElement(By.xpath("(//android.widget.Button[@resource-id='com.booking:id/bui_input_stepper_add_button'])[3]"));
        hijos.click();
        MobileElement edadHijo = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(By.id("com.booking:id/age_picker_view")));
        scroll(driver, edadHijo, 6, 540, 1200, 540, 1050, 500);
        MobileElement okEdad = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(By.id("android:id/button1")));
        okEdad.click();
        MobileElement hijos2 = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//android.widget.Button[@resource-id='com.booking:id/bui_input_stepper_add_button'])[3]")));
        hijos2.click();
        scroll(driver, edadHijo, 9, 540, 1200, 540, 1050, 500);
        okEdad = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(By.id("android:id/button1")));
        okEdad.click();

        MobileElement aplicHabitacion = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(By.id("com.booking:id/group_config_apply_button")));
        aplicHabitacion.click();
        MobileElement Search = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(By.id("com.booking:id/facet_search_box_cta")));
        Search.click();
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
                Thread.sleep(500);
            }
        } else {
            System.out.println("El elemento es null. No se puede realizar el scroll.");
        }
    }

}
