package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

import java.util.List;

public class WebViewPage extends BasePage {

    public WebViewPage() {
        super();
    }

    @AndroidFindBy(xpath = "//android.widget.ListView/android.view.View/android.view.View")
    private List<MobileElement> someTextViews;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeLink[@name=\"Docs\"])[1]")
    @AndroidFindBy(xpath = "//android.widget.ListView/android.view.View/android.view.View[@text='Docs']")
    private MobileElement lnkDocs;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeLink[@name=\"API\"])[1]")
    @AndroidFindBy(xpath = "//android.widget.ListView/android.view.View/android.view.View[@text='API']")
    private MobileElement lnkApi;

    @AndroidFindBy(xpath = "//android.widget.ListView/android.view.View/android.view.View[@text='Help']")
    private MobileElement lnkHelp;

    @AndroidFindBy(xpath = "//android.widget.ListView/android.view.View/android.view.View[@text='Versions']")
    private MobileElement lnkVersions;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeLink[@name=\"Blog\"])[1]")
    @AndroidFindBy(xpath = "//android.widget.ListView/android.view.View/android.view.View[@text='Blog']")
    private MobileElement lnkBlog;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeLink[@name=\"Contribute\"])[1]")
    @AndroidFindBy(xpath = "//android.widget.ListView/android.view.View/android.view.View[@text='Contribute']")
    private MobileElement lnkContribute;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeLink[@name=\"Community\"])[1]")
    private MobileElement lnkCommunity;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeLink[@name=\"v7\"])[1]")
    private MobileElement lnkV7;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeLink[@name=\"GitHub repository\"]")
    private MobileElement lnkRepository;

    @iOSXCUITFindBy(accessibility = "Navigation bar toggle")
    private MobileElement menuBariOS;

    public boolean isDisplayedLnksWebView() {
        boolean existe = false;
        if (dotenv.get("PLATFORM_NAME").equals("Android")) {
            wait.untilElementIsVisible(timeOutSeconds, lnkApi);
            existe = lnkHelp.isDisplayed() && lnkVersions.isDisplayed();
        } else {
            wait.untilElementIsVisible(timeOutSeconds, menuBariOS);
            menuBariOS.click();
            existe = lnkCommunity.isDisplayed() && lnkV7.isDisplayed() && lnkRepository.isDisplayed();
        }
        existe = lnkDocs.isDisplayed() && lnkApi.isDisplayed() && lnkBlog.isDisplayed() && lnkContribute.isDisplayed();

        return existe;
    }
}
