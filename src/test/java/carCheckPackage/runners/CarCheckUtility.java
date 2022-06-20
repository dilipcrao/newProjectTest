package carCheckPackage.runners;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/carTest.feature",
        glue = {"carCheckPackage/steps"},
        plugin={"pretty","html:target/cucumber"}
)

public class CarCheckUtility {

}
