package Test11_End_To_End_WebBrowser.Web_AutomatedApply.WebBrowserApply.Automaton;

import Test11_End_To_End_WebBrowser.Web_AutomatedApply.WebBrowserApply.GlobalResources.AbstractWaits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ApplicationProcess extends AbstractWaits {
    WebDriver driver;
    public ApplicationProcess(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[contains(@class,'progress-bar')]")
    WebElement stepsForJobProcess;

    @FindBy(css = "#navbarDropdown-9")
    WebElement dropDownToggle;

    @FindBy(css = "a[href='/dashboard/jobs']")
    WebElement dropDownJobSelect;

    @FindBy(xpath = "//div[4]//div[1]//div[2]//div[1]//button[1]")
    WebElement idkWhatElementThisIs;
    By idkWhatThisIS = By.xpath("//div[4]//div[1]//div[2]//div[1]//button[1]");

    @FindBy(xpath = "//button[@class='btn btn-primary btn-next btn-block']")
    WebElement nextBtn;

    @FindBy(xpath = "//button[@class='btn btn-primary btn-next btn-split']")
    WebElement submitAppBtn;

    @FindBy(css = "div[class='post-apply-header-text'] h1")
    WebElement assertIfSubmit;

    @FindBy(xpath = "//div[contains(@class,'application-submitted')]//p")
    WebElement alreadyAppliedText;

    public void verifyEasyApplyLogic(){
        String splitNum = stepsForJobProcess.getText().split("of ")[1];
        if(Integer.parseInt(splitNum) > 2){
            dropDownToggle.click();
            dropDownJobSelect.click();
            goBackToSavedJobs();
            visibilityOf(idkWhatThisIS);
            idkWhatElementThisIs.click();
        }
        nextBtn.click();
        submitAppBtn.click();
        Assert.assertEquals(assertIfSubmit.getText(), "Application submitted. We're rooting for you.");
    }


    public RepeatedApply applicationProcess(){
        verifyEasyApplyLogic();
        return new RepeatedApply(driver);
    }
}