package pages;

import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class MenuPage extends BasePage {

    public MenuPage() {
        super();
    }

    @AndroidFindBy(xpath = "//*[@content-desc='WebView']")
    private AndroidElement bottomBarWebView;

    @AndroidFindBy(xpath = "//*[@content-desc='Login']")
    private AndroidElement bottomBarLogin;

    @AndroidFindBy(xpath = "//*[@content-desc='Home']")
    private AndroidElement bottomBarHome;

    @AndroidFindBy(xpath = "//*[@content-desc='Forms']")
    private AndroidElement bottomBarForms;

    @AndroidFindBy(xpath = "//*[@content-desc='Swipe']")
    private AndroidElement bottomBarSwipe;


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
