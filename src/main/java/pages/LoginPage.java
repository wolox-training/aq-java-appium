package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class LoginPage extends BasePage {

    public LoginPage() {
        super();
    }

    @AndroidFindBy(xpath = "//android.widget.ScrollView[@content-desc='Login-screen']/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.TextView")
    private MobileElement titleLogin;

    public String getTitleLoginMenu(){
        return titleLogin.getText();
    }

}
