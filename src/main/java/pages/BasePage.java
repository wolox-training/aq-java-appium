package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.github.cdimascio.dotenv.Dotenv;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserManagement;
import utils.Wait;

import java.time.Duration;


public class BasePage {

    protected AppiumDriver<MobileElement> appiumDriver;
    protected Wait wait;
    protected Dotenv dotenv;
    protected int timeOutSeconds;

    public BasePage() {
        dotenv = Dotenv.load();
        appiumDriver = BrowserManagement.getDriver();
        wait = Wait.getInstance();
        timeOutSeconds = Integer.parseInt(dotenv.get("TIME_SECONDS"));
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver, Duration.ofSeconds(timeOutSeconds)), this);
    }

    /**
     * This method verifies if a webelement is displayed
     *
     * @param element
     * @return
     */
    protected boolean elementIsDisplayed(MobileElement element) {
        try {
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

}
