package Test11_End_To_End_WebBrowser.Web_AutomatedApply.WebBrowserApply.Automaton;

import Test11_End_To_End_WebBrowser.Web_AutomatedApply.WebBrowserApply.GlobalResources.AbstractWaits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;

public class SignInDetails extends AbstractWaits {
    WebDriver driver;
    public SignInDetails(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//h1[normalize-space()='Sign In']")
    WebElement signInHeader;
    By headerSignIn = By.xpath("//h1[normalize-space()='Sign In']");

    @FindBy(id = "email")
    WebElement email;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(css = "button[type='submit']")
    WebElement submitBtn;


   @Parameters({"email", "password"})
    public void signInDetails(String userEmail, String userPassword){
        visibilityOf(headerSignIn);
        email.sendKeys(userEmail);
        password.sendKeys(userPassword);
        submitBtn.click();

    }
    @Parameters({"email", "password"})
    public FilterJobSelection searchJobRole(String userEmail, String userPassword){
        signInDetails(userEmail,userPassword);
        return new FilterJobSelection(driver);
    }

}