package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumberHtmlReport"},
        features = "src/test/resources/features/forms.feature",
        glue = {"steps"}
)
class FormsTest extends AbstractTest{


}
