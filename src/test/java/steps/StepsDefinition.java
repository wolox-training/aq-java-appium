package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.MenuPage;
import pages.WebViewPage;

public class StepsDefinition {

    @Given("^I am in the WebDriverIo app$")
    public void iAmInTheWebDriverIoApp() {
        MenuPage menuPage = new MenuPage();
        Assert.assertTrue(menuPage.isDisplayedHomeMenu());
        Assert.assertTrue(menuPage.isDisplayedWebViewMenu());
        Assert.assertTrue(menuPage.isDisplayedLoginMenu());
        Assert.assertTrue(menuPage.isDisplayedFormsMenu());
        Assert.assertTrue(menuPage.isDisplayedSwipeMenu());
    }

    @When("I click on the WebView menu")
    public void iClickOnTheWebViewMenu() {
        MenuPage menuPage = new MenuPage();
        menuPage.clicWebViewMenu();
    }

    @Then("The web view opens")
    public void theWebViewOpens() {
        WebViewPage webViewPage = new WebViewPage();
        Assert.assertTrue(webViewPage.isDisplayedLnkDocs());
        Assert.assertTrue(webViewPage.isDisplayedLnkApi());
        Assert.assertTrue(webViewPage.isDisplayedLnkHelp());
        Assert.assertTrue(webViewPage.isDisplayedLnkBlog());
        Assert.assertTrue(webViewPage.isDisplayedLnkVersions());
        Assert.assertTrue(webViewPage.isDisplayedLnkContribute());
    }
}


