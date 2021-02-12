package steps;

import io.cucumber.java.After;
import utils.BrowserManagement;

public class Hooks {

    @After
    public void resetApp(){
        BrowserManagement.getDriver().resetApp();
    }
}
