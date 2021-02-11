package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.LoginPage;

import static dictionary.Constants.*;

public class StepsLogin {

    private LoginPage loginPage = new LoginPage();

    @When("I write the {string} and {string}")
    public void iWriteTheAnd(String email, String pass) {
        loginPage.writeCredentials(email, pass);
    }

    @And("I click the login button")
    public void iClickTheLoginButton() {
        loginPage.clickLoginButton();
    }


    @Then("the system displays the {string} message")
    public void theSystemDisplaysTheMessage(String msg) {
        if (msg.equals("error")) {
            Assert.assertTrue(ERROR_INPUT_EMAIL.equals(loginPage.msgErrorEmail()));
            Assert.assertTrue(ERROR_INPUT_PASSWORD.equals(loginPage.msgErrorPassword()));
        } else {
            Assert.assertTrue(SUCCESS_INPUT_PASSWORD.equals(loginPage.msgSuccessLogin()));
            loginPage.clickOkButtonAlert();
        }
    }
}


