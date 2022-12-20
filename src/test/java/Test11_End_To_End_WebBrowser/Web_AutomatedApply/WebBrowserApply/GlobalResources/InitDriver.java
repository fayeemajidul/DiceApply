package Test11_End_To_End_WebBrowser.Web_AutomatedApply.WebBrowserApply.GlobalResources;

import Test11_End_To_End_WebBrowser.Web_AutomatedApply.WebBrowserApply.Automaton.SignInDetails;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
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

        //!!!!!!!!!!!!!!!!!!!!!!!!!!!! // Change to your Properties File: // !!!!!!!!!!!!!!!!!!!!
        FileInputStream file = new FileInputStream("/Users/fayeemmooktadeer/Desktop/DiceApply/src/test/java/Test11_End_To_End_WebBrowser/Web_AutomatedApply/WebBrowserApply/GlobalResources/Property.properties");
        //!!!!!!!!!!!!!!!!!!!!!!!!!!!! // Change to your Properties File: // !!!!!!!!!!!!!!!!!!!!

        property.load(file);
        String browserName = property.getProperty("browser"); //Getting the Variable from property class.

        if(browserName.equalsIgnoreCase("firefox")){
            System.setProperty("webdriver.gecko.driver", "/Users/fayeemmooktadeer/Desktop/Grid/geckodriver");
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
        }
        if(browserName.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver", "/Users/fayeemmooktadeer/Desktop/Grid/geckodriver");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        driver.get("https://www.dice.com/dashboard/login");
        return driver;
    }

    public SignInDetails signIn() throws IOException {
        driver = InitializeDriver();
        return new SignInDetails(driver);
    }

}

