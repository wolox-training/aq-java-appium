package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import utils.SwipeHelper;

public class SwipePage extends BasePage {

    public SwipePage() {
        super();
    }

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Swipe horizontal\"]")
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
                String titleOptionCarusel = "//XCUIElementTypeOther[@name=\"Carousel\"]/XCUIElementTypeOther[1]//XCUIElementTypeOther[@name=\"card\"]//XCUIElementTypeOther[2]//XCUIElementTypeStaticText[1]";
                MobileElement item = appiumDriver.findElementByXPath(titleOptionCarusel);
                int i = 5;
                while (!item.getText().equals(text) && i > 0) {
                    SwipeHelper.scroll(SwipeHelper.ScrollDirection.RIGHT, 0.2);
                    titleOptionCarusel = "(//XCUIElementTypeOther[@name=\"card\"])[2]//XCUIElementTypeOther[2]//XCUIElementTypeStaticText[1]";
                    item = appiumDriver.findElementByXPath(titleOptionCarusel);
                    i--;
                }
                elementCarousel = appiumDriver.findElementByAccessibilityId(text);
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
