package pages.components;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.github.cdimascio.dotenv.Dotenv;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserManagement;
import utils.Wait;

import java.time.Duration;


public class BaseComponent {

    protected AppiumDriver<MobileElement> appiumDriver;
    protected Wait wait;
    protected Dotenv dotenv;
    protected int timeOutSeconds;

    public BaseComponent() {
        dotenv = Dotenv.load();
        appiumDriver = BrowserManagement.getDriver();
        wait = Wait.getInstance();
        timeOutSeconds = Integer.parseInt(dotenv.get("TIME_SECONDS"));
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver, Duration.ofSeconds(timeOutSeconds)), this);
    }



}
