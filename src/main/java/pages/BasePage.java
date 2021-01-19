package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.github.cdimascio.dotenv.Dotenv;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BrowserManagement;
import utils.Wait;

import java.time.Duration;

public class BasePage {
    protected AppiumDriver<AndroidElement> androidDriver;
    protected IOSDriver<IOSElement> iosDriver;
    protected Wait wait;
    protected Dotenv dotenv;
    protected int timeOutSeconds;


    public BasePage() {
        dotenv = Dotenv.load();
        androidDriver= (AppiumDriver<AndroidElement>) BrowserManagement.getDriver();
        wait = Wait.getInstance();
        timeOutSeconds = Integer.parseInt(dotenv.get("TIME_SECONDS"));
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver, Duration.ofMillis(10000)), this);
    }

}
