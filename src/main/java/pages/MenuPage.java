package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class MenuPage extends BasePage {

    public MenuPage() {
        super();
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

    public void clicWebViewMenu() {
        bottomBarWebView.click();
    }

    public void clicLoginMenu() {
        bottomBarLogin.click();
    }

    public boolean isDisplayedHomeMenu(){
        return bottomBarHome.isDisplayed();
    }

    public boolean isDisplayedWebViewMenu(){
        return bottomBarWebView.isDisplayed();
    }

    public boolean isDisplayedLoginMenu(){
        return bottomBarLogin.isDisplayed();
    }

    public boolean isDisplayedFormsMenu(){
        return bottomBarForms.isDisplayed();
    }

    public boolean isDisplayedSwipeMenu(){
        return bottomBarSwipe.isDisplayed();
    }
}
