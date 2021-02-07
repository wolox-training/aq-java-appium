package utils;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

import java.time.Duration;

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

    /**
     * Método de https://github.com/sunilpatro1985/AppiumTest_Java_And_iOS/blob/master/src/main/java/base/Util.java
     */
    public static void scrollDown(){
        Dimension dimension = BrowserManagement.getDriver().manage().window().getSize();
        int scrollStart = (int) (dimension.getHeight() * 0.5);
        int scrollEnd = (int) (dimension.getHeight() * 0.2);

        new TouchAction((PerformsTouchActions) BrowserManagement.getDriver())
                .press(PointOption.point(0, scrollStart))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(0, scrollEnd))
                .release().perform();
    }

    public static void scrollNClick(By listItems, String Text){
        boolean flag = false;

        while(true){
            for(WebElement el: BrowserManagement.getDriver().findElements(listItems)){
                if(el.getAttribute("text").equals(Text)){
                    el.click();
                    flag=true;
                    break;
                }
            }
            if(flag)
                break;
            else
                scrollDown();
        }
    }

    public static void scrollNClick(WebElement el){
        int retry = 0;
        while(retry <= 5){
            try{
                el.click();
                break;
            }catch (org.openqa.selenium.NoSuchElementException e){
                scrollDown();
                retry++;
            }
        }
    }
}
