package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.*;
import utils.BrowserManagement;
import utils.TabBar;

import static dictionary.ConstantApp.*;

public class StepsDefinition {

    @Given("I am in the WebDriverIo app")
    public void iAmInTheWebDriverIoApp() {
        TabBar tabBar = new TabBar(BrowserManagement.getDriver());
        Assert.assertTrue(tabBar.isDisplayedMenu());
    }

    @When("I click on the {string} menu")
    public void iClickOnTheWebViewMenu(String menu) {
        TabBar tabBar = new TabBar(BrowserManagement.getDriver());
        switch (menu) {
            case WEBVIEW_MENU:
                tabBar.clicWebViewMenu();
                break;
            case LOGIN_MENU:
                tabBar.clicLoginMenu();
                break;
            case FORMS_MENU:
                tabBar.clicFormsMenu();
                break;
            case SWIPE_MENU:
                tabBar.clicSwipeMenu();
                break;
            case HOME_MENU:
            default:
                tabBar.clicHomeMenu();
        }
    }

    @Then("The web view opens")
    public void theWebViewOpens() {
        WebViewPage webViewPage = new WebViewPage();
        Assert.assertTrue(webViewPage.isDisplayedLnksWebView());
    }

    @Then("The Home opens")
    public void theHomeOpens() {
        HomePage homePage = new HomePage();
        Assert.assertTrue(homePage.isDisplayedImgsHome());
    }

    @Then("The login opens")
    public void theLoginOpens() {
        LoginPage loginPage = new LoginPage();
        Assert.assertEquals(TITLE_LOGIN_MENU, loginPage.getTitleLoginMenu());
    }

    @Then("The forms opens")
    public void theFormsOpens() {
        FormsPage formsPage = new FormsPage();
        Assert.assertEquals(TITLE_FORMS_MENU, formsPage.getTitleFormsMenu());
    }

    @Then("The swipe opens")
    public void theSwipeOpens() {
        SwipePage swipePage = new SwipePage();
        Assert.assertEquals(TITLE_SWIPE_MENU, swipePage.getTitleSwipeMenu());
    }
}


