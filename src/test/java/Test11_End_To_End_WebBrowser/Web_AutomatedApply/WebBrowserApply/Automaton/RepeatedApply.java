package Test11_End_To_End_WebBrowser.Web_AutomatedApply.WebBrowserApply.Automaton;

import Test11_End_To_End_WebBrowser.Web_AutomatedApply.WebBrowserApply.GlobalResources.AbstractWaits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RepeatedApply extends AbstractWaits {
    WebDriver driver;
    public RepeatedApply(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebDriver returnDriver(){
        return driver;
    }
    @FindBy(css = "#navbarDropdown-8")
    WebElement dropDownToggle;

    @FindBy(xpath = "//a[@class = 'ng-binding']")
    WebElement firstJobToAppearOnPage;

    @FindBy(css = "a[class = '.neutral.sc-dhi-button']")
    WebElement unsavedBtn;

    public void goBackToSaved() throws InterruptedException {
        Thread.sleep(2000);
        dropDownToggle.click();
        Thread.sleep(2000);
        goBackToSavedJobs();
    }
    public void unsavedJob() throws InterruptedException {
        firstJobToAppearOnPage.click();
        Thread.sleep(2000);
        unsavedBtn.click();
    }
    public void connectSteps() throws InterruptedException {
        goBackToSaved();
        Thread.sleep(2000);
        unsavedJob();
    }

}
