package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.FormsPage;
import utils.FakerManager;

import static dictionary.Constants.BUTTONS_ACTIVE_ALERT;

public class StepsForms {

    private FormsPage formsPage = new FormsPage();
    private String statusSwitch;
    private String textSwitch;
    private String textInput;

    public String getStatusSwitch() {
        return statusSwitch;
    }

    public void setStatusSwitch(String statusSwitch) {
        this.statusSwitch = statusSwitch;
    }

    public String getTextInput() {
        return textInput;
    }

    public void setTextInput(String textInput) {
        this.textInput = textInput;
    }

    public String getTextSwitch() {
        return textSwitch;
    }

    public void setTextSwitch(String textSwitch) {
        this.textSwitch = textSwitch;
    }

    @When("I write something in the input field")
    public void iWriteSomethingInTheInputField() {
        setTextInput(FakerManager.getInstance().getFaker().name().name());
        formsPage.sendTextInputField(getTextInput());
    }

    @Then("The text entered is displayed in the result field")
    public void theTextEnteredIsDisplayedInTheResultField() {
        Assert.assertEquals(getTextInput(), formsPage.getTextInputResult());
    }

    @And("I press the form switch")
    public void iPressTheFormSwitch() {
        setTextSwitch(formsPage.getSwitchText());
        setStatusSwitch(formsPage.statusSwitch());
        formsPage.clickSwitchForm();
    }

    @And("Switch state changes")
    public void switchStateChanges() {
        Assert.assertNotEquals(getStatusSwitch(), formsPage.statusSwitch());
        Assert.assertNotEquals(getTextSwitch(), formsPage.getSwitchText());
    }

    @And("I select option {string} from the dropDown")
    public void iSelectOptionFromTheDropDown(String option) {
        formsPage.selectOptionDropDown(option);
    }

    @And("The inactive button is disabled")
    public void theInactiveButtonIsDisabled() {
        boolean status;
        int randomNum = FakerManager.getInstance().getFaker().number().numberBetween(1, 2);
        if (randomNum == 1) {
            status = formsPage.getStatusInactiveButton1();
        } else {
            status = formsPage.getStatusInactiveButton2();
        }
        Assert.assertFalse(status);
    }

    @When("I click the Active button")
    public void iClickTheActiveButton() {
        formsPage.clickActiveButton();
    }

    @Then("The system displays an alarm with the corresponding buttons")
    public void theSystemDisplaysAnAlarmWithTheCorrespondingButtons() {
        Assert.assertTrue(BUTTONS_ACTIVE_ALERT.containsAll(formsPage.getOptionsAlert()));
    }

}


