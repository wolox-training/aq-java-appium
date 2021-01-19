package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.List;

public class WebViewPage extends BasePage {

    public WebViewPage() {
        super();
    }

    @AndroidFindBy(xpath = "//android.widget.ListView/android.view.View/android.view.View")
    private List<AndroidElement> someTextViews;
    @AndroidFindBy(xpath = "//android.widget.ListView/android.view.View/android.view.View[@text='Docs']")
    private AndroidElement lnkDocs;
    @AndroidFindBy(xpath = "//android.widget.ListView/android.view.View/android.view.View[@text='API']")
    private AndroidElement lnkApi;
    @AndroidFindBy(xpath = "//android.widget.ListView/android.view.View/android.view.View[@text='Help']")
    private AndroidElement lnkHelp;
    @AndroidFindBy(xpath = "//android.widget.ListView/android.view.View/android.view.View[@text='Versions']")
    private AndroidElement lnkVersions;
    @AndroidFindBy(xpath = "//android.widget.ListView/android.view.View/android.view.View[@text='Blog']")
    private AndroidElement lnkBlog;
    @AndroidFindBy(xpath = "//android.widget.ListView/android.view.View/android.view.View[@text='Contribute']")
    private AndroidElement lnkContribute;

    public boolean isDisplayedLnkDocs (){
        wait.untilElementIsVisible(timeOutSeconds, lnkApi);
        return lnkDocs.isDisplayed();
    }
    public boolean isDisplayedLnkApi (){
        return lnkApi.isDisplayed();
    }
    public boolean isDisplayedLnkHelp(){
        return lnkHelp.isDisplayed();
    }
    public boolean isDisplayedLnkVersions (){
        return lnkVersions.isDisplayed();
    }
    public boolean isDisplayedLnkBlog(){
        return lnkBlog.isDisplayed();
    }
    public boolean isDisplayedLnkContribute (){
        return lnkContribute.isDisplayed();
    }
}
