package Test11_End_To_End_WebBrowser.Web_AutomatedApply.WebBrowserRegistration.GlobalResources;

import Test11_End_To_End_WebBrowser.Web_AutomatedApply.WebBrowserRegistration.Automation.LandingPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class InitDriver {
    WebDriver driver;

    @BeforeClass
        public WebDriver InitializeDriver() throws IOException {
            //Global Properties Class: Reading the File.
            Properties property = new Properties();
            FileInputStream file = new FileInputStream("/Users/fayeemmooktadeer/Desktop/DiceApply/src/test/java/Test11_End_To_End_WebBrowser/Web_AutomatedApply/WebBrowserRegistration/GlobalResources/Property.properties");
            property.load(file);
            String browserName = property.getProperty("browser"); //Getting the Variable from property class.

            if(browserName.equalsIgnoreCase("firefox")){
                FirefoxOptions options = new FirefoxOptions();
                System.setProperty("webdriver.gecko.driver", "/Users/fayeemmooktadeer/Desktop/Grid/geckodriver");
                driver = new FirefoxDriver();
                driver.manage().window().maximize();

            }
            driver.get("https://www.dice.com/register"); //Depends on Action.
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
            return driver;
        }
        public LandingPage launchPage() throws IOException {
            driver = InitializeDriver();
            return new LandingPage(driver);
        }


}
