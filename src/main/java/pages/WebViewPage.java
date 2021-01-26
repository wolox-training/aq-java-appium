package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.List;

public class WebViewPage extends BasePage {

    public WebViewPage() {
        super();
    }

    @AndroidFindBy(xpath = "//android.widget.ListView/android.view.View/android.view.View")
    private List<MobileElement> someTextViews;

    @AndroidFindBy(xpath = "//android.widget.ListView/android.view.View/android.view.View[@text='Docs']")
    private MobileElement lnkDocs;

    @AndroidFindBy(xpath = "//android.widget.ListView/android.view.View/android.view.View[@text='API']")
    private MobileElement lnkApi;

    @AndroidFindBy(xpath = "//android.widget.ListView/android.view.View/android.view.View[@text='Help']")
    private MobileElement lnkHelp;

    @AndroidFindBy(xpath = "//android.widget.ListView/android.view.View/android.view.View[@text='Versions']")
    private MobileElement lnkVersions;

    @AndroidFindBy(xpath = "//android.widget.ListView/android.view.View/android.view.View[@text='Blog']")
    private MobileElement lnkBlog;

    @AndroidFindBy(xpath = "//android.widget.ListView/android.view.View/android.view.View[@text='Contribute']")
    private MobileElement lnkContribute;

    public boolean isDisplayedLnksWebView() {
        wait.untilElementIsVisible(timeOutSeconds, lnkApi);
        return lnkDocs.isDisplayed() && lnkApi.isDisplayed() && lnkHelp.isDisplayed() &&
                lnkVersions.isDisplayed() && lnkBlog.isDisplayed() && lnkContribute.isDisplayed();
    }
}
