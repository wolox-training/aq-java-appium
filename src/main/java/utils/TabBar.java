package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class TabBar {

    protected AppiumDriver<MobileElement> appiumDriver;
    protected int timeOutSeconds;

    public TabBar(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver, Duration.ofSeconds(10)), this);
    }

    @AndroidFindBy(xpath = "//*[@content-desc='WebView']")
    private MobileElement bottomBarWebView;

    @AndroidFindBy(xpath = "//*[@content-desc='Login']")
    private MobileElement bottomBarLogin;

    @AndroidFindBy(xpath = "//*[@content-desc='Home']")
    private MobileElement bottomBarHome;

    @AndroidFindBy(xpath = "//*[@content-desc='Forms']")
    private MobileElement bottomBarForms;

    @AndroidFindBy(xpath = "//*[@content-desc='Swipe']")
    private MobileElement bottomBarSwipe;

    public void clicHomeMenu() {
        bottomBarHome.click();
    }

    public void clicWebViewMenu() {
        bottomBarWebView.click();
    }

    public void clicLoginMenu() {
        bottomBarLogin.click();
    }

    public void clicFormsMenu() {
        bottomBarForms.click();
    }

    public void clicSwipeMenu() {
        bottomBarSwipe.click();
    }

    public boolean isDisplayedMenu(){
        return bottomBarHome.isDisplayed() && bottomBarWebView.isDisplayed()
                && bottomBarLogin.isDisplayed() && bottomBarForms.isDisplayed()
                && bottomBarSwipe.isDisplayed();
    }
}
