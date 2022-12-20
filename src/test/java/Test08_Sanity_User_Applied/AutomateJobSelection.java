package Test08_Sanity_User_Applied;

import Mobile_AutomatedApply.AutomatedResources.ConfigDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class AutomateJobSelection extends ConfigDriver {
    AndroidDriver driver;
    public AutomateJobSelection(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    int iterationRepetition;

    @FindBy(id = "com.dice.app.jobs:id/apply_btn")
    private WebElement verifyIfApplied;

    @FindBy(id = "com.dice.app.jobs:id/SubmitApplicationButton")
    private WebElement submitApp;

    @FindBy(id = "com.dice.app.jobs:id/SubmitApplicationProgress")
    private WebElement applicationSubmitRender;

    @FindBy(id = "com.dice.app.jobs:id/appliedText")
    private WebElement submitVerificationText;

    boolean ignoreSteps = false;


    public void invisibilityOfElement(WebElement element){
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(6));
        explicitWait.until(ExpectedConditions.invisibilityOf(element));
    }
    public void visibilityOfElement(WebElement element){
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(6));
        explicitWait.until(ExpectedConditions.visibilityOf(element));
    }
    public void SelectCareerOption() throws InterruptedException {
        for(int i = 0; i <= 5; i++){
            Thread.sleep(1000);
            boolean isEasyApplicable = driver.findElements(By.xpath("//android.view.ViewGroup[" + i + "]//android.widget.TextView[5]")).size() > 0;
            if(isEasyApplicable){
                driver.findElement(By.xpath("//android.view.ViewGroup[" + i + "]")).click();
                break;
            }else{
                System.out.println("Job #" + i + " is not easy applicable.");
                //What if none of them are easy applicable, scroll down and execute again.
            }
            iterationRepetition = i;
        }
    }
    public void applicationLogic() throws InterruptedException {
        String alreadyApplied = verifyIfApplied.getAttribute("text").split(" ")[0];
        if (alreadyApplied.equalsIgnoreCase("APPLIED")) {
            driver.navigate().back();
            ignoreSteps = true;
            driver.quit();
        }
    }

    public void proceedWithApplication() throws InterruptedException {
        if (!ignoreSteps) {
            verifyIfApplied.click();
            submitApp.click();
            invisibilityOfElement(applicationSubmitRender);
        }
    }
    public void verifyApplicationSuccess(){
        visibilityOfElement(submitVerificationText);
        String verifyText = submitVerificationText.getAttribute("text");
        Assert.assertEquals(verifyText, "Thanks for Applying!");
    }

    public void applicationAutomation() throws InterruptedException {
        SelectCareerOption();
        applicationLogic();
        if(!ignoreSteps){
            proceedWithApplication();
            verifyApplicationSuccess();
        }else{
            System.out.println("Driver was quit, because job has already been applied to.");
        }
    }
}