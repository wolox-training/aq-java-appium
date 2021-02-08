package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import utils.SwipeHelper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class FormsPage extends BasePage {

    public FormsPage() {
        super();
    }

    @AndroidFindBy(xpath = "//android.widget.ScrollView[@content-desc='Forms-screen']/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.TextView")
    private MobileElement titleForm;

    @AndroidFindBy(accessibility = "text-input")
    private MobileElement inputField;

    @AndroidFindBy(accessibility = "input-text-result")
    private MobileElement inputTextResult;

    @AndroidFindBy(accessibility = "switch")
    private MobileElement switchFormn;

    @AndroidFindBy(accessibility = "switch-text")
    private MobileElement switchTextFormn;

    @AndroidFindBy(accessibility = "select-Dropdown")
    private MobileElement dropDownFormn;

    @AndroidFindBy(id = "android:id/text1")
    private List<MobileElement> listOptionsDownFormn;

    @AndroidFindBy(accessibility = "button-Inactive")
    private MobileElement inactiveButton;

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
        Optional<MobileElement> option = listOptionsDownFormn.stream().filter(element -> element.getText().equals(text)).findFirst();
        if (option.isPresent()) {
            option.get().click();
        }
    }

    public boolean getStatusInactiveButton1() {
        SwipeHelper.scrollNClick(inactiveButton);
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
