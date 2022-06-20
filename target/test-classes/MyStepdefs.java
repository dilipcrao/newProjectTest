import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class MyStepdefs {
    @Given("the user reads from an input file {string}")
    public void theUserReadsFromAnInputFile(String arg0) {
        try(BufferedReader br = new BufferedReader(new FileReader("/Users/dilipchakravarthy/Documents/TestProjects/newProjectTest/src/test/resources/car_input.txt"))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            String everything = sb.toString();
        }
    }

    @And("the user search the car details in the portal")
    public void theUserSearchTheCarDetailsInThePortal() {

    }

    @Then("the car details are displayed")
    public void theCarDetailsAreDisplayed() {

    }

    @And("car details should match with the {string}")
    public void carDetailsShouldMatchWithThe(String arg0) {
    }
}
