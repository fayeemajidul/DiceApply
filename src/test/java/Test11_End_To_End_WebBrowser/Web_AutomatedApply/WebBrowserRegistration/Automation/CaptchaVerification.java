package Test11_End_To_End_WebBrowser.Web_AutomatedApply.WebBrowserRegistration.Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class CaptchaVerification {
    WebDriver driver;
    public CaptchaVerification(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(css = "button[type='submit']")
    WebElement submitBtn;

    @FindBy(xpath = "//button[@id='thirdPartyYes']")
    WebElement humanVerification;

    public void avoidCaptcha() throws InterruptedException {
        Thread.sleep(8000);
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor)driver;
        javascriptExecutor.executeScript("window.scrollBy(0,600)");
        submitBtn.click();
        humanVerification.click();
    }

}
