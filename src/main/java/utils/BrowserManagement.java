package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.github.cdimascio.dotenv.Dotenv;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Class in charge of the initialization and configuration of the webdriver
 */
public class BrowserManagement {

    protected static ThreadLocal<AppiumDriver<MobileElement>> driver = new ThreadLocal<>();
    private static Dotenv dotenv = Dotenv.load();
    private static AppiumDriverLocalService server;

    private BrowserManagement() {
    }

    public static AppiumDriver<MobileElement> getDriver() {
        if (driver.get() == null) {
            driver.set( initializeDriver() );
        }
        return driver.get();
    }

    /**
     * Method that determines through the BROWSER environment variable the browser to use and its configuration
     *
     * @return
     */
    private static AppiumDriver<MobileElement> initializeDriver() {
        AppiumDriver<MobileElement> driver = null;
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

    private static AppiumDriver<MobileElement> androidSetup() {
        AppiumDriver<MobileElement> driver = null;
        DesiredCapabilities capabilities = getCapabilities();
        String serverUrl = dotenv.get("SERVER_URL");
        try {
            driver = new AndroidDriver<MobileElement>(new URL(serverUrl), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return driver;
    }

    private static DesiredCapabilities getCapabilities() {
        File app = new File(dotenv.get("APK_NAME"));
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 20);
        capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        String[] capabilitiesFile = dotenv.get("CAPABILITY").split(";");
        for (int i = 0; i < capabilitiesFile.length; i += 2) {
            capabilities.setCapability(capabilitiesFile[i], capabilitiesFile[i + 1]);
        }
        return capabilities;
    }

    public static void startServer() {
        server = AppiumDriverLocalService.buildDefaultService();
        server.start();
    }

    public static void stopServer() {
        getDriver().closeApp();
        getDriver().quit();
        server.stop();
        driver.remove();
    }
}
