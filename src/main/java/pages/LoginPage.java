package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import utils.SwipeHelper;

public class LoginPage extends BasePage {

    public LoginPage() {
        super();
    }

    @AndroidFindBy(xpath = "//android.widget.ScrollView[@content-desc='Login-screen']/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.TextView")
    private MobileElement titleLogin;

    @iOSXCUITFindBy(accessibility = "input-email")
    @AndroidFindBy(accessibility = "input-email")
    private MobileElement inputEmail;

    @iOSXCUITFindBy(accessibility = "Please enter a valid email address")
    @AndroidFindBy(xpath = "//android.widget.ScrollView[@content-desc=\"Login-screen\"]//android.view.ViewGroup[4]/android.widget.TextView[1]")
    private MobileElement errorInputEmail;

    @iOSXCUITFindBy(accessibility = "input-password")
    @AndroidFindBy(accessibility = "input-password")
    private MobileElement inputPassword;

    @iOSXCUITFindBy(accessibility = "Please enter at least 8 characters")
    @AndroidFindBy(xpath = "//android.widget.ScrollView[@content-desc=\"Login-screen\"]//android.view.ViewGroup[4]/android.widget.TextView[2]")
    private MobileElement errorInputPassword;

    @iOSXCUITFindBy(accessibility = "button-LOGIN")
    @AndroidFindBy(accessibility = "button-LOGIN")
    private MobileElement inputButtonLogin;

    @iOSXCUITFindBy(accessibility = "You are logged in!")
    @AndroidFindBy(id = "android:id/message")
    private MobileElement alertMessage;

    @iOSXCUITFindBy(accessibility = "OK")
    @AndroidFindBy(id = "android:id/button1")
    private MobileElement okAlertButton;

    public String getTitleLoginMenu() {
        return titleLogin.getText();
    }
    
    public void writeCredentials(String email, String pass) {
        inputEmail.sendKeys(email);
        inputPassword.sendKeys(pass);
    }

    public void clickLoginButton() {
        if (!elementIsDisplayed(inputButtonLogin)) {
            SwipeHelper.scrollAndClick(inputButtonLogin);
        }
        inputButtonLogin.click();
    }

    public String msgErrorEmail() {
        return errorInputEmail.getText();
    }

    public String msgErrorPassword() {
        return errorInputPassword.getText();
    }

    public String msgSuccessLogin() {
        return alertMessage.getText();
    }

    public void clickOkButtonAlert() {
        okAlertButton.click();
    }

}
