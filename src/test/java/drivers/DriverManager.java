package drivers;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.net.MalformedURLException;
import java.net.URL;

public class DriverManager {

    private AppiumDriver<MobileElement> appiumDriver;
    private WebDriverWait wait;

    // Método para configurar y obtener el driver
    public AppiumDriver<MobileElement> getDriver() throws MalformedURLException {
        if (appiumDriver == null) {
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("automationName", "uiautomator2");
            caps.setCapability("udid", "emulator-5554");  // O el ID de tu dispositivo/emulador
            caps.setCapability("platformName", "Android");
            caps.setCapability("appPackage", "com.booking");
            caps.setCapability("appActivity", "com.booking.appindex.presentation.activity.SearchActivity");

            URL appiumServer = new URL("http://127.0.0.1:4723/wd/hub");
            appiumDriver = new AppiumDriver<>(appiumServer, caps);
            wait = new WebDriverWait(appiumDriver, 10);
        }
        return appiumDriver;
    }

    // Método para obtener el WebDriverWait
    public WebDriverWait getWait() {
        return wait;
    }

    // Método para cerrar el driver
    public void quitDriver() {
        if (appiumDriver != null) {
            appiumDriver.quit();
        }
    }

}
