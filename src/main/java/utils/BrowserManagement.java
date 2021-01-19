package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.github.cdimascio.dotenv.Dotenv;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Class in charge of the initialization and configuration of the webdriver
 */
public class BrowserManagement {

    protected static AppiumDriver driver;
    private static Dotenv dotenv = Dotenv.load();

    private BrowserManagement() {
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            driver = initializeDriver();
        }
        return driver;
    }

    /**
     * Method that determines through the BROWSER environment variable the browser to use and its configuration
     * @return
     */
    public static AppiumDriver initializeDriver() {
        switch (dotenv.get("PLATFORM_NAME")) {
            case "Android":
                driver = androidSetup();
                break;
            case "iOS":
            default:
                break;
        }
        return driver;
    }

    private static AppiumDriver androidSetup(){
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.PLATFORM_NAME, dotenv.get("PLATFORM_NAME"));
        capabilities.setCapability("device", dotenv.get("DEVICE_NAME"));
        capabilities.setCapability("noReset", dotenv.get("RESET_APP"));
        File file = new File("src/test/resources/apks", dotenv.get("APK_NAME"));
        capabilities.setCapability("app", file.getAbsolutePath());
        String serverUrl = dotenv.get("SERVER_URL");
        try {
            driver = new AndroidDriver(new URL(serverUrl), capabilities);
            driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return driver;
    }

}
