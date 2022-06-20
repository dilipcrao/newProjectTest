package carCheckPackage.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.AbstractDriverClass;
import org.example.FreeCarCheckPage;
import org.example.FreeCarCheckResultPage;
import org.junit.Assert;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CarsCheckSteps extends AbstractDriverClass {

    private final Path path = Paths.get(""); // Points to the root directory of the current project
    private final String testDir = path.toAbsolutePath().toString()+"/src/test/resources/";// a Directory contains various test files
    List<String> allMatches = new ArrayList<>();


    @Given("the user reads from an input file {string}")
    public void theUserReadsFromAnInputFile(String carInput) {

            String everything;
        try (BufferedReader br = new BufferedReader(new FileReader( testDir+ carInput))) {
                StringBuilder sb = new StringBuilder();
                String line = br.readLine();

                while (line != null) {
                    sb.append(line);
                    sb.append(System.lineSeparator());
                    line = br.readLine();
                }
                everything = sb.toString();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        String resultString = "";

            String regex = "(([A-Z]{2}).*?\\s(\\d{3}|\\d{2}|d{1})\\s?[A-Z])|([A-Z]\\s?(\\d{3}|\\d{2}|\\d{1})\\s?[A-Z]{3})|(([A-HK-PRSVWY][A-HJ-PR-Y])\\s?([0][2-9]|[1-9][0-9])\\s?[A-HJ-PR-Z]{3})";
            Pattern regexPattern = Pattern.compile(regex);
            Matcher match = regexPattern.matcher(everything);


            while (match.find()) {
                allMatches.add(match.group());
            }
            allMatches.forEach(System.out::println);

    }

    @And("the user search the car details in the portal for a given {string}")
    public void theUserSearchTheCarDetailsInThePortalForAGiven(String inputRow) {

        AbstractDriverClass.setDriver();
        FreeCarCheckPage checkPage = createPage(FreeCarCheckPage.class);
        checkPage.enterRegNumberandClick(allMatches.get(Integer.parseInt(inputRow)));

    }

    @Then("the car details are displayed")
    public void theCarDetailsAreDisplayed() throws InterruptedException {
        FreeCarCheckResultPage checkResultPage = createPage(FreeCarCheckResultPage.class);
        Assert.assertNotNull("Registration Value is not null", checkResultPage.getRegistrationValue());
        Assert.assertNotNull("Model Value is not null", checkResultPage.getModelValue());
        Assert.assertNotNull("Make Value is not null", checkResultPage.getMakeValue());
        Assert.assertNotNull("Colour Value is not null", checkResultPage.getColourValue());
    }

    @And("car details should match with the {string} for the specific {string}")
    public void carDetailsShouldMatchWithTheForTheSpecific(String carOutput, String outPutRow) {
        String[] strings = new String[0];
        FreeCarCheckResultPage checkResultPage = createPage(FreeCarCheckResultPage.class);
        List<String[]> r = CarOutputContentResults.readTextFile(carOutput);
          strings = r.get(Integer.parseInt(outPutRow));
            for (int j = 0; j < strings.length; j++) {
                System.out.print(j+strings[j] + " ");
            }
        try {
            Assert.assertEquals("Error!, the value in the file for Registration doesn't match as in the website", true, checkResultPage.getRegistrationValue().equalsIgnoreCase(strings[0]));
            Assert.assertEquals("Error!, the value in the file for Make doesn't match as in the website", true, checkResultPage.getMakeValue().equalsIgnoreCase(strings[1]));
            Assert.assertEquals("Error!, the value in the file for Model doesn't match as in the website", true, checkResultPage.getModelValue().equalsIgnoreCase(strings[2]));
            Assert.assertEquals("Error!, the value in the file for Colour doesn't match as in the website", true, checkResultPage.getColourValue().equalsIgnoreCase(strings[3]));
            Assert.assertEquals("Error!, the value in the file for Year doesn't match as in the website", true, checkResultPage.getYearValue().equalsIgnoreCase(strings[4]));


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        AbstractDriverClass.quitDriver();
    }
}
