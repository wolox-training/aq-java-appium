package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import utils.BrowserManagement;


@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumberHtmlReport"},
        features = "src/test/resources/features/swipe.feature",
        glue = {"steps"}
)
class SwipeTest {

    @BeforeClass
    public static void init() {
        BrowserManagement.startServer();
    }

    @AfterClass
    public static void finish() {
        BrowserManagement.getDriver().closeApp();
        BrowserManagement.getDriver().quit();
        BrowserManagement.stopServer();
    }
}
