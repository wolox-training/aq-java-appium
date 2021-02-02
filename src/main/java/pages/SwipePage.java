package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class SwipePage extends BasePage {

    public SwipePage() {
        super();
    }

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='Swipe-screen']/android.view.ViewGroup[1]/android.widget.TextView")
    private MobileElement titleSwipe;

    public String getTitleSwipeMenu(){
        wait.untilElementIsVisible(timeOutSeconds, titleSwipe);
        return titleSwipe.getText();
    }

}
