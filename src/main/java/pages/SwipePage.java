package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import utils.SwipeHelper;

public class SwipePage extends BasePage {

    public SwipePage() {
        super();
    }

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='Swipe-screen']/android.view.ViewGroup[1]/android.widget.TextView")
    private MobileElement titleSwipe;

    private MobileElement elementCarousel;

    private String horizontalScrollView = "new UiSelector().className(\"android.widget.HorizontalScrollView\")";

    private String neededElement_finder = "new UiSelector().text(\"%s\")";

    public String getTitleSwipeMenu() {
        wait.untilElementIsVisible(timeOutSeconds, titleSwipe);
        return titleSwipe.getText();
    }

    public void selectCarruselOption(String text) {
        switch (dotenv.get("PLATFORM_NAME")) {
            case "iOS":
                //Aquí va lo relacionado a la busqueda en iOS
                break;
            case "Android":
            default:
                elementCarousel = SwipeHelper.androidHorizonalSwipe(horizontalScrollView, String.format(neededElement_finder, text));
        }
    }

    public boolean isDisplayedCarruselOption() {
        return elementIsDisplayed(elementCarousel);
    }

}
