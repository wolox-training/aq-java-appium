package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class FormsPage extends BasePage {

    public FormsPage() {
        super();
    }

    @AndroidFindBy(xpath = "//android.widget.ScrollView[@content-desc='Forms-screen']/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.TextView")
    private MobileElement titleForm;

    public String getTitleFormsMenu(){
        wait.untilElementIsVisible(timeOutSeconds, titleForm);
        return titleForm.getText();
    }

}
