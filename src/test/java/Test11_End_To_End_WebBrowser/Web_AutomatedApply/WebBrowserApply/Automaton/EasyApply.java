package Test11_End_To_End_WebBrowser.Web_AutomatedApply.WebBrowserApply.Automaton;

import Test11_End_To_End_WebBrowser.Web_AutomatedApply.WebBrowserApply.GlobalResources.AbstractWaits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class EasyApply extends AbstractWaits {
    WebDriver driver;
    public EasyApply(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    By jobHeaderVisible = By.cssSelector("div[id='savedJobs'] h3[class='jobs-heading']");
    @FindBy(xpath = "//a[@class = 'ng-binding']")
    WebElement firstJobToAppearOnPage;

    @FindBy(xpath = "//div[contains(@class,'apply-button')]")
    WebElement shadowEasyApply;

    @FindBy(xpath = "//div[contains(@class,'apply-button')]")
    List<WebElement> isEasyApplyPresent;

    public void clickOnJob() throws InterruptedException {
        clickMenuToggle();
        visibilityOf(jobHeaderVisible);
        Thread.sleep(2000);
        firstJobToAppearOnPage.click();
        Thread.sleep(3000);

    }

    public void clickOnEasyApply() throws InterruptedException {
        boolean isEasyApplicable = (isEasyApplyPresent.size() > 0);
        if(!isEasyApplicable){
            //Then Go Back To Page, Remove Job and Apply Again. For now just do Skip.
            System.out.println("Job Is Not Easy Applicable, Remove this Job and Try Again");
            driver.quit();
        }
        shadowEasyApply.click();
        Thread.sleep(3000);
    }

    public ApplicationProcess easyApplyJobs() throws InterruptedException {
        clickOnJob();
        clickOnEasyApply();
        return new ApplicationProcess(driver);
    }
}

