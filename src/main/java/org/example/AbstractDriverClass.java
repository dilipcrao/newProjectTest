package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

public class AbstractDriverClass {


        protected static final Logger log = LoggerFactory.getLogger(AbstractDriverClass.class);
        private static Path path = Paths.get(""); // Points to the root directory of the current project
        private static String testDir = path.toAbsolutePath().toString()+"/src/test/resources/";// a Directory contains various test files
        protected static final String carCheckURL = "https://cartaxcheck.co.uk/";//URL is defined as Final, as it might not change

        protected static WebDriver driver;

        public static WebDriver getDriver(){
            return driver;
        }

        public static void setDriver(){
            System.setProperty("webdriver.chrome.driver",testDir+"driver/chromedriver");//can be expanded to other browsers, but currently designed to work on chrome only
            driver = new ChromeDriver();
            driver.get(carCheckURL);
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //implicit wait to take any issues while loading

        }

        protected static void quitDriver(){
            log.info("Quitting WebDriver");
            if (driver != null){
                driver.quit();
                driver = null;
            }
        }

        public <T extends AbstractDriverClass> T createPage(Class<T> pageClass) {
            return PageFactory.initElements(getDriver(), pageClass);
        }

    }


