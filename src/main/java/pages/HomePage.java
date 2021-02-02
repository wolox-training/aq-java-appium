package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class HomePage extends BasePage {

    public HomePage() {
        super();
    }

    @AndroidFindBy(className = "android.widget.ImageView")
    private MobileElement imgView;

    @AndroidFindBy(xpath = "//android.widget.ScrollView[@content-desc='Home-screen']//android.view.ViewGroup[2]/android.widget.TextView[1]")
    private MobileElement imgIconiOS;

    @AndroidFindBy(xpath = "//android.widget.ScrollView[@content-desc='Home-screen']//android.view.ViewGroup[2]/android.widget.TextView[2]")
    private MobileElement imgIconAndroid;


    public boolean isDisplayedImgsHome() {
        wait.untilElementIsVisible(timeOutSeconds, imgView);
        return imgIconiOS.isDisplayed() && imgIconAndroid.isDisplayed();
    }
}
