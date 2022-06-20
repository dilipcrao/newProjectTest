package carCheckPackage.steps;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class CarOutputContentResults {
    public static Path path = Paths.get(""); // Points to the root directory of the current project
    public static String testDir = path.toAbsolutePath().toString()+"/src/test/resources/";// a Directory contains various test files

    public CarOutputContentResults()  {
    }

    public static List<String[]> readTextFile(String carOutput)  {

        String fileName = testDir + carOutput;
        CSVParser csvParser = new CSVParserBuilder().withSeparator(',').build(); // custom separator
        try(CSVReader reader = new CSVReaderBuilder(
                new FileReader(fileName))
                .withCSVParser(csvParser)   // custom CSV parser
                .withSkipLines(1)// skip the first line, header info
                .build()){
            List<String[]> r = reader.readAll();
            r.forEach(x -> System.out.println(Arrays.toString(x)));
            return r;

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (CsvException e) {
            throw new RuntimeException(e);
        }

    }


}
