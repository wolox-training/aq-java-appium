package utils;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

public class SwipeHelp {

    public static MobileElement androidHorizonalSwipe(String carousel, String option){
        return BrowserManagement.getDriver().findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable("+carousel+").setAsHorizontalList()." +
                "scrollIntoView("+option+")"));
    }

    public static MobileElement androidVerticalSwipe(String carousel, String option){
        return BrowserManagement.getDriver().findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable("+carousel+").setAsVerticalList()." +
                        "scrollIntoView("+option+")"));
    }
}
