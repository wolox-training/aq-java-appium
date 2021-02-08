package runners;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import utils.BrowserManagement;

public abstract class AbstractTest {

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
