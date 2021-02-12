package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class HomePage extends BasePage {

    public HomePage() {
        super();
    }

    @iOSXCUITFindBy(accessibility = "assets/js/assets/webdriverio.png")
    @AndroidFindBy(className = "android.widget.ImageView")
    private MobileElement imgView;

    @AndroidFindBy(xpath = "//android.widget.ScrollView[@content-desc='Home-screen']//android.view.ViewGroup[2]/android.widget.TextView[1]")
    private MobileElement imgIconiOS;

    @AndroidFindBy(xpath = "//android.widget.ScrollView[@content-desc='Home-screen']//android.view.ViewGroup[2]/android.widget.TextView[2]")
    private MobileElement imgIconAndroid;


    public boolean isDisplayedImgsHome() {
        return imgView.isDisplayed();
//        wait.untilElementIsVisible(timeOutSeconds, imgView);
//        return imgIconiOS.isDisplayed() && imgIconAndroid.isDisplayed();
    }
}
