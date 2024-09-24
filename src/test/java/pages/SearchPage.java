package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class SearchPage {

    private AppiumDriver<MobileElement> driver;
    private WebDriverWait wait;

    public SearchPage(AppiumDriver<MobileElement> driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void searchDestination(String destination) {
        MobileElement buscarDestino = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(By.id("com.booking:id/facet_search_box_basic_field_label")));
        buscarDestino.click();
        MobileElement escribirDestino = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(By.id("com.booking:id/facet_with_bui_free_search_booking_header_toolbar_content")));
        escribirDestino.sendKeys(destination);
        MobileElement selectDestino = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//androidx.recyclerview.widget.RecyclerView[@resource-id='com.booking:id/facet_disambiguation_content']/android.view.ViewGroup[1]")));
        selectDestino.click();
    }

}
