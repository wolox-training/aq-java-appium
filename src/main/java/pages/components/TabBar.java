package pages.components;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class TabBar extends BaseComponent {


    @iOSXCUITFindBy(accessibility = "WebView")
    @AndroidFindBy(xpath = "//*[@content-desc='WebView']")
    private MobileElement bottomBarWebView;

    @iOSXCUITFindBy(accessibility = "Login")
    @AndroidFindBy(xpath = "//*[@content-desc='Login']")
    private MobileElement bottomBarLogin;

    @iOSXCUITFindBy(accessibility = "Home")
    @AndroidFindBy(xpath = "//*[@content-desc='Home']")
    private MobileElement bottomBarHome;

    @iOSXCUITFindBy(accessibility = "Forms")
    @AndroidFindBy(xpath = "//*[@content-desc='Forms']")
    private MobileElement bottomBarForms;

    @iOSXCUITFindBy(accessibility = "Swipe")
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

    public boolean isDisplayedMenu() {
        return bottomBarHome.isDisplayed() && bottomBarWebView.isDisplayed()
                && bottomBarLogin.isDisplayed() && bottomBarForms.isDisplayed()
                && bottomBarSwipe.isDisplayed();
    }
}
