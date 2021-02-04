package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.*;
import pages.components.TabBar;

import static dictionary.Constants.*;

public class StepsDefinition {

    @Given("I am in the WebDriverIo app")
    public void iAmInTheWebDriverIoApp() {
        TabBar tabBar = new TabBar();
        Assert.assertTrue(tabBar.isDisplayedMenu());
    }

    @When("I click on the {string} menu")
    public void iClickOnTheWebViewMenu(String menu) {
        TabBar tabBar = new TabBar();
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

    @Then("The {string} opens")
    public void theOpens(String menu) {
        switch (menu) {
            case WEBVIEW_MENU:
                WebViewPage webViewPage = new WebViewPage();
                Assert.assertTrue(webViewPage.isDisplayedLnksWebView());
                break;
            case LOGIN_MENU:
                LoginPage loginPage = new LoginPage();
                Assert.assertEquals(TITLE_LOGIN_MENU, loginPage.getTitleLoginMenu());
                break;
            case FORMS_MENU:
                FormsPage formsPage = new FormsPage();
                Assert.assertEquals(TITLE_FORMS_MENU, formsPage.getTitleFormsMenu());
                break;
            case SWIPE_MENU:
                SwipePage swipePage = new SwipePage();
                Assert.assertEquals(TITLE_SWIPE_MENU, swipePage.getTitleSwipeMenu());
                break;
            case HOME_MENU:
            default:
                HomePage homePage = new HomePage();
                Assert.assertTrue(homePage.isDisplayedImgsHome());
        }
    }

}


