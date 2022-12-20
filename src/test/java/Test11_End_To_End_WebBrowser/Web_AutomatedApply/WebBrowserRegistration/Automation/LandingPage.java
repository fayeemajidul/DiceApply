package Test11_End_To_End_WebBrowser.Web_AutomatedApply.WebBrowserRegistration.Automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.IOException;

public class LandingPage {
    WebDriver driver;
    public LandingPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//div[@class='fe-step']/h4")
    WebElement greetingText;

    @FindBy(id = "fe-option1")
    WebElement userOption;

    @FindBy(className = "fe-next")
    WebElement nextButton;

    public void landingPageNavigation(){
        String verifyText = greetingText.getText();
        Assert.assertEquals(verifyText, "Let's get you started with Dice");

        userOption.click();
        nextButton.click();
    }

    public UserInfo navigateToUserPage() throws IOException {
        landingPageNavigation();
        return new UserInfo(driver);
    }
}
