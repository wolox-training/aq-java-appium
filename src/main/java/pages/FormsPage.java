package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import utils.SwipeHelper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class FormsPage extends BasePage {

    public FormsPage() {
        super();
    }

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Form components\"]")
    @AndroidFindBy(xpath = "//android.widget.ScrollView[@content-desc='Forms-screen']/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.TextView")
    private MobileElement titleForm;

    @iOSXCUITFindBy(accessibility = "text-input")
    @AndroidFindBy(accessibility = "text-input")
    private MobileElement inputField;

    @iOSXCUITFindBy(accessibility = "input-text-result")
    @AndroidFindBy(accessibility = "input-text-result")
    private MobileElement inputTextResult;

    @iOSXCUITFindBy(accessibility = "switch")
    @AndroidFindBy(accessibility = "switch")
    private MobileElement switchFormn;

    @iOSXCUITFindBy(accessibility = "switch-text")
    @AndroidFindBy(accessibility = "switch-text")
    private MobileElement switchTextFormn;

    @iOSXCUITFindBy(accessibility = "select-Dropdown")
    @AndroidFindBy(accessibility = "select-Dropdown")
    private MobileElement dropDownFormn;

    @AndroidFindBy(id = "android:id/text1")
    private List<MobileElement> listOptionsDownFormn;

    @iOSXCUITFindBy(className = "XCUIElementTypePickerWheel")
    private MobileElement optionsDropDownFormIOS;

    @iOSXCUITFindBy(accessibility = "header-Dropdown")
    private MobileElement doneButton;

    @iOSXCUITFindBy(accessibility = "button-Inactive")
    @AndroidFindBy(accessibility = "button-Inactive")
    private MobileElement inactiveButton;

    @iOSXCUITFindBy(accessibility = "button-Active")
    @AndroidFindBy(accessibility = "button-Active")
    private MobileElement activeButton;

    @AndroidFindBy(id = "android:id/button")
    private List<MobileElement> listButtonsAlert;

    private String classButton = "new UiSelector().className(\"android.widget.TextView\")";

    public String getTitleFormsMenu() {
        wait.untilElementIsVisible(timeOutSeconds, titleForm);
        return titleForm.getText();
    }

    public void sendTextInputField(String text) {
        inputField.sendKeys(text);
    }

    public String getTextInputResult() {
        return inputTextResult.getText();
    }

    public String statusSwitch() {
        return switchFormn.getText();
    }

    public String getSwitchText() {
        return switchTextFormn.getText();
    }

    public void clickSwitchForm() {
        switchFormn.click();
    }

    public void selectOptionDropDown(String text) {
        dropDownFormn.click();
        if (dotenv.get("PLATFORM_NAME").equals("Android")) {
            Optional<MobileElement> option = listOptionsDownFormn.stream().filter(element -> element.getText().equals(text)).findFirst();
            if (option.isPresent()) {
                option.get().click();
            }
        } else {
            optionsDropDownFormIOS.setValue(text);
            doneButton.click();
        }
    }


    public boolean getStatusInactiveButton1() {
        SwipeHelper.scrollAndClick(inactiveButton);
        return inactiveButton.isEnabled();
    }

    public boolean getStatusInactiveButton2() {
        if (!elementIsDisplayed(inactiveButton)) {
            String neededElement_finder = "new UiSelector().text(\"Inactive\")";
            SwipeHelper.androidVerticalSwipe(classButton, neededElement_finder);
        }
        return inactiveButton.isEnabled();
    }

    public void clickActiveButton() {
        if (!elementIsDisplayed(activeButton)) {
            String neededElement_finder = "new UiSelector().text(\"Active\")";
            SwipeHelper.androidVerticalSwipe(classButton, neededElement_finder);
        }
        activeButton.click();
    }

    public List<String> getOptionsAlert() {
        return listButtonsAlert.stream().map(MobileElement::getText).collect(Collectors.toList());
    }
}
